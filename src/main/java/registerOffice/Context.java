package registerOffice;

public final class Context {

	private int quantityOfBikes;
	private int quantityOfPeople;
	
	private Context() {
	}

	private static Context instance;

	public static Context getInstance() {
		
		if (instance == null)
			synchronized (Context.class) {
				if (instance == null)
					instance = new Context();
			}
		return instance;
	}
	
	public void reduceBikes()
	{
		this.quantityOfBikes--;
	}
	
	public void reducePeople()
	{
		this.quantityOfPeople--;
	}
	public void raiseNumberOfBikes()
	{
		this.quantityOfBikes++;
	}

	public void raisenumberOfPeople()
	{
		this.quantityOfPeople++;
	}
	
	public int getQuantityOfPeople()
	{
		return this.quantityOfPeople;
	}
	public int getQuantity()
	{
		return this.quantityOfBikes;
	}
}
