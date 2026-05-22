package com.zalo.auto.jav103_su26_sd21301.jdbc;

import com.zalo.auto.jav103_su26_sd21301.utils.EntityManagerUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcMain {

    public static void main(String[] args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("QuanLyBanHang", "sa", "123456");

        try (Connection connection = dcm.getConnection()) {

            System.out.println("Connected...");

        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }

        try (var emf = EntityManagerUtils.getEntityManager()) {
            System.out.println("Created tables... ");

        } catch (Exception e) {
            System.out.println("Failed to create EntityManager");
            e.printStackTrace();
        }
    }

}
