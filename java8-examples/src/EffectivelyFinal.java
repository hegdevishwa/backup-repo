
public class EffectivelyFinal {

	public static void main(String args[]) {
		 String nonFinal = "I am non final local variable";
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Using non-final local variable inside anonymous class in Java");
				System.out.println("Value of non-final variable is : " + nonFinal);
			}
		};

		Thread t = new Thread(r);
		t.start();

		class abc {
			public void def() {
				System.out.println(nonFinal);

			}
		}
	}


}
