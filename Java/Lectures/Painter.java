package shalgalt;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Painter extends JFrame{

	private int pointCount=0;
	
	//array of 1000 java.awt.Point references
	private Point points[]=new Point[1000];
	
	//set up GUI and register mouse event handler
	public Painter() 
	{
		super("A simple paint program");
		
		//create a label and place it in SOUTH of BorderLayout
		getContentPane().add(new Label("Drag the mouse to draw"),BorderLayout.SOUTH);
		
		addMouseMotionListener(new MouseMotionAdapter() 
                    {//anonymouse inner class
			public void mouseDragged(MouseEvent event)
                            {
				if(pointCount<points.length){
					points[pointCount]=event.getPoint();
							++pointCount;
							repaint();
				}
                            }
							}//end anonymouse inner class
		);//end call to addMouseMotionListener
		
		setSize(300,150);
		setVisible(true);
	}//end Painter constructor
	//draw oval in a 4-by-4 bounding box at specified location on window
	public void paint(Graphics g)
	{
		super.paint(g);//clears drawing area
		for (int i = 0; i < points.length&&points[i]!=null; i++) 
			g.fillOval(points[i].x, points[i].y, 4,4);
	}
	public static void main(String[] args) {
		Painter application=new Painter();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}//end class Painter