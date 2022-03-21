package pair2;

import pair1.Pair;

import java.time.LocalDate;

public class PairTest2 {

    public static void main(String[] args) {
        LocalDate[] birthdays =
                {
                        LocalDate.of(1906, 12, 9),
                        LocalDate.of(1815, 12, 10),
                        LocalDate.of(1910, 6, 22),
                };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}


class ArrayAlg {

    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (T str : a) {
            if (min.compareTo(str) > 0) min = str;
            if (max.compareTo(str) < 0) max = str;
        }
        return new Pair<>(min, max);
    }
}
