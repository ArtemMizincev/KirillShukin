package com.example.myapplication.domain.use_case

import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import com.example.myapplication.utils.APP_PREFERENCES
import com.example.myapplication.utils.PREFERENCES_VALUE

class ExpenseUseCase(context: Context) {
    private var preference: SharedPreferences = ContextWrapper(context).getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

    fun putExpense(string: String){
        preference.edit()
            .putString(PREFERENCES_VALUE, string)
            .apply()
    }

    fun getExpense(): String? {
        return preference.getString(PREFERENCES_VALUE, "")
    }
}
