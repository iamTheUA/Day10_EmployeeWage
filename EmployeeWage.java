package Day10_EmployeeWage;

import java.util.Random;

public class EmployeeWage {
	static int FULLTIME_HOUR = 8;
	public static int hours;
	static int WAGE_PER_HOUR = 200;
	
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
			hours = FULLTIME_HOUR;
			break;
		}
	}
	
	public static int dailyWage(int h) {
		return h * WAGE_PER_HOUR;
	}
}
