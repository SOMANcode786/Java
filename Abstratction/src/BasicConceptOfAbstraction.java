//What is abstraction mean?
		
//		Existing in thought or idea wtithout has concreate structure 
// AbStract Method: 
//      Abstract void moveTO(double x,double y);
//      If a class include abstract method then the class must be declare abstract
//  Abstract class doesn't have an object beacuse he is a standard and sourcce of another class


abstract class parent{
	parent(){
		System.out.println("Ma COntructor ho parent ka");
		
	}
	
	public void SayHellow() {
		System.out.println("hellow");
	}
	
	
	abstract void greet();
}
class child extends parent{
	void  greet() {
		System.out.println("Hi");
	};
	void greet2() {
		
	}
}



public class BasicConceptOfAbstraction {
	public static void main(String[] args) {
//		Error because the abstrat class has no object0
//		parent p=new parent();
		child c=new child();
		c.greet();
	}

}
