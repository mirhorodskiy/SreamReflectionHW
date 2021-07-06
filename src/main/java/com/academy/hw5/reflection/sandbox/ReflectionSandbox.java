package com.academy.hw5.reflection.sandbox;

import com.academy.hw5.reflection.HelperClass;
import com.academy.hw5.reflection.annotations.MethodAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionSandbox {
  private final HelperClass helperClass = new HelperClass();

  // TODO: implement simple class name extraction. This should return: ReflectionSandbox if Object o is instance of ReflectionSandbox.class
  //  And return null if object is null
  public String getSimpleName(Object o) {
    return "";
  }

  // TODO: implement fully qualified name extraction.
  //  This should return com.academy.hw5.reflection.sandbox.ReflectionSandbox
  //  if Object o is instance of ReflectionSandbox.class
  //  And return null if object is null
  public String getFullyQualifiedName(Object o) {
    return "";
  }

  // TODO: return a value called from private method in HelperClass.veryPrivateMessage
  public String getPrivateMessage()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    return "";
  }

  /**
   * TODO: change helper class declared annotations to make this method return string: "custom key value"
   * // !!!! IMPORTANT !!!! : Don't change this method
   **/
  public String getAnnotatedMethodKey() throws NoSuchMethodException {
    Method annotatedMethod = HelperClass.class.getDeclaredMethod("annotatedMethod");
    MethodAnnotation methodAnnotation = annotatedMethod.getAnnotation(MethodAnnotation.class);
    return methodAnnotation.key();
  }

  /**
   * You need to create new annotation with FIELD target and name FieldAnnotation(com.academy.hw5.reflection.annotations package)
   * with 2 custom properties: "key" and "value".
   * Then annotate HelperClass.property with it in a way that will make code below works(and test green).
   * Make sure values of annotation properties are correct(see the test)
   * // !!!! IMPORTANT !!!! : Don't change this method
   */
  public String getCustomAnnotationPropertyFromField()
      throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException,
      InvocationTargetException {
    Field property = helperClass.getClass().getDeclaredField("property");
    Annotation[] annotations = property.getAnnotations();
    for (Annotation annotation : annotations) {
      Class<? extends Annotation> annotationClass = annotation.annotationType();
      if ("FieldAnnotation".equals(annotationClass.getSimpleName())) {
        Method keyMethod = annotationClass.getDeclaredMethod("key");
        Method valueMethod = annotationClass.getDeclaredMethod("value");

        String key = (String) keyMethod.invoke(annotation);
        String value = (String) valueMethod.invoke(annotation);

        return String.format("%s:%s", key, value);
      }
    }
    throw new RuntimeException("Not implemented. Read instructions carefully");
  }

}
