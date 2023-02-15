package com.example.myapplication.presentation.main_screen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MainViewModel
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.domain.use_case.ExpenseUseCase
import com.example.myapplication.presentation.create_card_screen.CreateCardActivity
import com.example.myapplication.presentation.replace_shet_screen.ReplaceActivity


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MainAdapter
    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.initDatabase()

        adapter = MainAdapter(this)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.replaceButton.setOnClickListener{
            startActivity(Intent(this, ReplaceActivity::class.java))
        }

        binding.addCardButton.setOnClickListener{
            startActivity(Intent(this, CreateCardActivity::class.java))
        }

        viewModel.getAllNotes().observe(this){
            adapter.addCard(it.asReversed())
        }


    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()

        val expenseUseCase = ExpenseUseCase(this)
        binding.Shet.setText("счет: ${expenseUseCase.getExpense()}")
    }

}


