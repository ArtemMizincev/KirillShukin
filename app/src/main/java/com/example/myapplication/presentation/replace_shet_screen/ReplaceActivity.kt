package com.example.myapplication.presentation.replace_shet_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityReplaceBinding
import com.example.myapplication.domain.use_case.ExpenseUseCase
import com.example.myapplication.presentation.main_screen.MainActivity

class ReplaceActivity : AppCompatActivity() {
    lateinit var binding: ActivityReplaceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReplaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val expenseUseCase = ExpenseUseCase(this)

        binding.button.setOnClickListener {
            expenseUseCase.putExpense(binding.shetText.text.toString())
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}