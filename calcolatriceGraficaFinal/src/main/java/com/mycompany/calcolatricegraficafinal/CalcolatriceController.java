package com.mycompany.calcolatricegraficafinal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalcolatriceController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn0"
    private Button btn0; // Value injected by FXMLLoader

    @FXML // fx:id="btn1"
    private Button btn1; // Value injected by FXMLLoader

    @FXML // fx:id="btn2"
    private Button btn2; // Value injected by FXMLLoader

    @FXML // fx:id="btn3"
    private Button btn3; // Value injected by FXMLLoader

    @FXML // fx:id="btn4"
    private Button btn4; // Value injected by FXMLLoader

    @FXML // fx:id="btn5"
    private Button btn5; // Value injected by FXMLLoader

    @FXML // fx:id="btn6"
    private Button btn6; // Value injected by FXMLLoader

    @FXML // fx:id="btn7"
    private Button btn7; // Value injected by FXMLLoader

    @FXML // fx:id="btn8"
    private Button btn8; // Value injected by FXMLLoader

    @FXML // fx:id="btn9"
    private Button btn9; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddizione"
    private Button btnAddizione; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader

    @FXML // fx:id="btnDivisione"
    private Button btnDivisione; // Value injected by FXMLLoader

    @FXML // fx:id="btnEquals"
    private Button btnEquals; // Value injected by FXMLLoader

    @FXML // fx:id="btnMoltiplicazione"
    private Button btnMoltiplicazione; // Value injected by FXMLLoader

    @FXML // fx:id="btnSottrazione"
    private Button btnSottrazione; // Value injected by FXMLLoader

    @FXML // fx:id="btnVirgola"
    private Button btnVirgola; // Value injected by FXMLLoader

    @FXML // fx:id="txtOperazioni"
    private TextField txtOperazioni; // Value injected by FXMLLoader

    private static final int lunghezzaMax=10;
    private double accumulatore=0;
    private String operatore="";
    private boolean nuovoNumero=true;
    
    private void appendNumber(String num){
        
        String testo= txtOperazioni.getText();
        
        if(testo == null || testo.isEmpty() || nuovoNumero) {
        txtOperazioni.setText(num);
        nuovoNumero=false;
        return;
        }
        
        if(testo.length() >= lunghezzaMax) return;
        
        txtOperazioni.setText(testo+num);
    }
   
                
    @FXML
    void handle0(ActionEvent event) {
        appendNumber("0");
    }

    @FXML
    void handle1(ActionEvent event) {
        appendNumber("1");
    }

    @FXML
    void handle2(ActionEvent event) {
        appendNumber("2");
    }

    @FXML
    void handle3(ActionEvent event) {
        appendNumber("3");
    }

    @FXML
    void handle4(ActionEvent event) {
        appendNumber("4");
    }

    @FXML
    void handle5(ActionEvent event) {
        appendNumber("5");
    }

    @FXML
    void handle6(ActionEvent event) {
        appendNumber("6");
    }

    @FXML
    void handle7(ActionEvent event) {
        appendNumber("7");
    }

    @FXML
    void handle8(ActionEvent event) {
        appendNumber("8");
    }

    @FXML
    void handle9(ActionEvent event) {
        appendNumber("9");
    }

    
    private void handleOperazioniActual(String op) {
        if (!txtOperazioni.getText().isEmpty())   {
            if(!operatore.isEmpty()) calcola();
            else accumulatore=parseDisplay();
            operatore =op;
            nuovoNumero= true;}
    }
    
 
    @FXML
    void handleAddizione(ActionEvent event) {
        handleOperazioniActual("+");
        txtOperazioni.setText("");
    }

    @FXML
    void handleCancella(ActionEvent event) {
        txtOperazioni.setText("");
        accumulatore=0;
        operatore="";
        nuovoNumero=true;
    }

    @FXML
    void handleDivisione(ActionEvent event) {
        handleOperazioniActual("/");
        txtOperazioni.setText("");
    }

    @FXML
    void handleEquals(ActionEvent event) {
        if(!operatore.isEmpty() && !txtOperazioni.getText().isEmpty()) {
            calcola();
            operatore="";
            nuovoNumero=true;
        }
    }

    @FXML
    void handleMoltiplicazione(ActionEvent event) {
        handleOperazioniActual("x");
        txtOperazioni.setText("");
    }

    

    @FXML
    void handleSottrazione(ActionEvent event) {
        
        handleOperazioniActual("-");
        txtOperazioni.setText("");
    }

    @FXML
    void handleVirgola(ActionEvent event) {
        if (txtOperazioni.getText().length() >= lunghezzaMax) return;
        if (nuovoNumero){
           txtOperazioni.setText("0,");
           nuovoNumero= false;
        } else if (!txtOperazioni.getText().contains(",")) {
                txtOperazioni.setText(txtOperazioni.getText()+ ",");
            
        }
    }
    private void calcola() {
        double numerocorrente=parseDisplay();
        
        switch (operatore) {
            case "+" : accumulatore+=numerocorrente;
                       break;
            case "-" : accumulatore-=numerocorrente;
                       break;
            case "x" : accumulatore*=numerocorrente;
                       break;
            case "/" :
                if (numerocorrente != 0) 
                    accumulatore /= numerocorrente;
                else { 
                    txtOperazioni.setText("Errore");
                    operatore= "";
                    nuovoNumero= true;
                    }
                break;
        }
        txtOperazioni.setText(formatDouble(accumulatore));
        
    }
    private double parseDisplay () {
        return Double.parseDouble(txtOperazioni.getText().replace(",","."));
    }
    private String formatDouble(double valore){
        String testo = String.valueOf(valore);
        if (testo.endsWith(".0")) testo= testo.substring(0, testo.length() -2);
        return testo.replace(",",".");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btn0 != null : "fx:id=\"btn0\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btn3 != null : "fx:id=\"btn3\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btn4 != null : "fx:id=\"btn4\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btn5 != null : "fx:id=\"btn5\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btn6 != null : "fx:id=\"btn6\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btn7 != null : "fx:id=\"btn7\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btn8 != null : "fx:id=\"btn8\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btn9 != null : "fx:id=\"btn9\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btnAddizione != null : "fx:id=\"btnAddizione\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btnDivisione != null : "fx:id=\"btnDivisione\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btnEquals != null : "fx:id=\"btnEquals\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btnMoltiplicazione != null : "fx:id=\"btnMoltiplicazione\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btnSottrazione != null : "fx:id=\"btnSottrazione\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert btnVirgola != null : "fx:id=\"btnVirgola\" was not injected: check your FXML file 'Calcolatrice.fxml'.";
        assert txtOperazioni != null : "fx:id=\"txtOperazioni\" was not injected: check your FXML file 'Calcolatrice.fxml'.";

    }

}
