package SoundSystem;

import Exceptions.NoSuchAuthorException;

import java.util.*;
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

        for (Map.Entry<String,List<Track>> entry : songs.entrySet()) {
            String key = entry.getKey();
            List<Track> value = entry.getValue();
            for (Track t : value) {
                if (res.containsKey(t.getRating())){
                    res.get(t.getRating()).add(t.clone());
                }
                else {
                    ArrayList<Track> list = new ArrayList<>();
                    list.add(t.clone());
                    res.put(t.getRating(),list);
                }
            }

        }
        return res;
    }

    /**
     * Another implementation this time with internal iterators
     * @return Map
     */
    public Map<Integer,List<Track>> tracksByRating2() {
        HashMap<Integer,List<Track>> res = new HashMap<>();
        Iterator<Map.Entry<String, List<Track>>> it = songs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String,List<Track>> entry = it.next();
            Iterator<Track> track = entry.getValue().iterator();
            while (track.hasNext()) {
                Track t = track.next();
                if (res.containsKey(t.getRating())) {
                    res.get(t.getRating()).add(t.clone());
                } else {
                    ArrayList<Track> list = new ArrayList<>();
                    list.add(t.clone());
                    res.put(t.getRating(), list);
                }
            }
        }
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
        sb.append("SoundSystem.Playlist name: "+this.name+"\n");
        for(String author : this.songs.keySet()){
            sb.append("Author name: "+author+"\n");
            for(Track t : this.songs.get(author)){
                sb.append("Song name: "+t.getName()+"\n");
            }
        }
        return sb.toString();
    }
}
