package com.kodilla;

import javafx.scene.image.Image;

public class CheckerPiece {
    private Image image;
    private PieceColor color;

    public CheckerPiece(Image image,PieceColor color){
        this.image = image;
        this.color = color;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }
}
