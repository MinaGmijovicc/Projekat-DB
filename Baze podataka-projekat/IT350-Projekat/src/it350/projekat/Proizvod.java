/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it350.projekat;

/**
 *
 * @author uSER
 */
public class Proizvod {
     private int ID_PROIZVODA;
    private int ID_VRSTE;
    private double JEDINICAMERE;
    private int CENA;
    private String NAZIVPROIZVODA;

    public Proizvod(int ID_PROIZVODA, int ID_VRSTE, double JEDINICAMERE, int CENA, String NAZIVPROIZVODA) {
        this.ID_PROIZVODA = ID_PROIZVODA;
        this.ID_VRSTE = ID_VRSTE;
        this.JEDINICAMERE = JEDINICAMERE;
        this.CENA = CENA;
        this.NAZIVPROIZVODA = NAZIVPROIZVODA;
    }

    public int getID_PROIZVODA() {
        return ID_PROIZVODA;
    }

    public void setID_PROIZVODA(int ID_PROIZVODA) {
        this.ID_PROIZVODA = ID_PROIZVODA;
    }

    public int getID_VRSTE() {
        return ID_VRSTE;
    }

    public void setID_VRSTE(int ID_VRSTE) {
        this.ID_VRSTE = ID_VRSTE;
    }

    public double getJEDINICAMERE() {
        return JEDINICAMERE;
    }

    public void setJEDINICAMERE(double JEDINICAMERE) {
        this.JEDINICAMERE = JEDINICAMERE;
    }

    public int getCENA() {
        return CENA;
    }

    public void setCENA(int CENA) {
        this.CENA = CENA;
    }

    public String getNAZIVPROIZVODA() {
        return NAZIVPROIZVODA;
    }

    public void setNAZIVPROIZVODA(String NAZIVPROIZVODA) {
        this.NAZIVPROIZVODA = NAZIVPROIZVODA;
    }

    @Override
    public String toString() {
        return "Proizvod{" + "ID_PROIZVODA=" + ID_PROIZVODA + ", ID_VRSTE=" + ID_VRSTE + ", JEDINICAMERE=" + JEDINICAMERE + ", CENA=" + CENA + ", NAZIVPROIZVODA=" + NAZIVPROIZVODA + '}';
    }
    
    
}

    

