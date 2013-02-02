package registerOffice.businessObjects.persons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import registerOffice.Context;
import registerOffice.businessObjects.cars.*;


@Entity
@Table(name = "Kolarze")
@NamedQueries({
	@NamedQuery(
			name="Cyclist.all",
			query="from Cyclist p"
			),
	@NamedQuery(
			name="Cyclist.id",
			query="from Cyclist p where id= :id"
			),
	@NamedQuery(
			name="Cyclist.delete",
			query="Delete from Cyclist p where id=:id"
			)
})
public class Cyclist {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Imie")
	private String name;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.PERSIST)
	private List<Bike> cars;
	
	private String pesel;
	private String address;
	
	@Transient
	Context context;
	
	public Cyclist(String name, String pesel, String address)
	{
		this(name,pesel);
		this.address=address;
	}
	public Cyclist(String name, String pesel)
	{
		context= Context.getInstance();
		context.raisenumberOfPeople();
		this.pesel=pesel;
		this.name=name;
		this.cars=new ArrayList<Bike>();
	}
	
	public Cyclist(String name) {
		
		this(name,"");
	}
	
	public Cyclist()
	{
		
		this("","");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Bike> getBikes() {
		return cars;
	}
	public void setBikes(List<Bike> bikes) {
		this.cars = bikes;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	protected void finalize() throws Throwable {
		context.reducePeople();
		super.finalize();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
