package com.atv1calendarfsa.database

object UserTable {
    const val TABLE_NAME = "users"
    const val COLUMN_ID = "id"
    const val COLUMN_USERNAME = "username"
    const val COLUMN_PASSWORD = "password"
    const val COLUMN_NAME = "name"
    const val COLUMN_EMAIL = "email"
    const val COLUMN_PHONE = "phone"

    const val CREATE_TABLE = """
        CREATE TABLE $TABLE_NAME (
            $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMN_USERNAME TEXT,
            $COLUMN_PASSWORD TEXT,
            $COLUMN_NAME TEXT,
            $COLUMN_EMAIL TEXT,
            $COLUMN_PHONE TEXT
        )
    """
}
