package sg.edu.rp.c346.id21021749.nationaldaythemesong;

import java.io.Serializable;

public class song implements Serializable {

    private int id;
    private String title;
    private String singers;
    private int year;
    private int rating;


    public song(int id, String title, String singers, int year, int rating) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.rating = rating;
    }

    public int get_id() {
        return id;
    }

    public String getTitle() {

        return title;
    }
    public String getSingers() {

        return singers;
    }
    public int getYear() {

        return year;
    }
    public int getRating() {

        return rating;
    }
    public String setTitle(String title) {

        return title;
    }
    public String setSinger(String singers) {

        return singers;
    }

    public int setYear(String toString) {

        return year;
    }

    public int setRating (int rating) {
        return rating;
    }

    @Override
    public String toString() {
        return "song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", singers='" + singers + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}