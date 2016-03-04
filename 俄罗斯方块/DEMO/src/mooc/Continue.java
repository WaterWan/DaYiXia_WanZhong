package mooc;

public class Continue {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i <= 50; i++) {
			if (i%2 == 1) {
				continue;
			}
			sum += i;
		}
		System.out.println(sum);
	}

}
