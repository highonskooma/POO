package SoundSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Track implements Playable {
    private String name;
    private String author;
    private double duration;
    private int rating;
    private ArrayList<String> lyrics;
    private int timesPlayed;
    private LocalDateTime lastPlayed;

    public Track() {
        this.name = "n/a";
        this.author = "n/a";
        this.duration = 0;
        this.rating = 0;
        this.lyrics = new ArrayList<>();
        this.timesPlayed = 0;
        this.lastPlayed = LocalDateTime.now();
    }

    public Track(String name, String author, double duration, int rating,
                 ArrayList<String> lyrics, int timesPlayed, LocalDateTime lastPlayed){
        this.name = name;
        this.author = author;
        this.duration = duration;
        this.rating = rating;
        this.lyrics = lyrics;
        this.timesPlayed = timesPlayed;
        this.lastPlayed = lastPlayed;
    }

    public Track(Track t) {
        this.name = t.getName();
        this.author = t.getAuthor();
        this.duration = t.getDuration();
        this.rating = t.getRating();
        this.lyrics = t.getLyrics();
        this.timesPlayed = t.getTimesPlayed();
        this.lastPlayed = t.getLastPlayed();

    }

    public void play() {

    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getDuration() {
        return duration;
    }

    public int getRating() {
        return rating;
    }

    public ArrayList<String> getLyrics() {
        return lyrics;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public LocalDateTime getLastPlayed() {
        return lastPlayed;
    }

    //Compare by times played
    public int compareTo(Track t) {
        int tp = t.getTimesPlayed();
        int res = 0;
        if (this.timesPlayed == tp) return 0;
        else if (this.timesPlayed > tp) {
            res = 1;
        } else res = -1;
        return res;
    }

    //Compare by last time played
    public int compareToLastPlayed(Track t) {
        LocalDateTime last = t.getLastPlayed();
        if (last == this.lastPlayed) return 0;
        if (last.isBefore(this.lastPlayed)) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return "{ name='" + name + '\'' +
                ", author='" + author + '\'' +
                " }\n";
    }

    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || this.getClass() != o.getClass()) return false;

        Track t = (Track) o;
        return name.equals(t.getName()) &&
                author.equals(t.getAuthor()) &&
                duration == t.getDuration() &&
                rating == t.getRating() &&
                lyrics.equals(t.getLyrics()) &&
                timesPlayed == t.getTimesPlayed() &&
                lastPlayed.equals(t.getLastPlayed());
    }

    public Track clone() {
        return new Track(this);
    }
}
