/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it350.projekat;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author uSER
 */
public class IT350Projekat extends Application {
    
     @Override
    public void start(Stage primaryStage) {
        Button unos = new Button("Unos novog proizvoda");
        unos.setOnAction(e -> {
            Unos.unesi();
        }); 
        //kada se unosi pacijent u polikliniku, PIB mora da bude vazeci u bazi podataka
        Button spisak = new Button("Spisak proizvoda");
        spisak.setOnAction(e -> {
            PrikazProizvoda.svi();
        });
          Button update = new Button("Update proizvod");
        update.setOnAction(e -> {
            AzurirajProizvod.update();
        });
        VBox vb = new VBox();
        vb.setPadding(new Insets(15, 10, 10, 40));
        vb.setSpacing(20);
        vb.getChildren().addAll(unos, spisak, update);

        Scene scene = new Scene(vb, 300, 250);

        primaryStage.setTitle("Pocetni meni");
        primaryStage.setScene(scene);
        primaryStage.show();
         }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
