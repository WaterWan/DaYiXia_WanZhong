package main;

public class InitailTelphone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telphone phone = new Telphone();
		Telphone phone2 =new Telphone(1.5f, 1.4f, 2.0f);
		System.out.println(phone2.screen);
		System.out.println(Telphone.price);
	}

}
