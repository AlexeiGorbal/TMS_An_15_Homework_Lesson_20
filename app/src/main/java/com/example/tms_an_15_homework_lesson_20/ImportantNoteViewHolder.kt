package com.example.tms_an_15_homework_lesson_20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.text.SimpleDateFormat

class ImportantNoteViewHolder(view: View) : BaseNoteViewHolder(view) {
    companion object {

        fun from(parent: ViewGroup): ImportantNoteViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_important_note, parent, false
            )
            return ImportantNoteViewHolder(view)
        }
    }
}