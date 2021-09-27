package com.example.forgetmenot

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.content.Intent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

const val LOG_TAG = "MainActivityLog"

class MainActivity : AppCompatActivity() {
    // 1
    private val taskList: MutableList<String> = mutableListOf()
    private val ADD_TASK_REQUEST = 1
    private lateinit var dateTimeTextView: TextView
    private val tickReceiver by lazy { makeBroadcastReceiver() }

    companion object {
        private fun getCurrentTimeStamp(): String {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
            val now = Date()
            return simpleDateFormat.format(now)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 4
        val taskListView = findViewById<RecyclerView>(R.id.recyclerView)
        taskListView.adapter = adapter //TODO need to create an adapter

        // 5
        /*   TODO what would you like to happen when the list is clicked taskListView.onItemClickListener {
                         parent, view, position, id ->

                 }*/
        val intent = Intent(this, TaskDescriptionActivity::class.java)
        startActivityForResult(intent, ADD_TASK_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            // 3
            val task = data?.getStringExtra(EXTRA_TASK_DESCRIPTION)
            task?.let {
                taskList.add(task)
                // 4
                adapter.notifyDataSetChanged()
                makeBroadcastReceiver()
            }
        }
    }
}

// 6
fun addTaskClicked(view: View) {
    TODO("not yet implemented")
}

// 7

private fun makeBroadcastReceiver(): BroadcastReceiver {
    return object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            if (intent?.action == Intent.ACTION_TIME_TICK) {
                TODO("not yet implemented")
            }
        }
    }
}
