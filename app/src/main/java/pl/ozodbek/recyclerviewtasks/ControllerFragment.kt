package pl.ozodbek.recyclerviewtasks


import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import pl.ozodbek.recyclerviewtasks.databinding.FragmentControllerBinding
import java.util.*

class ControllerFragment : Fragment() {
    private var _binding: FragmentControllerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentControllerBinding.inflate(inflater, container, false)


        binding.regionBtn.setOnClickListener {

            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { _, selectedHour, selectedMinute ->
                    val formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                    Snackbar.make(binding.root, formattedTime, Snackbar.LENGTH_SHORT).show()
                },
                hour, minute, false
            )

            timePickerDialog.setTitle("Set a time !!")
            timePickerDialog.setCanceledOnTouchOutside(false)

            timePickerDialog.show()

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}