package LectureCode.inheritance3;

public class Maximizer {
    public static Comparable max(Comparable[] items) { // Comparable是接口指代实现类
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            int cmp = items[i].compareTo(items[maxDex]);

            if (cmp > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }
} 