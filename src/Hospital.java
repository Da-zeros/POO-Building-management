
public class Hospital extends Building{

	private int patients;
	
	

	public Hospital(String name, int amountOfFloors, int totalSurface, int patients) {
		super(name, amountOfFloors, totalSurface);
		// TODO Auto-generated constructor stub
		setPatients(patients);
	}
	
	public void show() {

		super.show();
		System.out.println(foodDelivering());
	}
	
	public String foodDelivering() {
		
		int foodRations; 
		String string;
		
		foodRations = this.patients * 3;
		string = "We are distribuiting " + foodRations + " rations of food" ;
		
		return string;
	}
	
	public String calculateVigilanceCost() {
		
		return super.calculateVigilanceCost();
	}
	
	public String toString() {
		
		String string;
		string = "Building name: " + getName() + "\nAmount of floors: " + getAmountOfFloors() + "\nTotal surface:" + getTotalSurface() + "\nTotal amount of patients: " + getPatients();
		return string;
	}
	
	public int getPatients() {
		return patients;
	}

	public void setPatients(int patients) {
		this.patients = patients;
	}
	
	
	
}
