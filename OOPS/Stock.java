package OOPS;

public class Stock 
{
	private String stockName;
	
	@Override
	public String toString()
	{
		StringBuilder details = new StringBuilder();
		details.append("Stockname = "  );
		
		
		return details.toString();
		
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	
}
