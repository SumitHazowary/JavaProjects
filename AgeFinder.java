package com.studyopedia;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeFinder {
	public static void main(String[] args) {
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter your DOB(YYYY/MM/DD)");
		String stringDOB = myObj.nextLine();
		
		int stringYear = Integer.parseInt(stringDOB.substring(0,4));
		int stringMonths = Integer.parseInt(stringDOB.substring(5,7));
		int stringDays = Integer.parseInt(stringDOB.substring(8,10));

		LocalDate currentDate = LocalDate.now();
		LocalDate birthDate = LocalDate.of(stringYear, stringMonths, stringDays);
		
		if (birthDate.isAfter(currentDate)) {
            System.out.println("Error: Birth date can't be in the future.");
        } else {
            Period age = Period.between(birthDate, currentDate);
            System.out.println("Your are  " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days old.");
        }
		myObj.close();
	}
}
