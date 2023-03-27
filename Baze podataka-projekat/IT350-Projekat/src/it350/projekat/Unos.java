/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it350.projekat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author uSER
 */
public class Unos {
    public static void unesi() {
         
    Stage stage = new Stage();
        Label idpr = new Label("ID Proizvoda");
        Label idvrste = new Label("ID Vrste");
        Label jedinicamere = new Label("Jedinica mere");
        Label cena = new Label("Cena");
        Label nazivproizvoda = new Label ("Naziv proizvoda");
        
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();
        Button unesi = new Button("Unesi");
        //upisivanje u bazu podataka klikom na dugme unesi pomocu preparedStatement
        unesi.setOnAction((ActionEvent e) -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projekatnovo", "root", "");
                Statement st = con.createStatement();

                PreparedStatement ps = con.prepareStatement("INSERT INTO proizvod (ID_PROIZVODA, ID_VRSTE, JEDINICAMERE, CENA, NAZIVPROIZVODA) VALUES(?, ?, ?, ?, ?)");

                ps.setInt(1, Integer.parseInt(tf1.getText()));
                ps.setInt(2, Integer.parseInt(tf2.getText()));
                ps.setInt(3, Integer.parseInt(tf3.getText()));
                ps.setInt(4, Integer.parseInt(tf4.getText()));
                 ps.setString(5, tf5.getText());

                ps.execute();
                AlertBoxUnet.alert();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Unos.class.getName()).log(Level.SEVERE, null, ex);
            }            
            stage.close();
    });

        HBox hb1 = new HBox(15);
        hb1.getChildren().addAll(idpr, tf1);
        HBox hb2 = new HBox(15);
        hb2.getChildren().addAll(idvrste, tf2);
        HBox hb3 = new HBox(15);
        hb3.getChildren().addAll(jedinicamere, tf3);
        HBox hb4 = new HBox(15);
        hb4.getChildren().addAll(cena, tf4);
        HBox hb5 = new HBox(15);
        hb5.getChildren().addAll(nazivproizvoda, tf5);
        

        VBox vb1 = new VBox(20);
        vb1.getChildren().addAll(hb1, hb2, hb3, hb4, hb5, unesi);
        vb1.setAlignment(Pos.CENTER);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(vb1);

        Scene scene = new Scene(sp, 350, 300);
        stage.setTitle("Unos proizvoda");
        stage.setScene(scene);
        stage.show();
}
}
    

