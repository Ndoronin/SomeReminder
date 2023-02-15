package com.example.somereminder

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.somereminder.databinding.FragmentAddTaskBinding


class AddTaskFragment : Fragment() {

    private val binding: FragmentAddTaskBinding by viewBinding()
    private lateinit var mTaskViewModel:TaskViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_add_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mTaskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]
        binding.fabAddNewTask.setOnClickListener {
            insertDataToDatabase()
        }
    }


    private fun insertDataToDatabase() {
        val task = binding.newTaskEditText.text.toString()
        val date = binding.dateEditText.text.toString()

        if (inputCheck(task,date)){
            val task = Task(0,task,date)
            mTaskViewModel.addTask(task)
            Toast.makeText(requireContext(),"Successfully added!",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addTaskFragment_to_mainFragment)
        } else{
            Toast.makeText(requireContext(),"Please fill out all fields",Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(task:String,date:String):Boolean{
        return !(TextUtils.isEmpty(task) && TextUtils.isEmpty(date))
    }


}