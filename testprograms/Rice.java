package testprograms;

public class Rice
{
	private String name;
	private int weight;
	private int price;

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ").append(name)
		.append("\nWeight: ").append(weight)
		.append("\nPrice : ").append(price)
		.append("\n");
		
		return sb.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getTotal() {
		
		return (weight*price);
	}
}
