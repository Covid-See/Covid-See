package com.example.covidsee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.example.covidsee.databinding.ActivitySplashBinding
import com.sarnava.textwriter.TextWriter


@Suppress("DEPRECATION")
class Splash : AppCompatActivity() {

    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        splashScreen()

    }

    private fun splashScreen(){

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        binding.textWriter
            .setWidth(12F)
            .setDelay(50)
            .setColor(R.color.black)
            .setConfig(TextWriter.Configuration.INTERMEDIATE)
            .setSizeFactor(30f)
            .setLetterSpacing(25f)
            .setText("COVID SEE")
            .setListener(TextWriter.Listener {
                binding.cvSeeImage.startAnimation(AnimationUtils.loadAnimation(this,R.anim.pop))
                Handler().postDelayed({
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                },1500)
            })
            .startAnimation()
    }

}