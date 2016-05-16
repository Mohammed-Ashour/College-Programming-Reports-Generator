package girl;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class head extends Applet {

		

		public void paint(Graphics g) {
			
			g.fillArc(100,100,80,80,0,180); // hair
			
			g.drawOval(110,110,60,60); // head
			g.setColor(Color.white);
			g.fillOval(110,110,60,60);
			
			g.setColor(Color.black);
			
			g.drawOval(120,120,10,20); // first white eye
		        g.fillOval(120,130,10,10); // first black eye
			
			g.drawOval(150,120,10,20); // second white eye
			g.fillOval(150,130,10,10); // second black eye
			
			g.fillOval(100,140,10,10); // right hair
			g.fillOval(100,150,10,10);
			g.fillOval(100,160,10,10);
		
	                g.fillOval(170,140,10,10); // left hair	
			g.fillOval(170,150,10,10);
			g.fillOval(170,160,10,10);
			
			g.fillArc(130,150,20,20,180,180);

		}
}