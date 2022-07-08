package structure;

import java.util.Comparator;

public class Comparators {

    public static class CompCzasPrzybycia implements Comparator<Process> {
        @Override
        public int compare(Process o1, Process o2) {
            return o1.getCzasPrzybycia() - o2.getCzasPrzybycia();
        }
    }
}
