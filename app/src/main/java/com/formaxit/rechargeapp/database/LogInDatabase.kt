package com.formaxit.rechargeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserCred::class], version = 1, exportSchema = false)
abstract class LogInDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object {

        @Volatile
        private var INSTANCE: LogInDatabase? = null

        fun getInstance(context: Context): LogInDatabase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LogInDatabase::class.java,
                        "log_in_database")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}