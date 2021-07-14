import Exceptions.PodcastNotFoundException;
import Exceptions.UserCurrentlySubscribedException;

import java.sql.Array;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws PodcastNotFoundException, UserCurrentlySubscribedException {
        LocalTime time1 = LocalTime.parse("02:24:55", DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime time2 = LocalTime.parse("00:55:29", DateTimeFormatter.ofPattern("HH:mm:ss"));

        ArrayList<String> content = new ArrayList<>();

        Episodio e1 = new Episodio("Episode 1", time1, 78, content, 356, LocalDateTime.now());
        Episodio e2 = new Episodio("Episode 2", time2, 91, content, 560, LocalDateTime.now());
        Episodio e3 = new Episodio("Episode 3", time1, 48, content, 150, LocalDateTime.now());
        Episodio e4 = new Episodio("Episode 4", time2, 80, content, 4561, LocalDateTime.now());

        ArrayList<Episodio> list1 = new ArrayList<>();
        list1.add(e1);list1.add(e2);list1.add(e3);
        ArrayList<Episodio> list2 = new ArrayList<>();
        list2.add(e4);

        Podcast p1 = new Podcast("Podcast 1",list1);
        Podcast p2 = new Podcast("Podcast 2",list2);

        ArrayList<Podcast> listPodcast1 = new ArrayList<>();
        listPodcast1.add(p1);
        ArrayList<Podcast> listPodcast2 = new ArrayList<>();
        listPodcast2.add(p1);
        listPodcast2.add(p2);

        Utilizador u1 = new Utilizador("mariajoao99","Mary Jane",listPodcast1);
        Utilizador u2 = new Utilizador("joaomiguel2000","João Miguel",listPodcast2);

        SpotifyPOO SPOO = new SpotifyPOO();
        SPOO.addPodcast(p1);
        SPOO.addPodcast(p2);
        SPOO.addUser(u1);
        SPOO.addUser(u2);

        System.out.println("Episodio mais longo: "+SPOO.getEpisodioMaisLongo(u2.getId()));
        try {
            SPOO.remove(p2.getId());
        } catch (UserCurrentlySubscribedException e) {};

        System.out.println(p1);
    }
}
