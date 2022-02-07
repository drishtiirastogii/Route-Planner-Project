package com.Collections;

public class Route 
{
	private String FromCity;
	private String toCity;
	private String distanceInKM;
	private String TimeTravelled;
	private String price;
	public String getFromCity() {
		return FromCity;
	}
	public void setFromCity(String fromCity) {
		FromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getDistanceInKM() {
		return distanceInKM;
	}
	public void setDistanceInKM(String distanceInKM) {
		this.distanceInKM = distanceInKM;
	}
	public String getTimeTravelled() {
		return TimeTravelled;
	}
	public void setTimeTravelled(String timeTravelled) {
		TimeTravelled = timeTravelled;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Route(String fromCity, String toCity, String route, String route2, String route3) {
		super();
		FromCity = fromCity;
		this.toCity = toCity;
		this.distanceInKM = route;
		TimeTravelled = route2;
		this.price = route3;
	}
	public Route(){}
	
	public void display()
	{
		System.out.format("%-20s %-20s %-20s %-20s %-20s \n",this.FromCity,this.toCity,this.distanceInKM,this.TimeTravelled,this.price);
	}
	
	@Override  //toString inbuilt method always under override/overload
	public String toString() {
		return "route FromCity=" + FromCity + ", toCity=" + toCity + ", distanceInKM=" + distanceInKM
				+ ", TimeTravelled=" + TimeTravelled + ", price=" + price + "";
	}
	
	
}
