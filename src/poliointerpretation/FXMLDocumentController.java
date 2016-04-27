/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poliointerpretation;

import com.google.gson.Gson;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
 *
 * @author Olivia
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    //private BarChart chart;
    private BarChart barChart;
    /*@FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        chart.setText("Hello World!");
    }*/
   // @FXML
   // private Slider minimum;
    
    @Override
    public void initialize(URL urlParam, ResourceBundle rb) {
        // TODO
        String s = "http://apps.who.int/gho/athena/data/GHO/WHS4_544.json?profile=simple&filter=YEAR:1980";
        URL url = null;
        try {
            url = new URL(s);
        } catch (Exception e) {
            System.out.println("Improper URL " + s);
            System.exit(-1);
        }
     
        // read from the URL
        Scanner scan = null;
        try {
            scan = new Scanner(url.openStream());
        } catch (Exception e) {
            System.out.println("Could not connect to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
        }
        scan.close();
        
        Gson gson = new Gson();
        Dataset dS = gson.fromJson(str, Dataset.class);
        //Dim countryName = gson.fromJson(str, Dataset.class);
        
        XYChart.Series<String, Number> country = new XYChart.Series();
        country.setName("Country");
        
        for(DataPoint f : dS.getDP()){
            if (f.getDim().getCOUNTRY() != null){
                country.getData().add(new XYChart.Data(f.getDim().getCOUNTRY(), f.getValue()));
            }
        }
        
        //keys = .keySet().toArray();
        barChart.getData().add(country);    
        
    }    
    
}
