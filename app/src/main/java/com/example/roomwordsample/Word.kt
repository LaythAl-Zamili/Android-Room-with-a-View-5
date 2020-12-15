package com.example.roomwordsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)


//annotation class ColumnInfo(val name: String)

//annotation class PrimaryKey

//annotation class Entity(val tableName: String)

// Note : In the DAO (data access object), you specify SQL queries and associate them with method calls. The compiler checks the SQL and generates queries from convenience annotations for common queries, such as @Insert. Room uses the DAO to create a clean API for your code.
//
//The DAO must be an interface or abstract class. //Layth