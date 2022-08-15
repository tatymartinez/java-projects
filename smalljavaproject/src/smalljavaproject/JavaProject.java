package smalljavaproject;

import java.util.Scanner;

public class JavaProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("What is your age? ");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int age = Integer.parseInt(s);
		
		if (age > 20 && age < 40) {
			System.out.println("Do you like birds?");
			String birds = scan.nextLine();
			
			if (birds.equals("yes") || birds.equals("Yes")) {
				System.out.println("Do you have a pet bird?");
				String sure = scan.nextLine();
				
				if (sure.equals("yes") || sure.equals("Yes")) {
					System.out.println("Awesome, me too!!  We are cool.");
				} 
				else if (sure.equals("no") || sure.equals("No")) {
					System.out.println("Aw, darn.  We could have been bird buddies.");
				}
				else {
					System.out.println("I'm glad I asked!");
				}
			}
			else if (birds.equals("no") || birds.equals("No")){
				System.out.println("Aw, darn.  We could have been bird buddies.");
			}
			else {
				System.out.println("I can tell we will be best friends.");
			}
		} 
		else if (age <= 20) {
			System.out.println("Do you like cats?");
			String cats = scan.nextLine();
			
			if (cats.equals("yes") || cats.equals("Yes")) {
				System.out.println("I love cats too!  I want to name one Chocolate.");
			}
			else if (cats.equals("no") || cats.equals("No")) {
				System.out.println("Interesting.. very interesting.");
			}
			else {
				System.out.println("I can tell we will be best friends.");
			}
		} 
		else if (age >= 40){
			System.out.println("Do you like dogs?");
			String dogs = scan.nextLine();
			
			if (dogs.equals("yes") || dogs.equals("Yes")) {
				System.out.println("Awesome! They make me happy too.");
			}
			else if (dogs.equals("no") || dogs.equals("No")) {
				System.out.println("That is good to know.");
			}
			else {
				System.out.println("I can tell we will be best friends.");
			}
			
		}
		
	}

}
