package BookingHotelDB;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Hotel_DB {

    private DataSource dataSource;

    public Hotel_DB(DataSource theDataSource) {
        dataSource = theDataSource;
    }
    private static final String DB_URL = "jdbc:mysql://localhost:8080/HOTEL_BOOKING_DB";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public List<Hotel> getHotels() {
        List<Hotel> hotels = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM hotels")) {

            while (resultSet.next()) {
                int hotelId = resultSet.getInt("hotel_id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                double rating = resultSet.getDouble("rating");
                String facilities = resultSet.getString("facilities");

                Hotel hotel = new Hotel(hotelId, name, address, city, country, rating, facilities);
                hotels.add(hotel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotels;
    }
    public Hotel getHotelById(int hotelId) {
        Hotel hotel = null;

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM hotels WHERE hotel_id = ?")) {

            statement.setInt(1, hotelId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                double rating = resultSet.getDouble("rating");
                String facilities = resultSet.getString("facilities");

                hotel = new Hotel(hotelId, name, address, city, country, rating, facilities);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotel;
    }
    public List<Rooms> getRoomsByHotelId(int hotelId) {
        List<Rooms> rooms = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM rooms WHERE hotel_id = ?")) {

            statement.setInt(1, hotelId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int roomId = resultSet.getInt("room_id");
                String roomType = resultSet.getString("room_type");
                double price = resultSet.getDouble("price");
                boolean availability = resultSet.getBoolean("availabiliti");

                Rooms room = new Rooms(roomId, hotelId, roomType, price, availability);
                rooms.add(room);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }

    public List<Hotel> searchHotelsByName(String hotelName) {
        List<Hotel> hotels = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM hotels WHERE name LIKE ?")) {

            statement.setString(1, "%" + hotelName + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int hotelId = resultSet.getInt("hotel_id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                double rating = resultSet.getDouble("rating");
                String facilities = resultSet.getString("facilities");

                Hotel hotel = new Hotel(hotelId, name, address, city, country, rating, facilities);
                hotels.add(hotel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotels;
    }

    public void bookRoom(int roomId, int userId, Date checkInDate, Date checkOutDate, int numGuests, double totalPrice) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO reservations (room_id, user_id, check_in_date, check_out_date, num_guests, total_price) VALUES (?, ?, ?, ?, ?, ?)")) {

            statement.setInt(1, roomId);
            statement.setInt(2, userId);
            statement.setDate(3, checkInDate);
            statement.setDate(4, checkOutDate);
            statement.setInt(5, numGuests);
            statement.setDouble(6, totalPrice);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
