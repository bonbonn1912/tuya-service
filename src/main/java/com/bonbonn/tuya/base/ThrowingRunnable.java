package com.bonbonn.tuya.base;

@FunctionalInterface
public interface ThrowingRunnable {
  void run() throws Exception;
}