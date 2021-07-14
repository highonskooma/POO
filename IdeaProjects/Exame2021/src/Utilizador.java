import java.util.List;

public class Utilizador {
    private String id;
    private String nome;
    private List<Podcast> subscricoes; //podcasts a q o user está subscrito

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

    @Override
    public String toString() {
        return "Utilizador{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", subscricoes=" + subscricoes +
                '}';
    }
}
