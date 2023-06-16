package org.max.seminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreditTest extends AbstractTest {

    @Test
    void getCredits_whenValid_shouldReturn() throws SQLException {
        //given
        String sql = "SELECT * FROM credit";
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
