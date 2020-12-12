package l4;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant{
	double balance;
	LinkedList<Beer> beers=new LinkedList<Beer>();
	LinkedList<Juice> juices=new LinkedList<Juice>();
	static LinkedList<SetMeal> meals=new LinkedList<SetMeal>();
	
	public West2FriedChickenRestaurant(double balance, LinkedList<Beer> beers, LinkedList<Juice> juices) {
		this.balance=balance;
		this.beers=beers;
		this.juices=juices;
		
	}
	
	private void use(Beer beer) {
		boolean sellout=true;
		Iterator<Beer> it=beers.iterator();
		while(it.hasNext()) {
			if(beer==it.next()) {
				sellout=false;
				if(beer.isOverDue()) {
					System.out.println("The beer is overdue.");
				} else {
					beers.remove(it.next());
				}
				break;
			}
		}
		if(sellout) {
			throw new IngredientSortOutException("The beer has been sold out.");
		}
	}
	
	private void use(Juice juice) {
		boolean sellout=true;
		Iterator<Juice> it=juices.iterator();
		while(it.hasNext()) {
			if(juice==it.next()) {
				sellout=false;
				if(juice.isOverDue()) {
					System.out.println("The juice is overdue.");
				} else {
					juices.remove(it.next());
				}
				break;
			}
		}
		if(sellout) {
			throw new IngredientSortOutException("The juice has been sold out.");
		}
	}
	
	public void sellMeal(SetMeal meal) {
		Iterator<SetMeal> it=meals.iterator();
		while(it.hasNext()) {
			if(meal==it.next()) {
				if(it.next().drink instanceof Beer) {
					use((Beer)(it.next().drink));
				} else {
					use((Juice)(it.next().drink));
				}
			}
		}
	}
	
	public void purchase(Drinks drink) {
		if(drink instanceof Beer) {
			if(drink.cost<=balance) {
				beers.add((Beer)drink);
			} else {
				throw new OverdraftBalanceException("The purchase cost is over the balance.");
			}
		} else {
			if(drink.cost<=balance) {
				juices.add((Juice)drink);
			} else {
				throw new OverdraftBalanceException("The purchase cost is over the balance.");
			}
		}
	}
}
