
public abstract class Hotel {
    private int numOfAvailableRooms;

    protected Hotel(int numOfRooms){
        if(numOfRooms < 0)
            throw new IllegalArgumentException();
        this.numOfAvailableRooms = numOfRooms;
    }

    public boolean book() {
        if(numOfAvailableRooms == 0)
            return false;
        numOfAvailableRooms--;
        return true;
    }

    public void checkOut() {
        numOfAvailableRooms++;
    }

    public int getNumOfAvailableRooms() {
        return numOfAvailableRooms;
    }

    public abstract int getRoomPrice();
    public abstract int getNumberOfStars();
}

