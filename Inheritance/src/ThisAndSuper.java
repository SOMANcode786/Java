//How To use this KEyword ?

class Ekclass{
	int a;

	int getA() {
		return a;
	}
//
//	Ekclass(int a) {
//	a = a;
//	} this is error the variable and the method varible are same name
	
//	Fine
	
//	this keywrod is used to refrence of the object 
	Ekclass(int a) {
		this.a=a;
	}
	
//		
	
}


public class ThisAndSuper {

	public static void main(String[] args) {

Ekclass e=new Ekclass(15);
System.out.println(e.getA());


	}

}
