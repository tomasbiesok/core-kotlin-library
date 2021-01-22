package cz.wiechocz.libraries.corelibrarysample.system

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import cz.wiechocz.libraries.corelibrarysample.databinding.ActivitySampleBinding
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySampleBinding
    private val viewModel: SampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.vButtonNumber.setOnClickListener {
            lifecycleScope.launch {
                val value = binding.vInput.text.toString()
                val result = viewModel.invokeUseCase(value)
                binding.vLabelNumber.text = "Number is $result"
            }
        }

        binding.vButtonStartCount.setOnClickListener {
            lifecycleScope.launch {
                val result = viewModel.startCount()
                Toast.makeText(applicationContext, "Start count result -> $result", Toast.LENGTH_SHORT).show()
            }
        }

        binding.vButtonStopCount.setOnClickListener {
            lifecycleScope.launch {
                val result = viewModel.stopCount()
            }
        }

        lifecycleScope.launch {
            viewModel.observeCounter().collect {
                binding.vLabelCount.text = it.toString()
            }
        }
    }
}