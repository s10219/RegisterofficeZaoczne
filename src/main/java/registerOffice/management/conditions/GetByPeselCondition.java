package registerOffice.management.conditions;

import registerOffice.businessObjects.cyclists.Cyclist;

public class GetByPeselCondition extends Condition<Cyclist>{

	private String pesel;
	
	public GetByPeselCondition(String pesel)
	{
		this.pesel=pesel;
	}
	
	@Override
	protected boolean check(Cyclist obj) {
		
		return obj.getPesel().equalsIgnoreCase(pesel);
	}

}
