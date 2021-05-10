package com.game.pruebataxislibres.utils.ui

import android.app.Activity
import android.view.View
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView
import com.game.pruebataxislibres.R

class LoadingAnimation {
    private lateinit var lottieAnimationView: LottieAnimationView

    constructor(context: Activity, raw: Int = R.raw.no_network) {
        lottieAnimationView = context.findViewById(R.id.lavLoading)
        lottieAnimationView.visibility = View.VISIBLE
        lottieAnimationView.setAnimation(raw)
    }

    fun playAnimation(loop: Boolean) {
        lottieAnimationView.loop(loop)
        lottieAnimationView.playAnimation()
        lottieAnimationView.visibility = View.VISIBLE
    }

    fun stopAnimation() {
        lottieAnimationView.cancelAnimation()
        lottieAnimationView.visibility = View.GONE
    }
}