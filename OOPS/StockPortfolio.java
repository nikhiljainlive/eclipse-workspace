package OOPS;

public class StockPortfolio
{
	private String stockName;
	private String shareName;
	private int noOfShares;
	private int sharePrice;
	
	public String getShareName() {
		return shareName;
	}
	
	public void setShareName(String shareName) {
		this.shareName = shareName;
	}
	
	public int getNoOfShares() {
		return noOfShares;
	}
	
	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}
	
	public int getSharePrice() {
		return sharePrice;
	}
	
	public void setSharePrice(int sharePrice) {
		this.sharePrice = sharePrice;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
}
