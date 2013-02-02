package registerOffice.businessObjects.bikes;

import javax.persistence.Entity;


@Entity
public class CyclistBike extends Bike{

	//pole statyczne
	
	//pola prywatne
	
	
	
	private String mark;
	private String frameColor;
	
	//pola publiczne
	
	//konstruktory
	public CyclistBike(String mark, String color)
	{
		this.mark=mark;
		this.frameColor=color;
	}
	
	public CyclistBike()
	{
		this("","");
	}
	
	//wlasciwosci
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getRegisterNumber() {
		return frameColor;
	}

	public void setRegisterNumber(String registerNumber) {
		this.frameColor = registerNumber;
	}
	
	//metody
	

	@Override
	public String getBikeDetails() {
		// TODO Auto-generated method stub
		return mark+" "+frameColor;
	}

	@Override
	public Bike Clone() {
		
		CyclistBike returnValue =new CyclistBike();
		returnValue.setRegisterNumber(this.frameColor);
		
		return returnValue;
	}
}
