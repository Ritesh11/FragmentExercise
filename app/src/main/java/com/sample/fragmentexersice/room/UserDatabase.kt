package com.sample.fragmentexersice.room

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.RenameColumn
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.sample.fragmentexersice.model.User

@Database(
    entities = [User::class],
    version = 4, autoMigrations = [AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3, spec = UserDatabase.Migrate2To3::class),
    AutoMigration(from = 3, to = 4, spec = UserDatabase.Migrate3To4::class)]
)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    @RenameColumn(tableName = "registered_user_table", fromColumnName = "technology", toColumnName = "department")
    class Migrate2To3: AutoMigrationSpec

    @DeleteColumn(tableName = "registered_user_table", columnName = "user_position")
    class Migrate3To4: AutoMigrationSpec

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, UserDatabase::class.java,
                        "registered_user_table"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }
}