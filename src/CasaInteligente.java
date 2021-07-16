import Exceptions.ElementNotRemovedException;
import Exceptions.NoDeviceException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CasaInteligente {
    private String morada;
    private HashMap<String, ArrayList<SmartDevice>> rooms;

    public CasaInteligente() {
        this.morada = "n/a";
        this.rooms = new HashMap<String, ArrayList<SmartDevice>>();
    }

    public CasaInteligente(String morada) {
        this.morada = morada;
        this.rooms = new HashMap<String, ArrayList<SmartDevice>>();
    }

    public CasaInteligente(String morada, HashMap<String, ArrayList<SmartDevice>> rooms) {
        this.morada = morada;
        this.rooms = rooms;
    }

    public CasaInteligente(CasaInteligente o) {
        this.morada = o.getMorada();
        this.rooms = o.getRooms();
    }

    public CasaInteligente(Collection<SmartDevice> devices) {
        HashMap<String, ArrayList<SmartDevice>> rooms = new HashMap<>();
        ArrayList<SmartDevice> array = new ArrayList<>();
        String sala = "sala";
        rooms.put(sala,array);
        for (SmartDevice sd : devices) {rooms.get(sala).add(sd);}
        this.rooms = rooms;
    }
/*
    public CasaInteligente(Collection<SmartDevice> devices) {
        Iterator<SmartDevice> it = devices.iterator();
        HashMap<String, ArrayList<SmartDevice>> rooms = new HashMap<>();
        ArrayList<SmartDevice> array = new ArrayList<>();
        String sala = "sala";
        rooms.put(sala,array);
        while (it.hasNext()) {
            SmartDevice device = it.next();
            rooms.get(sala).add(device);
        }
        this.rooms = rooms;
    }

 */

    public String getMorada() {
        return this.morada;
    }

    public HashMap<String, ArrayList<SmartDevice>> getRooms() {
        return this.rooms;
    }

    public boolean existsDevice(String ID) {
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            for (SmartDevice elem : entry.getValue()) {
                if (ID == elem.getID()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addRoom(String quarto) {
        ArrayList<SmartDevice> a = new ArrayList<SmartDevice>();
        this.rooms.put(quarto, a);
    }

    public void removeFromRoom(String quarto,String ID){
        for(SmartDevice sd : this.rooms.get(quarto)){
            if(ID==sd.getID()){
                this.rooms.get(quarto).remove(sd);
                break;
            }
        }
    }
/*
    public addToRoom(String quarto,String ID) {
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : rooms.entrySet()) {
            if (entry.getValue().stream().anyMatch(a->a.getID().equals(ID))) {
                if (!entry.getKey().equals(quarto))
            }
        }
    }*/

    public void addToRoom(String quarto,String ID) {
        int flag = 0;
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            for (SmartDevice sd : entry.getValue()) {
                if (ID.equals(sd.getID())) {
                    if (quarto.equals(entry.getKey())) {
                        flag = 1;
                        break;
                    } else {
                        flag = 1;

                        addDevice(sd,quarto);

                        removeFromRoom(entry.getKey(), ID);
                    }
                }
            }
        }
        if (flag == 0) {
            ArrayList<SmartDevice> a = new ArrayList<>();
            SmartDevice sd = new SmartDevice(ID);
            a.add(sd);
            this.rooms.put(quarto, a);
        }
    }


    public void addDevice(SmartDevice sd, String quarto) {
        int flag = 0;
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            if (entry.getKey() == quarto) {
                entry.getValue().add(sd);
                flag += 1;
                break;
            }
        }
        if (flag == 0) {
            ArrayList<SmartDevice> a = new ArrayList<SmartDevice>();
            a.add(sd);
            this.rooms.put(quarto, a);
        }
    }

    public SmartDevice getDevice(String ID){
        SmartDevice s = new SmartDevice();
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            for (SmartDevice device : entry.getValue()) {
                if (device.getID() == ID) {
                    s = device;
                }
            }
        }
        return s;
    }

    public void setAllOn(boolean estado) {
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            for (SmartDevice device : entry.getValue()) {
                device.setOn(estado);
            }
        }
    }

    public boolean hasRoom(String room) {
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            if (entry.getKey() == room) {
                return true;
            }
        }
        return false;
    }

    public boolean roomHasDevice(String room,String ID) {
        if (rooms.containsKey(room)) return rooms.get(room).stream().anyMatch(a->a.getID().equals(ID));
        else return false;
    }
/*
    public boolean roomHasDevice2(String room,String ID) {
        for (HashMap.Entry<String, ArrayList<SmartDevice>> entry : this.rooms.entrySet()) {
            for (SmartDevice device : entry.getValue()) {
                if (device.getID() == ID && entry.getKey() == room) {
                    return true;
                }
            }
        }
        return false;
    }

 */

    public void remove(String id) throws ElementNotRemovedException {
        int flag=0;
        String room = null;
        for (Map.Entry<String,ArrayList<SmartDevice>> entry : rooms.entrySet()) {
            for (SmartDevice sd : entry.getValue()) {
                if (sd.getID().equals(id)) {
                    rooms.get(entry.getKey()).remove(sd);
                    room = entry.getKey();
                    //if (entry.getValue().isEmpty()) rooms.remove(entry.getKey());
                    flag=1;
                    break;
                }
            }
        }
        if (flag==0)
            throw new ElementNotRemovedException();
        if (room!=null) rooms.remove(room);
    }


    /**
     * devolve um iterador com ordena¸c˜ao crescente por consumo
     * @return
     */
    static class consuptionComparator implements Comparator<SmartDevice> {
        @Override
        public int compare(SmartDevice sd1,SmartDevice sd2) {
            return Double.compare(sd1.getConsumoPorHora(),sd2.getConsumoPorHora());
        }
    }

    public List<SmartDevice> devicesPorConsumoCrescente() {
        ArrayList<SmartDevice> group = new ArrayList<>();
        for (ArrayList<SmartDevice> list : rooms.values()) {
            list.stream().map(group::add).collect(Collectors.toList());
            //System.out.println(group);
        }
        System.out.println("group: "+group);
        consuptionComparator c = new consuptionComparator();
        List<SmartDevice> res = group.stream().sorted(c).collect(Collectors.toList());
        return res;
    }

    /**
     * determina a divis˜ao da casa que apresenta o menor consumo. Se duas divis˜oes apresentarem o
     * mesmo consumo ent˜ao dever´a ser devolvida a divis˜ao cuja designa¸c˜ao tem o maior valor
     * alfab´etico
     * @return
     */
    static class consuptionComparatorRev implements Comparator<SmartDevice> {
        public int compare(SmartDevice sd1, SmartDevice sd2) {
            int consumption = Double.compare(sd2.getConsumoPorHora(),sd1.getConsumoPorHora());
            int name = sd1.getID().compareTo(sd2.getID());
            return (consumption==0) ? name : consumption;
        }
    }

    public String divisaoMaisEconomica() throws NoDeviceException {
        double min = 100.0;
        String res = null;
        consuptionComparatorRev c = new consuptionComparatorRev();
        for (Map.Entry<String,ArrayList<SmartDevice>> entry : rooms.entrySet()) {
            Double d = entry.getValue().stream().sorted(c).map(SmartDevice::getConsumoPorHora)
                    .reduce(Double::sum).orElseThrow(NoDeviceException::new);
            //System.out.println(d);
            if (min>d) {
                min = d;
                res = entry.getKey();
            }
        }
        return res;
    }


}

