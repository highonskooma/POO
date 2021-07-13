package HotelsInc;

import java.util.Comparator;

class CustomerSortingComparator
        implements Comparator<Hotel>  {

    @Override
    public int compare(Hotel hotel1,
                       Hotel hotel2)
    {

        // for comparison
        int NameCompare = hotel1.getNome().compareTo(
                hotel2.getNome());
        int StarCompare = Integer.compare(hotel2.getEstrelas(),
                hotel1.getEstrelas());


        // 2-level comparison
        return (NameCompare == 0) ? StarCompare
                : NameCompare;
    }
}