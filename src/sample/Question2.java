//Rowan Birnbaum 100701879

package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Question2 extends Application{
    //variable initilization
    int invAmt;
    int year;
    float intRate;

    public void start(Stage primaryStage) throws Exception {
        //gridpane setup
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(5);
        pane.setHgap(5);

        //investment label/box
        Label invLabel = new Label("Investment Amount:");
        TextField IA = new TextField();
        IA.setPromptText("Enter Amount");
        pane.add(invLabel, 0, 0);
        pane.add(IA, 1, 0);

        //year label/box
        Label yearLabel = new Label("Years:");
        TextField years = new TextField();
        years.setPromptText("Enter Number of Years");
        pane.add(yearLabel, 0, 1);
        pane.add(years, 1, 1);

        //interest rate label/box
        Label intLabel = new Label("Annual Interest Rate:");
        TextField AIR = new TextField();
        AIR.setPromptText("Enter Interest Rate");
        pane.add(intLabel, 0, 2);
        pane.add(AIR, 1, 2);

        //future value label/box
        Label futureValLabel = new Label("Future Value:");
        TextField FV = new TextField();
        pane.add(futureValLabel, 0, 3);
        pane.add(FV, 1, 3);

        //calculate button
        Button calc = new Button("Calculate");
        pane.add(calc, 1,4);
        GridPane.setHalignment(calc, HPos.RIGHT);

        //display gridpane
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question_2");
        primaryStage.show();

        //calculate future value once calculate button is pressed
        calc.setOnAction(event -> {
            FV.setText(calculate(Integer.parseInt(IA.getText()),Integer.parseInt(years.getText()),Float.parseFloat(AIR.getText())));
        });
    }
    //function to calculate future value
    public String calculate(float x, float y, float z){
        z=(z/1200)+1;
        y=y*12;
        return String.valueOf((x*(Math.pow(z, y))));
    }
}
