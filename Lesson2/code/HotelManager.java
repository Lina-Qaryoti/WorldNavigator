
import java.util.HashMap;
public class HotelManager {
    private HashMap<String,Hotel> hotels;
    public HotelManager() {
        hotels = new HashMap<String,Hotel> ();
    }
    public void createHotel(String hotelName, String hotelType, int numOfRooms){
        if(hotelName == null || hotelType == null || numOfRooms < 0)
            throw new IllegalArgumentException();
        if(!hotels.containsKey(hotelName)) {
            if(hotelType.equalsIgnoreCase("luxury"))
                hotels.put(hotelName, new LuxuryHotel(numOfRooms));
            else if(hotelType.equalsIgnoreCase("budget"))
                hotels.put(hotelName, new BudgetHotel(numOfRooms));
        }
    }
    public boolean book(String hotelName){
        if(hotelName == null || !hotels.containsKey(hotelName))
            return false;
        return hotels.get(hotelName).book();
    }
    public void checkOut(String hotelName){
        if(hotelName == null || !hotels.containsKey(hotelName))
            throw new IllegalArgumentException();
        hotels.get(hotelName).checkOut();
    }
    public int getRoomPrice(String hotelName){
        if(hotelName == null || !hotels.containsKey(hotelName))
            throw new IllegalArgumentException();
        return hotels.get(hotelName).getRoomPrice();
    }
    public int getNumOfAvailableRooms(String hotelName){
        if(hotelName == null || !hotels.containsKey(hotelName))
            throw new IllegalArgumentException();
        return hotels.get(hotelName).getNumOfAvailableRooms();
    }
    public int getNumberOfStars(String hotelName){
        if(hotelName == null || !hotels.containsKey(hotelName))
            throw new IllegalArgumentException();
        return hotels.get(hotelName).getNumberOfStars();
    }
}

