package HotelsInc;

public class HotelPremium extends Hotel {
    private double luxuryTax;

    public HotelPremium() {
        super();
        this.luxuryTax = 0;
    }

    public HotelPremium(String codigo, String nome, String localidade, double precoQuarto, int numQuartos, int estrelas, double tax) {
        super(codigo, nome, localidade, precoQuarto, numQuartos, estrelas);
        this.luxuryTax = tax;
    }

    public HotelPremium(Hotel c) {
        super(c);
        this.luxuryTax = 0;
    }

    public double getLuxuryTax() {return this.luxuryTax;}
    public void setLuxuryTax(double tax) {this.luxuryTax = tax;}

    public double pricePerNight() {
        return (this.roomPrice() * this.luxuryTax) + this.roomPrice();
    }

}
