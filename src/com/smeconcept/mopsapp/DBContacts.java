package com.smeconcept.mopsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBContacts {
    static final String KEY_ROWID = "_id";
    static final String KEY_NAME = "name";
    static final String KEY_START = "start";
	static final String KEY_LUNCH= "lunch";
	static final String KEY_FINISH="finish";
	static final String KEY_MONTH="month";
	static final String KEY_DAY="day";
	static final String KEY_YEAR="year";
	static final String KEY_STATUS ="status";
	static final String KEY_REAL_START="r_start";
	static final String KEY_REAL_LUNCH="r_lunch";
	static final String KEY_REAL_FINISH="r_finish";
	static final String KEY_REPORT ="report";
    static final String TAG = "DBContacts";

    static final String DATABASE_NAME = "MyDBC45";
    static final String DATABASE_TABLE = "contacts";
    static final int DATABASE_VERSION = 1;

    static final String DATABASE_CREATE =
	"create table contacts (_id integer primary key autoincrement, "
	+ "name tfext not null, start number not null, lunch number, finish number, status text, month number, day number, year number,r_start number not null, r_lunch number, r_finish number, report text );";

    final Context context;

    DatabaseHelper DBHelper;
    SQLiteDatabase DBC2;

    public DBContacts(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase DBC2)
        {
            try {
                DBC2.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase DBC2, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
				  + newVersion + ", which will destroy all old data");
            DBC2.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(DBC2);
        }
    }

    //---opens the database---
    public DBContacts open() throws SQLException 
    {
        DBC2 = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close() 
    {
        DBHelper.close();
    }

    //---insert a contact into the database---
    public long insertContact(String name, Integer start, Integer lunch, Integer finish, String status,Integer month, Integer day, Integer year, Integer r_start, Integer r_lunch, Integer r_finish, String report) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_START, start);
		initialValues.put(KEY_LUNCH, lunch);
		initialValues.put(KEY_FINISH, finish);	
		initialValues.put(KEY_STATUS, status);
		initialValues.put(KEY_MONTH, month);
		initialValues.put(KEY_DAY, day);
		initialValues.put(KEY_YEAR, year);
		initialValues.put(KEY_REAL_START, r_start);
		initialValues.put(KEY_REAL_LUNCH, r_lunch);
		initialValues.put(KEY_REAL_FINISH, r_finish);
		initialValues.put(KEY_REPORT, report);	
        return DBC2.insert(DATABASE_TABLE, null, initialValues);
    }

    //---deletes a particular contact---
    public boolean deleteContact(long rowId) 
    {
        return DBC2.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    //---retrieves all the contacts---
    public Cursor getAllContacts()
    {
        return DBC2.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_NAME,
							  KEY_START, KEY_LUNCH, KEY_FINISH, KEY_STATUS, KEY_MONTH, KEY_DAY, KEY_YEAR, KEY_REAL_START, KEY_REAL_LUNCH, KEY_REAL_FINISH, KEY_REPORT}, null, null, null, null, null);
    }

    //---retrieves a particular contact---
    public Cursor getContact(long rowId) throws SQLException 
    {
        Cursor mCursor =
			DBC2.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
						   KEY_NAME, KEY_START, KEY_LUNCH, KEY_FINISH, KEY_STATUS, KEY_MONTH, KEY_DAY, KEY_YEAR, KEY_REAL_START, KEY_REAL_LUNCH, KEY_REAL_FINISH, KEY_REPORT}, KEY_ROWID + "=" + rowId, null,
					 null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a contact---
    public boolean updateContact(long rowId, String name, Integer start, Integer lunch, Integer finish, String status,Integer month, Integer day, Integer year, Integer r_start, Integer r_lunch, Integer r_finish, String report) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_START, start);
		args.put(KEY_LUNCH, lunch);
		args.put(KEY_FINISH, finish);
		args.put(KEY_STATUS, status);
		args.put(KEY_MONTH, month);
		args.put(KEY_DAY, day);
		args.put(KEY_YEAR, year);
		args.put(KEY_REAL_START, r_start);
		args.put(KEY_REAL_LUNCH, r_lunch);
		args.put(KEY_REAL_FINISH, r_finish);
		args.put(KEY_REPORT, report);
        return DBC2.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
	
	public boolean updatePunchIn(long rowId, Integer r_start) 
    {
        ContentValues args = new ContentValues();
        
		args.put(KEY_REAL_START, r_start);
		
        return DBC2.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
	
	
	public boolean updateReport(long rowId,String report) 
    {
        ContentValues args = new ContentValues();
		args.put(KEY_REPORT, report);
        return DBC2.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
	
	public boolean updatePunchOut(long rowId,Integer r_finish) 
    {
        ContentValues args = new ContentValues();
		args.put(KEY_REAL_FINISH, r_finish);
        return DBC2.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
	
}

