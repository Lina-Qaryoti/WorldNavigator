
public class HotelClient {

    public static void main(String[] args){
        HotelManager hotelManager = new HotelManager();

        hotelManager.createHotel("Sheraton","luxury", 200);
        hotelManager.createHotel("Marriot", "luxury", 300);
        hotelManager.createHotel("Amman","budget", 20);
        hotelManager.createHotel("Zarqa","budget", 25);

        System.out.println(hotelManager.getNumberOfStars("Sheraton"));
        System.out.println(hotelManager.getNumberOfStars("Marriot"));
        System.out.println(hotelManager.getNumberOfStars("Amman"));
        System.out.println(hotelManager.getNumberOfStars("Zarqa"));

        System.out.println(hotelManager.book("Marriot"));
        System.out.println(hotelManager.book("Zarqa"));
        System.out.println(hotelManager.book("Zarqa"));
        System.out.println(hotelManager.book("Sheraton"));
        System.out.println(hotelManager.book("Sheraton"));
        System.out.println(hotelManager.book("Sheraton"));
        System.out.println(hotelManager.book("Sheraton"));

        System.out.println(hotelManager.getNumOfAvailableRooms("Sheraton"));
        System.out.println(hotelManager.getNumOfAvailableRooms("Marriot"));
        System.out.println(hotelManager.getNumOfAvailableRooms("Amman"));
        System.out.println(hotelManager.getNumOfAvailableRooms("Zarqa"));
    }
}

