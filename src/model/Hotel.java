package model;

import model.Room;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String country;
    private String city;
    private int stars;
    private List<Room> rooms = new ArrayList<>();

    public Hotel(String name, String country, String city, int stars) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.stars = stars;
    }

    public Hotel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRooms(Room rooms) { this.rooms.add(rooms); }
}
