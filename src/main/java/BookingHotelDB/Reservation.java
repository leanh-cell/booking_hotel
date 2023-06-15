package BookingHotelDB;

import java.sql.Date;

public class Reservation {
    private int reservation_id;
    private int room_id;
    private int user_id;
    private Date check_in_date;
    private Date check_out_date;
    private int num_guests;
    private double total_price;

    public Reservation(int reservation_id, int room_id, int user_id, Date check_in_date, Date check_out_date, int num_guests, double total_price) {
        this.reservation_id = reservation_id;
        this.room_id = room_id;
        this.user_id = user_id;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.num_guests = num_guests;
        this.total_price = total_price;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(Date check_in_date) {
        this.check_in_date = check_in_date;
    }

    public Date getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(Date check_out_date) {
        this.check_out_date = check_out_date;
    }

    public int getNum_guests() {
        return num_guests;
    }

    public void setNum_guests(int num_guests) {
        this.num_guests = num_guests;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Reservation [reservation_id=" + reservation_id + ", room_id=" + room_id + ", user_id=" + user_id +
                ", check_in_date=" + check_in_date + ", check_out_date=" + check_out_date + ", num_guests=" +
                num_guests + ", total_price=" + total_price + "]";
    }
}
