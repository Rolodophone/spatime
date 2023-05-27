package net.rolodophone.spatime.ui.timer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import net.rolodophone.spatime.Project
import net.rolodophone.spatime.R
import net.rolodophone.spatime.Timer

class TimerFragment: Fragment() {

	private lateinit var timerViewModel: TimerViewModel

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
		val root = inflater.inflate(R.layout.fragment_timer, container, false)

		val textView: TextView = root.findViewById(R.id.timer_text)
		timerViewModel.timerString.observe(viewLifecycleOwner) { textView.text = it }

		root.findViewById<Button>(R.id.button_minus).setOnClickListener { timerViewModel.timer.offset(-5) }
		root.findViewById<Button>(R.id.button_plus).setOnClickListener { timerViewModel.timer.offset(5) }

		val tableLayout = root.findViewById<ViewGroup>(R.id.timer_table_layout)
		var currentTableRow = TableRow(context)
		currentTableRow.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
		var columnIndex = 0

		for (project in Project.values()) {
			val button = ImageButton(context)
			button.layoutParams = TableRow.LayoutParams(112, 112).apply {
				setMargins(16, 16, 16, 16)
			}
			button.setImageResource(project.drawableResource)
			button.background = ResourcesCompat.getDrawable(resources, R.drawable.circle_button, null)?.apply {
				setTint(project.colour)
			}
			if (project.dark) {
				button.setColorFilter(0xFFFFFFFF.toInt())
			}
			button.elevation = 2f
			button.setOnClickListener(ProjectBtnOnClickListener(timerViewModel.timer, root.findViewById(R.id.project_title), project))

			currentTableRow.addView(button)
			columnIndex++

			if (columnIndex == 5) {
				//new row
				tableLayout.addView(currentTableRow)
				currentTableRow = TableRow(context)
				currentTableRow.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
				columnIndex = 0
			}
		}

		tableLayout.addView(currentTableRow)

		return root
	}
}

class ProjectBtnOnClickListener(val timer: Timer, val projectText: TextView, val project: Project): View.OnClickListener {
	override fun onClick(v: View) {
		projectText.text = project.projectName
		projectText.setTextColor(project.colour)
		timer.set(project.timerMins)
	}
}