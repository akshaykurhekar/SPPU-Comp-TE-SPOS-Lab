import java.util.*;
import java.io.*;

public class fcfs
{

    public static void main(String args[])
    {
        int n,sum=0;
        float total_tt=0,total_waiting=0;
        
          Scanner s=new Scanner(System.in);
          System.out.println("Enter Number Of Process U want 2 Execute---"); 
          n=s.nextInt();
          int arrival[]=new int[n];
          int cpu[]=new int[n];
          int finish[]=new int[n];
          int turntt[]=new int[n];
          int wait[]=new int[n];
          int process[]=new int[n];
          
         // int pro[][]=new int[3][3];
          for(int i=0;i<n;i++)
          {
                System.out.println("Enter arrival time of "+(i+1)+" Process : ");
                arrival[i]=s.nextInt();
                System.out.println("Enter CPU time of "+(i+1)+" Process : ");
                cpu[i]=s.nextInt();
                
                process[i]=i+1;
          }
          
           for(int i=0;i<n;i++)
          {
                sum=sum+cpu[i];
                finish[i]=sum;
          }
          
          for(int i=0;i<n;i++)
          {
                turntt[i]=finish[i]-arrival[i];
                
                total_tt=total_tt+turntt[i];
                
                wait[i]=turntt[i]-cpu[i];
                
                total_waiting+=wait[i];
          }
          
          System.out.println("\n\nProcess\t\tAT\tCPU_T");
          for(int i=0;i<n;i++)
          {
                System.out.println(process[i]+"\t\t"+arrival[i]+"\t"+cpu[i]);
          }
          
          System.out.println("\n\n");
          System.out.println("Total turn around time is : "+(total_tt/n));
          System.out.println("Total waiting time is : "+(total_waiting/n));
          
                                    
    }
}

/*
OUTPUT:

Enter Number Of Process U want 2 Execute---
2 3 2 1 5 2 4 5 3 2 5 2
Enter arrival time of 1 Process : 
Enter CPU time of 1 Process : 
Enter arrival time of 2 Process : 
Enter CPU time of 2 Process : 


Process		AT	CPU_T
1		3	2
2		1	5



Total turn around time is : 2.5
Total waiting time is : -1.0
*/

