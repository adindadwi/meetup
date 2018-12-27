package com.adinda.meetup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Date;


public class DataHelper extends SQLiteOpenHelper{

//    private static final String DATABASE_NAME = "meetup.db";
//    private static final int DATABASE_VERSION = 2;
//
//    public DataHelper(Context context){
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String sql = "CREATE TABLE user (idUser integer primary key , nama text null, jk text null, password text);";
//        Log.d("Data", "onCreate: " + sql);
//        db.execSQL(sql);
//        String sql2 = "CREATE TABLE group (idGroup integer primary key, namaGroup text null, katGroup text null )";
//        Log.d("Data", "onCreate: " + sql2);
//        db.execSQL(sql2);
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
//        onCreate(db);
//    }
    private static final String LOG = "DataHelper";

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "meetup.db";

    // Table Names
    private static final String TABLE_USER = "user";
    private static final String TABLE_GRUP = "grup";
    private static final String TABLE_EVENT = "event";
    private static final String TABLE_CATEGORYEVENT = "eventcategory";
    private static final String TABLE_USERGROUP = "usergroup";
    private static final String TABLE_GROUPEVENT = "groupevent";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    // USER Table - column names
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    // USER Table - column names
    private static final String KEY_CATEGORY_NAME = "categoryname";

    // user Table Create Statements
    private static final String CREATE_TABLE_CATEGORYEVENT = "CREATE TABLE "
            + TABLE_CATEGORYEVENT + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CATEGORY_NAME
            + " TEXT," + KEY_CREATED_AT
            + " DATETIME" + ")";

    // user Table Create Statements
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERNAME
            + " TEXT," + KEY_EMAIL + " TEXT," + KEY_PASSWORD + " TEXT, " + KEY_CREATED_AT
            + " DATETIME" + ")";

    // EVENT Table - column names
    private static final String KEY_EVENT_NAME = "event_name";
    private static final String KEY_EVENT_DESCRIPTION = "event_description";
    private static final String KEY_EVENT_CATEGORIES = "event_categories_id";
    private static final String KEY_EVENT_DATE = "event_date";
    private static final String KEY_EVENT_PLACE = "event_place";
    private static final String KEY_EVENT_PHOTO = "event_photo";

    // EVENT table create statement
    private static final String CREATE_TABLE_EVENT = "CREATE TABLE " + TABLE_EVENT
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_EVENT_NAME + " TEXT," + KEY_EVENT_DESCRIPTION + " TEXT, "         + KEY_EVENT_PHOTO+"IMAGE, " + KEY_EVENT_CATEGORIES + " TEXT, "
            + KEY_EVENT_DATE + "DATETIME," + KEY_EVENT_PLACE + "TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    // GROUP table
    private static final String KEY_GROUP_NAME = "group_name";
    private static final String KEY_GROUP_DESCRIPTION = "group_description";
    private static final String KEY_GROUP_CATEGORIES = "group_categories";
    private static final String KEY_GROUP_MEMBERS = "group_members";
    private static final String KEY_GROUP_EVENTS = "group_events";

    // group table create statement
    private static final String CREATE_TABLE_GRUP = "CREATE TABLE " + TABLE_GRUP
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_GROUP_NAME + " TEXT," + KEY_GROUP_DESCRIPTION + " TEXT, "
            + KEY_GROUP_CATEGORIES + " TEXT, " + KEY_GROUP_EVENTS + "TEXT," + KEY_GROUP_MEMBERS + "TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    // user_group Table - column names
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_GROUP_ID = "group_id";

    // USER_GROUP table create statement
    private static final String CREATE_TABLE_USERGROUP = "CREATE TABLE "
            + TABLE_USERGROUP + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_USER_ID + " INTEGER," + KEY_GROUP_ID  + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    // event_group table
    private static final String KEY_GROUPEVENT_ID = "groupevent_id";
    private static final String KEY_EVENT_ID = "event_id";

    // GROUP EVENT table create statement
    private static final String CREATE_TABLE_GROUPEVENT = "CREATE TABLE "
            + TABLE_GROUPEVENT + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_GROUPEVENT_ID + " INTEGER," + KEY_EVENT_ID  + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_GRUP);
        db.execSQL(CREATE_TABLE_EVENT);
        db.execSQL(CREATE_TABLE_USERGROUP);
        db.execSQL(CREATE_TABLE_GROUPEVENT);
        db.execSQL(CREATE_TABLE_CATEGORYEVENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GRUP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERGROUP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUPEVENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORYEVENT);

        // create new tables
        onCreate(db);
    }
}
