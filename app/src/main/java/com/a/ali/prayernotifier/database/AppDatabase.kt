package com.a.ali.prayernotifier.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.a.ali.prayernotifier.model.DayDatabaseModel

@Database(entities = [DayDatabaseModel::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "prayer_notifier"
                ).apply {
                    addMigrations(object : Migration(2, 3) {
                        override fun migrate(database: SupportSQLiteDatabase) {
                            //delete old table DayData
                            database.execSQL("DROP TABLE IF EXISTS  `DayDate`")

                            //create new table DayDatabaseModel
                            database.execSQL("CREATE TABLE IF NOT EXISTS `DayDatabaseModel` (`fajr` TEXT NOT NULL, `sunrise` TEXT NOT NULL, `dhuhr` TEXT NOT NULL, `asr` TEXT NOT NULL, `maghrib` TEXT NOT NULL, `isha` TEXT NOT NULL, `gregorianDateEN` TEXT NOT NULL, `gregorianDateAR` TEXT NOT NULL, `hijriDateEN` TEXT NOT NULL, `hijriDateAR` TEXT NOT NULL, `dayNameEN` TEXT NOT NULL, `dayNameAR` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)")                        }
                    })
                }
                INSTANCE = instance.build()

                INSTANCE
            }!!
        }
    }
}