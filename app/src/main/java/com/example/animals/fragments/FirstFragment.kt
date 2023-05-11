package com.example.animals.fragments

import android.app.AlertDialog
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.animals.OnItemClickListener
import com.example.animals.R
import com.example.animals.adapters.AnimalsAdapter
import com.example.animals.models.Animal
import com.example.animals.models.AnimalDao
import com.example.animals.models.AnimalDatabase
import com.example.animals.models.Continent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class FirstFragment : Fragment(), OnItemClickListener {

    var animals = ArrayList<Animal>()
    private lateinit var adapter: AnimalsAdapter
    private lateinit var animalNameEditText: EditText
    private lateinit var continentEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animalNameEditText = view.findViewById(R.id.animal_name_input)
        continentEditText = view.findViewById(R.id.continent_input)
        val addButton = view.findViewById<Button>(R.id.add_button)
        addButton.setOnClickListener {
            onClick(it, 1)
        }

        val recycleView = view.findViewById<RecyclerView>(R.id.rv_animals)

//        val sharedPreferences =
//            context?.getSharedPreferences("Animals", Context.MODE_PRIVATE)
//        sharedPreferences?.edit()?.putString("Wolf", "Europe")
//        sharedPreferences?.edit()?.putString("Dragon", "Asia")
//        sharedPreferences?.edit()?.putString("Zebra", "America")
//        sharedPreferences?.edit()?.putString("Kangaroo", "Australia")

//        runBlocking {
//            launch(Dispatchers.IO) {
//                val sharedPref = context?.getSharedPreferences("Animals", Context.MODE_PRIVATE)
//                val allData: Map<String, *> = sharedPref?.all as Map<String, *>
//
//                for ((animalName, continent) in allData) {
//                    if (Continent.values().find{ it.toString() == continent} == null){
//                        continue;
//                    }
//                    animals.add(Animal(animalName, Continent.valueOf(continent as String)));
//                }
//            }
//        }

        runBlocking {
            launch(Dispatchers.IO) {

                animals = AnimalDatabase.getInstance(context).AnimalDao().getAllAnimals() as ArrayList<Animal>;
            }
        }
//        val thread : Thread = (Runnable {
//            animals = AnimalDatabase.getInstance(context).AnimalDao().getAllAnimals() as ArrayList<Animal>;
//        } as Thread)


//        animals.add(Animal("Wolf", Continent.Europe))
//        animals.add(Animal("Dragon", Continent.Asia))
//        animals.add(Animal("Wolf", Continent.Europe))
//        animals.add(Animal("Dragon", Continent.Asia))
//        animals.add(Animal("Zebra", Continent.Africa))
//        animals.add(Animal("Wolf", Continent.Europe))
//        animals.add(Animal("Wolf", Continent.Europe))
//        animals.add(Animal("Kangaroo", Continent.Australia))
//        animals.add(Animal("Zebra", Continent.Africa))
//        animals.add(Animal("Racoon", Continent.America))
//        animals.add(Animal("Zebra", Continent.Africa))
//        animals.add(Animal("Wolf", Continent.Europe))
//        animals.add(Animal("Dragon", Continent.Asia))
//        animals.add(Animal("Kangaroo", Continent.Australia))
//        animals.add(Animal("Wolf", Continent.Europe))
//        animals.add(Animal("Racoon", Continent.America))
//        animals.add(Animal("Zebra", Continent.Africa))
//        animals.add(Animal("Kangaroo", Continent.Australia))
//        animals.add(Animal("Wolf", Continent.Europe))
//        animals.add(Animal("Racoon", Continent.America))
//        animals.add(Animal("Kangaroo", Continent.Australia))
//        animals.add(Animal("Dragon", Continent.Asia))
//        animals.add(Animal("Kangaroo", Continent.Australia))
//        animals.add(Animal("Wolf", Continent.Europe))
//        animals.add(Animal("Dragon", Continent.Asia))
//        animals.add(Animal("Racoon", Continent.America))
//        animals.add(Animal("Zebra", Continent.Africa))
//        animals.add(Animal("Racoon", Continent.America))
//        animals.add(Animal("Wolf", Continent.Europe))
//        animals.add(Animal("Kangaroo", Continent.Australia))
//        animals.add(Animal("Zebra", Continent.Africa))
//        animals.add(Animal("Dragon", Continent.Asia))
//        animals.add(Animal("Racoon", Continent.America))
//        animals.add(Animal("Kangaroo", Continent.Australia))
//        animals.add(Animal("Racoon", Continent.America))
//        animals.add(Animal("Zebra", Continent.Africa))
//        animals.add(Animal("Zebra", Continent.Africa))
//        animals.add(Animal("Dragon", Continent.Asia))
//        animals.add(Animal("Kangaroo", Continent.Australia))
//        animals.add(Animal("Dragon", Continent.Asia))
//        animals.add(Animal("Kangaroo", Continent.Australia))
//        animals.add(Animal("Racoon", Continent.America))
//        animals.add(Animal("Zebra", Continent.Africa))
//        animals.add(Animal("Dragon", Continent.Asia))
//        animals.add(Animal("Racoon", Continent.America))
//        animals.add(Animal("Wolf", Continent.Europe))
//        animals.add(Animal("Dragon", Continent.Asia))
//        animals.add(Animal("Zebra", Continent.Africa))
//        animals.add(Animal("Kangaroo", Continent.Australia))
//        animals.add(Animal("Racoon", Continent.America))


        adapter = AnimalsAdapter(animals)

        recycleView.adapter = adapter
        adapter.setClickListener(this)
        val layoutManager = LinearLayoutManager(context)
        recycleView.layoutManager = layoutManager

    }

    private fun showInvalidDialog(title: String, message: String) {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
        alertDialog.show()
    }

    private fun addAnimalToSharedPreferences(context: Context, animal: Animal) {
//        GlobalScope.launch(Dispatchers.IO) {
//            val sharedPreferences = context.getSharedPreferences("Animals", Context.MODE_PRIVATE)
//            val editor = sharedPreferences.edit()
//            editor.putString(animal.name, animal.continent.toString())
//            editor.apply()
//        }

        runBlocking {
            launch(Dispatchers.IO) {
                AnimalDatabase.getInstance(context).AnimalDao().addAnimal(animal)
                animals.add( AnimalDatabase.getInstance(context).AnimalDao().getAnimal(animal.name))
            }
        }

    }

    private fun deleteAnimalFromSharedPreferences(context: Context, animal: Animal) {
//        GlobalScope.launch(Dispatchers.IO) {
//            val sharedPreferences = context.getSharedPreferences("Animals", Context.MODE_PRIVATE)
//            val editor = sharedPreferences.edit()
//            editor.remove(key)
//            editor.apply()
//        }

        runBlocking {
            launch(Dispatchers.IO) {
                AnimalDatabase.getInstance(context).AnimalDao().deleteAnimal(animal)
            }
        }
    }

    private fun updateAnimal(animal: Animal) {
        val updateAnimalTask = UpdateAnimalTask(context)
        updateAnimalTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, animal)
    }

    class UpdateAnimalTask(private val context: Context?) : AsyncTask<Animal, Void, Void>() {
        private lateinit var animalDao: AnimalDao

        override fun doInBackground(vararg animals: Animal): Void? {
            val animalDatabase = AnimalDatabase.getInstance(context)
            animalDao = animalDatabase.AnimalDao()
            animalDao.updateAnimal(animals[0])
            return null
        }
    }

    private fun retrieveDataFromEditText(): Pair<String, String> {
        val animalName = animalNameEditText.text.toString()
        val continent = continentEditText.text.toString()
        return Pair(animalName, continent)
    }

    override fun onClick(view: View?, position: Int) {
        when (view?.id) {
            R.id.add_button -> {
                val (animalName, continent) = retrieveDataFromEditText()
                if (animalName.isEmpty() or animalName.all { it == ' ' })
                    {
                        showInvalidDialog("Name is blank" ,"Please enter a valid name.");
                        return;
                    }

                if (Continent.values().find{ it.toString() == continent} == null)
                {
                    showInvalidDialog("Invalid continent.", "Please enter a valid continent.");
                    return;
                }

                val animal = animals.firstOrNull { it.name.lowercase() == animalName.lowercase() };
                if (animal != null)
                {
                    updateAnimal(animal)
                    animal.continent = continent;
                    adapter.notifyItemChanged(animals.indexOf(animal));
                    return;
                }

                val newAnimal = Animal(animalName, continent);
                context?.let { addAnimalToSharedPreferences(it, newAnimal) }
                adapter.notifyItemInserted(animals.size - 1)
                return;
            }
        }
        context?.let { deleteAnimalFromSharedPreferences(it, animals[position]) }
        animals.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}