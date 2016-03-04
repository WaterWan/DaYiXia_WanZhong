package mooc;

public class Break {

	public static void main(String[] args) {
		for (int i = 1; i < 3; i++) {
			System.out.println("Íâ²ã:" + i);
			for (int j = 1; j < 100; j++) {
				System.out.println("ÄÚ²ã" + j);
				if (j>5){
					System.out.println("½áÊø");
					break;
				}
			}
		}
	}

}
