/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varausjarjestelma;

import java.sql.Date;

/**
 *
 * @author Miska
 */
public class Varaus {

    int id;
    Asiakas asiakas;
    Date alkupaiva;
    Date loppupaiva;
    String huonetyyppi;
    int korkeinhinta;

    public Varaus(int id, Asiakas asiakas, Date alkupaiva, Date loppupaiva, String huonetyyppi, int korkeinhinta) {
        this.id = id;
        this.asiakas = asiakas;
        this.alkupaiva = alkupaiva;
        this.loppupaiva = loppupaiva;
        this.huonetyyppi = huonetyyppi;
        this.korkeinhinta = korkeinhinta;
    }

    public Asiakas getAsiakas() {
        return asiakas;
    }

    public void setAsiakas(Asiakas asiakas) {
        this.asiakas = asiakas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAlkupaiva() {
        return alkupaiva;
    }

    public void setAlkupaiva(Date alkupaiva) {
        this.alkupaiva = alkupaiva;
    }

    public Date getLoppupaiva() {
        return loppupaiva;
    }

    public void setLoppupaiva(Date loppupaiva) {
        this.loppupaiva = loppupaiva;
    }

    public String getHuonetyyppi() {
        return huonetyyppi;
    }

    public void setHuonetyyppi(String huonetyyppi) {
        this.huonetyyppi = huonetyyppi;
    }

    public int getKorkeinhinta() {
        return korkeinhinta;
    }

    public void setKorkeinhinta(int korkeinhinta) {
        this.korkeinhinta = korkeinhinta;
    }

}
