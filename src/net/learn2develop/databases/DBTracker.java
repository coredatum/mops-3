package net.learn2develop.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBTracker {
    static final String KEY_ROWID = "_id";
    static final String KEY_NAME = "name";
    static final String KEY_REAL_START = "r_start";
	static final String KEY_REAL_LUNCH= "r_lunch";
	static final String KEY_REAL_FINISH="r_finish";
	static final String KEY_MONTH="month";
	static final String KEY_DAY="day";
	static final String KEY_YEAR="year";
	static final String KEY_REAL_SALES="r_sales";
	
    static final String KEY_STATUS ="r_status";
	static final String TAG = "DBTracker";

    static final String DATABASE_NAME = "DBT";
    static final String DATABASE_TABLE = "tracker";
    static final int DATABASE_VERSION = 1;

    static final String DATABASE_CREATE =
	"create table contacts (_id integer primary key autoincrement, "
	+ "name text not null, r_start number not null, r_lunch number, r_finish number, r_status text, month number, day number, year number, r_sales number);";

    final Context context;

    DatabaseHelper DBHelper;
    SQLiteDatabase DBT;

    public DBTracker(Context ctx)
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
        public void onCreate(SQLiteDatabase DBT)
        {
            try {
                DBT.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase DBT, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
				  + newVersion + ", which will destroy all old data");
            DBT.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(DBT);
        }
    }

    //---opens the database---
    public DBTracker open() throws SQLException 
    {
        DBT = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close() 
    {
        DBHelper.close();
    }

    //---insert a contact into the database---
    public long insertContact(String name, Integer r_start, Integer r_lunch, Integer r_finish, String r_status,Integer month, Integer day, Integer year, Integer r_sales) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_REAL_START, r_start);
		initialValues.put(KEY_REAL_LUNCH, r_lunch);
		initialValues.put(KEY_REAL_FINISH, r_finish);
		initialValues.put(KEY_STATUS, r_status);
		initialValues.put(KEY_MONTH, month);
		initialValues.put(KEY_DAY, day);
		initialValues.put(KEY_YEAR, year);
		initialValues.put(KEY_REAL_SALES, r_sales);
        return DBT.insert(DATABASE_TABLE, null, initialValues);
    }

    //---deletes a particular contact---
    public boolean deleteContact(long rowId) 
    {
        return DBT.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    //---retrieves all the contacts---
    public Cursor getAllContacts()
    {
        return DBT.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_NAME,
							KEY_REAL_START, KEY_REAL_LUNCH, KEY_REAL_FINISH, KEY_STATUS, KEY_MONTH, KEY_DAY, KEY_YEAR, KEY_STATUS}, null, null, null, null, null);
    }

    //---retrieves a particular contact---
    public Cursor getContact(long rowId) throws SQLException 
    {
        Cursor mCursor =
			DBT.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
						 KEY_NAME, KEY_REAL_START, KEY_REAL_LUNCH, KEY_REAL_FINISH, KEY_STATUS, KEY_MONTH, KEY_DAY, KEY_YEAR, KEY_REAL_SALES}, KEY_ROWID + "=" + rowId, null,
					 null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a contact---
  /*  public boolean updateContact(long rowId, String name, Integer r_start, Integer r_lunch, Integer r_finish, String r_status,Integer month, Integer day, Integer year, r_sales) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_REAL_START, r_start);
		args.put(KEY_REAL_LUNCH, r_lunch);
		args.put(KEY_REAL_FINISH, r_finish);
		args.put(KEY_STATUS, r_status);
		args.put(KEY_MONTH, month);
		args.put(KEY_DAY, day);
		args.put(KEY_YEAR, year);
		args.put(KEY_REAL_SALES, r_sales);
        return DBT.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }*/
}

