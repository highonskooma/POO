import Exceptions.AlreadyPlayingException;

import java.util.List;

public class Utilizador {
    private String id;
    private String nome;
    private List<Podcast> subscricoes; //podcasts a q o user está subscrito
    private Episodio isPlaying; //boleano que assinala se o user esta a reproduzir conteudo

    public Utilizador(String id, String nome, List<Podcast> subscricoes) {
        this.id = id;
        this.nome = nome;
        this.subscricoes = subscricoes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Podcast> getSubscricoes() {
        return subscricoes;
    }

    public void setSubscricoes(List<Podcast> subscricoes) {
        this.subscricoes = subscricoes;
    }

    public Episodio getIsPlaying() { return isPlaying; }

    public void setPlaying(Episodio playing) { isPlaying = playing; }

    @Override
    public String toString() {
        return "Utilizador{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", subscricoes=" + subscricoes +
                '}';
    }

    public void playEpisodio(String idPodCast, String nomeEpisodio)
            throws AlreadyPlayingException {
        if (!(isPlaying == null)) throw new AlreadyPlayingException();
        else {
            for (Podcast p : subscricoes) {
                if (p.getId().equals(idPodCast)) setPlaying(p.getEpisodio(nomeEpisodio));
            }
        }
    }

}
