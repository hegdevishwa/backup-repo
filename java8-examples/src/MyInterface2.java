

public interface MyInterface2 extends MyInterface{

	public void foo();
	default int multiply() {
		System.out.println("Multiply in MyInterface2");
		return 1;
	}

}
