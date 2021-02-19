package horseClass;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("ENETER A PHONE NUMBER :");

		String input = scan.nextLine();

		String number = input.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");


		if(!validatePhoneNumber(input)) 
		{
			System.out.println("This is Not valid Phone Number");
		}
		else 
		{
			System.out.println("Great its a Good Phone Number ");
			System.out.println("Phone Number Is : "+number);
		}
	}
	private static boolean validatePhoneNumber(String phoneNumber) {
		// validate phone numbers of format "1234567890"
		if (phoneNumber.matches("\\d{10}"))
			return true;
		// validating phone number with -, . or spaces
		else if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
			return true;
		// validating phone number with extension length from 3 to 5
		else if (phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
			return true;
		// validating phone number where area code is in braces ()
		else if (phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
			return true;
		// Validation for India numbers
		else if (phoneNumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))
			return true;
		else if (phoneNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))
			return true;

		else if (phoneNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))
			return true;
		// return false if nothing matches the input
		else
			return false;

	}

}
