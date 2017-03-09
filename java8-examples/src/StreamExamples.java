import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

	public static void main(String args[]) {

		List<String> list = Arrays.asList("apple", "banana", "orange", "pears", "blueberry", "strawberry", "raspberry");

		// find the words starting with b
		List<String> l = list.stream().filter((s) -> s.charAt(0) == 'b').collect(Collectors.toList());
		l.forEach(System.out::println);

		// Count the number of words having word "berry"
		long a = list.stream().filter(s -> s.contains("berry")).collect(Collectors.counting()).longValue();
		System.out.println(a);
		list.stream().map(s -> s.length()).reduce((x, y) -> x + y).ifPresent(System.out::println);

	}

}
