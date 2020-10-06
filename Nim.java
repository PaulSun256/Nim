/**
*Nim
**/

import java.util.Scanner;

public class Nim {
	static int pile;

	public static void main(String[] args){
		//Variables
		Scanner in = new Scanner(System.in);
		int userInput, computersTurn;
		double wins=0, losses=0;
		String stringContinue;

		System.out.println("Welcome to the Game of Nim! Try to get 75% wins!");

		do{
			System.out.println("");
			pile = drawStones();
			while(pile>0){ //Continue game if stones remain
				do{//get legit input
					System.out.print("There are " + pile + " stones in the pile. How many would you like? (1-3): ");
					userInput = in.nextInt();
				}while(!isValidEntry(userInput) );
				pile-=userInput;
				System.out.print("There are " + pile + " stones in the pile. ");
				if(pile==0){ //If user lost
					losses++;
					System.out.println("\nSorry, you lose!");
				}
				else if (pile==1){ //If user wins
					System.out.print("Computer takes 1 stone.\n\nLooks like you win!");
					pile--;
					wins++;
				}
				else{ //Computer makes a move
					computersTurn = computersTurnAI();
					pile -= computersTurn;
					System.out.println("Computer takes " + computersTurn + " stones.");
				}
			}
			System.out.print("\nAfter " + (int)(wins+losses) + " games, your win percentage is " + Math.round((wins*10000.0)/(wins+losses))/100.0 + "%\nWould you like to play again?");
			in.nextLine();
			stringContinue = in.nextLine();
		}while(stringContinue.charAt(0)=='y'||stringContinue.charAt(0)=='Y');

		//Close scanner
		in.close();
	}
	
    public static int drawStones()	{
        return (int)(Math.random()*15.0) + 16;
    }

    public static int computersTurnAI()	{
        for(int i = 1; i < 4; i++)	if((pile - i) % 4 == 1) return i;
        return (int)(Math.random()*3.0) + 1;
    }
	
    public static boolean isValidEntry(int n)	{
        return (n > 0 && n < 4);
    }
}