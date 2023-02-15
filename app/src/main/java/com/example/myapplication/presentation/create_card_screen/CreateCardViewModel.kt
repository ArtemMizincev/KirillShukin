package com.example.myapplication.presentation.create_card_screen

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.db.model.Card
import com.example.myapplication.domain.use_case.ExpenseUseCase
import com.example.myapplication.presentation.main_screen.MainActivity
import com.example.myapplication.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateCardViewModel(): ViewModel() {

    fun insert(card: Card) = viewModelScope.launch(Dispatchers.IO) {
        REPOSITORY.insertCard(card)
    }

    inline fun checkExpense(
        summa: String,
        context: Context,
        job: () -> Unit,
    ){
        val expenseUseCase = ExpenseUseCase(context)
        val oldValue = expenseUseCase.getExpense()
        val result = "${(oldValue!!.toInt()) - summa.toInt()}"

        if (result.toInt() >= 0) {
            expenseUseCase.putExpense(result)
            job()
        }else {
            Toast.makeText(context, "недостаточно средств, на вашем счете $oldValue", Toast.LENGTH_LONG).show()
        }

    }

}

