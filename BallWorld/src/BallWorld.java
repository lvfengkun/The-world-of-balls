import javax.swing.*;
import java.awt.*;
public class BallWorld extends Frame 
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		BallWorld world=new BallWorld (Color.red);
		world.show();
	}
	private static final int FrameWidth=600;
	private static final int FrameHeight=400;
	private Ball [] ballArray;
	private static final int BallArraySize=6;
	private int counter =0;
	private BallWorld(Color ballColor) 
	{
		setSize(FrameWidth,FrameHeight);
		setTitle("Ball World");
		ballArray=new Ball[BallArraySize];
		for(int i=0;i<BallArraySize;i++)
		{
			ballArray[i]=new Ball(50,30,10);
			ballArray[i].setColor(ballColor);
			ballArray[i].setMotion(3.0+i, 6.0-i);
		}
	}
	public void paint (Graphics g)
	{
		for(int i=0;i<BallArraySize;i++)
		{
			ballArray[i].paint(g);
			ballArray[i].move();
		
		try {
			Thread.currentThread();
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if((ballArray[i].x()<0)||(ballArray[i].x()>FrameWidth)) 
			ballArray[i].setMotion(-ballArray[i].xMotion(),ballArray[i].yMotion());
		if((ballArray[i].y()<0)||(ballArray[i].y()>FrameWidth))
			ballArray[i].setMotion(ballArray[i].xMotion(),-ballArray[i].yMotion());
		/*if(counter>1000)
		{
			for(int j=0;j<BallArraySize;j++)
			{
				if(ballArray[i].x()==ballArray[j].x()&&ballArray[i].y()==ballArray[j].y())
				{
					ballArray[i].setMotion(-ballArray[i].xMotion(),ballArray[i].yMotion());
				}
			}
		}*/
		counter=counter+1;
		if(counter<200000) repaint();
		else System.exit(0);
		}
		
	}
}
