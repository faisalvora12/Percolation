import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation
{

	int [][]grid;
	int N;
	WeightedQuickUnionUF uf;
	//0- Blocked,1-Open,2-Full
	public Percolation(int n){
		N=n;
		grid=new int[N][N];
		uf=new WeightedQuickUnionUF((N*N)+2);
	}
	public void open(int x,int y){
		int row=N-y-1;
		int col=x;
	
		grid[row][col]=1;
		if(y==0)
			uf.union(N*N,xyTo1D(x,y));
		if(y==N-1)
			uf.union((N*N)+1,xyTo1D(x,y));	

		if(isOpen(x+1,y))
			uf.union(xyTo1D(x,y),xyTo1D(x+1,y));


		if(isOpen(x-1,y))
			uf.union(xyTo1D(x,y),xyTo1D(x-1,y));


		if(isOpen(x,y+1))
			uf.union(xyTo1D(x,y),xyTo1D(x,y+1));

		if(isOpen(x,y-1))
			uf.union(xyTo1D(x,y),xyTo1D(x,y-1));


	}

	public boolean isOpen(int x,int y){
		if(x>=0 && x<N && y>=0 && y<N)
		if(grid[N-y-1][x]==1)
			return true; 
			return false;
	}
	public boolean isFull(int x,int y){
		if(x>=0 && x<N && y>=0 && y<N)
		if(uf.connected((N*N)+1,N*x+y))
			return true;
		 return false;
	}
	public boolean percolates(){
		return uf.connected((N*N),(N*N)+1);
	}
	public int xyTo1D(int x,int y)
	{
		return ((x*N)+y);
	}
	public static void main(String args[]){
		int n=StdIn.readInt();
		Percolation P =  new Percolation(n);
		while(!(StdIn.isEmpty()))
		{
			int x=StdIn.readInt();
			int y=StdIn.readInt();
			P.open(x,y);}
		if(P.percolates())
			StdOut.println("Yes");
		else 
			StdOut.println("No");				
	}
}
