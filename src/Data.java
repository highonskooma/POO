import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data implements Cloneable {
    //INSTANCE VARIABLES
    public static Map<String, Equipa>  equipas; //nome, equipa
    public static Map<Integer, Jogador> jogadores; //numero, jogador
    public static List<Jogo> jogos;

    //CONSTRUCTORS
    public Data() {
        this.equipas = new HashMap<>();
        this.jogadores = new HashMap<>();
        this.jogos = new ArrayList<>();
    }

    public Data(Map<String,Equipa> equipas, Map<Integer, Jogador> jogadores, ArrayList<Jogo> jogos) {
        this.equipas = equipas;
        this.jogadores = jogadores;
        this.jogos = jogos;
    }

    public Data(Data obj) {
        this.equipas = obj.getEquipas();
        this.jogadores = obj.getJogadores();
        this.jogos = obj.getJogos();
    }

    public Map<String, Equipa> getEquipas() {return this.equipas;}
    public Map<Integer, Jogador> getJogadores() {return this.jogadores;}
    public List<Jogo> getJogos() {return this.jogos;}

    public void addEquipa(Equipa e){
        this.equipas.put(e.getNome(),e);
    }

    public void addJogador(Jogador j){
        this.jogadores.put(j.getNum(), j);
    }

    public void addJogo(Jogo jogo){
        this.jogos.add(jogo);
    }

    public Data clone() {return new Data(this);}
}