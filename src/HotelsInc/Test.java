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

        Hotel h4 = new Hotel("004","Nier Tribute","Lisboa",345,230,5);
        hoteisInc.addHotel(h4);

        System.out.println("is there a hotel woth code 002?: "+hoteisInc.existsHotel("002"));
        System.out.println("number of hotels: "+hoteisInc.howMany());
        System.out.println("number of hotels in braga: "+hoteisInc.howManyInACity("Braga"));
        System.out.println("list of all hotels: "+hoteisInc.getHoteis());


    }
}
