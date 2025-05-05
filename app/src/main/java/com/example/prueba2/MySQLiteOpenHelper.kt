package com.example.prueba2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLiteOpenHelper(context: Context): SQLiteOpenHelper(context,"amigos.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val orderCreate = "CREATE TABLE amigos (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "email TEXT)"
        db!!.execSQL(orderCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val orderDelete ="DROP TABLE IF EXISTS amigos"
        db!!.execSQL(orderDelete)
        onCreate(db)

    }

    fun insertData(name: String, email: String){
        val values = ContentValues()
        values.put("name",name)
        values.put("email", email)
        val db = this.writableDatabase
        db.insert("amigos",null,values)
        db.close()
    }
}