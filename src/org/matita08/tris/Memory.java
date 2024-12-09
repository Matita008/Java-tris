package org.matita08.tris;

import java.util.*;

public class Memory {
   private final int[][] mem;
   
   public Memory() {
      mem = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
   }
   
   public Memory(int[][] prev) {
      mem = prev;
   }
   
   public int[][] getState() {
      return mem;
   }
   
   public int getCell(int index) {
      Tools.between(index, 0, 8, "Invalid cell selected");
      return mem[index / 3][index % 3];
   }
   
   public void setCell(int index, int player) {
      Tools.between(index, 0, 9, "Invalid cell selected");
      Tools.between(player, 1, 2);
      mem[index / 3][index % 3]=player;
   }
   
   @Override
   public boolean equals(Object o) {
      if(this == o) return true;
      if(!(o instanceof Memory memory)) return false;
      return Objects.deepEquals(mem, memory.mem);
   }
   
   @Override
   public int hashCode() {
      return Arrays.deepHashCode(mem);
   }
   
   @Override
   public String toString() {
      return "Memory{" +
          "mem=" + Arrays.toString(mem) +
          '}';
   }
}
