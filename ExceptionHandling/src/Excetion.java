
public class Excetion {
public static void main(String[] args) {
	
//	int x=6000;
//	int b=0;
//	int c=x/b;
//	System.out.println(c);
//	Exception in thread "main" java.lang.ArithmeticException: / by zero
//	at Excetion.main(Excetion.java:7)  this type of excetion will be show 
	
	int x=6000;
	int y=0;
	try {
		
		int ans=x/y;
		System.out.println("Ans"+ans);
	}
	catch(Exception e){
	
		 System.out.println("Error: Division by zero is not allowed!");
	
}
	System.out.println("Error !");
	
	
	
	int b=2;
	int c=4;
	int d=b+c;
	System.out.println(d);
}
}




