import java.util.*;

public class banker {
	static int[][] claim, alloc;
	static int[] res,avail;
	static ArrayList<Integer> seq1 = new ArrayList<>();
	public static void main(String[] args) 
	{
		int i,j;
		try
		{
			System.out.print("Enter no of processes & no of resources:");
			Scanner sc=new Scanner(System.in);
			int np= sc.nextInt();
			int nr= sc.nextInt();			
			System.out.println("Enter Claim matrix:"); 
			int [][] claim=new int[np][nr];
			for(i=0;i<np;i++)
			{
				for(j=0;j<nr;j++)
				{
					int input=Integer.parseInt(sc.next());
					claim[i][j]=input;			
					
				}
			}
			System.out.print("Claim matrix:");
			for(i=0;i<np;i++)
			{
				System.out.println(" ");
				for(j=0;j<nr;j++)
				{
					System.out.print(" "+claim[i][j]);			
				
				}
			}
			System.out.println("\nEnter Allocation matrix:");
			int [][] alloc=new int[np][nr];
			for(i=0;i<np;i++)
			{
				for(j=0;j<nr;j++)
				{
					alloc[i][j]=sc.nextInt();				
				}
			}
			System.out.print("\nAllocation matrix:");
			for(i=0;i<np;i++)
			{
				System.out.println(" ");
				for(j=0;j<nr;j++)
				{
					System.out.print(" "+alloc[i][j]);				
				}
			}						
			System.out.print("\nEnter resource vector:");
			int[] res= new int[nr];
			for(i=0;i<nr;i++)
				res[i]=sc.nextInt();
			
			System.out.print("Resource Vector:");			
			for(i=0;i<nr;i++)
				System.out.print(" "+res[i]);			
			
			int [] avail =new int[nr];
			for(i=0;i<nr;i++)
				avail[i]=res[i];
			System.out.print("\nAvailable resources at beggining:");
			
			for(i=0;i<nr;i++)
				System.out.print(" "+avail[i]);
			System.out.print("\nAvailable resources after allocation:");
			for(i=0;i<nr;i++)
			{				
				for(j=0;j<np;j++)
				{					
					avail[i]=avail[i]-alloc[j][i];				
				}
			}
			for(i=0;i<nr;i++)
				System.out.print(" "+avail[i]);
			safe_sequence(claim,alloc,avail,np,nr);
			System.out.print("\nClaim matrix:");
			for(i=0;i<np;i++)
			{
				System.out.println(" ");
				for(j=0;j<nr;j++)
				{
					System.out.print(" "+claim[i][j]);				
				}
			}			
			System.out.print("\nAllocation matrix:");
			for(i=0;i<np;i++)
			{
				System.out.println(" ");
				for(j=0;j<nr;j++)
				{
					System.out.print(" "+alloc[i][j]);				
				}
			}			
			System.out.print("\nSafe sequence of execution:");
			System.out.println(seq1);			
		}catch(Exception e)
		{
			
		}
	}
	static int execute(int claim[],int alloc[],int avail[],int nr)
	{
		int i;
		for(i=0;i<nr;i++)
		{
			if((claim[i]-alloc[i])>avail[i])
				return 0;			
		}
		for(i=0;i<nr;i++)
		{
			avail[i]=avail[i]+alloc[i];
			claim[i]=alloc[i]=0;
			
		}
		
		return 1;
	}
	
	static void safe_sequence(int claim[][],int alloc[][],int avail[],int np,int nr)
	{
		int[] visited=new int[10];
		int i,count=0,flag;
		for(i=0;i<np;i++)
			visited[i]=0;
		for(;count<np;)
		{
			for(i=0;i<np;i++)
			{
				if(visited[i]==0 && execute(claim[i],alloc[i],avail,nr)==1)
				{					
					count++;
					visited[i]=1;
					System.out.println("\nNext Process="+i);
					//seq(i,np);
					seq1.add(i+1);
					System.out.println("Available Resources:");
					for(int t=0;t<nr;t++)
						System.out.print(" "+avail[t]);					
					System.out.print("\nClaim matrix:");
					for(int j=0;j<np;j++)
					{
						System.out.println(" ");
						for(int k=0;k<nr;k++)
						{
							System.out.print(" "+claim[j][k]);				
						}
					}			
					System.out.print("\nAllocation matrix:");
					for(int k=0;k<np;k++)
					{
						System.out.println(" ");
						for(int j=0;j<nr;j++)
						{
							System.out.print(" "+alloc[k][j]);				
						}
					}
					break;
				}
			}
		}		
	}
}

