package com.example.lovecalculator_mvvm

import android.content.Context
import android.widget.Toast

class Utils {

    fun showToast(context: Context){
        Toast.makeText(context, "Hello lucky boy/girl", Toast.LENGTH_SHORT).show()
    }

}