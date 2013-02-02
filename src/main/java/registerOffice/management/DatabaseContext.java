package registerOffice.management;

import java.util.ArrayList;
import java.util.List;

import registerOffice.businessObjects.cars.Bike;
import registerOffice.businessObjects.persons.Cyclist;

public class DatabaseContext {

	private static List<Cyclist> persons=new ArrayList<Cyclist>();
	private static List<Bike> cars=new ArrayList<Bike>();
	
	public static List<Cyclist> getPersons() {
		return persons;
	}
	public static List<Bike> getBikes() {
		return cars;
	}
	
	
}
