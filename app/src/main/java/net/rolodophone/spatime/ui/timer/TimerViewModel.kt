package net.rolodophone.spatime.ui.timer

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel: ViewModel() {

	private val _timerString = MutableLiveData<String>()
	val timerString: LiveData<String> = _timerString

	inner class Timer(duration: Int): CountDownTimer(duration * 1000L, 1000) {
		override fun onTick(millisUntilFinished: Long) {
			onTick((millisUntilFinished / 1000).toInt())
		}
		fun onTick(secondsLeft: Int) {
			val minutes = secondsLeft / 60
			val seconds = secondsLeft % 60
			_timerString.value = "%d:%02d".format(minutes, seconds)
		}
		override fun onFinish() {
			_timerString.value = "TIME'S UP!"
		}
	}

	var timer: Timer? = null
}