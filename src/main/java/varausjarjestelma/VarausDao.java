/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varausjarjestelma;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miska
 */
@Component
public class VarausDao implements Dao<Varaus, Integer> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AsiakasDao asiakasDao;

    @Override
    public void create(Varaus varaus) throws SQLException {
        jdbcTemplate.update("INSERT INTO Varaus"
                + "(id, asiakas, alkupaiva, loppupaiva, huonetyyppi, korkeinhinta)"
                + " VALUES (?, ?, ?, ?, ?, ?)",
                varaus.getId(), varaus.getAsiakas(), varaus.getAlkupaiva(), varaus.getLoppupaiva(), varaus.getHuonetyyppi(), varaus.getKorkeinhinta()
        );
    }

    @Override
    public Varaus read(Integer key) throws SQLException {
        List<Varaus> varaukset = jdbcTemplate.query(
                "SELECT * FROM Varaus WHERE id = ?",
                (rs, rowNum) -> new Varaus(rs.getInt("id"), asiakasDao.read(rs.getInt("asiakas_id")), rs.getDate("alkupaiva"), rs.getDate("loppupaiva"), rs.getString("huonetyyppi"), rs.getInt("korkeinhinta")),
                key);

        if (varaukset.isEmpty()) {
            return null;
        }
        return varaukset.get(0);
    }

    @Override
    public Varaus update(Varaus varaus) throws SQLException {
        jdbcTemplate.update("UPDATE Varaus SET"
                + " id=?, asiakas=?, alkupaiva=?, loppupaiva=?, huonetyyppi=?, korkeinhinta=?",
                varaus.getId(),
                varaus.getAsiakas(),
                varaus.getAlkupaiva(),
                varaus.getLoppupaiva(),
                varaus.getHuonetyyppi(),
                varaus.getKorkeinhinta());

        return varaus;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        jdbcTemplate.update("DELETE FROM Varaus"
                + " WHERE id = ?",
                key);
    }

    @Override
    public List<Varaus> list() throws SQLException {
        List<Varaus> varaukset = jdbcTemplate.query(
                "SELECT * FROM Varaus",
                (rs, rowNum) -> new Varaus(rs.getInt("id"), asiakasDao.read(rs.getInt("asiakas_id")), rs.getDate("alkupaiva"), rs.getDate("loppupaiva"), rs.getString("huonetyyppi"), rs.getInt("korkeinhinta")));

        return varaukset;
    }
    
//    public List<Hotellihuone> hae(Date alkupaiva, Date loppupaiva, String tyyppi, int korkeinhinta) throws SQLException {
//        List<Varaus> varaukset = list();
//        List<Hotellihuone> vapaat = new ArrayList<>();
//        
//        for(int i = 0; i < varaukset.size(); i++) {
//            Varaus testattava = varaukset.get(i);
//            
//            if ((tyyppi != null) && (tyyppi != testattava.getHuonetyyppi())) {
//                continue;
//            }
//            
//            if (alkupaiva.after(testattava.alkupaiva) && loppupaiva.before(testattava.loppupaiva)) {
//                continue;
//            } else {
//               // vapaat.add(HAKEE TESTATTAVAA VARAUSTA VASTAAVAN VAPAAN HUONEEN);
//            }
//
//        }
//        
//    }

}
