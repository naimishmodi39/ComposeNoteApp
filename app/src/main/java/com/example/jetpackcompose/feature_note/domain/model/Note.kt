package com.example.jetpackcompose.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jetpackcompose.theme.*
import java.sql.Timestamp

@Entity
data class Note(
    val title:String,
    val content:String,
    val timestamp:Long,
    val color:Int,
    @PrimaryKey val id:Int?=null,

){
    companion object{
        val noteColors  = listOf<Color>(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }

}

class InvalidNoteException(message:String):Exception(message)
