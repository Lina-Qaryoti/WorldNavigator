
public abstract class BeverageWithCondiments extends Beverage {

    protected Beverage beverage;

    protected BeverageWithCondiments(Beverage beverage){
        this.beverage = beverage;
    }

    public abstract String getDescription();
    public abstract double getPrice();

}

