package com.academy.hw5.streams;

import com.academy.hw5.streams.model.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StreamApiTasks {

  public static int calculateSumOfAllNumbers(List<Integer> numbers) {
    return 0;
  }

  //  TODO total number of letters in all the names with more than 5 letters
  public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
    return 0;
  }

  public static List<String> toUpperCase(List<String> list) {
    return null;
  }

  public static Integer getMaxValue(List<Integer> numbers) {
    return null;
  }

  public static Set<String> getNames(List<Person> people) {
    return null;
  }

  // TODO return name of people with age lesser than 18 years
  public static Set<String> getNamesMinors(List<Person> people) {
    return null;
  }

  //  TODO make map Map<Boolean, List<Person>>.
  //    sort persons by age
  //    collect all adult (age=>18) persons in Map with key 'true'
  //    collect all teens (age<18) persons in Map with key 'true'
  public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
    return null;
  }

  //  TODO return single comma separated string from list of strings.
  //    as delimiter, please use comma-with-space ", " not only comma ","
  //    also, please implement this method with streams, not with String.join()
  public static String toCommaSeparatedString(List<String> words) {
    return null;
  }

  public static Map<String, List<Person>> groupByCountry(List<Person> people) {
    return null;
  }
}
