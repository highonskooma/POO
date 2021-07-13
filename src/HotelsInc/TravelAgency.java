package HotelsInc;

import Exceptions.HotelNotFoundException;


import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TravelAgency {
    private HoteisInc hotels;
    private HashMap<String, List<String>> nifs; //(id do hotel, lista de nif dos clientes)


    public TravelAgency() {
        this.hotels = new HoteisInc();
        this.nifs = new HashMap<>();
    }

    public TravelAgency(HoteisInc hotels, HashMap<String,List<String>> nifs) {
        this.hotels = hotels;
        this.nifs = nifs;
    }

    public TravelAgency(TravelAgency obj) {
        this.hotels = obj.getHotels();
        this.nifs = obj.getNifs();
    }

    public HoteisInc getHotels() {return this.hotels;}
    public void setHotels(HoteisInc h) {hotels = h;}
    public HashMap<String, List<String>> getNifs() {return nifs;}
    public void setNifs(HashMap<String,List<String>> arg) {nifs = arg;}

    public void addNif(String id,String nif) throws HotelNotFoundException {
        if (nifs.containsKey(id)) {
            nifs.get(id).add(nif);
        }
        else throw new HotelNotFoundException();
    }

    public void removeNif(String id,String nif) throws HotelNotFoundException {
        if (nifs.containsKey(id)) {
            nifs.remove(nif);
            System.out.println("Cliente removido com sucesso\n");
        }
        else throw new HotelNotFoundException();
    }

    public void removeNif(String nif) {
        nifs.forEach( (k,v) -> {if (v.contains(nif)) v.remove(nif);} );
    }

    public void saveToCSV (String type) throws IOException {
        List<Hotel> filter = hotels.getHoteis().stream().filter(a->a.getClass().getSimpleName().equals(type)).collect(toList());
        FileWriter csvWrite = new FileWriter(type+".csv");
        for (Hotel h : filter) { csvWrite.append(h.toString()); }
        csvWrite.flush();
        csvWrite.close();
        }
}
