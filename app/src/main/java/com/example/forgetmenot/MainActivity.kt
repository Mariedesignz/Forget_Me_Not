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
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    // 1
    private val taskList: MutableList<String> = mutableListOf()
    private val adapter by lazy { makeAdapter(taskList) }
    private val ADD_TASK_REQUEST = 1
    private val tickReceiver by lazy { makeBroadcastReceiver() }

    private fun makeBroadcastReceiver() {
        TODO("Not yet implemented")
    }

    companion object {
        private const val LOG_TAG = "MainActivityLog"

        private fun getCurrentTimeStamp(): String {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
            val now = Date()
            return simpleDateFormat.format(now)
        }
    }

    val intent = Intent(this, TaskDescriptionActivity::class.java)
    startActivityForResult(intent, ADD_TASK_REQUEST)

    override fun onCreate(savedInstanceState: Bundle?) {override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // 1
        if (requestCode == ADD_TASK_REQUEST) {
            // 2
            if (resultCode == Activity.RESULT_OK) {
                // 3
                val task = data?.getStringExtra(TaskDescriptionActivity.EXTRA_TASK_DESCRIPTION)
                task?.let {
                    taskList.add(task)
                    // 4
                    adapter.notifyDataSetChanged()
                    private fun makeBroadcastReceiver(): BroadcastReceiver {
                        return object : BroadcastReceiver() {
                            override fun onReceive(context: Context, intent: Intent?) {
                                if (intent?.action == Intent.ACTION_TIME_TICK) {
                                    val dateTimeTextView
                                    dateTimeTextView.text = getCurrentTimeStamp()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
        // 2
        super.onCreate(savedInstanceState)
        // 3
        setContentView(R.layout.activity_main)

        // 4
        taskListView.adapter = adapter

        // 5
        taskListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> }
    }

    // 6
    fun addTaskClicked(view: View) {

    }

    // 7
    private fun makeAdapter(list: List<String>): ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
    private fun makeBroadcastReceiver(): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent?) {
                if (intent?.action == Intent.ACTION_TIME_TICK) {
                    val dateTimeTextView = null
                    dateTimeTextView.text = getCurrentTimeStamp()
                }
            }
        }
    }
}