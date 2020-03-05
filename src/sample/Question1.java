package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.*;

public class Question1 extends Application{
    public void start(Stage primaryStage) throws Exception{
        //set up and display application panel
        BorderPane pane = new BorderPane();
        pane.setTop(getHBox());
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question_1");
        primaryStage.show();
    }
    private HBox getHBox(){

        Random rand = new Random();
        //set ups spacing/padding/background colour in the hBox
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15,15,15,15));
        hBox.setStyle("-fx-background-color: black");
        //generate which card to display
        ImageView card1 = new ImageView(new Image("sample/Cards/"+(rand.nextInt(54)+1)+".png"));
        ImageView card2 = new ImageView(new Image("sample/Cards/"+(rand.nextInt(54)+1)+".png"));
        ImageView card3 = new ImageView(new Image("sample/Cards/"+(rand.nextInt(54)+1)+".png"));

        //add the cards to the panel
        hBox.getChildren().add(card1);
        hBox.getChildren().add(card2);
        hBox.getChildren().add(card3);

        return hBox;
    }


}
