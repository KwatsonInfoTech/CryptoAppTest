package com.example.cryptoapptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapptest.adapter.Adapter
import com.example.cryptoapptest.cryptoViewModel.CryptoVM
import com.example.cryptoapptest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewmodel: CryptoVM by viewModels()
    private lateinit var adapter: Adapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewmodel.repository.observe(this){

            Log.i("data", it.data.toString())
            adapter.submitList(it?.data)
        }

        adapter = Adapter(Adapter.OnClickListener{


        })
        binding.CryptoRV.adapter = adapter
        binding.CryptoRV.layoutManager = LinearLayoutManager(this)




    }
}