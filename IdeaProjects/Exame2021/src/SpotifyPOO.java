import Exceptions.PodcastNotFoundException;
import Exceptions.UserCurrentlySubscribedException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SpotifyPOO {
    HashMap<String,Podcast> podcasts; //(id podcast,obj podcast)
    HashMap<String,Utilizador> utilizadores; //(id user,user)

    public SpotifyPOO() {
        this.podcasts = new HashMap<>();
        this.utilizadores = new HashMap<>();
    }

    public SpotifyPOO(HashMap<String,Podcast> podcasts,
                      HashMap<String,Utilizador> users) {
        this.podcasts = podcasts;
        this.utilizadores = users;
    }

    public HashMap<String, Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(HashMap<String, Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    public HashMap<String, Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(HashMap<String,Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public List<Episodio> getEpisodios(String nomePodcast) {
        return this.podcasts.get(nomePodcast).getEpisodios();
    }

    /**
     * Adiciona um utilizador ao sistema
     * @param usr
     * @throws UserCurrentlySubscribedException
     */
    public void addUser(Utilizador usr) throws UserCurrentlySubscribedException {
        if (!this.utilizadores.keySet().contains(usr.getId())) this.utilizadores.put(usr.getId(),usr);
        else throw new UserCurrentlySubscribedException();
    }

    /**
     * Adiciona um podcast ao sistema
     * @param podcast
     * @throws PodcastNotFoundException
     */
    public void addPodcast(Podcast podcast) throws PodcastNotFoundException {
        if (!this.podcasts.keySet().contains(podcast.getId())) this.podcasts.put(podcast.getId(),podcast);
        else throw new PodcastNotFoundException();
    }

    /**
     * Remove do sistema o podcast com o ID indicado, não será possivel remocver se o podcast
     * nao existir registado no sistema ou se o mesmo podcast tiver utilizadores que atualmente o
     * estejam a subscrever
     * @param nomeP
     * @throws UserCurrentlySubscribedException
     * @throws PodcastNotFoundException
     */
    public void remove(String nomeP) throws UserCurrentlySubscribedException, PodcastNotFoundException {
        for (Utilizador user : this.utilizadores.values()) {
            if (user.getSubscricoes().stream().anyMatch(a->a.getId().equals(nomeP))) throw new UserCurrentlySubscribedException();
        }
        if (this.podcasts.keySet().contains(nomeP)) this.podcasts.remove(nomeP);
        else throw new PodcastNotFoundException();
    }

    /**
     * devolve o epis´odio mais longo de entre os
     * podcasts que um utilizador tem subscritos.
     * @param u
     * @return
     * @throws NoSuchElementException
     */
    public Episodio getEpisodioMaisLongo(String u) throws NoSuchElementException {
        LocalTime max = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
        Episodio maxEp = null;
        for (Podcast p : this.utilizadores.get(u).getSubscricoes()) {
            Episodio ep = p.getEpisodios().stream().max(Comparator.comparing(Episodio::getDuracao)).orElseThrow(NoSuchElementException::new);
            if (ep.getDuracao().isAfter(max) ) {
                max = ep.getDuracao();
                maxEp = ep;
            }
        }
        return maxEp;
    }
}
