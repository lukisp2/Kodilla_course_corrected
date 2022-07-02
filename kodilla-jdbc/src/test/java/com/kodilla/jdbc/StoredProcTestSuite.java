package com.kodilla.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.asserts.Assertion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        // When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        Assertions.assertEquals(0, howMany);
        rs.close();
        statement.close();
    }

}