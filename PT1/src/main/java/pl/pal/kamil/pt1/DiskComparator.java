package pl.pal.kamil.pt1;

import java.util.Comparator;

public class DiskComparator implements Comparator<DiskElement> {
    @Override
    public int compare(DiskElement o1, DiskElement o2) {

        long wynik = o1.getSize()-o2.getSize();

        if (wynik > 0)
        {
            return -1;
        }
        else if (wynik <0)
        {
            return 1;
        }
        else // jakby jakims cudem pliki mialy id
        {
            wynik = o1.file.compareTo(o2.file);
            return (int)wynik;
        }

    }
}
