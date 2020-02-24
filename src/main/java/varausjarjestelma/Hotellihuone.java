/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varausjarjestelma;


/**
 *
 * @author Miska
 */
public class Hotellihuone {
    int numero;
    String tyyppi;
    int paivahinta;
    
    public Hotellihuone(int numero, String tyyppi, int paivahinta) {
        this.numero = numero;
        this.tyyppi = tyyppi;
        this.paivahinta = paivahinta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public int getPaivahinta() {
        return paivahinta;
    }

    public void setPaivahinta(int paivahinta) {
        this.paivahinta = paivahinta;
    }
    
}
