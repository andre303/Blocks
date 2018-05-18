package views;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import static java.awt.Color.black;

public class MainFormController implements Initializable {
    @FXML
    private Label txt_steps;

    @FXML
    private Label txt_score;

    @FXML
    private GridPane game_field;
    private String[] colors = {"red","black","yellow","purple"};
    Random rnd = new Random();
    public void initialize(URL location, ResourceBundle resources) {
        try {
            txt_steps.setText("6");
            fillField();
            game_field.addEventHandler(Event.ANY, new EventHandler<Event>() {
                @Override
                public void handle(Event event) {
                    if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                        Node source = (Node) event.getSource();
                        Integer colIndex = GridPane.getColumnIndex(source);
                        Integer rowIndex = GridPane.getRowIndex(source);
                        txt_score.setText(colIndex + " " + rowIndex);
                    }
                }
            });

        }
        catch (Exception ex) {
        }
    }
    public void fillField(){
        for(int i = 0;i<7;i++)
        {
            for(int j = 0;j<5;j++){
                Circle c = new Circle(30, Color.valueOf("red"));
                c.setFill(Paint.valueOf(colors[rnd.nextInt(4)]));
                game_field.add(c, i, j);
            }
        }
    }
}
