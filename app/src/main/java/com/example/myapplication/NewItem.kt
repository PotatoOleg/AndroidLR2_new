package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Items.OneItem
import com.example.myapplication.Model.VModel
import com.example.myapplication.databinding.FragmentNewItemBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.math.cos


class NewItem(var item:OneItem?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewItemBinding
    private lateinit var vModel : VModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if(item!=null){
            binding.ItemNameText.text = "Edit Item"
            val editable = Editable.Factory.getInstance()
            binding.itemName.text = editable.newEditable(item!!.name)
            binding.itemCost.text = editable.newEditable(item!!.cost)

        }else{
            binding.ItemNameText.text = "New Item"
        }

        vModel = ViewModelProvider(activity).get(VModel::class.java)

        binding.saveButton.setOnClickListener {

            saveAction()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewItemBinding.inflate(inflater,container,false)

        return binding.root
    }

    private fun saveAction(){
        val name = binding.itemName.text.toString()
        val cost = binding.itemCost.text.toString()

        if(item == null){                       //добавление записи
            val newItem = OneItem(name,cost)
            vModel.addItem(newItem)
        }else{                                  //модернизаця записи
            item!!.name = name
            item!!.cost = cost

            vModel.updateItem(item!!)
        }

        binding.itemName.setText("")
        binding.itemCost.setText("")
        dismiss()
    }


}