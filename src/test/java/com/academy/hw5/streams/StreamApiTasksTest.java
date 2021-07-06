package com.academy.hw5.streams;

import com.academy.hw5.streams.model.Person;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.academy.hw5.streams.StreamApiTasks.*;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;


class StreamApiTasksTest {

  @Test
  public void calculateShouldSumAllNumbers() {
    List<Integer> numbers = asList(1, 2, 3, 4, 5);
    assertEquals(calculateSumOfAllNumbers(numbers), (1 + 2 + 3 + 4 + 5));
  }

  @Test
  public void calculateShouldSumAllNumbersWithNegative() {
    List<Integer> numbers = asList(0, 1, -1, 99, -64);
    assertEquals(calculateSumOfAllNumbers(numbers), (0 + 1 - 1 + 99 - 64));
  }

  @Test
  public void totalNumberOfLettersOfNamesLongerThanFiveTest() {
//    "Testing if [william, jones, aaron, seppe, frank, gilliam] returns 14"
    assertEquals(getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam", "kiss"), 14);

    assertEquals(getTotalNumberOfLettersOfNamesLongerThanFive("0", "sub", "zero", "scorpion"), 8);

    assertEquals(getTotalNumberOfLettersOfNamesLongerThanFive(), 0);

//    "Testing if [aaron] returns 0"
    assertEquals(getTotalNumberOfLettersOfNamesLongerThanFive("aaron"), 0);
  }

  @Test
  public void upperCase() {
    assertEquals(StreamApiTasks.toUpperCase(List.of("hello", "java", "streams")), List.of("HELLO", "JAVA", "STREAMS"));
  }

  @Test
  public void upperCaseWithSpaces() {
    assertEquals(StreamApiTasks.toUpperCase(List.of("hello world", "kinder surprise", "kill all humans")), List.of("HELLO WORLD", "KINDER SURPRISE", "KILL ALL HUMANS"));
  }

  @Test
  public void upperCaseWithCamelCases() {
    assertEquals(StreamApiTasks.toUpperCase(List.of("hElLo wOrlD", "Kinder SURPRISE", "kill AlL humans")), List.of("HELLO WORLD", "KINDER SURPRISE", "KILL ALL HUMANS"));
  }

  @Test
  public void maxValue() {
    assertEquals(StreamApiTasks.getMaxValue(List.of(5, 6, 2, 0, -1)), 6);
    assertEquals(StreamApiTasks.getMaxValue(List.of(100, 5, 23, 6, -1)), 100);
    assertEquals(StreamApiTasks.getMaxValue(List.of(-333, -4, -22, -70, -996)), -4);
  }

  @Test
  public void getNameShouldReturnNames() {
    Person sara = new Person("Sara", 4);
    Person viktor = new Person("Viktor", 40);
    Person eva = new Person("Eva", 42);
    Person anna = new Person("Anna", 5);
    List<Person> collection = asList(sara, eva, viktor, anna);

    assertEquals(getNames(collection), Set.of("Sara", "Viktor", "Eva", "Anna"));
  }

  @Test
  public void getNameShouldReturnNamesWithNull() {
    List<Person> collection = asList(new Person(null, 999));
    HashSet set = new HashSet();
    set.add(null);
    assertEquals(getNames(collection), set);
  }

  @Test
  public void getKidNameShouldReturnNamesOfAllKidsUnder18() {
    Person sara = new Person("Sara", 4);
    Person viktor = new Person("Viktor", 40);
    Person eva = new Person("Eva", 42);
    Person anna = new Person("Anna", 5);
    List<Person> collection = asList(sara, eva, viktor, anna);

    assertTrue(getNamesMinors(collection).contains("Sara"));
    assertTrue(getNamesMinors(collection).contains("Anna"));
    assertFalse(getNamesMinors(collection).contains("Viktor"));
    assertFalse(getNamesMinors(collection).contains("Eva"));
  }

  @Test
  public void getKidNameShouldReturnNamesOfAllKidsUnder18ComplexTest() {
    Person sara = new Person("Sara", -1);
    Person viktor = new Person("Viktor", 17);
    Person eva = new Person("Eva", 18);
    Person kora = new Person("Kora", 19);
    Person anna = new Person("Anna", 22);
    List<Person> collection = asList(sara, eva, viktor, anna, kora);

    assertTrue(getNamesMinors(collection).contains("Sara"));
    assertTrue(getNamesMinors(collection).contains("Viktor"));
    assertFalse(getNamesMinors(collection).contains("Eva"));
    assertFalse(getNamesMinors(collection).contains("Kora"));
    assertFalse(getNamesMinors(collection).contains("Anna"));
  }

  @Test
  public void partitionAdultsSimpleTest() {
    Person sara = new Person("Sara", 4);
    Person kara = new Person("Kara", 6);
    Person lera = new Person("Lera", 20);
    Person ira = new Person("Ira", 22);
    List<Person> collection = asList(sara, kara, lera, ira);
    Map<Boolean, List<Person>> result = partitionAdults(collection);
    assertEquals(result.get(false), List.of(sara, kara));
    assertEquals(result.get(true), asList(lera, ira));
  }

  @Test
  public void partitionAdultsCheck18YearsOldTest() {
    Person kim = new Person("Kim", 4);
    Person ken = new Person("Ken", 6);
    Person alex = new Person("Alex", 18);
    Person dima = new Person("Dima", 20);
    List<Person> collection = asList(kim, ken, alex, dima);
    Map<Boolean, List<Person>> result = partitionAdults(collection);
    assertEquals(result.get(false), List.of(kim, ken));
    assertEquals(result.get(true), asList(alex, dima));
  }

  @Test
  public void partitionAdultsCheckSortTest() {
    Person sara = new Person("Sara", 4);
    Person viktor = new Person("Viktor", 40);
    Person eva = new Person("Eva", 42);
    List<Person> collection = asList(sara, eva, viktor);
    Map<Boolean, List<Person>> result = partitionAdults(collection);
    assertEquals(result.get(true), asList(viktor, eva));
    assertEquals(result.get(false), singletonList(sara));
  }

  @Test
  public void partitionAdultsCheckNoTeenagersTest() {
    Person kukutsapol = new Person("Kukutsapol", 47);
    Person viktor = new Person("Viktor", 40);
    Person eva = new Person("Eva", 42);
    List<Person> collection = asList(kukutsapol, eva, viktor);
    Map<Boolean, List<Person>> result = partitionAdults(collection);
    assertEquals(result.get(true), asList(viktor, eva, kukutsapol));
    assertTrue(result.get(false) == null || result.get(false).equals(Collections.emptyList()));
  }

  @Test
  public void comaSeparatedStringTest() {
    assertEquals(toCommaSeparatedString(List.of("hello", "java", "streams")), "hello, java, streams");
  }

  @Test
  public void groupByNationalityTest() {
    Person sara = new Person("Sara", 4, "USA");
    Person viktor = new Person("Viktor", 40, "Canada");
    Person eva = new Person("Eva", 42, "USA");
    List<Person> collection = asList(sara, eva, viktor);
    Map<String, List<Person>> result = groupByCountry(collection);

    assertTrue(result.get("USA").contains(sara));
    assertTrue(result.get("USA").contains(eva));
    assertTrue(result.get("Canada").contains(viktor));

  }
}
