package com.bonbonn.tuya.base;

@FunctionalInterface
public interface ThrowingSupplier<T> {
  T get() throws Exception;
}