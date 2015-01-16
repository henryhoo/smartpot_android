package com.jikexueyuan.usingslidingmenu;

import java.util.logging.LoggingPermission;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Db extends SQLiteOpenHelper {

	public Db(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		Log.d("TAG", "start");
		arg0.execSQL("CREATE TABLE IF NOT EXISTS pot(" +
				"time INTEGER PRIMARY KEY AUTOINCREMENT," +
				"humid TEXT DEFAULT \"\"," +
				"tem TEXT DEFAULT \"\")");
		Log.d("TAG", "pot");
		arg0.execSQL("CREATE TABLE IF NOT EXISTS plants(" +
		"_id INTEGER PRIMARY KEY AUTOINCREMENT," +
				"humid TEXT DEFAULT \"\"," +
				"name TEXT DEFAULT \"\","+
				"tem TEXT DEFAULT \"\")");
		Log.d("TAG", "plants");

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
