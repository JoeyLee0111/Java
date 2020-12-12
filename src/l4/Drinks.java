package l4;

import java.time.LocalDate;
import java.time.Period;

public abstract class Drinks {
	String name;
	double cost;
	LocalDate productDate;
	int exp;
	
	public Drinks(String name, double cost, LocalDate productDate, int exp) {
		this.name=name;
		this.cost=cost;
		this.productDate=productDate;
		this.exp=exp;
	}
	public boolean isOverDue() {
		LocalDate first = LocalDate.now();
		Period beetween=Period.between(first, productDate);
		if(beetween.getDays()>exp) {
			return false;
		} else {
			return true;
		}
	}
	
	public abstract String toString();

}
