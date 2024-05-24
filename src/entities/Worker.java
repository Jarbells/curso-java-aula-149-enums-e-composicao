package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private List<HourContract> contracts = new ArrayList<>();	
	private Department department;
	
	public Worker() {
	}

	public Worker(Department department, String name, WorkerLevel level, Double baseSalary) {
		this.department = department;
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContracts(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(Integer year, Integer month) {
		double totalValue = 0.0;
		Calendar cal = Calendar.getInstance();
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int tempYear = cal.get(Calendar.YEAR);
			int tempMonth = 1 + cal.get(Calendar.MONTH);
			if(year == tempYear && month == tempMonth) {
				totalValue += c.totalValue();
			}
		}
		return totalValue + baseSalary;
	}
	
	public String toString() {
		return "Name: "
				+ name
				+ "\nDepartment: "
				+ department.getName();
	}
}
