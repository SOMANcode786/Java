 class Phone{
	
	
	void greet() {
		System.out.println("Hellow My name is Muhammad Soman");
		
	}
	void on() {
		
		System.out.println("Phone is On");
	}
}
 class SmartPhone extends Phone{
	 
	 SmartPhone() {
		 
		 System.out.println("Good Morining");
	 }
	 
	void mthod() {
		 System.out.println("Hellow My name is Muhammad Soman");
		
	}
//	Oviriding

	void on() {
		
		System.out.println("SmartPhone is On");
	}
}

public class Oviriding {
	   public static void main(String[] args) {
		
//		Phone p=new Phone();
//		p.on();
		
//		   This is also Known as run time polumorphism beacause the object create on run time for the new keyword
//		this is dynamic method dispatch 
		   Phone s=new SmartPhone();
		s.on();
		s.greet();
	}

}
