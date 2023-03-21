package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.itemAdapter
import com.example.myapplication.Items.ItemListener
import com.example.myapplication.Items.OneItem
import com.example.myapplication.Model.ItemModelFactory
import com.example.myapplication.Model.LR2App
import com.example.myapplication.Model.VModel
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ItemListener {
    private lateinit var binding: ActivityMainBinding
    private val vModel : VModel by viewModels {
        ItemModelFactory((application as LR2App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //vModel = ViewModelProvider(this).get(VModel::class.java)

        binding.addItemButton.setOnClickListener{
            NewItem(null).show(supportFragmentManager,"newItemTag")
        }

        setRecyclerView()

    }

    private fun setRecyclerView(){
        val mainActivity = this
        vModel.items.observe(this){
            binding.itemRecycleView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = itemAdapter(it,mainActivity)
            }
        }
    }

    override fun editItem(oneItem: OneItem) {
        NewItem(oneItem).show(supportFragmentManager,"newItemTag")
    }

    override fun deleteItem(oneItem: OneItem) {
        vModel.deleteItem(oneItem)
    }

}