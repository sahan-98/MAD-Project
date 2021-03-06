package com.example.burgerfreakz.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.burgerfreakz.Classes.LoginD;
import com.example.burgerfreakz.Classes.PDetails;
import com.example.burgerfreakz.Classes.Riders;
import com.example.burgerfreakz.Classes.Customer;
import com.example.burgerfreakz.Classes.FeedbackV;
import com.example.burgerfreakz.Classes.Employee;
import com.example.burgerfreakz.Classes.Product;


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

        String SQL_CUSTOMER_ENTRIES =
                "CREATE TABLE " + AppMaster.CustomerDetails.TABLE_NAME + " (" +
                        AppMaster.CustomerDetails._ID + " INTEGER PRIMARY KEY, " +
                        AppMaster.CustomerDetails.COLUMN_NAME_FIRSTNAME + " TEXT," +
                        AppMaster.CustomerDetails.COLUMN_NAME_LASTNAME + " TEXT," +
                        AppMaster.CustomerDetails.COLUMN_NAME_EMAIL + " TEXT," +
                        AppMaster.CustomerDetails.COLUMN_NAME_PHONE + " TEXT," +
                        AppMaster.CustomerDetails.COLUMN_NAME_ADDRESS + " TEXT)" ;


        String SQL_LOGIN_ENTRIES =
                "CREATE TABLE " + AppMaster.Login.TABLE_NAME + " (" +
                        AppMaster.Login._ID + " INTEGER PRIMARY KEY ," +
                        AppMaster.Login.COLUMN_NAME_USERNAME + " TEXT," +
                        AppMaster.Login.COLUMN_NAME_PWRD + " TEXT )";

        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + AppMaster.Products.TABLE_NAME + "(" +
                        AppMaster.Products._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        AppMaster.Products.COLUMN_NAME_PRODUCTNAME + " TEXT NOT NULL," +
                        AppMaster.Products.COLUMN_NAME_PRODUCTCODE + " TEXT NOT NULL," +
                        AppMaster.Products.COLUMN_NAME_PRODUCTPRICE + " TEXT NOT NULL," +
                        AppMaster.Products.COLUMN_NAME_PRODUCTSIZE + " TEXT NOT NULL);";

        String SQL_FEEDBACK_ENTRIES =
                "CREATE TABLE " + AppMaster.Feedbacks.TABLE_NAME + " (" +
                        AppMaster.Feedbacks._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        AppMaster.Feedbacks.COLUMN_NAME_FEEDCOMMENT + " TEXT," +
                        AppMaster.Feedbacks.COLUMN_NAME_FEEDMAIL + " TEXT )";

        String SQL_EMPLOYEE_ENTRIES =
                "CREATE TABLE " + AppMaster.Employees.TABLE_NAME + "(" +
                        AppMaster.Employees._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        AppMaster.Employees.COLUMN_NAME_EMPLOYEENAME + " TEXT NOT NULL," +
                        AppMaster.Employees.COLUMN_NAME_EMPLOYEEEMAIL + " TEXT NOT NULL," +
                        AppMaster.Employees.COLUMN_NAME_EMPLOYEECITY + " TEXT NOT NULL," +
                        AppMaster.Employees.COLUMN_NAME_EMPLOYEECONTACTNUMBER + " TEXT NOT NULL);";






        sqLiteDatabase.execSQL(SQL_RIDER_ENTRIES);
        sqLiteDatabase.execSQL(SQL_PAYMENT_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CUSTOMER_ENTRIES);
        sqLiteDatabase.execSQL(SQL_LOGIN_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_FEEDBACK_ENTRIES);
        sqLiteDatabase.execSQL(SQL_EMPLOYEE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }

    public long addLoginInfo(String uname,String pwrd){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppMaster.Login.COLUMN_NAME_USERNAME,uname);
        values.put(AppMaster.Login.COLUMN_NAME_PWRD,pwrd);

        long newRowId = db.insert(AppMaster.Login.TABLE_NAME,null,values);
        return newRowId;

    }

    public List readLoginInfo(String req){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                AppMaster.Login._ID,
                AppMaster.Login.COLUMN_NAME_USERNAME,
                AppMaster.Login.COLUMN_NAME_PWRD
        };
        String sortorder = AppMaster.Login.COLUMN_NAME_USERNAME + " DESC";

        Cursor cursor = db.query(
                AppMaster.Login.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortorder
        );

        List usernames = new ArrayList();
        List passwords = new ArrayList();

        while(cursor.moveToNext()){
            String username = cursor.getString(cursor.getColumnIndexOrThrow(AppMaster.Login.COLUMN_NAME_USERNAME));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(AppMaster.Login.COLUMN_NAME_PWRD));
            usernames.add(username);
            passwords.add(password);
        }
        cursor.close();

        if(req == "user"){
            return usernames;
        }else if(req == "password"){
            return passwords;
        }else{
            return null;
        }

    }

    public LoginD getPassword(String username){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(AppMaster.Login.TABLE_NAME,new String[]{AppMaster.Login._ID,
                        AppMaster.Login.COLUMN_NAME_USERNAME,
                        AppMaster.Login.COLUMN_NAME_PWRD}, AppMaster.Login.COLUMN_NAME_USERNAME + "= ?",new String[]{username},
                null,null,null);
        LoginD loginD;
        if(cursor != null){
            cursor.moveToFirst();

            loginD = new LoginD(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );
            return loginD;
        }
        return null;
    }

    public int updatePassword(LoginD loginD){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppMaster.Login.COLUMN_NAME_USERNAME,loginD.getUsername());
        values.put(AppMaster.Login.COLUMN_NAME_PWRD,loginD.getPassword());

        int status = sqLiteDatabase.update(AppMaster.Login.TABLE_NAME,values, AppMaster.Login._ID + " =?",
                new String[]{String.valueOf(loginD.getId())});

        sqLiteDatabase.close();
        return status;
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

    public List<PDetails> getPaymentDetails(){

        List<PDetails> details = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+ AppMaster.PaymentDetails.TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                PDetails pDetails = new PDetails();
                pDetails.setId(cursor.getInt(0));
                pDetails.setFname(cursor.getString(1));
                pDetails.setLname(cursor.getString(2));
                pDetails.setPhone(cursor.getString(3));
                pDetails.setAddress(cursor.getString(4));
                pDetails.setLandmarks(cursor.getString(5));
                pDetails.setProduct(cursor.getString(6));
                pDetails.setMethod(cursor.getString(7));
                pDetails.setSub(cursor.getString(8));
                pDetails.setSchrg(cursor.getString(9));
                pDetails.setNet(cursor.getString(10));

                details.add(pDetails);

            }while(cursor.moveToNext());
        }
        return details;

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

    public List<Riders> getAllRiders(){

        List<Riders> riders = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+ AppMaster.RiderDetails.TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                Riders rider = new Riders();
                rider.setID(cursor.getInt(0));
                rider.setName(cursor.getString(1));
                rider.setRiderNo(cursor.getString(2));
                rider.setPhone(cursor.getString(3));
                rider.setBikeNo(cursor.getString(4));

                riders.add(rider);
            }while(cursor.moveToNext());

        }
        return riders;

    }

    public void deleteRider(int id){
        SQLiteDatabase db = getWritableDatabase();

        db.delete(AppMaster.RiderDetails.TABLE_NAME,AppMaster.RiderDetails._ID +" =?",new String[]{String.valueOf(id)});
        db.close();

    }

    public Riders getSingleRider(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(AppMaster.RiderDetails.TABLE_NAME,new String[]{AppMaster.RiderDetails._ID,AppMaster.RiderDetails.COLUMN_NAME_NAME,
                        AppMaster.RiderDetails.COLUMN_NAME_RNO,AppMaster.RiderDetails.COLUMN_NAME_PHONE,AppMaster.RiderDetails.COLUMN_NAME_BNo},
                AppMaster.RiderDetails._ID + "= ?",new String[]{String.valueOf(id)},
                null,null,null);

        Riders riders;
        if(cursor != null){
            cursor.moveToFirst();

            riders = new Riders(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );

            return riders;
        }
        return null;
    }

    public int updateRider(Riders riders){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AppMaster.RiderDetails.COLUMN_NAME_NAME, riders.getName());
        values.put(AppMaster.RiderDetails.COLUMN_NAME_RNO, riders.getRiderNo());
        values.put(AppMaster.RiderDetails.COLUMN_NAME_PHONE, riders.getPhone());
        values.put(AppMaster.RiderDetails.COLUMN_NAME_BNo, riders.getBikeNo());

        int status = db.update(AppMaster.RiderDetails.TABLE_NAME,values, AppMaster.RiderDetails._ID + " =?",
                new String[]{String.valueOf(riders.getID())});
        db.close();
        return status;

    }

    public long addCustomerDetails(String fname, String lName, String email,String phone, String address) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppMaster.CustomerDetails.COLUMN_NAME_FIRSTNAME, fname);
        values.put(AppMaster.CustomerDetails.COLUMN_NAME_LASTNAME, lName);
        values.put(AppMaster.CustomerDetails.COLUMN_NAME_EMAIL, email);
        values.put(AppMaster.CustomerDetails.COLUMN_NAME_PHONE, phone);
        values.put(AppMaster.CustomerDetails.COLUMN_NAME_ADDRESS,address);

        long newRowId = db.insert(AppMaster.CustomerDetails.TABLE_NAME, null, values);
        return newRowId;
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+AppMaster.CustomerDetails.TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Customer customer = new Customer();

                customer.setId(cursor.getInt(0));
                customer.setFname(cursor.getString(1));
                customer.setLname(cursor.getString(2));
                customer.setEmail(cursor.getString(3));
                customer.setPhone(cursor.getString(4));
                customer.setAddress(cursor.getString(5));

                customers.add(customer);
            }while (cursor.moveToNext());
        }
        return customers;

     }

     public void deleteCustomer(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(AppMaster.CustomerDetails.TABLE_NAME,AppMaster.CustomerDetails._ID+"=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
     }

    public Customer getCustomer(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(AppMaster.CustomerDetails.TABLE_NAME,new String[]{AppMaster.CustomerDetails._ID,AppMaster.CustomerDetails.COLUMN_NAME_FIRSTNAME,AppMaster.CustomerDetails.COLUMN_NAME_LASTNAME,AppMaster.CustomerDetails.COLUMN_NAME_EMAIL,AppMaster.CustomerDetails.COLUMN_NAME_PHONE,AppMaster.CustomerDetails.COLUMN_NAME_ADDRESS},AppMaster.CustomerDetails._ID + "= ?",new String[]{String.valueOf(id)},null,null,null);
        Customer customer;
        if(cursor != null){
            cursor.moveToFirst();
            customer = new Customer(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );
            return customer;
        }
        return null;
    }

    public Customer getsingleCustomer(String username){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(AppMaster.CustomerDetails.TABLE_NAME,new String[]{AppMaster.CustomerDetails._ID,
                        AppMaster.CustomerDetails.COLUMN_NAME_FIRSTNAME,
                        AppMaster.CustomerDetails.COLUMN_NAME_LASTNAME,
                        AppMaster.CustomerDetails.COLUMN_NAME_EMAIL,
                        AppMaster.CustomerDetails.COLUMN_NAME_PHONE,
                        AppMaster.CustomerDetails.COLUMN_NAME_ADDRESS}, AppMaster.CustomerDetails.COLUMN_NAME_EMAIL + "= ?",new String[]{username},
                null,null,null);
        Customer customer;
        if(cursor != null){
            cursor.moveToFirst();

            customer = new Customer(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );
            return  customer;
        }
        return  null;
    }

    public int updateCustomer(Customer customer){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppMaster.CustomerDetails.COLUMN_NAME_FIRSTNAME,customer.getFname());
        values.put(AppMaster.CustomerDetails.COLUMN_NAME_LASTNAME,customer.getLname());
        values.put(AppMaster.CustomerDetails.COLUMN_NAME_EMAIL,customer.getEmail());
        values.put(AppMaster.CustomerDetails.COLUMN_NAME_PHONE,customer.getPhone());
        values.put(AppMaster.CustomerDetails.COLUMN_NAME_ADDRESS,customer.getAddress());


        int status = sqLiteDatabase.update(AppMaster.CustomerDetails.TABLE_NAME,values,AppMaster.CustomerDetails._ID +" =?",
                new String[]{String.valueOf(customer.getId())});

        sqLiteDatabase.close();
        return status;
    }

    public long addProduct(Product product) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppMaster.Products.COLUMN_NAME_PRODUCTNAME, product.getProName());
        values.put(AppMaster.Products.COLUMN_NAME_PRODUCTCODE, product.getProCode());
        values.put(AppMaster.Products.COLUMN_NAME_PRODUCTPRICE, product.getProPrice());
        values.put(AppMaster.Products.COLUMN_NAME_PRODUCTSIZE, product.getProSize());

        long newRowId = sqLiteDatabase.insert(AppMaster.Products.TABLE_NAME, null, values);
        return newRowId;

    }

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+ AppMaster.Products.TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                Product product = new Product();

                product.setId(cursor.getInt(0));
                product.setProName(cursor.getString(1));
                product.setProCode(cursor.getString(2));
                product.setProPrice(cursor.getString(3));
                product.setProSize(cursor.getString(4));

                products.add(product);
            }while (cursor.moveToNext());
        }
        return products;

    }

    public void deleteproduct(int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(AppMaster.Products.TABLE_NAME, AppMaster.Products._ID +" =?",new String[]{String.valueOf(Id)});
        sqLiteDatabase.close();
    }

    public Product getProduct (int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(AppMaster.Products.TABLE_NAME,new String[]{AppMaster.Products._ID, AppMaster.Products.COLUMN_NAME_PRODUCTNAME, AppMaster.Products.COLUMN_NAME_PRODUCTCODE, AppMaster.Products.COLUMN_NAME_PRODUCTPRICE, AppMaster.Products.COLUMN_NAME_PRODUCTSIZE}, AppMaster.Products._ID + "= ?",new String[]{String.valueOf(Id)},null,null,null);
        Product product;
        if(cursor != null){
            cursor.moveToFirst();
            product = new Product(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            return product;
        }
        return null;

    }

    public int updateProduct(Product product){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppMaster.Products.COLUMN_NAME_PRODUCTNAME,product.getProName());
        values.put(AppMaster.Products.COLUMN_NAME_PRODUCTCODE,product.getProCode());
        values.put(AppMaster.Products.COLUMN_NAME_PRODUCTPRICE,product.getProPrice());
        values.put(AppMaster.Products.COLUMN_NAME_PRODUCTSIZE,product.getProSize());

        int status = sqLiteDatabase.update(AppMaster.Products.TABLE_NAME,values, AppMaster.Products._ID +" =?",
                new String[]{String.valueOf(product.getId())});

        sqLiteDatabase.close();
        return status;
    }

    public long addfeedback(FeedbackV feedbackV){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppMaster.Feedbacks.COLUMN_NAME_FEEDCOMMENT,feedbackV.getComment());
        values.put(AppMaster.Feedbacks.COLUMN_NAME_FEEDMAIL,feedbackV.getFmail());

        long newRowId = sqLiteDatabase.insert(AppMaster.Feedbacks.TABLE_NAME,null,values);
        return newRowId;

    }

    public List<FeedbackV> getAllFeedback() {
        List<FeedbackV> feedbackVS = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+ AppMaster.Feedbacks.TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                FeedbackV feedbackV = new FeedbackV();

                feedbackV.setId(cursor.getInt(0));
                feedbackV.setComment(cursor.getString(1));
                feedbackV.setFmail(cursor.getString(2));

                feedbackVS.add(feedbackV);
            }while (cursor.moveToNext());
        }
        return feedbackVS;

    }

    public void deletefeedback(int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(AppMaster.Feedbacks.TABLE_NAME, AppMaster.Feedbacks._ID +" =?",new String[]{String.valueOf(Id)});
        sqLiteDatabase.close();
    }

    public FeedbackV getfeedback (int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(AppMaster.Feedbacks.TABLE_NAME,new String[]{AppMaster.Feedbacks._ID, AppMaster.Feedbacks.COLUMN_NAME_FEEDCOMMENT, AppMaster.Feedbacks.COLUMN_NAME_FEEDMAIL}, AppMaster.Feedbacks._ID + "= ?",new String[]{String.valueOf(Id)},null,null,null);
        FeedbackV feedbackV;
        if(cursor != null){
            cursor.moveToFirst();
            feedbackV = new FeedbackV(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );
            return feedbackV;
        }
        return null;

    }

    public long addEmployee(Employee employee) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppMaster.Employees.COLUMN_NAME_EMPLOYEENAME, employee.getEmpName() );
        values.put(AppMaster.Employees.COLUMN_NAME_EMPLOYEEEMAIL, employee.getEmpEmail());
        values.put(AppMaster.Employees.COLUMN_NAME_EMPLOYEECITY, employee.getEmpCity());
        values.put(AppMaster.Employees.COLUMN_NAME_EMPLOYEECONTACTNUMBER, employee.getEmpContactNumber());

        long newRowId = sqLiteDatabase.insert(AppMaster.Employees.TABLE_NAME, null, values);
        return newRowId;

    }

    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+AppMaster.Employees.TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                Employee employee = new Employee();

                employee.setId(cursor.getInt(0));
                employee.setEmpName(cursor.getString(1));
                employee.setEmpEmail(cursor.getString(2));
                employee.setEmpCity(cursor.getString(3));
                employee.setEmpContactNumber(cursor.getString(4));

                employees.add(employee);
            }while (cursor.moveToNext());
        }
        return employees;

    }

    public void deleteEmployee(int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(AppMaster.Employees.TABLE_NAME, AppMaster.Employees._ID +" =?",new String[]{String.valueOf(Id)});
        sqLiteDatabase.close();
    }

    public Employee getEmployee(int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(AppMaster.Employees.TABLE_NAME,new String[]{AppMaster.Employees._ID, AppMaster.Employees.COLUMN_NAME_EMPLOYEENAME, AppMaster.Employees.COLUMN_NAME_EMPLOYEEEMAIL, AppMaster.Employees.COLUMN_NAME_EMPLOYEECITY, AppMaster.Employees.COLUMN_NAME_EMPLOYEECONTACTNUMBER}, AppMaster.Employees._ID + "= ?",new String[]{String.valueOf(Id)},null,null,null);
        Employee employee;
        if(cursor != null){
            cursor.moveToFirst();
            employee = new Employee(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            return employee;
        }
        return null;

    }

    public int updateEmployee(Employee employee){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppMaster.Employees.COLUMN_NAME_EMPLOYEENAME,employee.getEmpName());
        values.put(AppMaster.Employees.COLUMN_NAME_EMPLOYEEEMAIL,employee.getEmpEmail());
        values.put(AppMaster.Employees.COLUMN_NAME_EMPLOYEECITY,employee.getEmpCity());
        values.put(AppMaster.Employees.COLUMN_NAME_EMPLOYEECONTACTNUMBER,employee.getEmpContactNumber());

        int status = sqLiteDatabase.update(AppMaster.Employees.TABLE_NAME,values, AppMaster.Employees._ID +" =?",
                new String[]{String.valueOf(employee.getId())});

        sqLiteDatabase.close();
        return status;
    }






}
