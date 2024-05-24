package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String tempDepartment = sc.nextLine();
		Department department = new Department(tempDepartment);
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.next();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		System.out.print("How many contracts to this worker? ");
		int quantity = sc.nextInt();
		
		Worker worker = new Worker(department, name, WorkerLevel.valueOf(level), baseSalary);
		
		for(int i = 0; i < quantity; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			String tempDate = sc.next();
			Date date = sdf.parse(tempDate);
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();			
			HourContract contract = new HourContract(date, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String tempDate = sc.next();
		int month = Integer.parseInt(tempDate.substring(0, 2));
		int year = Integer.parseInt(tempDate.substring(3));
		double income = worker.income(year, month);
		System.out.println(worker);
		System.out.println("Income for " + tempDate + ": " + income);
		
		sc.close();
	}
}
