package com.example.tms_an_15_homework_lesson_20

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatEditText
import java.util.Date

class CreateNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        val button = findViewById<AppCompatButton>(R.id.button)
        button.setOnClickListener {

            val titleView = findViewById<AppCompatEditText>(R.id.title)
            val title = titleView.text.toString()
            val textView = findViewById<AppCompatEditText>(R.id.text)
            val text = textView.text.toString()
            val date = Date(System.currentTimeMillis())
            val checkBoxView = findViewById<AppCompatCheckBox>(R.id.check_box)
            val important = checkBoxView.isChecked

            if (title.isBlank()) {
                titleView.error = "Empty title"
            }

            if (text.isBlank()) {
                textView.error = "Empty title"
            }

            if (!title.isBlank() && !text.isBlank()) {
                val intent = Intent()
                if (important) {
                    intent.putExtra("important_note", ImportantNote(title, text, date))
                } else {
                    intent.putExtra("note", Note(title, text, date))
                }
                setResult(101, intent)
                finish()
            }
        }
    }
}