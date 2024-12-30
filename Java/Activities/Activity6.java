package activities;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

class Plane{
	//Generic class of passengers List
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTakeOffTime;
	private Date lastLandingTime;
	
	Plane(int maxPassengers){
		this.maxPassengers = maxPassengers;
		this.passengers = new ArrayList<String>();
		//ArrayList is a class which i
	}
	
	public void onboard(String passengerName) {
		this.passengers.add(passengerName);
	}
	
	public void setTakeOff() {
		this.lastTakeOffTime = new Date();
	}
	
	public Date getTakeOffTime() {
		return this.lastTakeOffTime;
	}

	public void setland() {
		this.lastLandingTime = new Date();
		this.passengers.clear();
	}
	
	public Date getLastTimeLanded() {
		return this.lastLandingTime;
	}

	public List<String> getPassengers(){
		return this.passengers;
	}
	}



public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Create and Object of plane
		Plane b747 = new Plane(10);
		
		//Onboard Passengers
		b747.onboard("Shweta");
		b747.onboard("Shivani");
		b747.onboard("Mbs");
		
		//set the take off time
		b747.setTakeOff();
		System.out.println("Plane took off at: "+ b747.getTakeOffTime());
		System.out.println("The passengers in the plane: " + b747.getPassengers());
		
		
		//Flying......
		System.out.println("Plane is flying.....");
		Thread.sleep(5000);
		
	
		//Set the landing time
		b747.setland();
		System.out.println("Plane landed at: " + b747.getLastTimeLanded());
		System.out.println("The passengers in the plane after landing: "+b747.getPassengers());

	
	
	}

}
