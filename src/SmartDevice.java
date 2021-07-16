import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SmartDevice implements Comparable<SmartDevice>, Serializable {
    private String id;
    private boolean estado; //ligado = true, desligado = false
    private double consumoPorHora;
    private LocalDateTime inicio;

    public SmartDevice() {
        this.id = "";
        this.estado = false;

    }

    public SmartDevice(String id){
        this.id = id;
        this.estado = false;
    }

    public SmartDevice(String id,double consumoPorHora){
        this.id = id;
        this.estado = false;
        this.consumoPorHora = consumoPorHora;
    }

    public SmartDevice(String id,boolean estado){
        this.id = id;
        this.estado = estado;
    }

    public SmartDevice(SmartDevice o){
        this.id = o.getID();
        this.estado = o.getOn();
    }

    public String getID(){return this.id;}
    public boolean getOn(){return this.estado;}

    public void setID(String id){this.id = id;}
    public void setOn(boolean estado){this.estado = estado;}

    public double getConsumoPorHora() {
        return consumoPorHora;
    }

    public void setConsumoPorHora(double consumoPorHora) {
        this.consumoPorHora = consumoPorHora;
    }

    // devolve o consumo desde o inicio
    public double totalConsumo() {
        long hours = ChronoUnit.HOURS.between(this.inicio, LocalDateTime.now());
        return hours * this.consumoPorHora;
    }

    //liga o device. Se for a primeira vez inicializa o tempo de inicio
    public void turnOn() {
        this.estado = true;
        if (this.inicio == null)
            this.inicio = LocalDateTime.now();
    }

    @Override
    public int compareTo(SmartDevice o) {
        return 0;
    }
}
