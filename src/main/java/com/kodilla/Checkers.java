package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Checkers extends Application {

    private Image imageback = new Image("file:src/main/resources/warcaby.png");
    private Image checkerWhite = new Image("file:src/main/resources/checkerwhite.png");
    private Image checkerBlack = new Image("file:src/main/resources/checkerblack.png");
    private FlowPane checkers = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(12.5, 0, 0, 12.5));
        grid.setHgap(125);
        grid.setVgap(125);
        grid.setBackground(background);

        ImageView checkerWhiteImage = new ImageView(checkerWhite);
        ImageView checkerBlackImage = new ImageView(checkerBlack);
        checkers.getChildren().add(checkerWhiteImage);
        checkers.getChildren().add(checkerBlackImage);
        checkers.setHgap(25);
        checkers.setVgap(25);

        grid.add(checkers,0,0,3,1);

        Scene scene = new Scene(grid, 1000, 1000, Color.BLACK);

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
