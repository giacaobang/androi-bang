package com.example.jetnote.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteDbModel(
  @PrimaryKey(autoGenerate = true) val id: Long = 0,
  @ColumnInfo(name = "title") val title: String,
  @ColumnInfo(name = "content") val content: String,
  @ColumnInfo(name = "can_be_checked_off") val canBeCheckedOff: Boolean,
  @ColumnInfo(name = "is_checked_off") val isCheckedOff: Boolean,
  @ColumnInfo(name = "color_id") val colorId: Long,
  @ColumnInfo(name = "in_trash") val isInTrash: Boolean
) {

  companion object {

    val DEFAULT_NOTES = listOf(
      NoteDbModel(1, "English", "Speaking, Reading, Writing", false, false, 1, false),
      NoteDbModel(2, "Food", "Milk, eggs, salt, flour...", false, false, 2, false),
      NoteDbModel(3, "Math", "Math", false, false, 3, false),
      NoteDbModel(4, "history", "history", false, false, 4, false),
      NoteDbModel(5, "professional life training", "professional life training", false, false, 5, false),
      NoteDbModel(6, "development activities", "development activities", false, false, 6, false),
      NoteDbModel(7, "java", "java", false, false, 7, false),
      NoteDbModel(8, "Title 8", "Content 8", false, false, 8, false)
    )
  }
}
