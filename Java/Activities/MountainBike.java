package activities;

public class MountainBike extends Bicycle {
	int seatHeight;
   
    public MountainBike(int gears, int currentSpeed, int seatHeight) {
        super(gears, currentSpeed); 
        this.seatHeight = seatHeight;
    }

    public void setHeight(int height) {
        seatHeight = height;
        System.out.println("Seat height set to: " + seatHeight);
    }

    public void bicycleDesc() {
        super.bicycleDesc(); 
        System.out.println("Seat height: " + seatHeight);
    }

}
