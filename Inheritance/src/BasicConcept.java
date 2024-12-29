//This is a Parent Class
class Base{
private	int x;
	 private int getX() {
	return x;
}




private void setX(int x) {
	this.x = x;
}




	Base(){
		System.out.println("I am A COntructor of Shape"	);
	
}
}

//Declaring Inheritance With Extend Keyword
//Child class
class Derived extends Base{
private int y;


Derived(){
	System.out.println("I am A constructor of Derived CLass");
}
public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
	System.out.println(y);
}


}




public class BasicConcept {

	public static void main(String[] args) {
		Derived d=new Derived();
d.setY(4);
	}

}
