package clown;

import java.awt.*;
import java.applet.*;

public class clown extends Applet {
	int x = 0, i = 0, j = 0;
	boolean motion = false;
	public void paint(Graphics g){
		// ball
		g.setColor(Color.yellow);
		g.fillOval(x, 380, 160, 160);
		g.setColor(Color.red);
		g.fillArc(x, 380, 160, 160, x, 30);
		g.fillArc(x, 380, 160, 160, x + 90, 30);
		g.fillArc(x, 380, 160, 160, x + 180, 30);
		g.fillArc(x, 380, 160, 160, x + 270, 30);
		
		
		
		// back hand
		g.setColor(Color.red);
		int[] x_hand2 = {20 + x, 40 + x, 40 + x - j, 80 + x - j,
						80 + x - j, 40 + x - j, 20 + x - j};
		
		int[] y_hand2 = {160, 160, 190, 190, 210, 210, 190};
		g.setColor(Color.yellow);
		g.fillPolygon(x_hand2, y_hand2, 7);
		
		// body
		int[] x_body = {x, 20 + x, 20 + x, 40 + x, 40 + x, 60 + x, 60 + x, x};
		int[] y_body = {160, 140, 130, 130, 140, 150, 250, 250};
		g.setColor(Color.blue);
		g.fillPolygon(x_body, y_body, 8);
		
		// head
				g.setColor(Color.red);
				g.fillOval(10 + x, 100, 40, 40);
				g.setColor(Color.yellow);
				int[] hat_x = {5 + x, 30 + x, 55 + x};
				int[] hat_y = {105, 30, 105};
				g.fillPolygon(hat_x, hat_y, 3);
				
		// front hand
		int[] x_hand1 = {20 + x, 40 + x, 40 + x + j, 80 + x + j,
				80 + x + j, 40 + x + j, 20 + x + j};
		
		int[] y_hand1 = {160, 160, 190, 190, 210, 210, 190};
		g.setColor(Color.cyan);
		g.fillPolygon(x_hand1, y_hand1, 7);
		
		// back leg
		int[] x_leg2 = {x, 60 + x, 60 + x - j, 80 + x - j, 80 + x - j,
						40 + x - j};
		
		int[] y_leg2 = {250, 250, 360, 360, 380, 380};
		g.setColor(Color.darkGray);
		g.fillPolygon(x_leg2, y_leg2, 6);
		
		// front leg
		int[] x_leg1 = {x, 60 + x, 60 + x + j, 80 + x + j, 80 + x + j,
				40 + x + j};

		int[] y_leg1 = {250, 250, 360, 360, 380, 380};
		g.setColor(Color.magenta);
		g.fillPolygon(x_leg1, y_leg1, 6);
		
		// animation
		if (!motion){
			if (i == 0) j++;
			if (j == 20) i = 1;
			if (i == 1) j--;
			if (j == -20) i = 0;
			x++;
			if (x == this.getWidth()) motion = true;
		} else {
			x = 0;
			x++;
			motion = false;
		}
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException ex) {}
			this.repaint(20);
		

	}
}
