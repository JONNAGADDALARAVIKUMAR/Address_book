package addressBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address_book 
{

	public static void main(String[] args)
	{
		String firstName=null,lastName=null,mobileNum,city=null,address=null,state=null,zip=null,str=null;
		int choice;
		String first="^[A-Z]{1,}[a-z]{3,7}";
		String mobile="^(91){1}[1-9]{1}[0-9]{9}";
		String pin="^[1-9]{1}[0-9]{5}";
		
		Scanner scan = new Scanner(System.in);
		System.out.print("1.Create an Address\t2.Open Address book\n3.Delete an Address\n\n\tChoice : ");
    	choice=scan.nextInt();
    	if(choice == 1)
    	{
    		System.out.print("\nFirst Name must be having atleast 3 and not more than 7  Charecters\natleast one Upper case and one lower case\nFirst letter should be Upper case\nno Space\n\n\tFirst Name : ");
    		
    		firstName=scan.next();
    		Pattern pattern1 = Pattern.compile(first);
            Matcher matcher1 = pattern1.matcher(firstName);
            if(matcher1.matches())
            	System.out.println("\n"+firstName+" : Validated\n");
            else
            	System.out.println("\n"+firstName+" : Invalid\n");
    		
    		System.out.print("\n\nLast Name must be having atleast 3 and not more than 7  Charecters\natleast one Upper case and one lower case\nFirst letter should be Upper case\nno Space\n\n\tLast Name : ");
    		
    		lastName=scan.next();
    		
    		Pattern pattern2 = Pattern.compile(first);
            Matcher matcher2 = pattern2.matcher(lastName);
            if(matcher2.matches())
            	System.out.println("\n"+lastName+" : Validated\n");
            else
            	System.out.println("\n"+lastName+" : Invalid\n");
    		
    		System.out.print("Ex. D.No,Street,Village\n\nAddress : ");
    		
    		address=scan.next();
    		
    		
    		
    		System.out.print("\nex. 918888888888\n\nMobile : ");
    		mobileNum=scan.next();
    		
    		Pattern pattern3 = Pattern.compile(mobile);
            Matcher matcher3 = pattern3.matcher(mobileNum);
            if(matcher3.matches())
            	System.out.println("\n"+mobileNum+" : Validated\n");
            else
            	System.out.println("\n"+mobileNum+" : Invalid\n");
    		
    		System.out.print("\nCity : ");
    		city=scan.next();
    		
    		System.out.print("\nState : ");
    		state=scan.next();
    		
    		System.out.print("\nex. 516396\nZIP : ");
    		zip=scan.next();	
    		
    		Pattern pattern4 = Pattern.compile(pin);
            Matcher matcher4 = pattern4.matcher(zip);
            if(matcher4.matches())
            	System.out.println("\n"+zip+" : Validated\n");
            else
            	System.out.println("\n"+zip+" : Invalid\n");
    		try
    		{
    			File Obj = new File(lastName+".txt");
    			//System.out.println(Obj.getAbsolutePath());
    			if (Obj.createNewFile()) 
    			{
    				System.out.println("\nAddress book created as : " + Obj.getName());
    			} 
    			else
    			{
    				System.out.println(Obj.getName()+" Address book updated");
    			}
    		
    			FileWriter myWriter = new FileWriter(lastName+".txt");
    			myWriter.write(firstName+" "+lastName+" "+address+" "+mobileNum+" "+city+" "+state+" "+zip);
    			myWriter.close();
    			System.out.println("\nSuccessfully addaed to the Address book");
    		}
    		catch (IOException e) 
    		{
  		      System.out.println("An error occurred.");
  		      e.printStackTrace();
  		
    		}
    	}
    	else if(choice == 2)
    	{
    		File dir = new File(".");
    		File[] filesList = dir.listFiles();
    		for (File file : filesList) {
    		    if (file.isFile()) {
    		    	if(file.getAbsolutePath().endsWith(".txt"))
	    		        System.out.println(file.getName());
    		    }
    		    
    		}
    		System.out.print("\n\nEnter which Address you want to open \n(Enter with .txt) : ");
    		try
    		{
    			File myObj = new File(scan.next());
    			Scanner myReader = new Scanner(myObj);
    			while (myReader.hasNextLine()) {
    				String str1 = myReader.next();
    				System.out.println(str1);
    			}
    		}
    		catch (FileNotFoundException e)
    		{
    		      System.out.println("An error occurred.");
    		      e.printStackTrace();
    		}
    	}
    	else if(choice == 3)
    	{
    		File dir = new File(".");
    		File[] filesList = dir.listFiles();
    		for (File file : filesList) {
    		    if (file.isFile()) {
    		    	if(file.getAbsolutePath().endsWith(".txt"))
	    		        System.out.println(file.getName());
    		    }
    		    
    		}
    		System.out.print("\n\nEnter which Address you want to Delete \n(Enter with .txt) : ");
    		String delfile=scan.next();
    		File myObj = new File(delfile);
			
			myObj.delete();
			System.out.println(delfile+" Deleted Successfully");
    	}
    	else
    		System.out.println("Invalid choice");
    	
    	
    }
}