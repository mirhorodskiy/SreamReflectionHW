package com.academy.hw5.reflection;

import com.academy.hw5.reflection.annotations.MethodAnnotation;

public class HelperClass {
  public static final Long SEED = System.currentTimeMillis();
  // TODO: this property should be annotated
  private String property;

  @MethodAnnotation
  private void annotatedMethod() {
  }

  // DO NOT CHANGE THIS!
  private String veryPrivateMessage() {
    return "this is a private message " + SEED;
  }
}
