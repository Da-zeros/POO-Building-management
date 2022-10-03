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
				showBuildings(buildingArray);
				delBuilding(buildingArray);
				break;
			case "3":
				showBuildings(buildingArray);
				showBuildingInfo(buildingArray);
				break;
			case "4":
				programRunnig=false;
				break;
			default:
				System.out.println("Option out of range");
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
			System.out.println("Option out of range.");
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
		
		System.out.println("Introduce amount of patients:");
		patients= sc.nextInt();
		
		Hospital newHospital = new Hospital(hospitalName, hospitalFloors, hospitalSurface, patients);
		
		return newHospital;
	}
	
	public static int checkIfExists(List<Building> buildingList) {
		
		Scanner sc = new Scanner(System.in);
		boolean buildingExists = false;
		int index, arraySize, buildingIndex;
		String buildingName;
		
		arraySize =  buildingList.size();
		index = 0;
		
		System.out.println("Insert the building name:");
		buildingName = sc.nextLine();
		
		while(index < arraySize && !buildingExists) {
			
			buildingExists = (buildingName.equals( buildingList.get(index).getName() ) ) ? true : false;

			index++;
		}
		
		buildingIndex = ( buildingExists ) ? index -1: -1;
		
		return buildingIndex; 
		
	}
	
	public static void showBuildings(List<Building> buildingList) {
		
		System.out.println("Existing buildings");
		if(buildingList.size() > 0) {
			for (Building build : buildingList) {
				System.out.println(build.getName());
			}
		}else buildingList.get(0).getName();
		
	}
	
	public static void delBuilding(List<Building> buildingList) {
		int index;
		index = checkIfExists(buildingList);
		
		if( index != -1)buildingList.remove(index);
		else System.out.println("The building does't,'exist");
	}
	
	public static void showBuildingInfo(List<Building> buildingList) {
		
		Cinema cinema;
		Building building;
		int index, ticketPrice, customers;
		Scanner sc = new Scanner(System.in);;
		
		index = checkIfExists(buildingList);
		
		building = ( index != -1)?buildingList.get(index):null;
		
		if(building!=null) {
			
			if( building instanceof Cinema) {
				
				cinema = (Cinema) building;
				System.out.println("how many costumers per session");
				customers = sc.nextInt();
				System.out.println("how much the ticket costs");
				ticketPrice = sc.nextInt();
				cinema.show();
				System.out.println(cinema.plannedSession(customers, ticketPrice));
				

			}else {
				building.show();
			}
		}else System.out.println("The building does't,'exist");
		
	}
	

}
