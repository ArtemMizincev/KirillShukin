package com.example.myapplication.presentation.create_card_screen


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.db.model.Card
import com.example.myapplication.databinding.ActivityCreateCardBinding
import com.example.myapplication.domain.use_case.ExpenseUseCase
import com.example.myapplication.presentation.main_screen.MainActivity


class CreateCardActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val createCardViewModel = ViewModelProvider(this)[CreateCardViewModel::class.java]

        binding.createCardButtom.setOnClickListener {
            val summa = binding.summaText.text.toString()

            createCardViewModel.checkExpense(
                summa = summa,
                context = this
            ) {
                createCardViewModel.insert(
                    Card(
                        title = binding.titleText.text.toString(),
                        sum = summa
                    )
                )
                startActivity(Intent(this, MainActivity::class.java))
            }

        }

    }


}