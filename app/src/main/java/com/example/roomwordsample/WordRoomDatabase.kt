package com.example.roomwordsample

import android.content.Context

import kotlin.reflect.KClass

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        WordRoomDatabase::class.java,
                        "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

open class RoomDatabase {

}

annotation class Database(val entities: Array<KClass<Word>>, val version: Int, val exportSchema: Boolean)

class Room {

}
