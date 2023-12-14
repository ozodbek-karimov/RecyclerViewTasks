package pl.ozodbek.recyclerviewtasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.ozodbek.recyclerviewtasks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ControllerFragment())
            .setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            )
            .setReorderingAllowed(true)
            .addToBackStack(MainActivity().toString())
            .commit()
    }
}

