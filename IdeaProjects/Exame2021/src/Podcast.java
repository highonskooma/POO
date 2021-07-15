import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Podcast {
    String id;                 //identificador do podcast
    List<Episodio> episodios; //lista de episodios

    public Podcast(String id,List<Episodio> episodios) {
        this.id = id;
        this.episodios = episodios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    public Episodio getEpisodio(String idEpisodio) {
        return episodios.stream().filter(ep -> ep.getNome().equals(idEpisodio))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "id='" + id + '\'' +
                ", episodios=\n" + episodios +
                "}";
    }
}
