package sample;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller{

    @FXML
    private TextField campo;


    @FXML
    public void fecharP (){
        campo.setText(campo.getText()+" )");
    }

    @FXML
    public void abrirP(){
        campo.setText(campo.getText()+" (");
    }

    @FXML
    public void p (){
        campo.setText(campo.getText()+" P");
    }

    @FXML
    public void q (){
        campo.setText(campo.getText()+" Q");
    }

    @FXML
    public void r (){
        campo.setText(campo.getText()+" R");
    }

    @FXML
    public void s (){
        campo.setText(campo.getText()+" S");
    }

    @FXML
    public void negacao (){
        campo.setText(campo.getText()+" ~");
    }

    @FXML
    public void implicacao (){
        campo.setText(campo.getText()+" ->");
    }

    @FXML
    public void seSomenteSe (){
        campo.setText(campo.getText()+" <->");
    }

    @FXML
    public void se (){
        campo.setText(campo.getText()+" ->");
    }

    @FXML
    public void ouOu (){
        campo.setText(campo.getText()+" !");
    }

    @FXML
    public void e (){
        campo.setText(campo.getText()+" ^");
    }

    @FXML
    public void ou (){
        campo.setText(campo.getText()+" v");
    }

    @FXML
    public void reset (){
        campo.setText(" ");
    }


    @FXML
    public void calcular (){

        InserirValores.valores(campo.getText());

    }

}
