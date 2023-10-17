package com.example.tms_an_15_homework_lesson_20

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycle = findViewById<RecyclerView>(R.id.recycler)
        recycle.layoutManager = LinearLayoutManager(this)

        val adapter = NoteAdapter {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, it.title + "\n" + it.text)
            val chooser = Intent.createChooser(intent, null)
            try {
                startActivity(chooser)
            } catch (e: ActivityNotFoundException) {
                // Define what your app should do if no activity can handle the intent.
            }
        }

        recycle.adapter = adapter

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val note = it.data?.getParcelableExtra<Note>("note")
                ?: it.data?.getParcelableExtra<ImportantNote>("important_note")
            if (note != null) {
                adapter.addNote(note)
            }
        }

        val button = findViewById<AppCompatButton>(R.id.button)
        button.setOnClickListener {
            launcher.launch(Intent(this, CreateNoteActivity::class.java))
        }

    }
}