package HotelsInc;

public class HotelStandard extends Hotel {
    private boolean epocaAlta;

    public HotelStandard() {
        super();
        this.epocaAlta = false;
    }

    public HotelStandard(boolean epoca) {
        super();
        this.epocaAlta = epoca;
    }

    public HotelStandard(Hotel c) {
        super(c);
        this.epocaAlta = false;
    }
}
