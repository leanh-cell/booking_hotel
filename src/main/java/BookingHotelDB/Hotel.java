package BookingHotelDB;

public class Hotel {
    private int hotel_id;
    private String name;
    private String address;
    private String city;
    private String country;
    private double rating;
    private String facilities;

    public Hotel(int hotel_id, String name, String address, String city, String country, double rating, String facilities) {
        this.hotel_id = hotel_id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.rating = rating;
        this.facilities = facilities;

    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int id) {
        this.hotel_id = hotel_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "Student [hotel_id= " + hotel_id + ", name= " + name + ", address= " + address + ", city= " + city + ", country= " + country + ", rating= " + rating + ", facilities= " + facilities + "]";
    }
}
