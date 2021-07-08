package HotelsInc;

public class HotelDiscount extends Hotel {
    private double ocupation;

    public HotelDiscount() {
        super();
        this.ocupation = 0;
    }

    public HotelDiscount(String codigo, String nome, String localidade, double precoQuarto, int numQuartos, int estrelas, double oc) {
        super(codigo, nome, localidade, precoQuarto, numQuartos, estrelas);
        this.ocupation = oc;
    }

    public HotelDiscount(Hotel c) {
        super(c);
        this.ocupation = 0;
    }

    public double priceByNight() {
        return (roomPrice()*0.5) + (roomPrice()*0.4*ocupation);
    }
}
