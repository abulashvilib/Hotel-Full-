import model.Hotel;
import model.Room;

import java.util.ArrayList;
import java.util.List;

public class Filter {


    public static List<Hotel> filterHotels(String country, String city, int stars, double price, String type, List<Hotel> hotelList) {
        List<Hotel> filteredHotels = new ArrayList<>();
        List<Room> filteredRooms = new ArrayList<>();

        for (Hotel hotel : hotelList) {
            if (country.equals(hotel.getCountry()) &&
                    city.equals(hotel.getCity()) &&
                    stars == hotel.getStars()) {
                filteredHotels.add(hotel);
            }
        }

        for (Hotel hotel1 : filteredHotels) {
            for (Room room : hotel1.getRooms()) {
                if (price == room.getPrice() &&
                        type.equals(room.getType())) {
                    filteredRooms.add(room);
                }
            }
            hotel1.setRooms(filteredRooms);
        }

        return filteredHotels;
    }
}
