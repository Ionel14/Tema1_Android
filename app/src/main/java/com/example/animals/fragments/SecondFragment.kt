package com.example.animals.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.animals.R
import com.example.animals.models.Continent

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_second, container, false);
        val animalNameTextView = rootView.findViewById<TextView>(R.id.animal_name)
        val animalContinentTextView = rootView.findViewById<TextView>(R.id.animal_continent)

        if (animalNameTextView != null) {
            animalNameTextView.text = arguments?.getString("animal_name")
        }
        if (animalContinentTextView != null) {
            animalContinentTextView.text = arguments?.getString("animal_continent")
        }

        var color: Int? = null
        when (animalContinentTextView.text) {
            Continent.Europe.toString() -> {
                color = ContextCompat.getColor(requireContext(), R.color.green)
            }
            Continent.Africa.toString() -> {
                color = ContextCompat.getColor(requireContext(), R.color.yellow)
            }
            Continent.Asia.toString() -> {
                color = ContextCompat.getColor(requireContext(), R.color.red)
            }
            Continent.America.toString() -> {
                color = ContextCompat.getColor(requireContext(), R.color.blue)
            }
            Continent.Australia.toString() -> {
                color = ContextCompat.getColor(requireContext(), R.color.orange)
            }
        }
        if (color != null) {
            rootView.setBackgroundColor(color)
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val button = view.findViewById<Button>(R.id.button_second)
//        button.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}