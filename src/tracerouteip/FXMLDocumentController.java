/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracerouteip;

import java.net.URL;
import java.util.ResourceBundle;
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
    WebView wv_maps2;
    WebEngine webEngine;
    
    
    @FXML
    private void handleButtonTrace(ActionEvent event) {
        tf_dest.setText("Click");
        webEngine = wv_maps2.getEngine();
        webEngine.load("https://www.google.fr");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
