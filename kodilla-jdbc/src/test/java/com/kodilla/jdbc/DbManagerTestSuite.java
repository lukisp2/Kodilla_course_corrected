package com.kodilla.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "SELECT * FROM USERS";
        try {
            Statement statement = dbManager.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            //Then
            int counter = 0;
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + " " +
                        rs.getString("FIRSTNAME") + " " +
                        rs.getString("LASTNAME"));
                counter++;
            }
            rs.close();
            statement.close();
            assertEquals(5, counter);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    void testSelectUsersAndPosts() {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS NO_OR_POSTS\n" +
                "FROM USERS U JOIN POSTS P on U.ID = P.USER_ID\n" +
                "GROUP BY U.FIRSTNAME, U.LASTNAME\n" +
                "HAVING COUNT(*) >1";

        try {
            Statement statement = dbManager.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            int counter = 0;
            while (rs.next()) {
                System.out.println(
                        rs.getString("FIRSTNAME") + " " +
                                rs.getString("LASTNAME"));
                counter++;
                Assertions.assertEquals(1, counter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}