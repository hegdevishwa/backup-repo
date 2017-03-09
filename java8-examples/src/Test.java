import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String binary = Integer.toBinaryString(n);
		System.out.println(binary);
		char[] charArray = new char[binary.length()];
		binary.getChars(0, binary.length() - 1, charArray, 0);
		int counter = 0;
		char previous = '0';
		boolean first = true;
		/*for (char c : charArray) {
			System.out.println("loop");
			if (charArray.length <= 3 && c == '1') {
				counter++;
			} else if (first && c == '1') {
				System.out.println("first");
				counter++;
				previous = c;
				first = false;
			} else if (c == '1' && previous == '0') {
				System.out.println("2");
				counter++;
				previous = c;
			} else {
				previous = c;
			}
		}*/
		for(char c :charArray){
			if(c=='1'){
				counter++;
			}else{
				break;
			}
		}

		System.out.println(counter);

	}
}
