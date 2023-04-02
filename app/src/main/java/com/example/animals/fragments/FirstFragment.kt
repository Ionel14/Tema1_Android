package com.example.animals.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animals.R
import com.example.animals.adapters.AnimalsAdapter
import com.example.animals.models.Animal
import com.example.animals.models.Continent

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val button = view.findViewById<Button>(R.id.button_first)
//        button.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }

        val recycleView = view.findViewById < RecyclerView>(R.id.rv_animals)

        val animals = ArrayList<Animal>()
        animals.add(Animal("Wolf", Continent.Europe))
        animals.add(Animal("Dragon", Continent.Asia))
        animals.add(Animal("Wolf", Continent.Europe))
        animals.add(Animal("Dragon", Continent.Asia))
        animals.add(Animal("Zebra", Continent.Africa))
        animals.add(Animal("Wolf", Continent.Europe))
        animals.add(Animal("Wolf", Continent.Europe))
        animals.add(Animal("Kangoroo", Continent.Australia))
        animals.add(Animal("Zebra", Continent.Africa))
        animals.add(Animal("Racoon", Continent.America))
        animals.add(Animal("Zebra", Continent.Africa))
        animals.add(Animal("Wolf", Continent.Europe))
        animals.add(Animal("Dragon", Continent.Asia))
        animals.add(Animal("Kangoroo", Continent.Australia))
        animals.add(Animal("Wolf", Continent.Europe))
        animals.add(Animal("Racoon", Continent.America))
        animals.add(Animal("Zebra", Continent.Africa))
        animals.add(Animal("Kangoroo", Continent.Australia))
        animals.add(Animal("Wolf", Continent.Europe))
        animals.add(Animal("Racoon", Continent.America))
        animals.add(Animal("Kangoroo", Continent.Australia))
        animals.add(Animal("Dragon", Continent.Asia))
        animals.add(Animal("Kangoroo", Continent.Australia))
        animals.add(Animal("Wolf", Continent.Europe))
        animals.add(Animal("Dragon", Continent.Asia))
        animals.add(Animal("Racoon", Continent.America))
        animals.add(Animal("Zebra", Continent.Africa))
        animals.add(Animal("Racoon", Continent.America))
        animals.add(Animal("Wolf", Continent.Europe))
        animals.add(Animal("Kangoroo", Continent.Australia))
        animals.add(Animal("Zebra", Continent.Africa))
        animals.add(Animal("Dragon", Continent.Asia))
        animals.add(Animal("Racoon", Continent.America))
        animals.add(Animal("Kangoroo", Continent.Australia))
        animals.add(Animal("Racoon", Continent.America))
        animals.add(Animal("Zebra", Continent.Africa))
        animals.add(Animal("Zebra", Continent.Africa))
        animals.add(Animal("Dragon", Continent.Asia))
        animals.add(Animal("Kangoroo", Continent.Australia))
        animals.add(Animal("Dragon", Continent.Asia))
        animals.add(Animal("Kangoroo", Continent.Australia))
        animals.add(Animal("Racoon", Continent.America))
        animals.add(Animal("Zebra", Continent.Africa))
        animals.add(Animal("Dragon", Continent.Asia))
        animals.add(Animal("Racoon", Continent.America))
        animals.add(Animal("Wolf", Continent.Europe))
        animals.add(Animal("Dragon", Continent.Asia))
        animals.add(Animal("Zebra", Continent.Africa))
        animals.add(Animal("Kangoroo", Continent.Australia))
        animals.add(Animal("Racoon", Continent.America))


        val adapter = AnimalsAdapter(animals)

        recycleView.adapter = adapter

        val layoutManager = LinearLayoutManager(context)
        recycleView.layoutManager = layoutManager
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}