
public class BudgetHotel extends Hotel {

    public BudgetHotel(int numOfRooms){
        super(numOfRooms);
    }

    @Override
    public int getRoomPrice() {
        return 200;
    }

    @Override
    public int getNumberOfStars() {
        return 1;
    }
}

