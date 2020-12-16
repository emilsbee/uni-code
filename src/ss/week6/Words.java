package ss.week6;

import java.util.Scanner;

public class Words {
	
	private static final String END_WORD = "end";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Scanner to read input from user
		
		boolean loop = true;
		
		while(loop) { // Program loop

			System.out.print("Write a sentence: ");
			String str = sc.nextLine(); // Read user's input

			if (str.equals(Words.END_WORD)) { // If user's input is "end"
				loop = false;
			} else {
				Scanner scBreak = new Scanner(str); // Scanner to break user's input in words

				while (scBreak.hasNext()) { // While there are words left
					System.out.println(scBreak.next());
				}

				scBreak.close();
			}
		}
		
		System.out.println("End of program.");

		sc.close();
	}
}
