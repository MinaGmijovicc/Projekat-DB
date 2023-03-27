package it350.projekat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author uSER
 */
public class PrikazProizvoda {
    public static void svi() {
    TableView tv = ucitavanjeTabele();

        Button obrisi = new Button("Obrisi proizvod iz tabele");
        //brisanje osobe
        obrisi.setOnAction(e -> {
            ObrisiProizvod.obrisi();
        });

        Stage stage = new Stage();
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.getChildren().addAll(obrisi);

        BorderPane bp = new BorderPane();
        bp.setCenter(tv);
        bp.setBottom(hb);

        Scene scene = new Scene(bp, 900, 500);
        stage.setTitle("Spisak svih proizvoda ");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

    public static TableView ucitavanjeTabele() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/projekatnovo", "root", "");
            st = con.createStatement();
            System.out.println("Uspesno povezano");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Nije uspelo povezivanje");
        }

        //pravljenje tabele
        TableView tv = new TableView();

        TableColumn<Integer, Proizvod> column0 = new TableColumn<>("ID_PROIZVODA");
        column0.setCellValueFactory(new PropertyValueFactory<>("ID_PROIZVODA"));
        
        TableColumn<Integer, Proizvod> column1 = new TableColumn<>("ID_VRSTE");
        column1.setCellValueFactory(new PropertyValueFactory<>("ID_VRSTE"));
        
        TableColumn<Integer, Proizvod> column2 = new TableColumn<>("JEDINICAMERE");
        column2.setCellValueFactory(new PropertyValueFactory<>("JEDINICAMERE"));

        TableColumn<Integer, Proizvod> column3 = new TableColumn<>("CENA");
        column3.setCellValueFactory(new PropertyValueFactory<>("CENA"));

        TableColumn<String, Proizvod> column4 = new TableColumn<>("NAZIVPROIZVODA");
        column4.setCellValueFactory(new PropertyValueFactory<>("NAZIVPROIZVODA"));

        tv.getColumns().addAll(column0, column1, column2, column3, column4);
//iscitavanje iz baze i ubacivanje u tabelu
        try {

            String query = "SELECT * FROM Proizvod";
            rs = st.executeQuery(query);
            System.out.println("Uspesno iscitano");
            while (rs.next()) {

                tv.getItems().addAll(new  Proizvod(rs.getInt("ID_PROIZVODA"), rs.getInt("ID_VRSTE"), rs.getInt("JEDINICAMERE"), rs.getInt("CENA"), rs.getString("NAZIVPROIZVODA")));

            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nema proizvoda");
        }
        return tv;
    }
    
}
