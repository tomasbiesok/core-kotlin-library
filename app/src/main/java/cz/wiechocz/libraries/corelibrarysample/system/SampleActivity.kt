package cz.wiechocz.libraries.corelibrarysample.system

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import cz.wiechocz.libraries.corelibrarysample.databinding.ActivitySampleBinding
import kotlinx.coroutines.launch

class SampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySampleBinding
    private val viewModel: SampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.vButtonTest.setOnClickListener {
            lifecycleScope.launch {
                val value = binding.vInput.text.toString()
                val result = viewModel.invokeUseCase(value)
                binding.vLabel.text = "Number is $result"
            }
        }
    }
}