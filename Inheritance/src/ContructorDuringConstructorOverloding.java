

class Base2{
//	Constructor Overloading
	Base2(){
		System.out.println("I am a Non Paramerterized Contructor");
	}
	Base2(int x){
	System.out.println("THe Constructor which value is "+x);
	}
}
class Dev1 extends Base2{	
Dev1(){
	System.out.println("I am a Non Paramerterized Contructor of derived class");
}
	
	Dev1(int x,int y) {
		
//		Call the contructor of parent class takes paramter x
		super(x);
		System.out.println("THe Constructor which value is "+y);
		
	}	
}

public class ContructorDuringConstructorOverloding {
	
	
	public static void main(String[] args) {
		
		Dev1 d=new Dev1(14,23);
		
	}

}
