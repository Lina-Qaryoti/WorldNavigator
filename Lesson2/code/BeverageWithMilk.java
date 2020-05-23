
public class BeverageWithMilk extends BeverageWithCondiments {

    public BeverageWithMilk(Beverage beverage){
        super(beverage);
    }

    @Override
    public String getDescription() {
        return "milk, " + beverage.getDescription();
    }

    @Override
    public double getPrice() {
        return 0.2 + beverage.getPrice();
    }
}
