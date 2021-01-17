package com.kodilla;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class CheckerBoard {
    private final Image imageback = new Image("file:src/main/resources/warcaby.png");
    private final Image checkerWhite = new Image("file:src/main/resources/checkerwhite.png");
    private final Image checkerBlack = new Image("file:src/main/resources/checkerblack.png");
    private final Image checkerWhiteQueen = new Image("file:src/main/resources/checkerwhitequeen.png");
    private final Image checkerBlackQueen = new Image("file:src/main/resources/checkerblackqueen.png");
    private BorderPane board = new BorderPane();

    public Scene makeBoard() {
        this.board.setTop(makeFlowPane());

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setPadding(new Insets(0, 0, 0, 0));
        gridPane.setVgap(100);
        gridPane.setHgap(100);


        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        gridPane.setBackground(background);
        gridPane.setGridLinesVisible(true);

        placePieces(gridPane,startingPositions());

        this.board.setBottom(gridPane);

        Scene scene = new Scene(board, 800, 900, Color.DARKGRAY);
        return scene;
    }

    public void placePieces(GridPane gridPane, CheckerPiece[][] boardFields) {
        if (!(boardFields.length == 8 && boardFields[0].length == 8)) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ImageView img = choosePiece(boardFields[i][j]);
                gridPane.add(img, j, i, 2, 2);
            }
        }
    }

    private ImageView choosePiece(CheckerPiece checkerPiece) {
        ImageView image = new ImageView();
        switch (checkerPiece) {
            case EMPTY:
                return new ImageView();
            case WHITE:
                image.setImage(checkerWhite);
                break;
            case WHITE_QUEEN:
                image.setImage(checkerWhiteQueen);
                break;
            case BLACK:
                image.setImage(checkerBlack);
                break;
            case BLACK_QUEEN:
                image.setImage(checkerBlackQueen);
                break;
        }

        return image;
    }

    private FlowPane makeFlowPane() {
        FlowPane flowPane = new FlowPane();

        flowPane.setPrefSize(800,100);

        return flowPane;
    }

    private CheckerPiece[][] startingPositions() {
        CheckerPiece[][] pieces = new CheckerPiece[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i < 3){
                    if((j + i) % 2 == 0){
                        pieces[i][j] = CheckerPiece.BLACK;
                        continue;
                    }
                }

                if(i > 4){
                    if((j + i) % 2 == 0){
                        pieces[i][j] = CheckerPiece.WHITE;
                        continue;
                    }
                }

                pieces[i][j] = CheckerPiece.EMPTY;
            }
        }

        return pieces;
    }
}
