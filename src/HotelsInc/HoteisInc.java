package HotelsInc;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class HoteisInc {
    /**
     * lista dos hoteis (id,hotel)
     */
    private HashMap<String,Hotel> hotels;

    public HoteisInc() {
        this.hotels = new HashMap<>();
    }

    public HoteisInc(HashMap<String,Hotel> hotels) {
        this.hotels = hotels;
    }

    public boolean existsHotel(String id) {
        return this.hotels.containsKey(id);
    }

    public int howMany() {
        return this.hotels.keySet().size();
    }

    public int howManyInACity(String city) {
        return (int) this.hotels.values().stream().filter(a->a.getLocalidade().equals(city)).count();
    }

    /**
     * Devolve a quantidade de hoteis de um determinado
     * tipo (Premium,Standard,...)
     * @param type
     */
    public int howManyOfAType(String type) {
        int res = 0;
        for (Hotel h : this.hotels.values()){
            String tipo = h.getClass().getSimpleName();
            if (tipo.equals(type)) {res+=1;}
        }
        return res;
    }

    public List<Hotel> getHoteis() {
        return new ArrayList<>(this.hotels.values());
    }

    public HashMap<String, Hotel> getHotels() {
        return hotels;
    }

    public void addHotels(Set<Hotel> hl) {
        Iterator<Hotel> it = hl.iterator();
        while (it.hasNext()) {
            Hotel h = it.next();
            this.hotels.put(h.getCodigo(),h);
        }
    }

    public void addHotel(Hotel h) {
        this.hotels.put(h.getCodigo(),h);
    }

    public Hotel getHotel(String id) {
        return this.hotels.get(id);
    }

    public void changeEpoca() {
        for (Hotel h : this.hotels.values()) {
            if (h instanceof HotelStandard) {
                HotelStandard stand = (HotelStandard) h;
                if (stand.getEpocaAlta()) {
                    stand.setEpocaAlta(false);
                } else {
                    stand.setEpocaAlta(true);
                }
            }
        }
    }

    public double totalRevenue() {
        double res=0;
        for (Hotel h : this.hotels.values()) {
            if (h instanceof HotelDiscount){res+=((HotelDiscount) h).priceByNight()* h.getNumeroQuartos();}
            if (h instanceof HotelPremium){res+=((HotelPremium) h).pricePerNight()*h.getNumeroQuartos();}
            if (h instanceof HotelDiscount){res+=((HotelDiscount) h).priceByNight()* h.getNumeroQuartos();}
            else {res+=h.roomPrice()* h.getNumeroQuartos();}
        }
        return res;
    }


    public TreeSet<Hotel> orderHotels() {
        TreeSet<Hotel> hotels = new TreeSet<>();
        for (Hotel h : this.hotels.values()) {
            hotels.add(h.clone());
        }
        return hotels;
    }

    public TreeSet<Hotel> orderHotels(Comparator<Hotel> c) {
        //ArrayList<Hotel> hotels = new ArrayList<>(this.hotels.values());
        //Collections.sort(hotels,c);
        TreeSet<Hotel> tree = new TreeSet<>(c);
        for (Hotel h : this.hotels.values()) {
            tree.add(h.clone());
        }
        return tree;
    }



}
