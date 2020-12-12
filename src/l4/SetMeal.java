package l4;

public class SetMeal {
	String mealName;
	double cost;
	String chickenName;
	Drinks drink;
	
	public SetMeal(String mealName, double cost, String chickenName, Drinks drink) {
		this.mealName=mealName;
		this.cost=cost;
		this.chickenName=chickenName;
		this.drink=drink;
	}
	
	@Override
	public String toString() {
		return "SetMeal {Meal Name is " + this.mealName + "\n cost is " + this.cost + "\n Chicken Name is " + this.chickenName + "\n drink is " + this.drink + "}";
	}
	
}
