import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;

		T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int a = sc.nextInt(), b = sc.nextInt();

			System.out.println("#" + testCase + " " + a / b + " " + a % b);
		}
	}
}
