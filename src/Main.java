
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Main
{

  static String sortarry[] =
    { "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?",
"?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };

static List arrayListt = new ArrayList<>();

public static void main (String[]args)
{
 
 
  while(true){
   
    int a,b=0;
    Scanner sc = new Scanner (System.in);
    int state =  Integer.parseInt(sc.nextLine());

    String[]commandarry = new String[state];

    int count = 0;

      while (state > count)
      {
    	// Read an String value 
    	commandarry[count] = sc.nextLine();
    	count++;
       
      }

    for (String variable:commandarry)
      {
        StringBuffer text = new StringBuffer(variable); 
     
        if(variable.charAt(0)=='C' )
         {
                
            //if(text.substring(7,8)!=null)
            if(text.length()-1==7)
              Main.clear(Integer.parseInt(text.substring(6,8)));
            else
              Main.clear(Integer.parseInt(text.substring(6,7)));
         }
         else if(variable.charAt(0)=='S')
         {
             //if(text.substring(5,6)!=null)
             if(text.length()-1==5) 
               Main.seT(Integer.parseInt(text.substring(4,6)));
             else
               Main.seT(Integer.parseInt(text.substring(4,5)));
         }//or
         else if(variable.charAt(0)=='O')
         {
         
            if(text.charAt(4)!=' ')
             {
               a=Integer.parseInt(text.substring(3,5));
              if(text.charAt(7)!=' ')
                b=Integer.parseInt(text.substring(6,8));
              else
                b=Integer.parseInt(text.substring(6,7));
             }
             else
             { 
              a=Integer.parseInt(text.substring(3,4));
             
              if(text.length()-1 <= 6)
              {
                  b=Integer.parseInt(text.substring(5,6));
              }
              else
                  b=Integer.parseInt(text.substring(5,7));
                                 
             }
            
               Main.sOr(a,b);   
         }
         else if(variable.charAt(0)=='A')
         {
            
           if(text.charAt(5)!=' ')
             {
               a=Integer.parseInt(text.substring(4,6));
                if(text.charAt(8)!=' ')
                 b=Integer.parseInt(text.substring(7,9));
                 else
                 b=Integer.parseInt(text.substring(7,8));
             }
             else
             {
               a=Integer.parseInt(text.substring(4,5));
            
               if(text.length()-1 <= 7)
                 b=Integer.parseInt(text.substring(6,7)); 
               else
                 b=Integer.parseInt(text.substring(6,8)); 
                 
             }
            
             Main.sAnd(a,b);
         }
         else
         System.out.println("No Comment"+variable.charAt(0));
         
         
      }

   
    	List<String> list = Arrays.asList(sortarry);
		
		//next, reverse the list using Collections.reverse method
		Collections.reverse(list);
		
		//next, convert the list back to String array
		sortarry = (String[]) list.toArray();
		
	
		arrayListt.add(Arrays.toString(sortarry.clone()));
		
       if(state==0)
         break;
	   else 
	    {
	     for (int i = 0; i < Main.sortarry.length; i++)
          {
              Main.sortarry[i]="?";
             
          }  
           
	    }
       
    
    }

    for (int i = 0; i <  Main.arrayListt.size()-1; i++)
             System.out.println(Main.arrayListt.get(i));
               
          
          
       
 }


  static void clear (int bit)
  {

    for (int i = 0; i < Main.sortarry.length; i++)
      if (i == bit)
	{
	  Main.sortarry[i] = "0";
	  break;
	}
  }

  static void seT (int bit)
  {

    for (int i = 0; i < Main.sortarry.length; i++)
      if (i == bit)
	{
	  Main.sortarry[i] = "1";
	  break;
	}
  }

  static void sOr (int one, int two)
  {

    String inone = Main.sortarry[one];
    String intwo = Main.sortarry[two];

    if (!inone.equals ("?") | !intwo.equals ("?"))
      {
	if (inone.equals ("1") | intwo.equals ("1"))
	  Main.sortarry[one] = "1";
	else
	  {
	    if (inone.equals ("0") & intwo.equals ("0"))
	      Main.sortarry[one] = "0";
	    else
	      Main.sortarry[one] = "?";
	  }

      }
    else
      Main.sortarry[one] = "?";



  }

  static void sAnd (int one, int two)
  {


    String inone = Main.sortarry[one];
    String intwo = Main.sortarry[two];

    if (!inone.equals ("?") & !intwo.equals ("?"))
      {
	if (inone.equals ("1") & intwo.equals ("1"))
	  Main.sortarry[one] = "1";
	else
	  Main.sortarry[one] = "0";

      }
    else
      Main.sortarry[one] = "?";


  }
}
