package BookingHotelDB;

import BookingHotelDB.Hotel;
import BookingHotelDB.Hotel_DB;
import BookingHotelDB.Rooms;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/HotelServlet")
@MultipartConfig
public class HotelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Hotel_DB hotelDB;

    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            hotelDB = new Hotel_DB(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                listHotels(request, response);
            } else {
                switch (theCommand) {
                    case "DETAILS":
                        loadHotelDetails(request, response);
                        break;
                    case "SEARCH":
                        searchHotels(request, response);
                        break;
                    case "BOOK":
                        bookRoom(request, response);
                        break;
                    default:
                        listHotels(request, response);
                }
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listHotels(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Hotel> hotels = hotelDB.getHotels();
        request.setAttribute("HOTEL_LIST", hotels);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage.jsp");
        dispatcher.forward(request, response);
    }

    private void loadHotelDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int hotelId = Integer.parseInt(request.getParameter("hotel_id"));
        Hotel hotel = hotelDB.getHotelById(hotelId);
        List<Rooms> rooms = hotelDB.getRoomsByHotelId(hotelId);

        request.setAttribute("HOTEL", hotel);
        request.setAttribute("ROOMS", rooms);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel-details.jsp");
        dispatcher.forward(request, response);
    }

    private void searchHotels(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("search");
        List<Hotel> hotels = hotelDB.searchHotelsByName(searchQuery);
        request.setAttribute("HOTEL_LIST", hotels);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage.jsp");
        dispatcher.forward(request, response);
    }

    private void bookRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roomId = Integer.parseInt(request.getParameter("room_id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        Date checkInDate = Date.valueOf(request.getParameter("check_in_date"));
        Date checkOutDate = Date.valueOf(request.getParameter("check_out_date"));
        int numGuests = Integer.parseInt(request.getParameter("num_guests"));
        double totalPrice = Double.parseDouble(request.getParameter("total_price"));

        hotelDB.bookRoom(roomId, userId, checkInDate, checkOutDate, numGuests, totalPrice);

        response.sendRedirect(request.getContextPath() + "/booking-success.jsp");
    }
}
