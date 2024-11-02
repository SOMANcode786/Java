

import java.util.Scanner;
        public class RockPaperScissors {
            public static void main(String []args){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your move: ");
                int human = sc.nextInt();
                switch (human){
                    case 1 -> System.out.println("You have chosen rock.");
                    case 2 -> System.out.println("You have chosen Paper.");
                    case 3 -> System.out.println("You have chosen Scissor.");
                    default -> System.out.println("Invalid move. Please make a valid move.");
                }
                int min = 1;
                int max = 3;
                System.out.println("Computer has chosen: ");
                int x = (int)(Math.random()*(max-min+1)+min);
                System.out.println(x);
                switch (x) {
                    case 1 -> System.out.println("Computer have chosen rock.");
                    case 2 -> System.out.println("Computer have chosen Paper.");
                    case 3 -> System.out.println("Computer have chosen Scissor.");
                }
                if (human == x){
                    System.out.println("Match tie.");
                }
                else if((human == 1 && x == 2)||(human == 2 && x == 3)||(human == 3 && x == 1)){
                    System.out.println("Computer won!");
                }
                else if((human == 1 && x == 3)||(human == 2 && x == 1)||(human == 3 && x == 2)) {
                    System.out.println("Congratulations! You won the game!");
                }
                else if(human >= 4){
                    System.out.println("Match cannot be played");
                }
            }

    }


