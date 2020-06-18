package me.suski;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Bartek\\Documents\\Coding\\java-masterclass\\TestDB\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";


    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement()) {

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute(String.format(
                    "CREATE TABLE IF NOT EXISTS %s (%s TEXT, %s INTEGER, %s TEXT)",
                    TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL));

            insertContact(statement, "Tim", 874564132, "tim@mail.com");
            insertContact(statement, "Joe", 12345678, "joe@mail.com");
            insertContact(statement, "Jane", 54687, "jane@mail.com");
            insertContact(statement, "Fido", 258963, "fido@mail.com");

            statement.execute(String.format(
                    "UPDATE %s SET %s=5854787 WHERE %s='Jane'",
                    TABLE_CONTACTS, COLUMN_PHONE, COLUMN_NAME));

            statement.execute(String.format(
                    "DELETE FROM %s WHERE %s='Joe'",
                    TABLE_CONTACTS, COLUMN_NAME));

            ResultSet resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM %s", TABLE_CONTACTS));

            while (resultSet.next()) {
                System.out.printf("%s %d %s%n",
                        resultSet.getString(COLUMN_NAME),
                        resultSet.getInt(COLUMN_PHONE),
                        resultSet.getString(COLUMN_EMAIL));
            }

            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute(String.format(
                "INSERT INTO %s (%s, %s, %s) VALUES ('%s', %d, '%s')",
                TABLE_CONTACTS, COLUMN_NAME, COLUMN_PHONE, COLUMN_EMAIL,
                name, phone, email));
    }
}
