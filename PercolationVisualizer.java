//import java.awt.font;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class PercolationVisualizer
{
	public static void Draw(int x,int y,Percolation per, int N)
	{
		if(per.isFull(x,y))
		{
			StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
			StdDraw.filledSquare(x+0.2,y+0.2,0.5);
		}
	}
	public static void main(String args[])
	{
		int N=StdIn.readInt();
		Percolation p=new Percolation(N);

		int x=0,y=0;
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setXscale(0,N);
		StdDraw.setYscale(0,N);

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledSquare(i+0.2,j+0.2,0.5);
			}
		}
		StdDraw.show();	
		while(!(StdIn.isEmpty()))
		{
			x=StdIn.readInt();
			y=StdIn.readInt();
			p.open(x,y);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledSquare(x+0.2,y+0.2,0.5);
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					Draw(i,j,p,N);
				}
			}
			StdDraw.show(500);
		}
	}
}
