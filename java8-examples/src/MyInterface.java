
@FunctionalInterface
public interface MyInterface {

	public int add(int a, int b);

	default int multiply() {
		System.out.println("Multiply in MyIntefrace1");
		return 1;
	}

}
