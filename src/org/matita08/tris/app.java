package org.matita08.tris;

import java.io.IOException;
import java.util.Arrays;

import static org.matita08.tris.Configs.*;

public class app {
   public static boolean turn = false;
   
   public static void main(String[] args) {
      System.err.println("Log");
      System.out.println("Starting...");
      System.out.println(((char)2));
      Arrays.stream(args).forEachOrdered(System.out::println);
      init();
      try {
         mainLoop();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
      System.out.println("\nExited");
   }
   
   public static void mainLoop() throws IOException {
      Memory m = new Memory();
      Out.printScreen(m.getState());
      while(true) {
         Input.read(m, turn? 1 : 2);
         turn = !turn;//throw new RuntimeException("In is not in range: accepted (0,10], provided: " + in);
         Out.printScreen(m.getState());
         if(Checks.hasEnded(m)) {
            if(Checks.won == -1) System.out.print("\n\n\n\n\nLa partita è finita in parità");
            else System.out.print("\n\n\nPlayer " + Checks.won + " has won\nCongratulation!");
            break;
         }
      }
   }
}
