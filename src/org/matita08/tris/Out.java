package org.matita08.tris;

import static org.matita08.tris.Configs.frame;

import javax.swing.*;

public class Out {
   public static void printScreen(int[][] table) {
      System.gc();
      boolean first = true;
      JLabel lb = new JLabel();
      StringBuilder sb = new StringBuilder("\n\nì+\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      for (int[] row: table) {
         if(first) first = false;
         else sb.append("═══╬═══╬═══\n");
         sb.append(printCell(row[0])).append("║").append(printCell(row[1])).append("║").append(printCell(row[2])).append('\n');
      }
      sb.append('\n');
      System.out.print(sb);
      lb.setText(sb.toString());
      JTable t = new JTable(3, 3);
      t.getCellEditor().getTableCellEditorComponent(t, sb.toString(), false, 1, 1);
      frame.add(lb);
      frame.add(t);
   }
   
   public static String printCell(int v) {
      return switch(v) {
         case 0 -> "   ";
         case 1 -> " X ";
         case 2 -> " O ";
         default -> throw new RuntimeException(v + " is invalid");
      };
   }
   
   //just a temp bkp
   @SuppressWarnings("unused")
   public static void oldPrintScreen(int[][] table) {
      System.gc();
      boolean first = true;
      System.out.println("\n\nì+\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      for (int[] row: table) {
         if(first) first = false;
         else System.out.println("\n═══╬═══╬═══");
         System.out.print(printCell(row[0]) + "║" + printCell(row[1]) + "║" + printCell(row[2]));
      }
      System.out.print('\n');
   }
}
