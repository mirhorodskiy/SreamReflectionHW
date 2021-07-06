package com.academy.hw5.streams.model;

import java.util.Objects;

public class Person {
  private String name;
  private int age;
  private String country;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Person(String name, int age, String country) {
    this.name = name;
    this.age = age;
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age && Objects.equals(name, person.name) && Objects.equals(country, person.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, country);
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", country=" + country +
        '}';
  }
}
