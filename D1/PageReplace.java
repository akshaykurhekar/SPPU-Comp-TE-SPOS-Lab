import java.util.*;

public class PageReplace {
	static int[] stream = new int[30];
	public static void main(String[] args) 
	{
		int i,ch;
		try
		{
			Operations op=new Operations();
			System.out.print("Enter number of pages in page stream:");
			Scanner sc=new Scanner(System.in);
			int no=sc.nextInt();
			System.out.print("Enter page stream:");
			for(i=0;i<no;i++)
			{
				stream[i]=sc.nextInt();
			}
			while(true)
			{
				System.out.println("*************Menu*************");
				System.out.println("1.LRU");
				System.out.println("2.Optimal");
				System.out.println("3.Exit");
				System.out.print("Enter your Choice:");
				ch=sc.nextInt();
				switch(ch)
				{
					case 1: op.lru(no,stream);break;
					case 2:	op.optimal(no,stream);break;
					case 3:	return;
				}
			}
		}
		catch(Exception e)
		{			
		}
	}
}
class Operations
{
	int i,j;
	Scanner sc=new Scanner(System.in);
	int found(int no,int fs,int [] frame, int page)
	{	
		for(i=0;i<fs;i++)
			if(frame[i]==page)
				return 1;		
		return 0;			
	}
	public int empty(int []frame,int fs)
	{
		for(i=0;i<fs;i++)
			if(frame[i]==99)
				return i;			
		return -1;		
	}
	public int max(int [] lrud,int fs)
	{		
		j=0;
		for(i=1;i<fs;i++)
			if(lrud[i]>lrud[j])
				j=i;
		return j;		
	}		
	public void lru(int no,int[] stream)
	{		
		System.out.print("Enter frame size:");
		int fs=sc.nextInt();
		int [] frame=new int[fs];
		int [] lrud=new int[fs];
		int i,pf=0,Hit=0;
		for(i=0;i<fs;i++)
		{			
			frame[i]=99;
			lrud[i]=0;
		}
		int j;
		System.out.println("Page\tframe contents");
		System.out.print("\t");
		for(j=0;j<fs;j++)
			System.out.print(" "+frame[j]);		
		for(i=0;i<no;i++)
		{			
			if(found(no,fs,frame,stream[i])==0)
			{			
				int loc=empty(frame,fs);			
				if(loc!=-1)
				{
					for(j=0;j<fs;j++)
						lrud[j]++;
						frame[loc]=stream[i];
						lrud[loc]=0;						
				}
				else
				{
					loc=max(lrud,fs);
					frame[loc]=stream[i];
					for(j=0;j<fs;j++)
						lrud[j]++;
					lrud[loc]=0;
				}					
			}
			else
			{
				Hit=Hit+1;			
				for(j=0;j<fs;j++)
				{
					if(frame[j]!=stream[i])
						lrud[j]++;
					else
						lrud[j]=0;
				}
			}
			System.out.print("\n"+stream[i]+"\t");
			for(j=0;j<fs;j++)
				System.out.print(" "+frame[j]);			
		}
		pf=no-Hit;
		System.out.println("\nTotal number of page faults by LRU Technique:"+pf);	
	}
	int futureD(int [] stream, int no, int begin,int page)
	{	
		for(i=begin+1;i<no;i++)
			if(page==stream[i])
				return(i-begin);
			return(9999);						
	}
	public void optimal(int no,int[] stream)
	{
		System.out.print("Enter frame size:");
		int fs=sc.nextInt();
		int [] frame=new int[fs];
		int [] optd=new int[fs];
		int pf=0,Hit=0;
		for(i=0;i<fs;i++)
		{			
			frame[i]=99;
			optd[i]=0;
		}		
		System.out.println("Page\tframe contents");
		System.out.print("\t");
		for(j=0;j<fs;j++)
			System.out.print(" "+frame[j]);		
		for(i=0;i<no;i++)
		{			
			if(found(no,fs,frame,stream[i])==0)
			{				
				int loc=empty(frame,fs);				
				if(loc!=-1)				
					frame[loc]=stream[i];			
				else
				{
					loc=max(optd,fs);
					frame[loc]=stream[i];					
				}					
			}
			else
			{
				Hit=Hit+1;		
			}
			for(int k=0;k<fs;k++)
			{
				optd[k]=futureD(stream,no,i,frame[k]);
			}
			System.out.print("\n"+stream[i]+"\t");
			for(j=0;j<fs;j++)
				System.out.print(" "+frame[j]);			
		}				
		pf=no-Hit;
		System.out.println("\nTotal number of page faults by Optimal Page Replacement Technique:"+pf);
	}
}

