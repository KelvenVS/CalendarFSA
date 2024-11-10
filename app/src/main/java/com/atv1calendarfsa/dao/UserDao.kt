package com.atv1calendarfsa.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.atv1calendarfsa.database.DatabaseHelper
import com.atv1calendarfsa.database.UserTable
import com.atv1calendarfsa.model.User

class UserDao(context: Context) {
    private val dbHelper = DatabaseHelper(context)

    fun insertUser(user: User): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(UserTable.COLUMN_USERNAME, user.username)
            put(UserTable.COLUMN_PASSWORD, user.password)
            put(UserTable.COLUMN_NAME, user.name)
            put(UserTable.COLUMN_EMAIL, user.email)
            put(UserTable.COLUMN_PHONE, user.phone)
        }
        return db.insert(UserTable.TABLE_NAME, null, values)
    }

    fun getUser(username: String, password: String): User? {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            UserTable.TABLE_NAME,
            null,
            "${UserTable.COLUMN_USERNAME} = ? AND ${UserTable.COLUMN_PASSWORD} = ?",
            arrayOf(username, password),
            null,
            null,
            null
        )
        return if (cursor.moveToFirst()) {
            User(
                id = cursor.getLong(cursor.getColumnIndexOrThrow(UserTable.COLUMN_ID)),
                username = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.COLUMN_USERNAME)),
                password = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.COLUMN_PASSWORD)),
                name = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.COLUMN_NAME)),
                email = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.COLUMN_EMAIL)),
                phone = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.COLUMN_PHONE))
            )
        } else {
            null
        }.also {
            cursor.close()
            db.close()
        }
    }

    fun updatePassword(email: String, newPassword: String): Boolean {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(UserTable.COLUMN_PASSWORD, newPassword)
        }
        val rowsAffected = db.update(
            UserTable.TABLE_NAME,
            values,
            "${UserTable.COLUMN_EMAIL} = ?",
            arrayOf(email)
        )
        db.close()
        return rowsAffected > 0
    }


    // UserDao.kt
    fun getUserById(id: Long): User? {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            UserTable.TABLE_NAME,
            null,
            "${UserTable.COLUMN_ID} = ?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        return if (cursor.moveToFirst()) {
            User(
                id = cursor.getLong(cursor.getColumnIndexOrThrow(UserTable.COLUMN_ID)),
                username = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.COLUMN_USERNAME)),
                password = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.COLUMN_PASSWORD)),
                name = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.COLUMN_NAME)),
                email = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.COLUMN_EMAIL)),
                phone = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.COLUMN_PHONE))
            )
        } else {
            null
        }.also {
            cursor.close()
            db.close()
        }
    }

    // Funções adicionais para update e delete podem ser adicionadas aqui
}
