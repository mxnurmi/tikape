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
public class HotellihuoneVaraus {

    Varaus varaus;
    Hotellihuone hotellihuone;

    public HotellihuoneVaraus(Varaus varaus, Hotellihuone hotellihuone) {
        this.varaus = varaus;
        this.hotellihuone = hotellihuone;
    }

    public Varaus getVaraus() {
        return varaus;
    }

    public Hotellihuone getHotellihuone() {
        return hotellihuone;
    }

}
