package com.example;


public class Player {
   
   public static String redMove = new String("S"), blueMove = new String("S");

   public static String getRedMove() {
      return redMove;
   }

   public static void setRedMove(String move) {
      redMove = move;

   }

   public static String getBlueMove() {
      return blueMove;
   }

   public static void setBlueMove(String move) {
      blueMove = move;
   }
}