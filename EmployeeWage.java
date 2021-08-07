package Day10_EmployeeWage;

import java.util.Random;

public class EmployeeWage {
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program");
		Emp e1 = new Emp("TATA", 20, 100, 200);
		System.out.println("Monthly Wage : " + e1.monthlyWage());
	}
}

class Emp {
	String company;
	static int WAGE_PER_HOUR = 200;
	static int FULLTIME_HOUR = 8;
	static int PARTTIME_HOUR = 4;
	static int WORKING_DAYS = 20;
	static int TOTAL_WORKING_HOURS = 100;
	public static int hours;
	public static int TotalWage, totalHours = 0;

	Emp(String company, int WORKING_DAYS, int TOTAL_WORKING_HOURS, int WAGE_PER_HOUR) {
		this.company = company;
		this.WORKING_DAYS = WORKING_DAYS;
		this.TOTAL_WORKING_HOURS = TOTAL_WORKING_HOURS;
		this.WAGE_PER_HOUR = WAGE_PER_HOUR;
	}

	public static void isPresent() {
		Random ran = new Random();
		int isPresent = ran.nextInt(3);
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
		while (i < WORKING_DAYS && totalHours < TOTAL_WORKING_HOURS) {
			isPresent();
			TotalWage += dailyWage(hours);
			totalHours += hours;
			i++;
			System.out.println("Day" + i + ": " + dailyWage(hours));
		}

		return TotalWage;
	}
}
