/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it350.projekat;

import javafx.scene.control.Alert;

/**
 *
 * @author uSER
 */
public class AlertBoxUpdated {
     public static void alert() {

        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setHeaderText("Uspesno ste azurirali proizvod iz tabele!");
        al.setTitle("Success!");
        al.show();
    }
    
}
