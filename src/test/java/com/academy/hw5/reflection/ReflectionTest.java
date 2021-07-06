package com.academy.hw5.reflection;

import com.academy.hw5.reflection.sandbox.ReflectionSandbox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReflectionTest {
  private ReflectionSandbox sandbox;

  @BeforeEach
  void setUp() {
    sandbox = new ReflectionSandbox();
  }

  @Test
  void getClassName() {
    assertEquals("String", sandbox.getSimpleName("aaa"));
    assertEquals("ReflectionSandbox", sandbox.getSimpleName(sandbox));
    assertEquals("Integer", sandbox.getSimpleName(7));
    assertEquals("Float", sandbox.getSimpleName(0.7F));
    assertEquals("Double", sandbox.getSimpleName(0.7D));
    assertEquals("ReflectionTest", sandbox.getSimpleName(this));
  }

  @Test
  void getFullyQualifiedName() {
    assertEquals("java.lang.String", sandbox.getFullyQualifiedName("aaa"));
    assertEquals("com.academy.hw5.reflection.sandbox.ReflectionSandbox", sandbox.getFullyQualifiedName(sandbox));
    assertEquals("java.lang.Integer", sandbox.getFullyQualifiedName(7));
    assertEquals("java.lang.Float", sandbox.getFullyQualifiedName(0.7F));
    assertEquals("java.lang.Double", sandbox.getFullyQualifiedName(0.7D));
    assertEquals("com.academy.hw5.reflection.ReflectionTest", sandbox.getFullyQualifiedName(this));
  }

  @Test
  void getVeryPrivateMessage()
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    assertEquals("this is a private message " + HelperClass.SEED, sandbox.getPrivateMessage());
  }

  @Test
  void testMethodAnnotation() throws NoSuchMethodException {
    assertEquals("custom key value", sandbox.getAnnotatedMethodKey());
  }

  @Test
  void testFieldAnnotation()
      throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException,
      InvocationTargetException {
    assertEquals("aKey:aValue", sandbox.getCustomAnnotationPropertyFromField());
  }
}
