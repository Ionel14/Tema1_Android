package com.example.animals.fragments

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animals.OnItemClickListener
import com.example.animals.R
import com.example.animals.adapters.AnimalsAdapter
import com.example.animals.models.Animal
import com.example.animals.models.Continent


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class FirstFragment : Fragment(), OnItemClickListener {

    val animals = ArrayList<Animal>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycleView = view.findViewById < RecyclerView>(R.id.rv_animals)

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
        adapter.setClickListener(this)
        val layoutManager = LinearLayoutManager(context)
        recycleView.layoutManager = layoutManager

//        val button = view.findViewById<Button>(R.id.delete_button)
//
//        button.setOnClickListener {
//            animals.remove()
//        }

    }

    override fun onClick(view: View?, position: Int) {
//        val animal = animals[position]
//
//        val args = Bundle()
//
//        args.putString("animal_name", animal.name)
//        args.putString("animal_continent", animal.continent.toString())
//
//        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, args)
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}