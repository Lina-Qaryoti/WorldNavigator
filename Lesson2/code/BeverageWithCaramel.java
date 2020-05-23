
public class BeverageWithCaramel extends BeverageWithCondiments {

    public BeverageWithCaramel(Beverage beverage){
        super(beverage);
    }

    @Override
    public String getDescription() {
        return "caramel, " + beverage.getDescription();
    }

    @Override
    public double getPrice() {
        return 0.5 + beverage.getPrice();
    }
}
