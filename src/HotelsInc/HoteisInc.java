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

    public List<Hotel> getHoteis() {
        return new ArrayList<>(this.hotels.values());
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

}
