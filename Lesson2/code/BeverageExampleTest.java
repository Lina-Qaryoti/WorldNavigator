
public class BeverageExampleTest {

    public static void main(String[] args){
        Beverage beverage1 = new EspressoBeverage();
        Beverage beverage2 = new BeverageWithCaramel(beverage1);
        System.out.println(beverage1.getDescription());
        System.out.println(beverage2.getDescription());

        Beverage beverage3 = new AmericanoBeverage();
        Beverage beverage4 = new BeverageWithMilk(beverage3);
        beverage4 = new BeverageWithMilk(beverage4);
        beverage4 = new BeverageWithCaramel(beverage4);
        System.out.println(beverage3.getDescription());
        System.out.println(beverage4.getDescription());

    }
}
