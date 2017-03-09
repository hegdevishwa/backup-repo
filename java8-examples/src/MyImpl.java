import java.util.ArrayList;
import java.util.List;

public class MyImpl implements MyInterface, MyInterface2 {

	@Override
	public int add(int a, int b) {
		return 0;
	}

	public static void main(String[] args) {
		MyInterface i = new MyImpl();
		i.multiply();
		List list = new ArrayList();

	}

	@Override
	public void foo() {
		// TODO Auto-generated method stub

	}

	/*
	 * @Override public int multiply() {
	 * System.out.println("Multiply in MyImpl"); // TODO Auto-generated method
	 * stub return 1; }
	 */

}
