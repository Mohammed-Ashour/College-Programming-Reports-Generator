
	import java.awt.*;
	import java.applet.*;
	public class center extends Applet {
		
	int x=0;
	int i=0;
	Color [] colors={Color.red,Color.green,Color.blue,Color.yellow,Color.pink,Color.cyan,Color.magenta,Color.orange};
		public void paint(Graphics g) {
			
		    g.setColor(Color.white);
		    
			g.drawOval(x,x,40,40);
			
			g.drawOval(400-x,x,40,40);
			
			g.drawOval(x,400-x,40,40);
			
			g.drawOval(400-x,400-x,40,40);
			
			 for(int j=0;j<360;j+=45)
			      {
			      	g.setColor(colors[j/45]);
			      	g.fillArc(x,x,40,40,j-i,45);
			      	g.fillArc(400-x,x,40,40,j-i,45);
			      	g.fillArc(x,400-x,40,40,j-i,45);
			      	g.fillArc(400-x,400-x,40,40,j-i,45);
			      }
			
			x++;
			if(x>=200)
				{ x=0;
			      g.setColor(Color.white);
			      g.drawOval(180,180,70,70);
			      
			      for(int j=0;j<360;j+=45)
			      {
			      	g.setColor(colors[j/45]);
			      	g.fillArc(185,185,70,70,j-i,45);
			     
			      }
			    }
			    i++; 
			    if(i==360) i=0;
			    repaint();
			    try{Thread.sleep(10);}
		   catch(Exception ex){};         
			
		}
	}