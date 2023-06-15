package BookingHotelDB;

public class Rooms {
    private int room_id;
    private int hotel_id;
    private String room_type;
    private double price;
    private boolean availability;

    public Rooms(int room_id, int hotel_id, String room_type, double price, boolean availability) {
        this.room_id = room_id;
        this.hotel_id = hotel_id;
        this.room_type = room_type;
        this.price = price;
        this.availability = availability;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int id) {
        this.room_id = id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room [room_id=" + room_id + ", hotel_id=" + hotel_id + ", room_type=" + room_type + ", price=" + price + ", availability=" + availability + "]";
    }


}
