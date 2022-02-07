package com.Collections;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class RouteIMP 
{
	static String readFile="C:\\File1\\routes.csv";
	Scanner scanobj=new Scanner(System.in);
	static RoutesLogic Rl=new RoutesLogic();
	
	void menu()
	{
		System.out.println("Enter 1 to view all flight details");
		System.out.println("Enter 2 to view flights from the city you want to travel");
		System.out.println("Enter 3 to view direct flights from the above city you mentioned");
		System.out.println("Enter 4 to check connecting flights");
	}
	
	public void Display() throws FileNotFoundException, IOException
	{
		List<Route> list=Rl.readRoutesfile(readFile); 
		displayFormat();
		list.forEach(Route::display); 
	}
	
	public void show() throws FileNotFoundException, IOException
	{
		System.out.println("Enter the city you want to travel from");
		String str=scanobj.nextLine();
		Stream<Route> list=Rl.displayFile(Rl.readRoutesfile(readFile),str );
		displayFormat();
		list.forEach(Route::display);
	}
	
	public void direct() throws FileNotFoundException, IOException
	{
		System.out.println("Enter the city you want to travel from");
		String str1=scanobj.nextLine();
		System.out.println("Enter the city you want to travel to");
		String str2=scanobj.nextLine();
		Stream<Route> list=Rl.displayDirect(Rl.readRoutesfile(readFile), str1, str2);
		displayFormat();
		list.forEach(Route::display);
	}
	
	public void connecting() throws FileNotFoundException, IOException
	{
		System.out.println("Enter the city you want to travel from");
		String str1=scanobj.nextLine();
		System.out.println("Enter the city you want to travel to");
		String str2=scanobj.nextLine();
		Stream<Route> list=Rl.connecting(Rl.readRoutesfile(readFile), str1, str2);
		displayFormat();
		list.forEach(Route::display);
	}
	
	public void displayFormat()
	{
		System.out.println();
		System.out.format("%-20s %-20s %-20s %-20s %-20s \n","From","To","Distance in KM","Time travel","Price");
		System.out.println("===================================================================================================");
	}
}
