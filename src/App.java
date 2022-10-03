import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		mainProgram();
		
		/*Cinema cine = new Cinema("cine", 3, 5000);
		Hotel hotel = new Hotel("hotel", 2, 7000, 40);
		Hospital hs = new Hospital("hospital", 2, 1000, 50);
		cine.show(23, 40);
		hotel.show();
		hs.show();*/
		
	}
	
	public static void  mainProgram() {
		
		List <Building> buildingArray = new ArrayList<Building>();
		Scanner sc = new Scanner(System.in);
		boolean programRunnig;
		String choise;
		
		programRunnig = true;
				
		while (programRunnig) {
			
			System.out.println("Select a numeric option between [1 - 4]\n\n[1].Add new building\n[2].Delete a building\n[3].Show building info\n[4].Exit");
			choise = sc.nextLine();
			
			switch (choise) {
			case "1":
				selectTypeOfBuilding(buildingArray);
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			default:
				break;
			}
			
		}
	}
	
	public static void  selectTypeOfBuilding( List<Building> buildingArray) {
		
		Scanner sc = new Scanner(System.in);
		String buildingChoise;

		System.out.println("Select a numeric option between [1 - 3]\n\n[1].Add a Cinema\n[2].Add a Hotel\n[3].Add a hospital");
		buildingChoise = sc.nextLine();
		
		createBuilding(buildingChoise, buildingArray);
			
	}
	
	public static void createBuilding(String choise, List<Building> buildingArray) {
		
		String buildingName;
		int buildingFloors, buildingSurface;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce building name.");
		buildingName = sc.nextLine();
		
		System.out.println("Introduce building amount of floors.");
		buildingFloors = sc.nextInt();
		
		System.out.println("Introduce building total surface.");
		buildingSurface = sc.nextInt();
		
		switch (choise) {
		case "1":
			Cinema newBuilding = new Cinema(buildingName, buildingFloors, buildingSurface);
			buildingArray.add(newBuilding);
			break;
		case "2":
			buildingArray.add(createHotel(buildingName, buildingFloors, buildingSurface));
			break;
		case "3":
			buildingArray.add(createHospital(buildingName, buildingFloors, buildingSurface));
			break;
		default:
			break;
		}
		
	}
	
	public static Building createHotel(String hotelName, int hotelFloors, int hotelSurface) {
		
		Scanner sc = new Scanner(System.in);
		int hotelRooms;
		
		System.out.println("Introduce amount of rooms:");
		hotelRooms = sc.nextInt();
		
		Hotel newHotel = new Hotel(hotelName, hotelFloors, hotelSurface, hotelRooms);
		
		return newHotel;
	}
	

	public static Building createHospital(String hospitalName, int hospitalFloors, int hospitalSurface) {
		
		Scanner sc = new Scanner(System.in);
		int patients;
		
		System.out.println("Introduce amount of rooms:");
		patients= sc.nextInt();
		
		Hospital newHospital = new Hospital(hospitalName, hospitalFloors, hospitalSurface, patients);
		
		return newHospital;
	}
	

}
