package newprograms;

public class CPerson 
{
	public String name;
	public long phNumber;
	public int cash;
	public int availableShares;

	public String toString() {
		return "Person [name=" + name + ", phNumber=" + phNumber + ", cash=" + cash + "]";
	}

	public CPerson() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getAvailableShares() {
		return availableShares;
	}

	public void setAvailableShares(int availableShares) {
		this.availableShares = availableShares;
	}

}
