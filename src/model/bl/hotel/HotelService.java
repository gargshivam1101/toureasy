package model.bl.hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.entity.Hotel;
import model.entity.Person;

public class HotelService {
	static List<Hotel> hotelList = new ArrayList<>(Arrays.asList(//
			new Hotel("Radisson", "avenue lincoln",
					new Person("SS", "GG", null, "123456678", "hmanager@gmail.com", null), "Montreal", 50, 499)));

	public static List<Hotel> getHotelList() {
		return hotelList;
	}

	public static void putHotelList(Hotel hotel) {
		hotelList.add(hotel);
	}

	public static void removeHotelList(Hotel hotel) {
		hotelList.remove(hotel);
	}

	public static Hotel getHotelById(Integer hotelId) {
		return hotelList.stream().filter(h -> hotelId == h.getHotelId()).findFirst().orElse(null);
	}
}
