package com.bonbonn.tuya.base;

public class SafeExecutor {

  public static <T> void run(ThrowingSupplier<T> supplier) {
    try {
      supplier.get();
    } catch (Exception e) {
      System.err.println("Fehler: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void runVoid(ThrowingRunnable runnable) {
    try {
      runnable.run();
    } catch (Exception e) {
      System.err.println("Fehler: " + e.getMessage());
      e.printStackTrace();
    }
  }
}