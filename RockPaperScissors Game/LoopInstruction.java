import java.util.Scanner;

public class LoopInstruction {
    public static void main(String[] args) {

        int a;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter The number you want  make a table :");
         a= sc.nextInt();

         //for loop 
         for (int i=1;i<=10;i++){
int x=a*i;
            System.out.println(a + "x" + i + "=" + x);
        }





    }


}
