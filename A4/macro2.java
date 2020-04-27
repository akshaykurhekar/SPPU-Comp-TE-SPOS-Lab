import java.util.*;
import java.io.*;
public class macro2
{
        public static void main(String args[])
        {

                BufferedReader br,br1,br2;
                OutputStream oo;
                String input=null,input1=null;
                String tt=null;
                String arg=null;
                String macroTokens=null;
                int macroindex[]=new int[10];
                String mnt[]=new String[10];
                int mcount=0,arg_count=0;
                int middlecount=0;
                int index=1;
                int main_enc=0;
              
                try
                {
                        br=new BufferedReader(new FileReader("Input.txt"));
                        br1=new BufferedReader(new FileReader("mnt.txt"));
                        br2=new BufferedReader(new FileReader("mdt.txt"));
                        File f = new File("final_output.txt");
                        PrintWriter p = new PrintWriter(f);
                        int ii=0;
                        while((input = br1.readLine())!=null)
                        {
                        	StringTokenizer st = new StringTokenizer(input,"\t"); 
                          	tt=st.nextToken();
                        	mnt[ii]=tt;
                        	System.out.println(mnt[ii]);
                        	ii++;
                        }
                        while ((input = br.readLine()) != null)
                        {
         		  StringTokenizer st = new StringTokenizer(input," "); 
                          tt=st.nextToken();  
                          if(tt.equals("START"))
                          {
		          	main_enc=1;
		                p.print("START ");
		                tt=st.nextToken();
		                p.println(tt);
                          }
                         
                          else
                          {
		               	 if(main_enc==1)
		                  {
		                      if(input.equals("END"))
		                      {
		                      	main_enc=0;
		                      	p.println("END");
		                      }
		                      else
		                      {
		                                StringTokenizer t=new StringTokenizer(input," ");
		                                //System.out.println(input);
		                                while(t.hasMoreTokens())
		                                {
		                                
		                                
		                                     macroTokens=t.nextToken();
		                                     for(int i=0;i<ii;i++)
		                                     {
		                                     	if(macroTokens.equals(mnt[i]))
		                                     	{
		                                     	int ff=0;
		                                     	//System.out.println("match");
		                                     		while((input1 = br2.readLine())!=null)
								{
									if(input1.equals(mnt[i]))
									{
										 ff=1;//System.out.println("match");
										 continue;
									}
									
									if(input1.equals("MEND"))
									{
										 ff=0;
									}
									
									if(ff==1)
									{
										 p.println(input1);
									}
								}
		                                     	}
		                                     }
		                                     
		                                     if(!(t.hasMoreTokens()) && Arrays.asList(mnt).contains(macroTokens)){
		                                     	//p.println(macroTokens);
		                                     	
		                                     	}
		                                     else if(!(t.hasMoreTokens())){
		                                     	p.println(macroTokens);
		                                     	
		                                     	}
		                                     else
		                                     	{
		                                     		if (Arrays.asList(mnt).contains(macroTokens) )
		                                     			{System.out.println("hi");}
		                                     		else
		                                     			p.print(macroTokens+" ");
		                                     	
		                                     
		                                     }
		                                     
		                                        
		                                }
		                      }
		                      
		                  }
                       	  }		   
                       	index++;
                        } 
                        p.close();
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }
        }
       
} 

