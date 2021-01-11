package com.android.postest8;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "posttes.db";
    private static int DATABASE_VERSION = 1;
    public DataHelper (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table tb_brg(no integer primary key, barang text null, harga integer null, stok integer null, suplier text null);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql);
        String sql2 = "create table login(no integer primary key autoincrement, username text null, password text null);";
        Log.d("Data2","onCreate: "+sql2);
        db.execSQL(sql2);
        sql2 = "INSERT INTO login (username, password) VALUES ('ahmada', '1800018279');";
        db.execSQL(sql2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }
}
