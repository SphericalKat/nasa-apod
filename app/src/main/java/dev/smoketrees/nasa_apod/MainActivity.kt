package dev.smoketrees.nasa_apod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import dev.smoketrees.nasa_apod.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val spannable = SpannableString(getString(R.string.app_name))
        spannable.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.neon_green)),
            4, 8,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.toolbarText.text = spannable
    }
}