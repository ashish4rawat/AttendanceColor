package com.technialrj.attendancemaster;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper  extends SQLiteOpenHelper{


        public static final String DATABASE_NAME = "AttendancMaster.db";
        public static final String TIMETABLE_TABLE_NAME = "timetable";
        public static final String SUBJECTS_TABLE_NAME= "subjects";


        public static final String TIMETABLE_COLUMN_ID = "id";
        public static final String TIMETABLE_COLUMN_MONDAY = "monday";
        public static final String TIMETABLE_COLUMN_TUESDAY = "tuesday";
        public static final String TIMETABLE_COLUMN_WEDNESDAY = "wednesday";
        public static final String TIMETABLE_COLUMN_THURSDAY = "thursday";
        public static final String TIMETABLE_COLUMN_FRIDAY = "friday";
        public static final String TIMETABLE_COLUMN_SATURDAY = "saturday";
        public static final String TIMETABLE_COLUMN_SUNDAY = "sunday";



        public static final String SUBJECTS_COLUMN_ID = "id";
        public static final String SUBJECTS_COLUMN_SUBJECT_NAME = "subjectname";


        public DBHelper(Context context) {
                super(context, DATABASE_NAME , null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

                db.execSQL(
                        "create table " + TIMETABLE_TABLE_NAME  +
                                " (" + TIMETABLE_COLUMN_ID + " integer primary key autoincrement, " +
                                TIMETABLE_COLUMN_MONDAY+ " text, " +
                                TIMETABLE_COLUMN_TUESDAY+ " text, " +
                                TIMETABLE_COLUMN_WEDNESDAY+ " text, " +
                                TIMETABLE_COLUMN_THURSDAY+ " text, " +
                                TIMETABLE_COLUMN_FRIDAY+ " text, " +
                                TIMETABLE_COLUMN_SATURDAY+ " text, " +
                                TIMETABLE_COLUMN_SUNDAY+ " text)"
                );

                db.execSQL(
                        "create table " + SUBJECTS_TABLE_NAME  +
                                " (" + SUBJECTS_COLUMN_ID + " integer primary key autoincrement, " +
                                SUBJECTS_COLUMN_SUBJECT_NAME+ " text)"
                );




        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



        }


        // Add methods here which will return data you want  like getAllSubjects , getAllRollnumbers

        // Use final string and define it in the top of file


        public boolean addSubject(String sub_name){


                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(SUBJECTS_COLUMN_SUBJECT_NAME , sub_name);
                db.insert(SUBJECTS_TABLE_NAME, null, contentValues);

                return true;

        }

        public ArrayList<String> getAllSubjects(){

                ArrayList<String> all_sub_names = new ArrayList<>();



                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor =  db.rawQuery( "select * from " + SUBJECTS_TABLE_NAME , null );
                cursor.moveToFirst();

                Log.i("InfoText", "Total value : "+String.valueOf(cursor.getCount()));

                while(cursor.isAfterLast() == false){
                        all_sub_names.add(cursor.getString(cursor.getColumnIndex(SUBJECTS_COLUMN_SUBJECT_NAME)));
                        Log.i("InfoText","inside getAllsub : "+ cursor.getString(cursor.getColumnIndex(SUBJECTS_COLUMN_SUBJECT_NAME)));

                        cursor.moveToNext();
                }

                cursor.close();

                return  all_sub_names ;
        }




}
