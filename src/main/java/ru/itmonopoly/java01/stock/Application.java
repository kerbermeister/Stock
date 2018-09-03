package ru.itmonopoly.java01.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://address=(host=localhost)(port=3306)(serverTimezone=UTC)/study",
                "root",
                "rootroot");




        SpringApplication.run(Application.class, args);
    }

}
