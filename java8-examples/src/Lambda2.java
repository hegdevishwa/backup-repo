import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Lambda2 {

	public static void main(String[] args) {
		User u1 = new User("Vishwa", 10);
		User u2 = new User("Dhru", 20);

		Comparator<User> compareByAge = (user1, user2) -> user1.age - user2.age;

		Consumer<User> printUser = u -> {
			System.out.print(u.getName());
			System.out.print(" " + u.getAge());
			System.out.println();
		};

		List<User> user = new ArrayList<>();
		user.add(u1);
		user.add(u2);

		user.sort(compareByAge);
		user.forEach(u -> {
			System.out.print(u.getName());
			System.out.print(" " + u.getAge());
			System.out.println();
		});

		// Passing methiod reference
		user.forEach(System.out::println);

		Collections.sort(user, (user1, user2) -> u1.name.compareTo(u2.name));
		// Passing method reference
		user.forEach(printUser);

	}

}

class User {

	String name;
	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	User(String a, int age) {
		name = a;
		this.age = age;

	}
}