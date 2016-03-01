package main;

public class Telphone {
	public static int price = 10000;
	float screen;
	float cpu;
	float mem;
	public Telphone(){
		System.out.println("无参的构造方法执行了！");
	}
	public Telphone(float newScreen, float newCpu, float newMem){
		screen = newScreen < 3.5f ? 3.5f : newScreen;
		cpu = newCpu;
		mem = newMem;
		System.out.println("有参的构造方法执行了");
	}
	
}
