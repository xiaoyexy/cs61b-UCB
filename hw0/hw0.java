package hw0;

public class hw0 {

    public static void drawTriangle(int N) {
        int col = 1;
        int row = 1;
        int size = N;

        while (row <= size) {
            while (col < row) {
                System.out.print("*");
                col += 1;
            }
            System.out.println("*");
            row += 1;
            col = 1;
        }
    }

    public static int max(int[] m) {
        int maxNumber = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] > maxNumber) {
                maxNumber = m[i];
            }
        }
        return maxNumber;
    }


    public static int[] windowPosSum(int[] a, int n) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = 0;

            if (a[i] <= 0) {
                b[i] = a[i];
                continue;
            }

            int maxIndex = i + n;
            int j = i;
            while ((j <= maxIndex) && (j < a.length)) {
                b[i] += a[j];
                j++;
            }
        }
        return b;
    }


    public static void main(String[] args) {
        //1
        drawTriangle(10);

        //2
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));

        //3
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        a = windowPosSum(a, n);
        System.out.println(java.util.Arrays.toString(a));

        //4
        String[] c = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};
        for (String s : c) {
            for (int j = 0; j < 3; j += 1) {
                System.out.println(s);
                if (s.contains("horse")) {
                    break;
                }
            }
        }
    }
}


