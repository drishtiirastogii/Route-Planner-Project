package com.Collections;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class RoutesLogic 
{	
	String line;
	int count=0;							// String to integer Integer.parseInt(route[2])			
	
	public List<Route> readRoutesfile(String fileName) throws IOException, FileNotFoundException
	{	
		List<Route> readFile=new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		while((line=br.readLine())!=null)
		{	
			String[] route=line.split(",");
			readFile.add(new Route(route[0],route[1],route[2],route[3],route[4]));
		}
		return readFile;
	}
	
	
	public Stream<Route> displayFile(List<Route> ReadRouteFile, String city )//with stream we can DIRECTLY write return then logic
	{	
		return ReadRouteFile.stream().filter(p->p.getFromCity().equalsIgnoreCase(city))
		.sorted((Comparator.comparing(Route::getToCity))); //syntax->(Route::gettocity)
	}
	
	
	public Stream<Route> displayDirect(List<Route> direct, String FromCity, String ToCity)//with List we will have to write return statement 
	{	
		return direct.stream().filter(p->p.getFromCity().trim().equalsIgnoreCase(FromCity) && p.getToCity().trim().equalsIgnoreCase(ToCity));
	}	//totrim() to trim spaces in csv file it is impp!!!!!
		//to trim() with getter setter getToCity<-eg !!
	
	
	public Stream<Route> connecting (List<Route> connectFlight, String FromCity, String ToCity)
	{
		Stream<Route> directFlight= displayDirect(connectFlight, FromCity, ToCity); 
		
		Stream<Route> FirstConnection= displayFile(connectFlight, FromCity); // from city 
		for(Route F1:FirstConnection.toList())
		{
			Stream<Route> SecondConnection= displayFile(connectFlight, F1.getToCity().trim()); 
			List<Route> connectFlights= SecondConnection.filter(p->p.getToCity().trim().equalsIgnoreCase(ToCity)).toList();
			if(connectFlights.size()==1)
			{
				List<Route> rou=new ArrayList();
				rou.add(F1);
				directFlight=Stream.concat(directFlight, rou.stream());
			}
			directFlight=Stream.concat(directFlight, connectFlights.stream());
		}
		return directFlight;
	}
	
}