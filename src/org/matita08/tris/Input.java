package org.matita08.tris;

import static org.matita08.tris.Checks.*;

import java.io.IOException;

public class Input {
   @SuppressWarnings({"ResultOfMethodCallIgnored"})
   public static void read(Memory m, int player) throws IOException {
      int cell;
      boolean first = true;
      do {
         if(!first) {
            System.out.println((oob? "Cella selezionata invalida! deve essere compresa tra 1 e 9 (inclusi)\n" : "") + (occupied? "Cella già selezionata, devi selezionarne una vuota!\n" : "") + "Riprova: ");
         } else first = false;
         int w = 0;
         while(System.in.available() == 0) w++;//System.Out.print('.');
         cell = System.in.read() - '1';
         while(System.in.available() > 0)
            System.in.skip(1);
         System.in.skip(1);
      } while(!Checks.isValid(m, cell));
      m.setCell(cell, player);
   }
}
