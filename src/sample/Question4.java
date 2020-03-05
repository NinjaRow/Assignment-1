//Rowan Birnbaum 100701879
package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;

public class Question4 extends Application {
    //graph setup
    CategoryAxis AxisX = new CategoryAxis();
    NumberAxis AxisY = new NumberAxis();
    BarChart<String,Number> chart = new BarChart<>(AxisX,AxisY);
    public XYChart.Series dataSeries = new XYChart.Series();
    public char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public int count[] = new int[256];

    //function to add number of times each letter occurred to the data set
    public void graph(){
        int x = 97;
        for (int i=0; i<alphabet.length; i++){
            // process ascii array element as numbers of letters within the text file
            dataSeries.getData().add(new XYChart.Data(Character.toString(alphabet[i]), count[x]));
            x++;
        }
    }
    public void start(Stage stage) throws Exception {
        // create the pane
        StackPane bgPane = new StackPane();
        // create button and textfield for file directory
        Button view = new Button("View");
        view.setAlignment(Pos.CENTER);
        TextField dir = new TextField("Enter directory");
        dir.setAlignment(Pos.BOTTOM_CENTER);
        dir.setMaxWidth(200);
        // set axis labels
        AxisX.setLabel("Alphabet");
        AxisY.setLabel("Appearance of letter");

        graph();
        // event handler for button and enter key
        EventHandler<ActionEvent> createGraph = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // reset count array every time button or enter is pushed
                count = new int[256];
                FileInputStream file = null;
                try {
                    // get file directory
                    file = new FileInputStream(dir.getText());
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                }
                // set up a reader function to read strings in text file
                BufferedReader reader = new BufferedReader(new InputStreamReader(file));
                String line = null;
                try {
                    line = reader.readLine();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String line1;
                // loop through each line of the file until there are no more lines
                while (line != null) {
                    // get the length of line for for loops and turn to lower case
                    int len = line.length();
                    line1 = line.toLowerCase();
                    // Initialize count array index
                    for (int i = 0; i < len; i++)
                        count[line1.charAt(i)]++;
                    try {
                        line = reader.readLine();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                graph();
            }
        };
        // when button pressed
        view.setOnAction(createGraph);
        dir.setOnAction(createGraph);
        //add xyzchart to bar-graph
        chart.getData().addAll(dataSeries);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(dir, view, chart);
        // set vbox to pane
        bgPane.getChildren().add(vBox);
        Scene scene = new Scene(bgPane, 850, 850);
        stage.setTitle("Question_4");
        stage.setScene(scene);
        stage.show();
    }
}

