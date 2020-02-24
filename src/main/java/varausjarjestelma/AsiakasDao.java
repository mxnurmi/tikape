/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varausjarjestelma;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miska
 */
@Component
public class AsiakasDao implements Dao<Asiakas, Integer> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void create(Asiakas asiakas) throws SQLException {
        jdbcTemplate.update("INSERT INTO Asiakas"
                + "(id, nimi, sahkoposti)"
                + " VALUES (?, ?, ?)",
                asiakas.getId(), asiakas.getNimi(), asiakas.getSahkoposti()
        );
    }

    @Override
    public Asiakas read(Integer key) throws SQLException {
        List<Asiakas> asiakkaat = jdbcTemplate.query(
                "SELECT * FROM Asiakas WHERE id = ?",
                (rs, rowNum) -> new Asiakas(rs.getInt("id"), rs.getString("nimi"), rs.getString("sahkoposti")),
                key);

        if (asiakkaat.isEmpty()) {
            return null;
        }

        return asiakkaat.get(0);
    }

    @Override
    public Asiakas update(Asiakas asiakas) throws SQLException {
        jdbcTemplate.update("UPDATE Asiakas SET"
                + " id=?, nimi=?, sahkoposti=?",
                asiakas.getId(),
                asiakas.getNimi(),
                asiakas.getSahkoposti());

        return asiakas;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        jdbcTemplate.update("DELETE FROM Asiakas"
                + " WHERE id = ?",
                key);
    }

    @Override
    public List<Asiakas> list() throws SQLException {
        List<Asiakas> asiakkaat = jdbcTemplate.query(
                "SELECT * FROM Asiakas",
                (rs, rowNum) -> new Asiakas(rs.getInt("id"), rs.getString("nimi"), rs.getString("sahkoposti")));

        return asiakkaat;
    }

}
