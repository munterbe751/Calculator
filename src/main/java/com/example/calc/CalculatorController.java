package com.example.calc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class CalculatorController {

    @FXML
    private Button fieldButton9;
    private Button fieldButton8;
    private Button fieldButton7;
    private Button fieldButton6;
    private Button fieldButton5;
    private Button fieldButton4;
    private Button fieldButton3;
    private Button fieldButton2;
    private Button fieldButton1;
    private Button fieldButton0;

    @FXML
    private Button fieldButtonDiv;
    private Button fieldButtonMul;
    private Button fieldButtonMin;
    private Button fieldButtonPlus;

    @FXML
    private Button fieldButtonProzent;
    private Button fieldButtonCE;
    private Button fieldButtonC;
    private Button fieldButtonDel;

    @FXML
    private Button fieldButtonErgebins;

    @FXML
    private TextField FeldText;

    @FXML
    private TextField VerlaufFeld;

    public void On0ButtonClick() {
        final int zero = 0;
        System.out.println(zero);
        FeldText.appendText(String.valueOf(zero));
    }

    public void On1ButtonClick() {
        final int eins = 1;
        System.out.println(eins);
        FeldText.appendText(String.valueOf(eins));
    }

    public void On2ButtonClick() {
        final int zwei = 2;
        System.out.println(zwei);
        FeldText.appendText(String.valueOf(zwei));
    }

    public void On3ButtonClick() {
        final int drei = 3;
        System.out.println(drei);
        FeldText.appendText(String.valueOf(drei));
    }

    public void On4ButtonClick() {
        final int vier = 4;
        System.out.println(vier);
        FeldText.appendText(String.valueOf(vier));
    }

    public void On5ButtonClick() {
        final int funf = 5;
        System.out.println(funf);
        FeldText.appendText(String.valueOf(funf));
    }

    public void On6ButtonClick() {
        final int scechs = 6;
        System.out.println(scechs);
        FeldText.appendText(String.valueOf(scechs));
    }

    public void On7ButtonClick() {
        final int sieben = 7;
        System.out.println(sieben);
        FeldText.appendText(String.valueOf(sieben));
    }

    public void On8ButtonClick() {
        final int acht = 8;
        System.out.println(acht);
        FeldText.appendText(String.valueOf(acht));
    }

    public void On9ButtonClick() {
        final int neun = 9;
        System.out.println(neun);
        FeldText.appendText(String.valueOf(neun));
    }

    public void OnKommaButtonClick() {

        FeldText.appendText(",");

    }


    public void OnPlusButtonClick() {

        FeldText.appendText("+");

    }

    public void OnMinusButtonClick() {

        FeldText.appendText("-");

    }

    public void OnMulButtonClick() {

        FeldText.appendText("*");

    }

    public void OnDivButtonClick() {

        FeldText.appendText("/");

    }

    public void OnSqrButtonClick() {
        System.out.println("²");

        double zahl = Integer.parseInt(FeldText.getText().substring(FindOperation() + 1));

        FeldText.replaceText(FindOperation(), '\0', String.valueOf(Math.pow(zahl, 2)));

    }

    public void OnSqrtButtonClick() {
        System.out.println("√");

        double zahl = Integer.parseInt(FeldText.getText().substring(0, FindOperation()));

        FeldText.replaceText(FindOperation(), '\0', String.valueOf(Math.sqrt(zahl)));

    }


    @FXML
    public void keys(KeyEvent enter) {

        if (enter.getCode() == KeyCode.ENTER) {         //https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html
            enter.consume();
            OnErgebnisButtonClick();

        }

    }


    boolean warNegativ = false;

    public String VorzeichenSchnitt() {

        String eingabe = FeldText.getText().replace(",", ".");

        int len = eingabe.length();

        if (eingabe.charAt(0) == '+' || eingabe.charAt(0) == '-' || eingabe.charAt(0) == '*' || eingabe.charAt(0) == '/') {
            eingabe = eingabe.substring(1, len);
            warNegativ = true;
        } else {
            warNegativ = false;
        }

        return eingabe;

    }


    public double OnErgebnisButtonClick() { //macht auch alle Rechenoperationen
        System.out.println("=");

        //String eingabe = FeldText.getText();

        char operation = 0;

        String rechenArt = (VorzeichenSchnitt().replaceAll("[0-9.]", ""));

        if (rechenArt.equals("+")) {
            operation = '+';
        } else if (rechenArt.equals("-")) {
            operation = '-';
        } else if (rechenArt.equals("*")) {
            operation = '*';
        } else if (rechenArt.equals("/")) {
            operation = '/';
        } else {
            System.out.println("ERRÖR RECHENOPERATION!!!");
        }

        System.out.println(rechenArt);

        double zahl1;
        double zahl2;
        double ergebnis = 0;

        int foundOp = FindOperation();

        zahl1 = Double.parseDouble(VorzeichenSchnitt().substring(0, foundOp));  //https://www.w3schools.com/java/ref_string_substring.asp
        zahl2 = Double.parseDouble(VorzeichenSchnitt().substring(foundOp + 1));

        if (warNegativ) {
            zahl1 *= (-1);
        }

        System.out.println(zahl1);
        System.out.println(zahl2);

        switch (operation) {
            case '+':
                ergebnis = zahl1 + zahl2;
                break;
            case '-':
                ergebnis = zahl1 - zahl2;
                break;
            case '*':
                ergebnis = zahl1 * zahl2;
                break;
            case '/':
                ergebnis = zahl1 / zahl2;
                break;
        }

//        switch (rechenArt) {
//            case "+":
//                //ergebnis = zahl1 + zahl2;
//                System.out.println("kas");
//                break;
//            case "-":
//                ergebnis = zahl1 - zahl2;
//                break;
//            case "*":
//                ergebnis = zahl1 * zahl2;
//                break;
//            case "/":
//                ergebnis = zahl1 / zahl2;
//                break;
//        }

        FeldText.setText(String.valueOf(ergebnis));
        System.out.println(ergebnis);

        String letzteEingabe = String.valueOf(zahl1) + rechenArt + String.valueOf(zahl2) + "=" + String.valueOf(ergebnis);

        VerlaufFeld.setText(letzteEingabe);

        return ergebnis;

    }

    public void OnCButtonClick() {
        System.out.println("C");
        FeldText.setText("");
    }

    public void OnCEButtonClick() {
        System.out.println("CE");
        FeldText.setText("");
        VerlaufFeld.setText("");
    }

    public void OnDelButtonClick() {               // https://stackoverflow.com/questions/7438612/how-to-remove-the-last-character-from-a-string
        System.out.println("Del");

        String text = FeldText.getText();

        int len = text.length();

        //FeldText.setText(text.replace(text.substring(len-1),""));

        FeldText.deleteText(len - 1, len);

    }

    public int FindOperation() {

        //int wo = eingabe.indexOf("[+*-/]");
        int wo = 0;

        //String eingabe = FeldText.getText();

        if (VorzeichenSchnitt().contains("+")) {            //https://www.w3schools.com/java/ref_string_contains.asp
            wo = VorzeichenSchnitt().indexOf("+");
        } else if (VorzeichenSchnitt().contains("-")) {
            wo = VorzeichenSchnitt().indexOf("-");
        } else if (VorzeichenSchnitt().contains("*")) {
            wo = VorzeichenSchnitt().indexOf("*");
        } else if (VorzeichenSchnitt().contains("/")) {
            wo = VorzeichenSchnitt().indexOf("/");
        }

        return wo;

    }


    public void OnInvertButtonClick() {

        //*(-1)

    }

}
