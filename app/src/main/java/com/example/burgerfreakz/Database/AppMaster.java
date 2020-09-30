package com.example.burgerfreakz.Database;

import android.provider.BaseColumns;

public class AppMaster {
    public AppMaster() {
    }

    public static class PaymentDetails implements BaseColumns{

        public static final String TABLE_NAME = "payment";
        public static final String COLUMN_NAME_FIRSTNAME = "first_name";
        public static final String COLUMN_NAME_LASTNAME = "last_name";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_LANDMARKS = "landmarks";
        public static final String COLUMN_NAME_PRODUCT = "product";
        public static final String COLUMN_NAME_METHOD = "method";
        public static final String COLUMN_NAME_SUBTOT = "sub_total";
        public static final String COLUMN_NAME_NETTOT = "net_total";
        public static final String COLUMN_NAME_SCHARG = "sCharg";

    }

    public static class RiderDetails implements BaseColumns{

        public static final String TABLE_NAME = "rider";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_RNO = "rider_no";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_BNo = "bike_no";

    }

    public static class CustomerDetails implements BaseColumns{

        public static final String TABLE_NAME = "customer";
        public static final String COLUMN_NAME_FIRSTNAME = "first_name";
        public static final String COLUMN_NAME_LASTNAME = "last_name";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_PASSWORD = "password";


    }


}
