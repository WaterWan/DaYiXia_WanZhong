package mooc;

public class Break {

	public static void main(String[] args) {
		for (int i = 1; i < 3; i++) {
			System.out.println("���:" + i);
			for (int j = 1; j < 100; j++) {
				System.out.println("�ڲ�" + j);
				if (j>5){
					System.out.println("����");
					break;
				}
			}
		}
	}

}
