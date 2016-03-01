package main;

public class HelloWorld {
	int num1;
	int num2;
	static int num3;
	public HelloWorld() {
		num1 = 91;
		System.out.println("通过构造方法为变量num1赋值");
	}
	{
		num2 = 74;
		System.out.println("通过初始化块为变量num2赋值");
	}
	static{
		num3 = 83;
		System.out.println("通过静态初始化块为变量num3赋值");
	}
	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld();
		System.out.println(hello.num1);
		System.out.println(hello.num2);
		System.out.println(num3);
		HelloWorld hello2 = new HelloWorld();
	}
}
