package com.qrcode.mohamedelaminebenallouch.test_anim

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateDecelerateInterpolator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstElementX = PropertyValuesHolder.ofFloat("x", 40f)
        val firstElementY = PropertyValuesHolder.ofFloat("y", 10f)

        var objectAnimator: ObjectAnimator? = null

        iv_anim_top_right.setOnClickListener {

            if (objectAnimator != null) {
                objectAnimator!!.reverse()
                objectAnimator = null

            } else {
                objectAnimator = ObjectAnimator.ofPropertyValuesHolder(iv_anim_top_right, firstElementX, firstElementY).setDuration(500)
                objectAnimator?.interpolator = AccelerateDecelerateInterpolator()
                objectAnimator?.start()
            }

        }
        iv_anim_top_left.setOnClickListener {
            (iv_anim_top_left.drawable as Animatable).start()
        }
        iv_anim_bottom_left.setOnClickListener {
            (iv_anim_bottom_left.drawable as Animatable).start()
        }
        iv_anim_bottom_right.setOnClickListener {
            (iv_anim_bottom_right.drawable as Animatable).start()
        }

    }


}
