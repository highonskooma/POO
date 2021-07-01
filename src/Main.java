import Exceptions.NoSuchAuthorException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchAuthorException {

        ArrayList<String> lyrics = new ArrayList<>();

        String date = "2021-03-08 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        Track t1 = new Track("Akina Speedstar","Xavier Wulf",2.3,5,lyrics,26885420,dateTime);
        Track t2 = new Track("Psycho Pass","Xavier Wulf",2.15,5,lyrics,30885420,dateTime);

        Track t3 = new Track("Spun","Chelsea Wolfe",5.28,5,lyrics,120450,dateTime);
        Track t4 = new Track("Vex","Chelsea Wolfe",3.02,5,lyrics,90400,dateTime);


        Playlist playlist = new Playlist();
        playlist.setName("Favorite songs");
        playlist.addTrack(t1);
        playlist.addTrack(t2);
        playlist.addTrack(t3);
        playlist.addTrack(t4);

        System.out.println(playlist);

        System.out.println("teste1: "+playlist.getTracks("Xavier Wulf"));
        System.out.println("teste2: "+playlist.tempoTotal("Chelsea Wolfe"));
        System.out.println("teste3: "+playlist.allTracks());


    }
}
