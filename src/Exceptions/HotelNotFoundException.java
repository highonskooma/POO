package Exceptions;

public class HotelNotFoundException extends Exception {
    public HotelNotFoundException() {
        super();
        System.out.println("O id fornecido não corresponde a nenhum hotel no sistema\n");
    }
}
