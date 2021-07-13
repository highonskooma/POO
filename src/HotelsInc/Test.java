package HotelsInc;

import Exceptions.NoSuchAuthorException;

import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        Hotel h1 = new Hotel("001","Solaria","Braga",237.99,344,3);
        Hotel h2 = new Hotel("002","Castello","Porto",400.0,500,5);
        Hotel h3 = new Hotel("003","Nier Tribute","Braga",250.5,150,2);

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

        CustomerSortingComparator comp = new CustomerSortingComparator();
        TreeSet<Hotel> copy = hoteisInc.orderHotels(comp);

        ArrayList<String> a1 = new ArrayList<String>( Arrays.asList("001", "002", "003") );
        ArrayList<String> a2 = new ArrayList<String>( Arrays.asList("004", "005", "006") );
        ArrayList<String> a3 = new ArrayList<String>( Arrays.asList("007", "008", "009") );
        ArrayList<String> a4 = new ArrayList<String>( Arrays.asList("010", "011", "012") );

        HashMap<String, List<String>> nifs = new HashMap<>();
        nifs.put(h1.getCodigo(),a1);
        nifs.put(h2.getCodigo(),a2);
        nifs.put(h3.getCodigo(),a3);
        nifs.put(h4.getCodigo(),a4);

        TravelAgency ta = new TravelAgency(hoteisInc,nifs);
        ta.saveToCSV("Hotel");

        System.out.println("is there a hotel with code 002?: "+hoteisInc.existsHotel("002"));
        System.out.println("number of hotels: "+hoteisInc.howMany());
        System.out.println("number of hotels in braga: "+hoteisInc.howManyInACity("Braga"));
        System.out.println("list of all hotels: "+hoteisInc.getHoteis());
        System.out.println("price per night of a Standard Hotel: "+h4.pricePerNight());
        System.out.println("price per night of a Premium Hotel: "+h5.pricePerNight());
        System.out.println("number of hotels with Premium type: "+hoteisInc.howManyOfAType("HotelPremium"));
        System.out.println("price of Discount Hotel with 70% ocupation: "+h6.priceByNight());
        System.out.println("total revenue of all hotels in 1 day: "+hoteisInc.totalRevenue());
        System.out.println("treeset of hotels by order (name,stars): "+copy);

    }
}
