import Builders.ButtonBuilder;
import Builders.CellBuilder;
import Calculator.Calculator;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.HashMap;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("The Calculator");
        ButtonBuilder buttonBuilder = new ButtonBuilder();
        CellBuilder cellBuilder = new CellBuilder();

        @SuppressWarnings("unchecked")
        ArrayList<Button> numericButtons = buttonBuilder.getNumericButtons(0,9);
        HashMap<String, Button> operators = buttonBuilder.getOperators();
        Calculator calculator = new Calculator();
        final boolean[] operatorUsed = {false};


        GridPane rootNode = new GridPane();
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 350);


        Label display = new Label("");
        display.setMinWidth(190);
        display.setAlignment(Pos.CENTER);


        // Setting the size of the zero button
        numericButtons.get(0).setMinSize(90, 40);


        Button comma = new Button(".");
        comma.setMinSize(40,40);
        numericButtons.add(comma);


        HBox rowOne = cellBuilder.getButtonRow(numericButtons, 1, 3);
        HBox rowTwo = cellBuilder.getButtonRow(numericButtons, 4, 6);
        HBox rowThree = cellBuilder.getButtonRow(numericButtons, 7, 9);
        HBox rowFour = new HBox(10);
        HBox rowFive = new HBox(10);


        rowFour.getChildren().addAll(numericButtons.get(0), comma);


        Button clear = new Button("Clear");
        clear.setMinSize(90, 40);

        Button equal = new Button("=");
        equal.setMinSize(90,40);

        rowFive.getChildren().addAll(clear, equal);


        VBox numerics = new VBox();
        numerics.setTranslateY(30);
        numerics.setSpacing(10);
        numerics.getChildren().addAll(rowOne, rowTwo, rowThree, rowFour, rowFive);


        VBox disp = new VBox();
        disp.getChildren().addAll(display);


        VBox operatorBox;
        operatorBox = cellBuilder.getButtonColumn(operators.values());
        operatorBox.setTranslateY(30);
        operatorBox.setTranslateX(150);



        numericButtons.stream().forEach(button ->
                button.setOnMouseClicked(event -> {
                    if (operatorUsed[0]) {
                        display.setText("");
                        operatorUsed[0] = false;
                    }
                    display.setText( display.getText() + button.getText() );
                    })

        );


        operators.get("+").setOnMouseClicked(ae -> {
                calculator.add(display.getText());
                operatorUsed[0] = true;
            }
        );


        operators.get("-").setOnMouseClicked(ae -> {
            calculator.sub(display.getText());
            operatorUsed[0] = true;
        });


        operators.get("*").setOnMouseClicked(ae -> {
            calculator.mult(display.getText());
            operatorUsed[0] = true;
        });


        operators.get("/").setOnMouseClicked(ae -> {
            calculator.div(display.getText());
            operatorUsed[0] = true;
        });


        // Returning the result to the screen
        equal.setOnMouseClicked(ae ->
                display.setText(calculator.equal( display.getText() ) )
        );


        clear.setOnMouseClicked(ae -> {
            display.setText("");
            calculator.clear();

        });


        rootNode.getChildren().addAll(disp, numerics, operatorBox);

        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}


