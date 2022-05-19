package com.example.examen3t

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examen3t.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.spinner
            .apply{adapter= ArrayAdapter.createFromResource(requireContext(),R.array.generos,R.layout.elemento)}
            .apply {
                onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        when(position){
                            1-> findNavController().navigate(MainFragmentDirections.actionMainFragmentToListaFragment("rock"))
                            2-> findNavController().navigate(MainFragmentDirections.actionMainFragmentToListaFragment("blues"))
                            3 -> findNavController().navigate(MainFragmentDirections.actionMainFragmentToListaFragment("jazz"))
                            4-> findNavController().navigate(MainFragmentDirections.actionMainFragmentToListaFragment("varios"))
                        }
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
            }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}