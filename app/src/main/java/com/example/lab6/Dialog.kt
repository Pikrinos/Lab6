package com.example.lab6

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class Dialog : DialogFragment() {

    private var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        number = arguments?.getInt("number") as Int
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Number")
            .setMessage("Your number is $number")
            .setPositiveButton("Ok",null)
            .create()
    }
    companion object {
        fun getNumber(number: Int): com.example.lab6.Dialog {
            val args = Bundle()
            args.putInt("number",number)
            val fragment = Dialog()
            fragment.arguments = args
            return fragment
        }
    }
}