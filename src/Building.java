import java.lang.Math; 
import java.lang.reflect.Field;

public class Building {
	
	private String name;
	private int amountOfFloors, totalSurface;
	
	
	public Building(String name, int amountOfFloors, int totalSurface) {
		setName(name);
		setAmountOfFloors(amountOfFloors);
		setTotalSurface(totalSurface);
	}
	
	public void cleanBuilding() {
		
		double extra, time, totalTime, salary;
		
		time = this.totalSurface/5;
		System.out.println(time);
		extra = ((0.5 * this.amountOfFloors)*30);
		
		totalTime = (time * 30 );
		
		salary = totalTime + extra;
		
		System.out.println(salary);
		
	}
	
	public void show() {
		
		System.out.println(toString());
		System.out.println(calculateVigilanceCost());
	}
	
	public String calculateVigilanceCost() {
		
		final int SALARYBASE;
		float ratio;
		int totalSalary;
		String string;
		
		SALARYBASE = 1300;
		ratio =  (this.totalSurface > 1000)?(Math.round((float)this.totalSurface / 1000)) : 1;
		totalSalary = SALARYBASE * (int)ratio;
		
		string = "Total security expenses: " + totalSalary;
		return string; 
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmountOfFloors() {
		return amountOfFloors;
	}
	public void setAmountOfFloors(int amountOfFloors) {
		this.amountOfFloors = amountOfFloors;
	}
	public int getTotalSurface() {
		return totalSurface;
	}
	public void setTotalSurface(int totalSurface) {
		this.totalSurface = totalSurface;
	}
	
	public String toString() {
		
		return "Building name: " + this.name + "\nAmount of floors: " + this.amountOfFloors + "\nTotal surface" + this.totalSurface;
	}

	
	
}
