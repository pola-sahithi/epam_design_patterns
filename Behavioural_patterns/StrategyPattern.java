import java.util.ArrayList;
import java.util.List;

class Cart {
	 
	List<Item> items;
	public Cart() {
		this.items=new ArrayList<Item>();
	}
	public void addItem(Item item) {
		this.items.add(item);
	}
	public void removeItem(Item item) {
		this.items.remove(item);
	}
	public double calculateTotal() {
		double sum=0;
		for(Item item:items) {
			sum+=item.getPrice();
		}
		return sum;
	}
	public void payAmount(Payment type) {
		double amount = calculateTotal();
		type.pay(amount);
	}
}

class CreditCard implements Payment{
	
	private String nameOfTheCardholder;
	private String cardNumber;
	private String cvvCode;
	private String dateOfExpiry;
	
	public CreditCard(String nameOfTheCardholder,String cardNumber,String cvvCode,String dateOfExpiry) {
		this.cardNumber=cardNumber;
		this.cvvCode=cvvCode;
		this.dateOfExpiry=dateOfExpiry;
		this.nameOfTheCardholder=nameOfTheCardholder;
	}
	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Amount paid by "+nameOfTheCardholder+" using credit card is : "+ amount);
	}

}
class Item {
private String barCode;
private double price;
public Item(String barCode,double price) {
	this.barCode=barCode;
	this.price=price;
}
public String getBarCode() {
	return barCode;
}
public double getPrice() {
	return price;
}
}

 interface Payment {
public void pay(double amount);
}


class UPI implements Payment {
	private String upiId;
	private String pin;
    private String name;

	public UPI(String upiId,String pin,String name) {
		this.pin=pin;
		this.upiId=upiId;
        this.name=name;
	}
	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Amount paid by "+name+" using UPI is : "+ amount);
		
	}

}
class StrategyPattern {
public static void main(String[] args) {
	Cart cart = new Cart();
	Item item1 = new Item("376534",66.3);
	Item item2 = new Item("545324",40.09);
	cart.addItem(item1);
	cart.addItem(item2);
	cart.payAmount(new CreditCard("Pushpa","21344676783443","345","10/25"));
	cart.payAmount(new UPI("9348453934@apl","1678","Pushpa "));
}
}