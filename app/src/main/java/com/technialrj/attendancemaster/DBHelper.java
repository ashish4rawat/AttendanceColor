package com.technialrj.attendancemaster;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLInput;
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


        public void addSubject(String sub_name){


                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(SUBJECTS_COLUMN_SUBJECT_NAME , sub_name);
                db.insert(SUBJECTS_TABLE_NAME, null, contentValues);


        }

        public void deleteSubject(String sub_name){

                SQLiteDatabase db = this.getWritableDatabase();
                db.delete(SUBJECTS_TABLE_NAME,SUBJECTS_COLUMN_SUBJECT_NAME+"="+sub_name,null);

        }

        public void updateSubject(String old_sub_name  ,  String new_sub_name){

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(SUBJECTS_COLUMN_SUBJECT_NAME,new_sub_name);

                db.update(SUBJECTS_TABLE_NAME,contentValues,SUBJECTS_COLUMN_SUBJECT_NAME + "=" + old_sub_name ,null);


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

        public void addToTimetable(String day , String sub_name){


                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();


                switch (day){

                        case "monday":

                                contentValues.put(TIMETABLE_COLUMN_MONDAY,sub_name);
                                db.insert(TIMETABLE_TABLE_NAME,null,contentValues);
                                break;

                        case "tuesday":

                                contentValues.put(TIMETABLE_COLUMN_TUESDAY,sub_name);
                                db.insert(TIMETABLE_TABLE_NAME,null,contentValues);
                                break;

                        case "wednesday":

                                contentValues.put(TIMETABLE_COLUMN_WEDNESDAY,sub_name);
                                db.insert(TIMETABLE_TABLE_NAME,null,contentValues);
                                break;

                        case "thursday":

                                contentValues.put(TIMETABLE_COLUMN_THURSDAY,sub_name);
                                db.insert(TIMETABLE_TABLE_NAME,null,contentValues);
                                break;

                        case "friday":

                                contentValues.put(TIMETABLE_COLUMN_FRIDAY,sub_name);
                                db.insert(TIMETABLE_TABLE_NAME,null,contentValues);
                                break;

                        case "saturday":

                                contentValues.put(TIMETABLE_COLUMN_SATURDAY,sub_name);
                                db.insert(TIMETABLE_TABLE_NAME,null,contentValues);
                                break;

                        case "sunday":

                                contentValues.put(TIMETABLE_COLUMN_SUNDAY,sub_name);
                                db.insert(TIMETABLE_TABLE_NAME,null,contentValues);
                                break;



                }



        }


        public void deleteFromTimetable(String day , String sub_name){

                SQLiteDatabase db = this.getWritableDatabase();

                switch (day){

                        case "monday":

                                db.delete(TIMETABLE_TABLE_NAME, TIMETABLE_COLUMN_MONDAY + " = " + sub_name,null);
                                break;

                        case "tuesday":

                                db.delete(TIMETABLE_TABLE_NAME, TIMETABLE_COLUMN_TUESDAY + " = " + sub_name,null);
                                break;

                        case "wednesday":

                                db.delete(TIMETABLE_TABLE_NAME, TIMETABLE_COLUMN_WEDNESDAY + " = " + sub_name,null);
                                break;

                        case "thursday":

                                db.delete(TIMETABLE_TABLE_NAME, TIMETABLE_COLUMN_THURSDAY + " = " + sub_name,null);
                                break;

                        case "friday":

                                db.delete(TIMETABLE_TABLE_NAME, TIMETABLE_COLUMN_FRIDAY + " = " + sub_name,null);
                                break;

                        case "saturday":

                                db.delete(TIMETABLE_TABLE_NAME, TIMETABLE_COLUMN_SATURDAY + " = " + sub_name,null);
                                break;

                        case "sunday":

                                db.delete(TIMETABLE_TABLE_NAME, TIMETABLE_COLUMN_SUNDAY + " = " + sub_name,null);
                                break;



                }



        }


        public ArrayList<String> getTimetable(String day ){

                SQLiteDatabase db = this.getWritableDatabase();
                ArrayList<String> allSubjects = new ArrayList<>();
                allSubjects.clear();
                Cursor cursor;

                switch (day){

                        case "monday":

                                cursor = db.rawQuery("select * from "+ TIMETABLE_TABLE_NAME , null );
                                cursor.moveToFirst();

                                while(cursor.isAfterLast() == false){

                                        String sub  =  cursor.getString(cursor.getColumnIndex(TIMETABLE_COLUMN_MONDAY)) ;
                                        allSubjects.add(sub);
                                        cursor.moveToNext();

                                }
                                cursor.close();

                                return allSubjects ;

                        case "tuesday":


                                cursor = db.rawQuery("select * from "+ TIMETABLE_TABLE_NAME , null );
                                cursor.moveToFirst();

                                while(cursor.isAfterLast() == false){

                                        String sub  =  cursor.getString(cursor.getColumnIndex(TIMETABLE_COLUMN_TUESDAY)) ;
                                        allSubjects.add(sub);
                                        cursor.moveToNext();

                                }
                                cursor.close();
                                return allSubjects ;


                        case "wednesday":
                                cursor = db.rawQuery("select * from "+ TIMETABLE_TABLE_NAME , null );
                                cursor.moveToFirst();

                                while(cursor.isAfterLast() == false){

                                        String sub  =  cursor.getString(cursor.getColumnIndex(TIMETABLE_COLUMN_WEDNESDAY)) ;
                                        allSubjects.add(sub);
                                        cursor.moveToNext();

                                }
                                cursor.close();
                                return allSubjects;


                        case "thursday":
                                cursor = db.rawQuery("select * from "+ TIMETABLE_TABLE_NAME , null );
                                cursor.moveToFirst();

                                while(cursor.isAfterLast() == false){

                                        String sub  =  cursor.getString(cursor.getColumnIndex(TIMETABLE_COLUMN_THURSDAY)) ;
                                        allSubjects.add(sub);
                                        cursor.moveToNext();

                                }
                                cursor.close();
                                return allSubjects ;


                        case "friday":
                                cursor = db.rawQuery("select * from "+ TIMETABLE_TABLE_NAME , null );
                                cursor.moveToFirst();

                                while(cursor.isAfterLast() == false){

                                        String sub  =  cursor.getString(cursor.getColumnIndex(TIMETABLE_COLUMN_FRIDAY)) ;
                                        allSubjects.add(sub);
                                        cursor.moveToNext();

                                }
                                cursor.close();
                                return allSubjects ;


                        case "saturday":
                                cursor = db.rawQuery("select * from "+ TIMETABLE_TABLE_NAME , null );
                                cursor.moveToFirst();

                                while(cursor.isAfterLast() == false){

                                        String sub  =  cursor.getString(cursor.getColumnIndex(TIMETABLE_COLUMN_SATURDAY)) ;
                                        allSubjects.add(sub);
                                        cursor.moveToNext();

                                }
                                cursor.close();
                                return allSubjects ;


                        case "sunday":
                                cursor = db.rawQuery("select * from "+ TIMETABLE_TABLE_NAME , null );
                                cursor.moveToFirst();

                                while(cursor.isAfterLast() == false){

                                        String sub  =  cursor.getString(cursor.getColumnIndex(TIMETABLE_COLUMN_SUNDAY)) ;
                                        allSubjects.add(sub);
                                        cursor.moveToNext();

                                }
                                cursor.close();
                                return allSubjects ;

                        default:

                                return  allSubjects;


                }

        }




}
