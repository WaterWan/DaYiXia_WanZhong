package water.eluosifangkuai.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerDisk extends Layer {
	
	

	public LayerDisk(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(Img.DISK, this.x+PANDDING, this.y+PANDDING, null);
	}
}
