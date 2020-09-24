package com.example.burgerfreakz.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Burgerfreakz.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_PAYMENT_ENTRIES =
                "CREATE TABLE " + AppMaster.PaymentDetails.TABLE_NAME + " (" +
                        AppMaster.PaymentDetails._ID + " INTEGER PRIMARY KEY, " +
                        AppMaster.PaymentDetails.COLUMN_NAME_FIRSTNAME + " TEXT," +
                        AppMaster.PaymentDetails.COLUMN_NAME_LASTNAME + " TEXT," +
                        AppMaster.PaymentDetails.COLUMN_NAME_PHONE + " TEXT," +
                        AppMaster.PaymentDetails.COLUMN_NAME_ADDRESS + " TEXT," +
                        AppMaster.PaymentDetails.COLUMN_NAME_LANDMARKS + " TEXT," +
                        AppMaster.PaymentDetails.COLUMN_NAME_PRODUCT + " TEXT," +
                        AppMaster.PaymentDetails.COLUMN_NAME_METHOD + " TEXT," +
                        AppMaster.PaymentDetails.COLUMN_NAME_SUBTOT + " TEXT," +
                        AppMaster.PaymentDetails.COLUMN_NAME_SCHARG + " TEXT," +
                        AppMaster.PaymentDetails.COLUMN_NAME_NETTOT + " TEXT)";

        String SQL_RIDER_ENTRIES =
                "CREATE TABLE " + AppMaster.RiderDetails.TABLE_NAME + " (" +
                        AppMaster.RiderDetails._ID + " INTEGER PRIMARY KEY," +
                        AppMaster.RiderDetails.COLUMN_NAME_NAME + " TEXT," +
                        AppMaster.RiderDetails.COLUMN_NAME_RNO + " TEXT ," +
                        AppMaster.RiderDetails.COLUMN_NAME_PHONE + " TEXT," +
                        AppMaster.RiderDetails.COLUMN_NAME_BNo + " TEXT)";

        sqLiteDatabase.execSQL(SQL_RIDER_ENTRIES);
        sqLiteDatabase.execSQL(SQL_PAYMENT_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }

    public long addPaymentDetails(String fname, String lName, String phone, String add, String land, String product,String method, String sub, String chrg, String net) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppMaster.PaymentDetails.COLUMN_NAME_FIRSTNAME, fname);
        values.put(AppMaster.PaymentDetails.COLUMN_NAME_LASTNAME, lName);
        values.put(AppMaster.PaymentDetails.COLUMN_NAME_PHONE, phone);
        values.put(AppMaster.PaymentDetails.COLUMN_NAME_ADDRESS, add);
        values.put(AppMaster.PaymentDetails.COLUMN_NAME_LANDMARKS, land);
        values.put(AppMaster.PaymentDetails.COLUMN_NAME_PRODUCT, product);
        values.put(AppMaster.PaymentDetails.COLUMN_NAME_METHOD, method);
        values.put(AppMaster.PaymentDetails.COLUMN_NAME_SUBTOT, sub);
        values.put(AppMaster.PaymentDetails.COLUMN_NAME_SCHARG, chrg);
        values.put(AppMaster.PaymentDetails.COLUMN_NAME_NETTOT, net);

        long newRowId = db.insert(AppMaster.PaymentDetails.TABLE_NAME, null, values);
        return newRowId;
    }

    public long addRiderDetails(String name, String rno, String phone, String bno) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppMaster.RiderDetails.COLUMN_NAME_NAME, name);
        values.put(AppMaster.RiderDetails.COLUMN_NAME_RNO, rno);
        values.put(AppMaster.RiderDetails.COLUMN_NAME_PHONE, phone);
        values.put(AppMaster.RiderDetails.COLUMN_NAME_BNo, bno);

        long newRodId = db.insert(AppMaster.RiderDetails.TABLE_NAME, null, values);
        return newRodId;
    }

    public List RiderInfo(){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                AppMaster.RiderDetails._ID,
                AppMaster.RiderDetails.COLUMN_NAME_NAME,
                AppMaster.RiderDetails.COLUMN_NAME_RNO,
                AppMaster.RiderDetails.COLUMN_NAME_PHONE,
                AppMaster.RiderDetails.COLUMN_NAME_BNo
        };

        String sortOrder = AppMaster.RiderDetails.COLUMN_NAME_RNO + " DESC";

        Cursor cursor = db.query(
                AppMaster.RiderDetails.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List Rnumbers = new ArrayList<>();
        List Rnames = new ArrayList<>();
        List Rphones = new ArrayList<>();
        List Bnos = new ArrayList<>();

        while (cursor.moveToNext()){
            String Rname = cursor.getString(cursor.getColumnIndexOrThrow(AppMaster.RiderDetails.COLUMN_NAME_NAME));
            String Rno = cursor.getString(cursor.getColumnIndexOrThrow(AppMaster.RiderDetails.COLUMN_NAME_RNO));
            String Rphone = cursor.getString(cursor.getColumnIndexOrThrow(AppMaster.RiderDetails.COLUMN_NAME_PHONE));
            String Bno = cursor.getString(cursor.getColumnIndexOrThrow(AppMaster.RiderDetails.COLUMN_NAME_BNo));
            Rnames.add(Rname);
            Rnumbers.add(Rno);
            Rphones.add(Rphone);
            Bnos.add(Bno);
        }
        cursor.close();
        return Rnumbers;
    }

}
