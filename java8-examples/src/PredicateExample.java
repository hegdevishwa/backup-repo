import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {

		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		System.out.println("Languages which starts with J :");
		filter(languages, str -> (str).startsWith("J"));
		System.out.println("Languages which ends with a ");
		filter(languages, str -> (str).endsWith("a"));
		System.out.println("Print all languages :");
		filter(languages, str -> true);
		System.out.println("Print no language : ");
		filter(languages, str -> false);
		System.out.println("Print language whose length greater than 4:");
		filter(languages, str -> (str).length() > 4);

		// List of pairs whose sum is equal to given value.
		BiFunction<Integer, Integer, Integer> b = (x, y) -> (x + y);
		BiPredicate<Integer, Integer> cond = (x, y) -> (x + y) == 22;
		List<Integer> numbers = Arrays.asList(10, 20, 12, 15, 41, 7);
		
		List<String> linet = new ArrayList<>();


		Map<String, String> cMap = new ConcurrentHashMap<>();


		
		// numbers.stream().rereduce(22, (x, y) -> x + y);

		// .reduce((x, y) -> x + y).filter(x -> x == 22).ifPresent();

		// numbers.stream().filter(numbers -> { )

	}

	/*
	 * public static void filter(List<String> names, Predicate<String>
	 * condition) { for (String name : names) { if (condition.test(name)) {
	 * System.out.println(name + " "); } } }
	 */

	public static void filter(List<String> names, Predicate<String> condition) {
		/*
		 * names.stream().filter((name) ->
		 * (condition.test(name))).forEach(System.out::println);
		 */
		names.stream().filter(condition).forEach(System.out::println);

	}

	public static void sum(List<Integer> numbers, Predicate<Integer> condition) {

	}

}
