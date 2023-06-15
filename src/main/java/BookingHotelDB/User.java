package BookingHotelDB;

public class User {
    private int user_id;
    private String username;
    private String email;
    private String password;
    private String phone_number;

    public User(int user_id, String username, String email, String password, String phone_number) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", username=" + username + ", email=" + email + ", password=" + password + ", phone_number=" + phone_number + "]";
    }
}