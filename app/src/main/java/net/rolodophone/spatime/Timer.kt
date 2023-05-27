package net.rolodophone.spatime

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData

const val TICK_INTERVAL = 20L

class Timer(durationMins: Int, val timerString: MutableLiveData<String>) {
	private var countDownTimer = MyCountDownTimer(durationMins * 60 * 1000L, TICK_INTERVAL)

	fun offset(minutes: Int) {
		countDownTimer.minutesToAdd = minutes
	}

	fun set(minutes: Int) {
		countDownTimer.cancel()
		countDownTimer = MyCountDownTimer(minutes * 60 * 1000L, TICK_INTERVAL)
		countDownTimer.start()
	}

	private inner class MyCountDownTimer(durationMillis: Long, intervalMillis: Long): CountDownTimer(durationMillis, intervalMillis) {
		var minutesToAdd: Int? = null

		override fun onTick(millisUntilFinished: Long) {
			updateTimerString((millisUntilFinished / 1000).toInt())

			minutesToAdd?.let { minutesToAdd ->
				countDownTimer = MyCountDownTimer((millisUntilFinished + minutesToAdd * 60 * 1000L), TICK_INTERVAL)
				countDownTimer.start()
				this.cancel()
				this.minutesToAdd = null
			}
		}

		fun updateTimerString(secondsLeft: Int) {
			val hours = secondsLeft / 3600
			val minutes = (secondsLeft % 3600) / 60
			val seconds = secondsLeft % 60
			if (hours > 0) timerString.value = "%d:%02d:%02d".format(hours, minutes, seconds)
			else timerString.value = "%d:%02d".format(minutes, seconds)
		}

		override fun onFinish() {}
	}
}