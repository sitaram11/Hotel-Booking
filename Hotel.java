import javax.swing.*;
import java.util.ArrayList;

public class Hotel {
    private String name;
    private String photo;
    private double rating;
    private ArrayList<String> comments = new ArrayList<>();
    private ArrayList<Double> ratings = new ArrayList<>();
    private String location;
    private double price;

    public Hotel(String name, String photo, double rating, String location, double price) {
        this.name = name;
        this.photo = photo;
        this.rating = rating;
        this.location = location;
        this.price = price;
    }

    public String getName() { return name; }
    public String getPhoto() { return photo; }
    public double getRating() { return rating; }
    public String getLocation() { return location; }
    public double getPrice() { return price; }

    public void book(String username) {
        JOptionPane.showMessageDialog(null, username + " booked " + name + " successfully!");
        LoginFrame.reservations.get(username).addReservation(this);
    }

    public void addComment(String comment, double rating) {
        comments.add(comment);
        ratings.add(rating);
        updateRating();
    }

    private void updateRating() {
        double sum = 0;
        for (double r : ratings) sum += r;
        this.rating = ratings.size() == 0 ? 0 : sum / ratings.size();
    }

    public String getComments() {
        if (comments.isEmpty()) return "No comments yet";
        return String.join(", ", comments);
    }
}
