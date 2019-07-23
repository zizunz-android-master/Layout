package happy.mjstudio.layoutsample.ui

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import happy.mjstudio.layoutsample.R
import kotlinx.android.synthetic.main.fragment_constraint_circle.*

class ConstraintCircleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_constraint_circle,container,false)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        startPlanetAnim()
    }

    private fun startPlanetAnim() {
        val mercury = mercury
        val venus = venus

        ValueAnimator.ofFloat(0f,359f).apply {
            addUpdateListener {
                val value = it.animatedValue as Float

                val lpMercury = mercury.layoutParams as ConstraintLayout.LayoutParams
                val lpVenus = venus.layoutParams as ConstraintLayout.LayoutParams

                lpMercury.circleAngle = value
                lpVenus.circleAngle = value + 90f

                mercury.layoutParams = lpMercury
                venus.layoutParams = lpVenus
            }

            repeatCount = ValueAnimator.INFINITE
            duration = 3000L
            interpolator = LinearInterpolator()

            start()
        }
    }
}