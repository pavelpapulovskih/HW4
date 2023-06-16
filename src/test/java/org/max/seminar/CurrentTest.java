package org.max.seminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CurrentTest extends AbstractTest {

    @Test
    void getCurrents_whenValid_shouldReturn() throws SQLException {
        //given
        String sql = "SELECT * FROM current ";
        Statement stmt  = getConnection().createStatement();
        int countTableSize = 0;
        //when
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            countTableSize++;
        }
        //then
        Assertions.assertEquals(1, countTableSize);
    }
}
