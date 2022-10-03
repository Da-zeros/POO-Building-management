
public class Hotel extends Building{

	private int rooms;
	

	public Hotel(String name, int amountOfFloors, int totalSurface, int rooms) {
		super(name, amountOfFloors, totalSurface);
		// TODO Auto-generated constructor stub
		setRooms(rooms);
	}
	

	public void show() {
		
		super.show();
		System.out.println(calculateStaffCost());
		
	}
	
	@Override
	public String calculateVigilanceCost() {
		
		String string;
		final int SALARYBASE;
		float ratio;
		int totalSalary, ratioExtra;
		
		SALARYBASE = 1300;
		ratio =  (getTotalSurface() > 1000)?(Math.round((float)getTotalSurface() / 1000)) : 1;
		ratioExtra = (int)ratio * 500;
		totalSalary = ((SALARYBASE * (int)ratio) + ratioExtra);
		
		string = "Total security expenses: " + totalSalary;
		return string; 
		
	}
	
	public String calculateStaffCost() {
		
		String string;
		int totalStaffSalary;
		final int STAFFSALARYBASE;
		double staffRatio;
		
		staffRatio =  (getRooms() > 20)?(Math.ceil((double)getRooms() / 20)) : 1;
		STAFFSALARYBASE = 1000;
		totalStaffSalary = STAFFSALARYBASE * (int)staffRatio;
		
		string = "Total Staff nedded to work " + (int)staffRatio + " and total salary expenses are " + totalStaffSalary;
		
		return string;
		
		 
	}
	
	public String toString() {
		
		String string;
		string = "Building name: " + getName() + "\nAmount of floors: " + getAmountOfFloors() + "\nTotal surface:" + getTotalSurface() + "\nTotal avaible rooms: " + getRooms();
		return string;
	}
	
	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

}
