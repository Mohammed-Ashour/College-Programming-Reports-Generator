import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class train extends Applet {
	
	public void init() {
	}
     int x=0,i=0;
	public void paint(Graphics g) 
		
	{
		int w =this.getWidth();
		this.setBackground(Color.cyan);
		
		g.setColor(Color.darkGray);
		int []xp={150+x,250+x,250+x,260+x,260+x,300+x,300+x,290+x,290+x,260+x,260+x,250+x,250+x,170+x,170+x,150+x}; // second car
		int []yp={40,40,20,20,40,40,150,150,130,130,150,150,80,80,150,150};
		g.setColor(Color.gray);
		g.fillPolygon(xp,yp,16); // second car  
		
		g.setColor(Color.pink);	
		g.fillOval(170+x,80,80,80); // second car wheels
		g.fillOval(260+x,130,30,30);
		
		g.fillRect(270+x,50,20,20); // window of second car
		
	
		g.fillArc(290+x,50,20,20,270,180); // lamp
		
		g.fillRect(140+x,50,10,10);//connectors
		g.fillRect(140+x,110,10,10);
		 
		g.setColor(Color.darkGray);
		g.fillRect(x,40,140,90); // first car 
		
		g.setColor(Color.pink);
		g.fillOval(10+x,130,30,30); // first car wheels
		g.fillOval(90+x,130,30,30);
		
		g.fillRect(10+x,50,20,20); // window of first car
		g.fillRect(60+x,50,20,20); 
		g.fillRect(110+x,50,20,20);
		 
		 g.setColor(Color.darkGray);
		 for(int j=0;j<=360;j+=90)
		 {
	        g.fillArc(10+x,130,30,30,j-i,20); // first car wheels arcs
		    g.fillArc(90+x,130,30,30,j-i,20);
		    g.fillArc(170+x,80,80,80,j-i,20); // second car wheels
		    g.fillArc(260+x,130,30,30,j-i,20);
		 }
		 g.setColor(Color.gray);
		 g.fillRect(0,160,w,100); // ground;
		 
		 x++; if(x==w) x=0;
		 i++; if(i==360) i=0;
		 
		 repaint(); 
		 try{Thread.sleep(10);}  
		 	catch(Exception ex){};
		
		
	}
}