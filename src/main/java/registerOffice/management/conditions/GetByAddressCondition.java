package registerOffice.management.conditions;

import registerOffice.businessObjects.cyclists.Cyclist;

public class GetByAddressCondition extends Condition<Cyclist>{

	private String address;
	
	public GetByAddressCondition(String address)
	{
		this.address=address;
	}
	@Override
	protected boolean check(Cyclist obj) {
		// TODO Auto-generated method stub
		return obj.getAddress().equalsIgnoreCase(address);
	}

}
