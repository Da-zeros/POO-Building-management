
public class Cinema extends Building{

	private int maximumCapacity;
	
	public Cinema(String name, int amountOfFloors, int totalSurface) {
		super(name, amountOfFloors, totalSurface);
		// TODO Auto-generated constructor stub
		this.maximumCapacity = 100;
	}
	
	
	public String plannedSession(int assistants, int ticketPrice) {
		
		int moneyRaising;
		String string;
		moneyRaising = (assistants <= this.maximumCapacity) ? assistants * ticketPrice : this.maximumCapacity * ticketPrice ;
		string = "Total earnings are " + moneyRaising ;
		return string;
	};
	
	@Override
	public String calculateVigilanceCost() {
		
		String string;
		final int SALARYBASE;
		float ratio;
		int totalSalary;
		
		SALARYBASE = 1300;
		ratio =  (getTotalSurface() > 3000)?(Math.round((float)getTotalSurface() / 3000)) : 1;
		totalSalary = SALARYBASE * (int)ratio;
		
		string = "Total security expenses: " + totalSalary;
		return string; 
	}
	
	public int getMaximumCapacity() {
		return maximumCapacity;
	}

	public void setMaximumCapacity(int maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
	}
	

}
