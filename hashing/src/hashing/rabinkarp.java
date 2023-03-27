package hashing;

import java.util.Scanner;

public class rabinkarp {
	static void Search(String t, String p) {
		int n = p.length();
		double h = hash(p);
		for (int i = 0; i < t.length(); i++) {
			if (i + n <= t.length()) {
				if (hash(t.substring(i, i + n)) != h) {
				continue;
				} else {
				if (t.substring(i, i + n).equals(p)) {
				System.out.println("Pattern found at index "
				+ i);
				} else
				continue;
				}
				}
				}
				}
	public static void main(String args[]) {
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the text : ");
		String txt = S.nextLine();
		System.out.println("Enter the pattern : ");
		Search(txt, S.nextLine());
		S.close();
		}
		static double hash(String S) {
		double h = 0;
		int n = S.length();
		for (int i = 0; i < n; i++) {
		char c = S.charAt(i);
		h = h + (((int) c - 96) * Math.pow(10, n - 1 - i));
		}
		return h;
		}
}
