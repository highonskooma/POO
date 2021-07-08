package HotelsInc;

import Exceptions.NoSuchAuthorException;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Hotel h1 = new Hotel("001","Solaria","Braga",237.99,344,3);
        Hotel h2 = new Hotel("002","Castello","Porto",400.0,500,5);
        Hotel h3 = new Hotel("003","Nova Donna","Braga",250.5,150,2);

        HashMap<String,Hotel> map = new HashMap<>();
        map.put(h1.getCodigo(),h1);
        map.put(h2.getCodigo(),h2);
        map.put(h3.getCodigo(),h3);

        HoteisInc hoteisInc = new HoteisInc(map);

        HotelStandard h4 = new HotelStandard("004","Nier Tribute","Lisboa",345,230,5,true);
        hoteisInc.addHotel(h4);
        HotelPremium h5 = new HotelPremium("005","Axis","Viana",366,500,4,0.3);
        hoteisInc.addHotel(h5);
        HotelDiscount h6 = new HotelDiscount("006","Lux","Porto",150,240,3,0.7);
        hoteisInc.addHotel(h6);

        System.out.println("is there a hotel with code 002?: "+hoteisInc.existsHotel("002"));
        System.out.println("number of hotels: "+hoteisInc.howMany());
        System.out.println("number of hotels in braga: "+hoteisInc.howManyInACity("Braga"));
        System.out.println("list of all hotels: "+hoteisInc.getHoteis());
        System.out.println("price per night of a Standard Hotel: "+h4.pricePerNight());
        System.out.println("price per night of a Premium Hotel: "+h5.pricePerNight());
        System.out.println("number of hotels with Premium type: "+hoteisInc.howManyOfAType("HotelPremium"));
        System.out.println("price of Discount Hotel with 70% ocupation: "+h6.priceByNight());
        System.out.println("total revenue of all hotels in 1 day: "+hoteisInc.totalRevenue());

    }
}
