package registerOffice.businessObjects.bikes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import registerOffice.Context;
import registerOffice.businessObjects.cyclists.Cyclist;

@Entity
public abstract class Bike implements BikeInterface{

	@Id
	@GeneratedValue
	private int id;
	
	
	@ManyToOne
	protected Cyclist owner;
	
	@Transient
	Context context;
	public Bike(){
		context =Context.getInstance();
		context.raiseNumberOfBikes();
	}
	
	public void printData()
	{
		System.out.println("Owner: "+owner.getName());
		System.out.println(getBikeDetails());
	}
	
	public abstract String getBikeDetails();
	
	public abstract Bike Clone();
	
	public void setOwner(Cyclist owner)
	{
		this.owner=owner;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	protected void finalize() throws Throwable {
		context.reduceBikes();
		super.finalize();
	}
	
}
