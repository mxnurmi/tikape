package varausjarjestelma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VarausjarjestelmaSovellus implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(VarausjarjestelmaSovellus.class);
    }

    @Autowired
    Tekstikayttoliittyma tekstikayttoliittyma;

    @Override
    public void run(String... args) throws Exception {
        Scanner lukija = new Scanner(System.in);
        alustaTietokanta();
        tekstikayttoliittyma.kaynnista(lukija);
    }

    private static void alustaTietokanta() {
        // mikäli poistat vahingossa tietokannan voit ajaa tämän metodin jolloin 
        // tietokantataulu luodaan uudestaan

        try (Connection conn = DriverManager.getConnection("jdbc:h2:./hotelliketju", "sa", "")) {
            conn.prepareStatement("DROP TABLE Hotellihuone IF EXISTS;").executeUpdate();
            conn.prepareStatement("CREATE TABLE Hotellihuone (numero INTEGER PRIMARY KEY, "
                    + "tyyppi VARCHAR(32), paivahinta INTEGER);").executeUpdate();

            conn.prepareStatement("DROP TABLE Asiakas IF EXISTS;").executeUpdate();
            conn.prepareStatement("CREATE TABLE Asiakas (id INTEGER PRIMARY KEY, "
                    + "nimi VARCHAR(32), sahkoposti VARCHAR(64));").executeUpdate();

            conn.prepareStatement("DROP TABLE Varaus IF EXISTS;").executeUpdate();
            conn.prepareStatement("CREATE TABLE Varaus(id INTEGER PRIMARY KEY, asiakas_id INTEGER, alkupaiva DATE, "
                    + "loppupaiva DATE, huonetyyppi VARCHAR(32), korkeinhinta INTEGER, "
                    + "FOREIGN KEY (asiakas_id) REFRENCES Asiakas(id));").executeUpdate();

            conn.prepareStatement("DROP TABLE HotellihuoneVaraus IF EXISTS;").executeUpdate();
            conn.prepareStatement("CREATE TABLE HotellihuoneVaraus();").executeUpdate();

            conn.prepareStatement("DROP TABLE Lisavaruste IF EXISTS;").executeUpdate();
            conn.prepareStatement("CREATE TABLE Lisavaruste(id INTEGER PRIMARY KEY, nimi STRING, hinta INTEGER);").executeUpdate();

            conn.prepareStatement("").executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VarausjarjestelmaSovellus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
