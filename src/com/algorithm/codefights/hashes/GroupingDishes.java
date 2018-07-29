package com.algorithm.codefights.hashes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GroupingDishes {

	String[][] groupingDishes(String[][] dishes) {

		Map<String, List<String>> groupingDish = new HashMap<String, List<String>>();

		for (int i = 0; i < dishes.length; i++) {

			for (int j = 1; j < dishes[i].length; j++) {

				groupingDish.put(dishes[i][j], groupingDish.getOrDefault(dishes[i][j], new ArrayList<String>()));
				List<String> dirtyDish = groupingDish.getOrDefault(dishes[i][j], new ArrayList<String>());
				dirtyDish.add(dishes[i][0]);
			}
		}

		groupingDish = groupingDish.entrySet().stream().filter(entry -> {
			return entry.getValue().size() > 1;
		}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
		;

		dishes = new String[groupingDish.size()][];
		int j = 0;
		
		
		Set<Map.Entry<String, List<String>>> dishIngredientEntrySet = new TreeSet<>((entry1,entry2)->{return entry1.getKey().compareTo(entry2.getKey());});
                                                                                
		dishIngredientEntrySet.addAll(groupingDish.entrySet());
		
		for (Map.Entry<String, List<String>> dish : dishIngredientEntrySet) {

			String ingredient = dish.getKey();
			dishes[j] = new String[dish.getValue().size() + 1];
			dishes[j][0] = ingredient;

			int i = 1;
			Collections.sort(dish.getValue());
			for (String d : dish.getValue()) {
				dishes[j][i++] = d;
			}
			j++;
		}

		return dishes;
	}

	public static void main(String[] args) {

		GroupingDishes dish = new GroupingDishes();
		dish.groupingDishes(new String[][] { { "Salad", "Tomato", "Cucumber", "Salad", "Sauce" },
				{ "Pizza", "Tomato", "Sausage", "Sauce", "Dough" }, { "Quesadilla", "Chicken", "Cheese", "Sauce" },
				{ "Sandwich", "Salad", "Bread", "Tomato", "Cheese" } });

	}
}
