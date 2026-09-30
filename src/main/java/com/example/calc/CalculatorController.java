package com.example.calc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.application.Platform;
import javafx.scene.Node;

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
        pruefeUndErsetzeOperator();
        wasClickedAgain();
        FeldText.appendText("+");
    }

    public void OnMinusButtonClick() {
        pruefeUndErsetzeOperator();
        wasClickedAgain();
        FeldText.appendText("-");
    }

    public void OnMulButtonClick() {
        pruefeUndErsetzeOperator();
        wasClickedAgain();
        FeldText.appendText("*");
    }

    public void OnDivButtonClick() {
        pruefeUndErsetzeOperator();
        wasClickedAgain();
        FeldText.appendText("/");
    }

    private void pruefeUndErsetzeOperator() {
        String text = FeldText.getText();
        if (!text.isEmpty()) {
            char letztes = text.charAt(text.length() - 1);
            if (letztes == '+' || letztes == '-' || letztes == '*' || letztes == '/') {
                FeldText.setText(text.substring(0, text.length() - 1));
            }
        }
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
    public void initialize() {        //https://www.w3schools.com/java/java_constructors.asp          //https://stackoverflow.com/questions/12005584/initialize-object-directly-in-ja
        FeldText.setFocusTraversable(false);
        VerlaufFeld.setFocusTraversable(false);
        Platform.runLater(() -> {               //https://openjfx.io/javadoc/17/javafx.graphics/javafx/application/Platform.html#runLater(java.lang.Runnable)
            if (FeldText.getScene() != null) {              //https://openjfx.io/javadoc/17/javafx.graphics/javafx/scene/Node.html#requestFocus()

                FeldText.getScene().getRoot().requestFocus();           //https://stackoverflow.com/questions/11090846/assigning-to-nested-qvariantmap

                for (Node node : FeldText.getScene().getRoot().lookupAll(".button")) {          //https://openjfx.io/javadoc/17/javafx.graphics/javafx/scene/Parent.html#lookupAll(java.lang.String)
                    node.setFocusTraversable(false);            //https://openjfx.io/javadoc/17/javafx.graphics/javafx/scene/Node.html#setFocusTraversable(boolean)
                }
            }
        });
    }


    @FXML
    public void keys(KeyEvent event) {          //https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html

        switch (event.getCode()) {

            case NUMPAD0:
            case DIGIT0:
                On0ButtonClick();
                break;

            case NUMPAD1:
            case DIGIT1:
                On1ButtonClick();
                break;

            case NUMPAD2:
            case DIGIT2:
                On2ButtonClick();
                break;

            case NUMPAD3:
            case DIGIT3:
                On3ButtonClick();
                break;

            case NUMPAD4:
            case DIGIT4:
                On4ButtonClick();
                break;

            case NUMPAD5:
            case DIGIT5:
                On5ButtonClick();
                break;

            case NUMPAD6:
            case DIGIT6:
                On6ButtonClick();
                break;

            case NUMPAD7:
            case DIGIT7:
                On7ButtonClick();
                break;

            case NUMPAD8:
            case DIGIT8:
                On8ButtonClick();
                break;

            case NUMPAD9:
            case DIGIT9:
                On9ButtonClick();
                break;

            case ADD:
            case PLUS:
                OnPlusButtonClick();
                break;

            case SUBTRACT:
            case MINUS:
                OnMinusButtonClick();
                break;

            case MULTIPLY:
                OnMulButtonClick();
                break;

            case DIVIDE:
                OnDivButtonClick();
                break;

            case DECIMAL:
            case COMMA:
            case PERIOD:
                OnKommaButtonClick();
                break;

            case ENTER:
                OnErgebnisButtonClick();
                break;

            case BACK_SPACE:
            case DELETE:
                OnDelButtonClick();
                break;

            default:
                return;
        }

        event.consume();
    }


    boolean warNegativ = false;

    public String VorzeichenSchnitt() {

        String eingabe = FeldText.getText().replace(",", ".");

        if (eingabe.isEmpty()) {
            warNegativ = false;
            return "";
        }

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

    public void OnClearButtonClick() {
        System.out.println("CE");
        FeldText.setText("");
        VerlaufFeld.setText("");
    }

    public void OnClearEntryButtonClick() {
        System.out.println("C");
        FeldText.setText("");
    }

    public void OnDelButtonClick() {               // https://stackoverflow.com/questions/7438612/how-to-remove-the-last-character-from-a-string
        System.out.println("Del");

        String text = FeldText.getText();

        int len = text.length();

        //FeldText.setText(text.replace(text.substring(len-1),""));

        if (len > 0) {
            FeldText.deleteText(len - 1, len);
        }

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

        String eingabe = FeldText.getText();

//        boolean count = false;
//
//        String buffer = "";
//
//        if (count) {
//            buffer = eingabe;
//        }
//
//        if (eingabe.charAt(0) == '-') {
//            count = true;
//            FeldText.setText(buffer);
//        } else {
//            eingabe = "-" + eingabe;
//            FeldText.setText(eingabe);
//        }

        if (eingabe.isEmpty()) {
            FeldText.setText("-");
            return;
        }

        if (eingabe.charAt(0) == '-') {
            eingabe = eingabe.substring(1);
            FeldText.setText(eingabe);
        } else {
            eingabe = "-" + eingabe;
            FeldText.setText(eingabe);
        }

    }

    public void wasClickedAgain() {
        String eingabe = VorzeichenSchnitt();

        boolean hatOperator = eingabe.contains("+") || eingabe.contains("-") ||
                eingabe.contains("*") || eingabe.contains("/");

        if (hatOperator && !eingabe.endsWith("+") && !eingabe.endsWith("-") &&
                !eingabe.endsWith("*") && !eingabe.endsWith("/")) {

            OnErgebnisButtonClick();
        }
    }


}
