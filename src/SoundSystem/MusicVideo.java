package SoundSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MusicVideo extends Track implements Playable {
    private String video;

    public MusicVideo(String name, String author, double duration, int rating,
                      ArrayList<String> lyrics, int timesPlayed, LocalDateTime lastPlayed, String video) {
        super(name,author,duration,rating,lyrics,timesPlayed,lastPlayed);
        this.video = video;
    }

    public void play() {
        super.play();
    }


}
