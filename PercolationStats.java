import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class PercolationStats
{
	int count;
	static double meanValue;
	static double stdValue;
	static double meanTime;
	static double stdTime;
	public PercolationStats(int N,int T,String speed){
		//	StdOut.println("Outn\n");
		this.meanValue=0.0;
		stdValue=0.0;
		meanTime=0.0;
		stdTime=0.0;
		double[] nums=new double[T];
		count=0;
		double[] times=new double[T];
		Stopwatch eachTime;
		Percolation perF;
		PercolationQuickFind perS;

		/**/
		for(int t=0;t<T;t++)
		{
			count=0;
			perF=new Percolation(N);
			perS=new PercolationQuickFind(N);
			eachTime = new Stopwatch(); 
			if(speed.equalsIgnoreCase("fast"))
			{
				while(!(perF.percolates()))
				{
					//			StdOut.println("/nHI/n");
					int coordinate1=(int)StdRandom.uniform(0,N);
					int coordinate2=(int)StdRandom.uniform(0,N);
					//StdOut.println("row: "+coordinate1+" col: "+coordinate2);	
					if(!perF.isOpen(coordinate1,coordinate2))
					{
						perF.open(coordinate1,coordinate2);
						count++;			
					}
					
					
				}
				
					nums[t]=(count+0.0)/(N*N);
					
					times[t]=eachTime.elapsedTime();
			}
			if(speed.equalsIgnoreCase("slow"))
			{
				while(!(perS.percolates()))
				{
					int coordinate1=(int)StdRandom.uniform(0,N);
					int coordinate2=(int)StdRandom.uniform(0,N);
					if(!perS.isOpen(coordinate1,coordinate2))
					{
						//StdOut.printf("test\n"); 
						perS.open(coordinate1,coordinate2);
						count++;
					}
				}
				nums[t]=(count+0.0)/(N*N);
			//	StdOut.println(count+"\n");
				times[t]=eachTime.elapsedTime();
				//StdOut.printf("Time(s): %f\n", times[t]);
			}
		}
		this.meanValue=StdStats.mean(nums,0,T-1);
		stdValue=StdStats.stddev(nums);
		meanTime=StdStats.mean(times,0,T-1);
		stdTime=StdStats.stddev(times);			
	}


	public static void main(String args[])
	{
		int N=Integer.parseInt(args[0]);
		int T=Integer.parseInt(args[1]);
		String type=args[2];

		Stopwatch tim=new Stopwatch();
		PercolationStats ps=new PercolationStats(N,T,type);
		double time=tim.elapsedTime();


		StdOut.println("mean threshold="+ ps.meanValue);
		StdOut.println("std dev="+ ps.stdValue);
		StdOut.println("time="+ time);
		StdOut.println("mean time="+ ps.meanTime);
		StdOut.println("stddev time="+ ps.stdTime);
	}
}
