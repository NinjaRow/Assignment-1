//Rowan Birnbaum 100701879

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Question3 extends Application{
    public void start(Stage primaryStage) throws Exception {
        //create a pane
        Pane pane = new Pane();
        pane.setMinSize(300,300);

        //generate large circle
        Circle circle = new Circle(150,150,120);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        //generate the 3 points
        Circle point1 = new Circle(150,30,5);
        point1.setStroke(Color.BLACK);
        point1.setFill(Color.RED);

        Circle point2 = new Circle(30,150,5);
        point2.setStroke(Color.BLACK);
        point2.setFill(Color.RED);

        Circle point3 = new Circle(270,150,5);
        point3.setStroke(Color.BLACK);
        point3.setFill(Color.RED);

        //generate connecting lines
        Line line1 = new Line(150,30,30,150);
        line1.setStroke(Color.GREEN);
        Line line2 = new Line(30,150,270,150);
        line2.setStroke(Color.BLUE);
        Line line3 = new Line(270,150,150,30);
        line3.setStroke(Color.PURPLE);

        //generate angle text
        Text angle1 = new Text(140,50,angle(line2, line1, line3));
        Text angle2 = new Text(20,170,angle(line3, line1, line2));
        Text angle3 = new Text(260,170,angle(line1, line2, line3));

        //add the everything to the panel
        pane.getChildren().add(circle);
        pane.getChildren().add(line1);
        pane.getChildren().add(line2);
        pane.getChildren().add(line3);
        pane.getChildren().add(angle1);
        pane.getChildren().add(angle2);
        pane.getChildren().add(angle3);
        pane.getChildren().add(point1);
        pane.getChildren().add(point2);
        pane.getChildren().add(point3);

        //action events of moving the points
        point1.setOnMouseDragged(e ->{
            double dx = e.getX()-150;
            double dy = e.getY()-150;
            double hyp = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));

            dx=((dx/hyp)*120)+150;
            dy=((dy/hyp)*120)+150;

            point1.setCenterX(dx);
            point1.setCenterY(dy);
            line1.setStartX(dx);
            line1.setStartY(dy);
            line3.setEndX(dx);
            line3.setEndY(dy);
            angle1.setX(dx-10);
            angle1.setY(dy+20);
            angle1.setText(angle(line2, line1, line3));
            angle2.setText(angle(line3, line1, line2));
            angle3.setText(angle(line1, line2, line3));
        });
        point2.setOnMouseDragged(e ->{
            double dx = e.getX()-150;
            double dy = e.getY()-150;
            double hyp = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));

            dx=((dx/hyp)*120)+150;
            dy=((dy/hyp)*120)+150;

            point2.setCenterX(dx);
            point2.setCenterY(dy);
            line2.setStartX(dx);
            line2.setStartY(dy);
            line1.setEndX(dx);
            line1.setEndY(dy);
            angle2.setX(dx-10);
            angle2.setY(dy+20);
            angle1.setText(angle(line2, line1, line3));
            angle2.setText(angle(line3, line1, line2));
            angle3.setText(angle(line1, line2, line3));
        });
        point3.setOnMouseDragged(e ->{
            double dx = e.getX()-150;
            double dy = e.getY()-150;
            double hyp = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));

            dx=((dx/hyp)*120)+150;
            dy=((dy/hyp)*120)+150;

            point3.setCenterX(dx);
            point3.setCenterY(dy);
            line3.setStartX(dx);
            line3.setStartY(dy);
            line2.setEndX(dx);
            line2.setEndY(dy);
            angle3.setX(dx-10);
            angle3.setY(dy+20);
            angle1.setText(angle(line2, line1, line3));
            angle2.setText(angle(line3, line1, line2));
            angle3.setText(angle(line1, line2, line3));
        });

        //display the screen
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question_3");
        primaryStage.show();
    }
    //function to calculate the angle between 2 lines
    public String angle(Line l1, Line l2, Line l3){
        double x1 = l1.getEndX()-l1.getStartX();
        double y1 = l1.getEndY()-l1.getStartY();
        double hyp1 = Math.sqrt(Math.pow(x1,2)+Math.pow(y1,2));

        double x2 = l2.getEndX()-l2.getStartX();
        double y2 = l2.getEndY()-l2.getStartY();
        double hyp2 = Math.sqrt(Math.pow(x2,2)+Math.pow(y2,2));

        double x3 = l3.getEndX()-l3.getStartX();
        double y3 = l3.getEndY()-l3.getStartY();
        double hyp3 = Math.sqrt(Math.pow(x3,2)+Math.pow(y3,2));
        double ans = Math.acos((Math.pow(hyp1,2)-Math.pow(hyp2,2)-Math.pow(hyp3,2))/(-2*hyp2*hyp3));
        ans = Math.toDegrees(ans);
        return String.valueOf(Math.round(ans));
    }
}
