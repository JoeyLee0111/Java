package l4;

import java.time.LocalDate;

public class Juice extends Drinks{
	public Juice(String name, double cost, LocalDate productDate, int exp) {
		super(name, cost, productDate, exp);
		exp=2;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Name: "+this.name+"\n"+"Cost: "+this.cost+"\n"+"Date: "+this.productDate+"\n"+"Expiration time: "+this.exp;
	}
	

}
