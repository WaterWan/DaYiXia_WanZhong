package water.eluosifangkuai.ui.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import water.eluosifangkuai.control.GameControl;
import water.eluosifangkuai.util.FrameUtil;

public class JFrameSavePoint extends JFrame{
	
	private JLabel lbPoint = null;
	private JTextField txName = null;
	
	private JButton btnOk = null;
	private JLabel errMsg = null;
	private GameControl gameControl = null;
	
	public JFrameSavePoint(GameControl gameControl){
		this.gameControl = gameControl;
		this.setTitle("保存记录");
		this.setSize(256, 128);
		FrameUtil.setFrameCenter(this);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.createCom();
		this.createAction();
	}
	
	/**
	 * 显示窗口
	 */
	public void showWindow(int point){
		this.lbPoint.setText("您的得分：" + point);
		this.setVisible(true);
	}
	
	/**
	 * 创建事件监听
	 */
	private void createAction() {
		this.btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 还可以加其他文字验证
				String name = txName.getText();
				if (name.length() > 16 || name == null || "".equals(name)) {
					errMsg.setText("请输入16位以下的名字");
				} else{
					gameControl.savePoint(name);
				}
			}
		});
	}

	/**
	 * 初始化控件
	 */
	private void createCom(){
		// 创建北部面板(流式布局)
		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		// 创建分数标签
		this.lbPoint = new JLabel();
		// 分数标签添加到北部面板
		north.add(this.lbPoint);

		// 创建错误信息控件
		this.errMsg = new JLabel();
		this.errMsg.setForeground(Color.RED);
		// 添加错误信息控件到北部面板
		north.add(this.errMsg);
		// 北部面板添加到主面板
		this.add(north, BorderLayout.NORTH);
		
		// 创建中部面板(流式布局)
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
		// 创建姓名输入框
		this.txName = new JTextField(10);
		// 姓名标签添加到中部面板
		center.add(new JLabel("您的名字："));
		// 姓名输入框添加到中部面板
		center.add(this.txName);
		// 中部面板添加到主面板
		this.add(center, BorderLayout.CENTER);
		
		
		// 创建确定按钮
		this.btnOk = new JButton("确定");
		// 创建南部面板(流式布局)
		JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// 按钮添加到南部面板
		south.add(btnOk);
		// 南部面板添加到主面板
		this.add(south, BorderLayout.SOUTH);

	}
}
