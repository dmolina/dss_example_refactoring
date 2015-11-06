package org.uca.dss.refactor.examplebook;

import java.util.Enumeration;
import java.util.Vector;

class  Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();
	public Customer (String name){
		_name = name;
	}
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	public String getName (){
		return _name;
	}

	public String getBill() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		
		for(Rental each: _rentals) {
			totalAmount += each.getAmount();
			frequentRenterPoints = each.incremFrequentPoints(frequentRenterPoints);
			//show figures for this rental
			result 
			+= "\t" + each.getMovie().getTitle()+ "\t" +
					String.valueOf(each.getAmount()) + "\n";
		}
		//add footer lines
		result +=  "Amount owed is " + String.valueOf(totalAmount) +"\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) 
				+" frequent renter points";

		return result;
	}
}
