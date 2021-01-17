package com.kodilla;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Checkers extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CheckerBoard checkerBoard = new CheckerBoard();

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(checkerBoard.makeBoard());
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
