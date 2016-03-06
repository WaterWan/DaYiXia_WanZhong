package cn.lili;
/*import package*/	
import java.awt.Container;
import java.awt.Panel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculatorSwing extends JFrame{
	//the size of the window
	static final int WIDTH=250;
	static final int HEIGHT=300;
	//the text in the textfield
	String str="";
	JTextField field=new JTextField(20);//创建field对象
	/*create the window*/
	public void CreateSwing(){					
		JFrame jf =new JFrame();
		jf.setSize(WIDTH,HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("Caculator");
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension  screenSize=kit.getScreenSize();
		//居中显示
		int width=screenSize.width;
		int height=screenSize.height;
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		jf.setLocation(x,y);
		//create the buttons
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		JButton b3=new JButton("3");
		JButton b4=new JButton("4");
		JButton b5=new JButton("5");
		JButton b6=new JButton("6");
		JButton b7=new JButton("7");
		JButton b8=new JButton("8");
		JButton b9=new JButton("9");
		JButton b10=new JButton("0");
		JButton b11=new JButton("+");
		JButton b12=new JButton("-");
		JButton b14=new JButton("*");
		JButton b13=new JButton("=");
		//design the layout
		FlowLayout f1=new FlowLayout(FlowLayout.CENTER,20,10);
		//join the cp into jf
		Container cp1=this.getContentPane();
		jf.add(cp1);
		//create the flow layout
		cp1.setLayout(f1);
		cp1.add(field);//add the textfield
		cp1.add(b1);
		cp1.add(b2);
		cp1.add(b3);
		cp1.add(b4);
		cp1.add(b5);
		cp1.add(b6);
		cp1.add(b7);
		cp1.add(b8);
		cp1.add(b9);
		cp1.add(b10);
		cp1.add(b11);
		cp1.add(b12);
		cp1.add(b14);
		cp1.add(b13);
		//show it on the screen
		jf.setVisible(true);
		//register listeners
		b1.addActionListener(new NumListener());
		b2.addActionListener(new NumListener());
		b3.addActionListener(new NumListener());
		b4.addActionListener(new NumListener());
		b5.addActionListener(new NumListener());
		b6.addActionListener(new NumListener());
		b7.addActionListener(new NumListener());
		b8.addActionListener(new NumListener());
		b9.addActionListener(new NumListener());
		b10.addActionListener(new NumListener());
		b11.addActionListener(new ArithListener());
		b12.addActionListener(new ArithListener());
		b14.addActionListener(new ArithListener());
		b13.addActionListener(new EqualListener());
		}
	
	
	int num,number1,number2;
	boolean test1,test2,test3,test4;
	//inner class:the kinds of the listeners 
	class NumListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			str=e.getActionCommand();
			field.setText(str);//改变field上的数字
			while(!(test1||test2||test3||test4)){//没有按下运算符键
				str=str+"getActionCommand()";//多位数
			field.setText(str);//更新field上的数字
			}
			num=Integer.parseInt(str);//turn string into number;num is the container of the first number
		}
	}
	class ArithListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			number1=num;
			switch(e.getActionCommand()){
			case("+"):
				test1=true;
			str=e.getActionCommand();
				break;
			case("-"):
				test2=true;
			str=e.getActionCommand();
				break;
			case("*"):
				test3=true;
			str=e.getActionCommand();
				break;
			}//switch	
			
		}
	}//close the inner class
	class EqualListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		test4=true;
		number2=num;
		if(test1&&test4){
			plus(number1,number2);//按了+和=
			}
		if(test2&&test4){
			minus(number1,number2);//按了-和=
			}
		if(test3&&test4){
			mutiply(number1,number2);//按了*和=
			}
		}
		//the calculation
		public  int plus(int a,int b){
			int result;
			result=a+b;
			return result;
		}
		public int minus(int a,int b){
			int result;
			result=a-b;
			return result;
		}
		public int mutiply(int a,int b){
			int result;
			result=a*b;
			return result;
		}
	
	
	}//close the inner class


}//close the outer class

