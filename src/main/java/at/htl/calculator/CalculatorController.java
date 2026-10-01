package at.htl.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;

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

    private Button fieldButtonDiv;
    private Button fieldButtonMul;
    private Button fieldButtonMin;
    private Button fieldButtonPlus;

    private Button fieldButtonProzent;
    private Button fieldButtonCE;
    private Button fieldButtonC;
    private Button fieldButtonDel;

    private Button fieldButtonErgebins;

    private TextField feld;

    private Label texti;



    public void On0ButtonClick(){
        final int zero = 0;
        System.out.println(zero);
        texti.setText(String.valueOf(zero));
        feld.setText(String.valueOf(zero));
    }

    public void On1ButtonClick(){
        final int eins = 1;
        System.out.println(eins);
    }

    public void On2ButtonClick(){
        final int zwei = 2;
        System.out.println(zwei);
    }

    public void On3ButtonClick(){
        final int drei = 3;
        System.out.println(drei);
    }

    public void On4ButtonClick(){
        final int vier = 4;
        System.out.println(vier);
    }

    public void On5ButtonClick(){
        final int funf = 5;
        System.out.println(funf);
    }

    public void On6ButtonClick(){
        final int scechs = 6;
        System.out.println(scechs);
    }

    public void On7ButtonClick(){
        final int sieben = 7;
        System.out.println(sieben);
    }

    public void On8ButtonClick(){
        final int acht = 8;
        System.out.println(acht);
    }

    public void On9ButtonClick(){
        final int neun = 9;
        System.out.println(neun);
    }









    public void OnErgebnisButtonClick(){
        feld.setText("kas");
        System.out.println("=");
    }

    public void OnDelButtonClick(){
        feld.setText("");
        System.out.println("Del");
    }



    public void OnPlusButtonClick(){
        String akt = feld.getText();
        int akt1 = Integer.parseInt(akt);
        int akt2 = 0;

        akt1 += akt2;

        feld.setText(String.valueOf(akt1));

    }



















}
