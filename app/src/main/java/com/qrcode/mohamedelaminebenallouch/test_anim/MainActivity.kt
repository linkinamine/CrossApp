package com.qrcode.mohamedelaminebenallouch.test_anim

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var objectAnimator: ObjectAnimator? = null
    private var animations = HashMap<Int, ObjectAnimator>()
    private val resizeFactorX = PropertyValuesHolder.ofFloat("scaleX", 1.5f)
    private val resizeFactorY = PropertyValuesHolder.ofFloat("scaleY", 1.5f)
    private val elementsAnchorX = PropertyValuesHolder.ofInt("translationX", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialiseButtonsAnimators()

    }

    private fun initialiseButtonsAnimators() {

        val bottomElementOffset = resources.getDimensionPixelSize(R.dimen.ca_default_buttons_iv).toFloat()
        val topElementOffset = resources.getDimensionPixelSize(R.dimen.semi_circle_small_height_vw) + ((resources.getDimensionPixelSize(R.dimen.view_holder_rl) -
            resources.getDimensionPixelSize(R.dimen.semi_circle_big_vw)) / 1.5).toFloat()

        val topElementAnchorY = PropertyValuesHolder.ofFloat("translationY", -topElementOffset)
        val bottomElementAnchorY = PropertyValuesHolder.ofFloat("translationY", -bottomElementOffset)

        iv_anim_bottom_left.setOnClickListener {
            handleElementAnimation(iv_anim_bottom_left, 1, elementsAnchorX, bottomElementAnchorY)
        }
        iv_anim_top_left.setOnClickListener {
            handleElementAnimation(iv_anim_top_left, 2, elementsAnchorX, topElementAnchorY)
        }
        iv_anim_top_right.setOnClickListener {
            handleElementAnimation(iv_anim_top_right, 3, elementsAnchorX, topElementAnchorY)
        }
        iv_anim_bottom_right.setOnClickListener {
            handleElementAnimation(iv_anim_bottom_right, 4, elementsAnchorX, bottomElementAnchorY)
        }
    }

    private fun handleElementAnimation(elementToAnimate: ImageView, animatedElementPosition: Int, elementAnchorX: PropertyValuesHolder?, elementAnchorY: PropertyValuesHolder?) {


        if (animations[animatedElementPosition] != null) {
            animations[animatedElementPosition]!!.reverse()
            animations.remove(animatedElementPosition)

        } else {
            objectAnimator = ObjectAnimator.ofPropertyValuesHolder(elementToAnimate, elementAnchorX, elementAnchorY, resizeFactorX, resizeFactorY).setDuration(500)
            objectAnimator?.interpolator = LinearInterpolator()
            objectAnimator?.start()
            objectAnimator?.let { animations.put(animatedElementPosition, it) }
        }
    }
    
}
