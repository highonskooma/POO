package HotelsInc;

public class HotelStandard extends Hotel implements CardPoints {
    private static boolean epocaAlta;

    public HotelStandard() {
        super();
        epocaAlta = false;
    }

    public HotelStandard(String codigo, String nome, String localidade, double precoQuarto, int numQuartos, int estrelas,boolean epoca) {
        super(codigo, nome, localidade, precoQuarto, numQuartos, estrelas);
        epocaAlta = epoca;
    }

    public HotelStandard(Hotel c) {
        super(c);
        epocaAlta = false;
    }

    public double pricePerNight() {
        if (epocaAlta) {return 20 + this.getPrecoQuarto();}
        else {return this.getPrecoQuarto();}
    }

    public boolean getEpocaAlta() {
        return epocaAlta;
    }

    public void setEpocaAlta(boolean ea) {
        epocaAlta = ea;
    }

    /**
     * INTERFACE
     * @return
     */
    private int points;

    @Override
    public void setPontos() {

    }

    public int getPontos() {
        return this.points;
    }
    public void setPontos(int p) {
        this.points = p;
    }




}


