package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private val allFoundMembers: MutableList<Pair<Person, Int>> = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setupBinding()
        searchForMothersAndFathers(createPersons())
        setupRecycleAdapter(allFoundMembers)

//        searchForMothersAndFathers(createPersons())
//        allFoundMembers.forEach {
//            println(it.first.name.padStart(4 * it.second + it.first.name.length - 4))
//            println(it.first.age.toString().padStart(4 * it.second + it.first.age.toString().length - 4)
//            )
//        }
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupRecycleAdapter(list: List<Pair<Person, Int>>) {
        binding.recycleView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recycleView.addItemDecoration(
            DividerItemDecoration(
                this,
                RecyclerView.VERTICAL
            )
        )
        binding.recycleView.adapter = RecycleAdapter(list)
    }

    private fun createPersons(): Person {
        val person1 = Person("Elena", 91, father = null, mother = null)
        val person2 = Person("Mariam", 83, father = null, mother = null)
        val person3 = Person("Vova", 99, father = null, mother = null)
        val person4 = Person("Nastya", 74, father = null, mother = null)
        val person5 = Person("Vladimir", 81, father = null, mother = null)
        val person6 = Person("Mira", 52, father = null, mother = null)

        val person7 = Person("Lyuda", 58, father = null, mother = person1)
        val person8 = Person("Kostya", 54, father = null, mother = person2)
        val person9 = Person("Evgeniy", 17, father = person3, mother = person4)
        val person10 = Person("Valya", 24, father = person5, mother = person6)

        val person11 = Person("Lenya", 17, father = person8, mother = person7)
        val person12 = Person("Katya", 24, father = person9, mother = person10)

        val me = Person("Me", 1, father = person11, mother = person12)

        allFoundMembers.clear()
        allFoundMembers.add(me to 1)

        return me
    }

    private fun searchForMothersAndFathers(person: Person, generation: Int = 1) {
        person.mother?.also {
            allFoundMembers.add(it to (generation + 1))
            searchForMothersAndFathers(it, generation + 1)
        }
        person.father?.also {
            allFoundMembers.add(it to (generation + 1))
            searchForMothersAndFathers(it, generation + 1)
        }
    }
}