/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varausjarjestelma;

import java.util.*;
import java.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miska
 */

@Component
public class HotellihuoneDao implements Dao<Hotellihuone, Integer> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void create(Hotellihuone hotellihuone) throws SQLException {
        jdbcTemplate.update("INSERT INTO Hotellihuone"
                + "(numero, tyyppi, paivahinta)"
                + " VALUES (?, ?, ?)",
                 hotellihuone.getNumero(), hotellihuone.getTyyppi(), hotellihuone.getPaivahinta()
        );
    }

    @Override
    public Hotellihuone read(Integer key) throws SQLException {
        List<Hotellihuone> huoneet = jdbcTemplate.query(
                "SELECT * FROM Hotellihuone WHERE id = ?",
                (rs, rowNum) -> new Hotellihuone(rs.getInt("numero"), rs.getString("tyyppi"), rs.getInt("paivahinta")),
                key);

        if (huoneet.isEmpty()) {
            return null;
        }

        return huoneet.get(0);
    }

    @Override
    public Hotellihuone update(Hotellihuone hotellihuone) throws SQLException {
        jdbcTemplate.update("UPDATE Hotellihuone SET"
                + " numero=?, tyyppi=?, paivahinta=?",
                hotellihuone.getNumero(),
                hotellihuone.getTyyppi(),
                hotellihuone.getPaivahinta());

        return hotellihuone;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        jdbcTemplate.update("DELETE FROM Hotellihuone"
                + " WHERE id = ?",
                key);
    }

    @Override
    public List<Hotellihuone> list() throws SQLException {
             List<Hotellihuone> huoneet = jdbcTemplate.query(
                "SELECT * FROM Hotellihuone",
                (rs, rowNum) -> new Hotellihuone(rs.getInt("numero"), rs.getString("tyyppi"), rs.getInt("paivahinta")));

        return huoneet;
    }
    

}
