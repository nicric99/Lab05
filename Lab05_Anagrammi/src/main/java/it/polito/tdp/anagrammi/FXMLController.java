package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAnagramma;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextField txtParola;
    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagramma(ActionEvent event) {
// controllo dell'input lo facciamo dopo
    	String parola= null;
    	try {
    		parola= txtParola.getText();
    		if(parola.isEmpty()) {
    			txtCorretti.setText("Attenzione non è stato inserito niente");
    			return;
    		}
    		if(parola.length()>8) {
    			txtCorretti.appendText("La parola è molto lunga ritentare con una più corta");
    			return;
    		}
    	}catch(NullPointerException npe) {
    		txtCorretti.setText(" NUll pointer exception");
    		return;
    	}
    	Set<String> soluzioni;
    	soluzioni=model.doAnagramma(parola);
    	Map<String,Boolean> mappaSoluzioni;
    	mappaSoluzioni=model.corretto(soluzioni);
    	for(String s: mappaSoluzioni.keySet()) {
    		if(mappaSoluzioni.get(s)) {
    			txtCorretti.appendText(s+" "+mappaSoluzioni.get(s)+" \n");
    		}else {
    			txtErrati.appendText(s+" "+mappaSoluzioni.get(s)+" \n");
    			}
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    	model.clearAnagrammi();

    }
    public void setModel(Model model) {
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}