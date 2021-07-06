package com.academy.hw5.streams;

import com.academy.hw5.streams.model.Person;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

public class StreamApiTasks {

  public static int calculateSumOfAllNumbers(List<Integer> numbers) {
    return numbers.stream().reduce(0, Integer::sum);
  }

  //  TODO total number of letters in all the names with more than 5 letters
  public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
    return (int) Arrays.stream(names).map(String::length).filter(length -> length > 5).reduce(0, Integer::sum);
  }

  public static List<String> toUpperCase(List<String> list) {
    return list.stream().map(String::toUpperCase).collect(Collectors.toList());
  }

  public static Integer getMaxValue(List<Integer> numbers) {
    return numbers.stream().mapToInt(x -> x).max().getAsInt();
  }

  public static Set<String> getNames(List<Person> people) {
    return people.stream().map(Person::getName).collect(Collectors.toSet());
  }

  // TODO return name of people with age lesser than 18 years
  public static Set<String> getNamesMinors(List<Person> people) {
    return people.stream().filter(x -> x.getAge() < 18).map(Person::getName).collect(Collectors.toSet());
  }

  //  TODO make map Map<Boolean, List<Person>>.
  //    sort persons by age
  //    collect all adult (age=>18) persons in Map with key 'true'
  //    collect all teens (age<18) persons in Map with key 'true'
  public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
    return people.stream().sorted(Comparator.comparing(Person::getAge))
            .collect(partitioningBy(person -> person.getAge() >= 18));
  }

  //  TODO return single comma separated string from list of strings.
  //    as delimiter, please use comma-with-space ", " not only comma ","
  //    also, please implement this method with streams, not with String.join()
  public static String toCommaSeparatedString(List<String> words) {
    return words.stream().collect(Collectors.joining(", "));
  }

  public static Map<String, List<Person>> groupByCountry(List<Person> people) {
    return people.stream()
            .collect(Collectors.groupingBy(Person::getCountry));
  }
}