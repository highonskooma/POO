import Exceptions.NoSuchAuthorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Playlist {
    private String name;
    private Map<String, List<Track>> songs; //author name, songs

    public Playlist() {
        this.name = "n/a";
        this.songs = new HashMap<String, List<Track>>();
    }

    public Playlist(String name, Map<String, List<Track>> songs) {
        this.name = name;
        this.songs = songs;
    }

    public void addTrack(Track t) {
        if (this.songs.keySet().contains(t.getAuthor())) {
            List<Track> value = this.songs.get(t.getAuthor());
            if (!value.contains(t)) {
                value.add(t);
            }
        }
        else {
            ArrayList<Track> l = new ArrayList<>();
            l.add(t);
            this.songs.put(t.getAuthor(),l);
        }
    }

    public List<String> getTracks(String author) throws NoSuchAuthorException {
        if(this.songs.containsKey(author)){
            return this.songs.get(author).stream().map(Track::getName).collect(Collectors.toList());
        }
        else{
            throw new NoSuchAuthorException(author);
        }
    }

    public double tempoTotal(String author) throws NoSuchAuthorException {
        if(songs.containsKey(author)){
            return songs.get(author).stream().mapToDouble(Track::getDuration).sum();
        }
        else {
            throw new NoSuchAuthorException(author);
        }
    }

    public List<Track> allTracks() {
        ArrayList<Track> res = new ArrayList<>();
        for(List<Track> list : songs.values()){
            res.addAll(list);
        }
        return res;
    }

    public Map<Integer,List<Track>> tracksByRating() {
        HashMap<Integer,List<Track>> res = new HashMap<>();


        return res;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSongs(Map<String, List<Track>> songs) {
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Track>> getSongs() {
        return songs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist name: "+this.name+"\n");
        for(String author : this.songs.keySet()){
            sb.append("Author name: "+author+"\n");
            for(Track t : this.songs.get(author)){
                sb.append("Song name: "+t.getName()+"\n");
            }
        }
        return sb.toString();
    }
}
