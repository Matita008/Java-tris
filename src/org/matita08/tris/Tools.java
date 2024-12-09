package org.matita08.tris;

public class Tools {
   
   public static void between(int n, int start, int end, String message) {
      if(n < start || n > end) throw new OutOfBoundException(message + " expected: (" + start + "," + end + ") but got: " + n);
   }
   
   public static boolean isBetween(int n, int start, int end) {
      return !(n < start || n > end);
   }
   
   public static void between(int n, int start, int end) {
      if(n < start || n > end) throw new OutOfBoundException();
   }
   
   static class OutOfBoundException extends RuntimeException {
      OutOfBoundException() {
         super();
      }
      
      OutOfBoundException(String message) {
         super(message);
      }
   }
}
