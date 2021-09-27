package com.example.forgetmenot

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.forgetmenot.R.layout.activity_task_description
import java.lang.reflect.Array.get


private val Nothing?.text: Any
    get() {}

class TaskDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_task_description)
        private val kotlin.Nothing?.text: Any
        get() {}
        

        val companion
        val companion1 = companion object {
            val EXTRA_TASK_DESCRIPTION = "task"
        }

        // 2
        @SuppressLint("MissingSuperCall")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            super.onCreate(savedInstanceState)
            super.onCreate(savedInstanceState)
            setContentView(activity_task_description)
        }

        // 3
        fun doneClicked(view: View) {

        }
        // 1
        val descriptionText = null
        val taskDescription = descriptionText.text.toString()

        if (!taskDescription.isEmpty()) {
            // 2
            val result = Intent()
            val EXTRA_TASK_DESCRIPTION
            result.putExtra(EXTRA_TASK_DESCRIPTION, taskDescription)
            setResult(Activity.RESULT_OK, result)
        } else {
            // 3
            setResult(Activity.RESULT_CANCELED)
        }

// 4
        finish()
    }
}