package com.Collections;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RoutesMain 
{
	public static void main(String args[])throws IOException
	{	
		Scanner scanobj=new Scanner(System.in);
		RouteIMP rou=new RouteIMP();
			rou.menu();
			int choice=scanobj.nextInt();	
			
			while(choice!=0)
			{
				switch(choice)
				{
				case 1:	
				rou.Display();
				break;
				
				case 2:
				rou.show();
				break;
				
				case 3:
				rou.direct();
				break;
				
				case 4:
				rou.connecting();
				}
				rou.menu();
				choice=scanobj.nextInt();
			}
	}
}
