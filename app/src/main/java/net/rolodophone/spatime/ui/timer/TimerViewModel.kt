package net.rolodophone.spatime.ui.timer

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.rolodophone.spatime.Timer

class TimerViewModel: ViewModel() {
	private val _timerString = MutableLiveData<String>()
	val timerString: LiveData<String> = _timerString
	var timer = Timer(0, _timerString)
}