package activities;

public class Car {

		//Class member variables
			String color;
			String transmission;
			int make;
			int tyres;
			int doors;
			
			
			Car(String color,String transmission,int make){
				this.color = color;
				this.transmission = transmission;
				this.make = make;
				this.tyres = 4;
				this.doors = 4;
			}
			
			
			public void displayCharacteristics() {
				System.out.println("Colour:" + color);
				System.out.println("Transmission type:" + transmission);
				System.out.println("Years of making:" + make);
				System.out.println("No. of tyres:" + tyres);
				System.out.println("No. of doors:" + doors);
			}
			
			public void accelerate() {
				System.out.println("Car is moving forward");
				
			}
			
			public void brake() {
				System.out.println("Car has stopped");
			}
	}


