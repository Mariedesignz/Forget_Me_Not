package com.example.forgetmenot

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_TASK_DESCRIPTION = "task"

class TaskDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_description)
    }

    // 3
    fun doneClicked(view: View) {
        // 1
        val descriptionText = findViewById<EditText>(R.id.descriptionText)
        val taskDescription = descriptionText.text.toString()

        if (!taskDescription.isEmpty()) {
            // 2
            val result = Intent()
            result.putExtra(EXTRA_TASK_DESCRIPTION, taskDescription)
            setResult(Activity.RESULT_OK, result)
        } else {
            // 3
            setResult(Activity.RESULT_CANCELED)
        }// 4
        finish()
    }
}