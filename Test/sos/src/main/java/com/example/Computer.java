package com.example;

import java.util.List;
import java.util.Random;
import javafx.scene.input.MouseButton;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;

public class Computer {

   public String move;
   public Boolean side;

   public void makeMove() {
      Square choice = chooseSquare();
      Bounds bounds = choice.getBoundsInLocal();
      Bounds sceneCoord = choice.localToScene(bounds);

      moveChoice();
      Player.setBlueMove(move);
      
      choice.fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED, sceneCoord.getMinX(), sceneCoord.getMinY(), 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, true, false, false, true, true, true, null));
   }

   Square chooseSquare() {
      List children = PrimaryController.boardSpaces.get(0).getParent().getChildrenUnmodifiable();
      List<Square> squares = children;
      Random rand = new Random();

      if(squares.size() == PrimaryController.boardSpaces.size()) {
         int x = rand.nextInt(PrimaryController.boardSpaces.size());
         return PrimaryController.boardSpaces.get(x);
      }

      return PrimaryController.boardSpaces.get(0);
   }

   void moveChoice() {

      Square choose = chooseSquare();
      Bounds bounds = choose.getBoundsInLocal();
      Bounds sceneCoord = choose.localToParent(bounds);
      chooseSquare();

      Random rand = new Random();
      int x = rand.nextInt(2);
      if (x == 0) {
         this.move = "S";
      }
      else if (x == 1) {
         this.move = "O";
      }

      if(!side) {
         PrimaryController.playerTurn.equals("B");
      }
      else if(side) {
         PrimaryController.playerTurn.equals("R");
      }
      choose.fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED, sceneCoord.getMinX(), sceneCoord.getMinY(), 0, 0, MouseButton.PRIMARY, 1, false, false, false, false, true, false, false, true, true, true, null));

   }

}