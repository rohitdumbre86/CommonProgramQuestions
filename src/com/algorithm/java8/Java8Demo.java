package com.algorithm.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Demo {

	public static void main(String[] args) {
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("a", "apple");
		maps.put("b", "bobcat");
		maps.put("d", "donkey");
		maps.put("c", "cat");

		maps = maps.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		maps.entrySet().stream().sorted((k1, k2) -> {
			return k1.getValue().compareTo(k2.getValue());
		}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		Map<String, List<Integer>> stringByValues = new HashMap<String, List<Integer>>();
		stringByValues.put("a", List.of(1, 4, 2, 13, 2, 13, 23, 32, 21, 32));
		stringByValues.put("b", List.of(11, 44, 2, 13, 25, 13, 231, 32, 23, 32));
		stringByValues.put("d", List.of(31, 4, 2, 13, 12, 13, 213, 32, 21, 32));

		stringByValues.entrySet().stream().forEach(entry -> Collections.sort(entry.getValue()));
		
		stringByValues.entrySet().stream().forEach(entry-> entry.getValue().stream().forEach(System.out::print));
		
	      Map<String,List<String>> mapOfListOfStrings = new HashMap<String,List<String>>();
	      mapOfListOfStrings.entrySet().stream().filter( kv -> {return kv.getValue().size() > 1 && kv.getValue().contains("Laurel");})
	      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


	}
}
