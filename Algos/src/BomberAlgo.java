import java.util.Scanner;

public class BomberAlgo {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		char[] in = input.toCharArray();

		boolean same;
		int startindex;
		int endindex = 0;
		int i = 0;
		int j = 0;
		for (; i < in.length; i++) {
			startindex = i;
			System.out.println("i loop");
			for (j = i + 1; j < in.length; j++) {
				System.out.println("j loop");
				if (in[i] == in[j]) {
					System.out.println("true");
					endindex = j;
				} else {
					System.out.println("break");
					break;
				}
			}
			System.out.println(startindex + " " + endindex);
			for (int k = startindex; endindex > 0 && k <= endindex; k++) {
				System.out.println("K Loop");
				in[k] = ' ';
			}
			i = endindex;
			endindex = 0;
		}
		for (int x = 0; x < in.length; x++) {
			System.out.println(in[x]);
		}
		String ans = String.valueOf(in);
		System.out.println("Hi");
		System.out.println(ans);

	}

}
