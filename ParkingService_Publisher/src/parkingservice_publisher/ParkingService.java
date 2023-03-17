package parkingservice_publisher;

public interface ParkingService {
	public void addVehicle(String name, int quantity);
	public void removeVehicle(String name, int quantity);
	public int getVehicles(String name);
	public void getFreeSlots();
	public void getParkingFee(String name, int mins);
	public void printParkDetailsToCSV();
	public void importDetails();
}
