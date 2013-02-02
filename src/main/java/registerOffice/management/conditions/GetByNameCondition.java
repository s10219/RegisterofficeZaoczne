package registerOffice.management.conditions;

import registerOffice.businessObjects.persons.Cyclist;

public class GetByNameCondition extends Condition<Cyclist>{

	private String name;
	
	public GetByNameCondition(String name)
	{
		this.name=name;
	}
	
	@Override
	protected boolean check(Cyclist obj) {
		
		return obj.getName().equalsIgnoreCase(name);
	}
	
	

}
