package lab2.Intlist;

public class main {
    public static void main(String[] args) {
        IntList A = IntList.of(1, 2, 3);
        System.out.println(A);
        IntList B = IntList.of(4, 5, 6);
        IntList C = IntList.dcatenate(A,B); //try debug
    }
}
