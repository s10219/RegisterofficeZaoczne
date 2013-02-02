package registerOffice;

import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import registerOffice.businessObjects.cars.Bike;
import registerOffice.businessObjects.cars.CyclistBike;
import registerOffice.businessObjects.cars.Tandem;
import registerOffice.businessObjects.persons.*;
import registerOffice.management.*;
import registerOffice.management.conditions.Condition;
import registerOffice.management.conditions.GetByAddressCondition;
import registerOffice.management.conditions.GetByNameCondition;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		ManagerInterface<Cyclist> hib= 
				new HibernateCyclistManager(session);
				
		//definicja kolarzy
		Cyclist JMJ = new Cyclist("Jean Michelle Jarre", "1234", "Pola Elizejskie 55");
		Cyclist Napo = new Cyclist("Napoleon", "4567", "Brzegi 35");
		Cyclist Jean = new Cyclist("Jean Reno", "1157", "Rondo De Gaulle'a 1/15");
		Cyclist deGaulle = new Cyclist("Charles De Gaulle", "4687", "Rondo");
		
		//definicja rowerow
		Bike romet = new CyclistBike("Romet","sniezna biel");
		Bike wigry = new CyclistBike("Wigry 3","lsniace srebro");
		Bike trek = new CyclistBike("Trek 3000","czerń nocy");
		
		//nadanie wlascicieli
		romet.setOwner(JMJ);
		wigry.setOwner(Jean);
		trek.setOwner(deGaulle);
		
		//przypisanie roweru do kolarza
		JMJ.getBikes().add(romet);
		Napo.getBikes().add(wigry);
		Jean.getBikes().add(romet);
		deGaulle.getBikes().add(trek);
		
		hib.save(JMJ);
		hib.save(Napo);
		hib.save(Jean);
		hib.save(deGaulle);
		
		List<Cyclist>results = hib.getAll();
		
		for(Cyclist p :results)
		{
			System.out.println(p.getName());
		}
		
	}

}
