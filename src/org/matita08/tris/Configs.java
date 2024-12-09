package org.matita08.tris;

import javax.swing.*;
import java.awt.*;

public class Configs {
   public static JFrame frame = new JFrame("Tris");
   
   public static void init() {
      frame.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
      frame.setSize(100,100);
      frame.setVisible(true);
   }
}
