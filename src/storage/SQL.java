package storage;

import lombok.SneakyThrows;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SQL {

    private File file;
    private Connection connection;

    @SneakyThrows
    public SQL() {
        // Check if the database file exists, if not, create it.
        file = new File("src/storage", "storage.db");
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        }

        // Try to connect, report success or not.
        if (connect())  System.out.println("Successfully connected to database.");
        else System.out.println("Failed to connect to database.");

        // Create tables.
        createTables();
    }

    @SneakyThrows
    public boolean connect() {
        final String connectionString = "jdbc:sqlite:" + file.getPath();
        connection = DriverManager.getConnection(connectionString);
        return connection != null;
    }

    @SneakyThrows
    public void createTables() {
        String infected = """
                CREATE TABLE IF NOT EXISTS infected (
                	id integer PRIMARY KEY,
                	first_name text NOT NULL,
                	last_name text NOT NULL,
                	date_of_birth text NOT NULL,
                	address text NOT NULL,
                	contact_phone text NOT NULL,
                	contact_email text NOT NULL,
                	number_of_close_contacts integer NOT NULL
                );""";

        final Statement statement = this.connection.createStatement();
        statement.addBatch(infected);
    }



}
