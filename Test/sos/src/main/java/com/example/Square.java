package com.example;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;


public class Square extends StackPane {

   private PrimaryController controller;

   public Square(int x, int y) {
      
      setStyle("-fx-border-color: white; -fx-background-color: lightgrey;");
      setId(String.valueOf(x)+"," +String.valueOf(y));
      this.setPrefSize(1750, 1750);
      this.setOnMouseClicked(e -> handleMouseClick());
      PrimaryController.boardSpaces.add(this);
   }

   private void handleMouseClick() {
      PrimaryController.makeMove(this);
   }

   public static void drawLine(Square currSq, Square i, Square j, String direction) {
      switch(direction) {
         case "vertical":
            Line vertLine1 = new Line((currSq.getWidth() / 2), 5.0f, (currSq.getWidth() / 2), currSq.getWidth());
            currSq.getChildren().add(vertLine1);
            Line vertLine2 = new Line((currSq.getWidth() / 2), 5.0f, (currSq.getWidth() / 2), currSq.getWidth());
            i.getChildren().add(vertLine2);
            Line vertLine3 = new Line((currSq.getWidth() / 2), 5.0f, (currSq.getWidth() / 2), currSq.getWidth());
            j.getChildren().add(vertLine3);
            break;

         case "horizontal":
            Line horizLine1 = new Line(5.0f, (currSq.getHeight() / 2), currSq.getWidth(), (currSq.getHeight() / 2));
            currSq.getChildren().add(horizLine1);
            Line horizLine2 = new Line(5.0f, (currSq.getHeight() / 2), currSq.getWidth(), (currSq.getHeight() / 2));
            i.getChildren().add(horizLine2);
            Line horizLine3 = new Line(5.0f, (currSq.getHeight() / 2), currSq.getWidth(), (currSq.getHeight() / 2));
            j.getChildren().add(horizLine3);
            break;
         
         case "diagForward":
            Line diagForw1 = new Line(currSq.getWidth(), 5.0f, 5.0f, currSq.getHeight());
            currSq.getChildren().add(diagForw1);
            Line diagForw2 = new Line(currSq.getWidth(), 5.0f, 5.0f, currSq.getHeight());
            i.getChildren().add(diagForw2);
            Line diagForw3 = new Line(currSq.getWidth(), 5.0f, 5.0f, currSq.getHeight());
            j.getChildren().add(diagForw3);
            break;

         case "diagBack":
            Line diagBack1 = new Line(5.0f, 5.0f, (currSq.getWidth()), (currSq.getHeight() - 20));
            currSq.getChildren().add(diagBack1);
            Line diagBack2 = new Line(5.0f, 5.0f, currSq.getWidth(), currSq.getHeight());
            i.getChildren().add(diagBack2);
            Line diagBack3 = new Line(5.0f, 5.0f, currSq.getWidth(), currSq.getHeight());
            j.getChildren().add(diagBack3);
            break;
   
      }
   
   }


}