package Day10_EmployeeWage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EmployeeWage {
	static ArrayList<Emp> emp = new ArrayList<Emp>();

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program");
		int ans = 1;
		Scanner scan = new Scanner(System.in);
		while (ans == 1) {
			System.out.println("Enter Details-----");
			Emp p = new Emp();
			emp.add(p);
			System.out.println("Want to Add more? Enter 1 for Yes, 2 for No");
			ans = scan.nextInt();
		}
		for (int i = 0; i < emp.size(); i++) {

			System.out.printf("Company: %-10s Total Wage: %d", emp.get(i).company,  emp.get(i).TotalWage);
		}
//		System.out.println("Monthly Wage : " + e1.monthlyWage());
	}
}

interface EmployeeBuilder {

	public void isPresent();

	public int dailyWage(int h);

	public int monthlyWage();
}

class Emp implements EmployeeBuilder {

	String company;
	int WAGE_PER_HOUR = 200;
	int FULLTIME_HOUR = 8;
	int PARTTIME_HOUR = 4;
	int WORKING_DAYS = 20;
	int TOTAL_WORKING_HOURS = 100;
	public int hours;
	public int TotalWage, totalHours = 0;
	ArrayList<Integer> ArrOfDailyWage = new ArrayList<Integer>();

	Emp() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Company Name: ");
		this.company = sc.next();
		System.out.println("Enter Working Days: ");
		this.WORKING_DAYS = sc.nextInt();
		System.out.println("Enter Total Working Hours: ");
		this.TOTAL_WORKING_HOURS = sc.nextInt();
		System.out.println("Enter Wage Per Hour: ");
		this.WAGE_PER_HOUR = sc.nextInt();
		this.monthlyWage();

	}

	public void isPresent() {
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

	public int dailyWage(int h) {
		ArrOfDailyWage.add(h * WAGE_PER_HOUR);
		return h * WAGE_PER_HOUR;
	}

	public int monthlyWage() {
		int i = 0;
		while (i < WORKING_DAYS && totalHours < TOTAL_WORKING_HOURS) {
			isPresent();
			TotalWage += dailyWage(hours);
			totalHours += hours;
			i++;
			//System.out.println("Day" + i + ": " + dailyWage(hours));
		}

		return TotalWage;
	}

	public void empBuilder(Emp e) {
		System.out.println("Company: " + e.company);
		System.out.println("Total Wage: " + e.TotalWage);
	}
}
