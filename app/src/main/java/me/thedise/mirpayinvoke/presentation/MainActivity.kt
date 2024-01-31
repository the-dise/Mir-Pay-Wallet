package me.thedise.mirpayinvoke.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager.LayoutParams.ALPHA_CHANGED
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import me.thedise.mirpayinvoke.databinding.ActivityMainBinding
import kotlin.system.exitProcess

/**
 * @author the_dise
 * @date 30 Jan 2024
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.addFlags(ALPHA_CHANGED)

        binding.icon.setOnClickListener {
            viewModel.resetTimer()
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.getTimerValue().collect { num ->
                    binding.countdown.text = num.toString()
                    if (num == 0) {
                        closeApp()
                    }
                }
            }
        }
    }

    private fun closeApp() {
        finish()
        Handler(Looper.getMainLooper()).postDelayed({
            exitApp()
        }, 50L)
    }

    private fun exitApp() {
        exitProcess(0)
    }
}