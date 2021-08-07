package Day10_EmployeeWage;

import java.util.Random;

public class EmployeeWage {
	static int FULLTIME_HOUR = 8;
	static int PARTTIME_HOUR = 4;
	public static int hours;
	static int WAGE_PER_HOUR = 200;
	public static int monthly = 0;
	static int WORKING_DAYS = 20;

	
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program");
	}
	
	public static void isPresent() {
		Random ran = new Random();
		int isPresent = ran.nextInt(2);
		switch (isPresent) {
		case 0:
			hours = 0;
			break;
		case 1:
			hours = PARTTIME_HOUR;
			break;
		case 2:
			hours = FULLTIME_HOUR;
			break;
		}
	}
	
	public static int dailyWage(int h) {
		return h * WAGE_PER_HOUR;
	}
	
	public int monthlyWage() {
		int i = 0;
		while (i < WORKING_DAYS) {
			isPresent();
			monthly += dailyWage(hours);
			i++;
			System.out.println("Day" + i + ": " + dailyWage(hours));
		}

		return monthly;
	}
}
