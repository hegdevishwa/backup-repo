package unionfind;

import java.util.Random;
import java.util.Scanner;

public class QuickUnion {

	private int[] id;

	public QuickUnion(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++)
			id[i] = i;
	}

	private int root(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}

	public void union(int p, int q) {
		System.out.println(p + "-" + q);
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}

	public boolean find(int p, int q) {
		return root(p) == root(q);

	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		QuickUnion qu = new QuickUnion(n);
		Random rand = new Random();
		for (int x = 0; x < 1000; x++) {
			qu.union(rand.nextInt(n - 1) + 1, rand.nextInt(n - 1) + 1);
		}

		while (scanner.hasNext()) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			System.out.println(qu.find(x, y));
		}
	}
}
