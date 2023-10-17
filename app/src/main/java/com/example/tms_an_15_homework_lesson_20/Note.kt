package com.example.tms_an_15_homework_lesson_20

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Note(
    override val title: String,
    override val text: String,
    override val date: Date
) : BaseNote(title, text, date), Parcelable
