/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracerouteip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author brice.arnault
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField tf_dest;
    @FXML
    WebView wv_maps;
    WebEngine webEngine;
    
    InetAddress adrDest;
    
    
    @FXML
    private void handleButtonTrace(ActionEvent event) {
        
        String str = tf_dest.getText();
            if(!str.isEmpty())//Saisie destiantion non vide
            {
                if(str.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"))//Destination est une ipV4
                {
                    System.out.println("Destination IPV4 OK");
                }
                else //On suppose que destination est une URL
                {
                    System.out.println("Destination URL");
                    try {
                        adrDest = InetAddress.getByName(str);
                        str = adrDest.getHostAddress();
                        System.out.println("IP destination : "+str);
                    } catch (UnknownHostException ex) {
                        System.out.println("Erreur getByName");
                    }
                }
            }
            else
            {
                System.out.println("Destination VIDE");
            }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        webEngine = wv_maps.getEngine();
        webEngine.load("https://www.google.fr/maps");
        
    }    
    
}
