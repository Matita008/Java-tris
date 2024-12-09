package org.matita08.tris;

import java.awt.*;

public class Checks {
   /**
    Indica il vincitore:
    -1 se è patta, 0 se non è finita, altrimenti 1||2 in base a chi ha vinto
    */
   public static int won = 0;
   public static boolean occupied = false;
   public static boolean oob = false;
   
   /**
    @param memory il {@link org.matita08.tris.Memory Memory} contenente la partita da valutare
    @return Se è finita o no
    Lo stato lo si legge in {@code won}
    */
   @SuppressWarnings("JavadocReference")
   public static boolean hasEnded(Memory memory) {
      int[][] table = memory.getState();
      boolean empty = false;//se almeno una cella è vuota vero, altrimenti falso -> ritorna che è patta
      int[] colsChk = new int[3];//array per il controllo delle colonne
      won = 0;//resetto la variabile
      for (int i = 0; i < 3; i++) {
         int[] row = table[i];
         switch(i) {
            case 0:
               for (int j = 0; j < 3; j++) {
                  colsChk[j] = row[j];//copio il contenuto della prima riga
                  if(row[j] == 0) empty = true;
               }
               break;
            case 1:
               for (int j = 0; j < 3; j++) {
                  if(colsChk[j] != row[j]) {
                     colsChk[j] = -1;
                     if(row[j] == 0) {
                        empty = true;
                        break;
                     }
                  }
               }
               break;
            case 2:
               for (int j = 0; j < 3; j++) {
                  if(!(colsChk[j] == -1 || colsChk[j] == 0)) {
                     if(colsChk[j] == row[j]) {
                        won = row[j];
                        return true;
                     }
                  }
               }
               break;
         }
         if(row[0] != 0 && row[0] == row[1] && row[1] == row[2]) {
            won = row[0];
            return true;
         }
      }
      if(table[1][1] != 0) {
         if((table[0][0] == table[1][1] && table[1][1] == table[2][2]) || (table[0][2] == table[1][1] && table[1][1] == table[2][0])) {
            won = table[1][1];
            return true;
         }
      }
      if(!empty) {
         won = -1;
         return true;
      }
      return false;
   }
   
   public static boolean isValid(Memory m, int cell) {
      try {
         occupied = m.getCell(cell) != 0;
         oob = !Tools.isBetween(cell, 0, 9);
         return !(occupied || oob);
      } catch (Exception _) {
         oob = true;
         occupied = false;
         return false;
      }
   }
}
