package mooc;

public class Plus {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i <= 50; i = i + 2) {
			sum += i;
		}
		System.out.println(sum);
	}
}
