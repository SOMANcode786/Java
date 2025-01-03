
//Interface is a point when two meet and interact with each other

//goup of met method with empty  bodies

import java.util.Scanner;

interface Bicycle{
	public int brake(int decrement);
	public int speedUp(int increment);
	
}

class electriCycle implements Bicycle{
private int speed;

electriCycle(int speed ){
	this.speed=speed;
}

	 public int getSpeed() {
	return speed;
}

	@Override
	public int brake(int decrement) {
	speed =speed-decrement;
		return speed;
	}

	@Override
	public int speedUp(int increment) {
		return speed =speed+increment;
		
	}
	
}


public class IntrotoInterface {

	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter THe Speed  :");
	int speed=s.nextInt();
	
electriCycle e=new electriCycle(speed);

while(true) {
	
	System.out.println("\n Curent Speed ="+e.getSpeed());
	System.out.println("\n---- Choose An action----");
	System.out.println("\n 1. Brake");
	System.out.println("\n 2. SpeedUp ");
	System.out.println("\n 3. Exit ");
	System.out.println("============================");

	int choice =s.nextInt();
	
	if(choice==1) {
		System.out.println("Enter Decrement Speed ");
		int decrement=s.nextInt();
	e.brake(decrement);
	System.out.println("Speed Slow!");
		
	}
	else if(choice==2) {
		System.out.println("Enter increment Speed ");
		int increment=s.nextInt();
	e.speedUp(increment);
	System.out.println("Speed Up!");
		
	}
	else if(choice==3) {
		System.out.println(" Exits !-- ");
		break;
		
	}

	


	
	
}




	}

}
