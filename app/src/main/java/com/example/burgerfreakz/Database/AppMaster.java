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

    }

    public static class Login implements BaseColumns{
        public static final String TABLE_NAME = "Login";
        public static final String COLUMN_NAME_USERNAME = "u_name";
        public static final String COLUMN_NAME_PWRD = "pwrd";
    }

    public static class Products implements BaseColumns{
        public static final String TABLE_NAME = "Product";
        public static final String COLUMN_NAME_PRODUCTNAME = "ProductName";
        public static final String COLUMN_NAME_PRODUCTCODE = "ProductCode";
        public static final String COLUMN_NAME_PRODUCTPRICE = "ProductPrice";
        public static final String COLUMN_NAME_PRODUCTSIZE = "ProductSize";

    }

    public static class Feedbacks implements BaseColumns {
        public static final String TABLE_NAME = "Feedback";
        public static final String COLUMN_NAME_FEEDCOMMENT = "FeedComment";
        public static final String COLUMN_NAME_FEEDMAIL = "FeedMail";

    }
    public static class Employees implements BaseColumns{
        public static final String TABLE_NAME = "Employee";
        public static final String COLUMN_NAME_EMPLOYEENAME = "EmployeeName";
        public static final String COLUMN_NAME_EMPLOYEEEMAIL = "EmployeeEmail";
        public static final String COLUMN_NAME_EMPLOYEECITY = "EmployeeCity";
        public static final String COLUMN_NAME_EMPLOYEECONTACTNUMBER = "EmployeeContactNumber";

    }


}
