package l4;

import java.time.LocalDate;

public class Beer extends Drinks{
	private float alcoholDegree;
	public Beer(String name, double cost, LocalDate productDate, int exp, float alcoholDegree) {
		super(name, cost, productDate, exp);
		alcoholDegree=this.alcoholDegree;
		exp=30;
		}
	public String toString() {
		return "Name: "+this.name+"\n"+"Cost: "+this.cost+"\n"+"Product date: "+this.productDate+"\n"+"Expiration time: "+this.exp;
	}	
	
}
