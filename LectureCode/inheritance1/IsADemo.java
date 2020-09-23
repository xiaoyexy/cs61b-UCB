package LectureCode.inheritance1;
public class IsADemo {
    public static void main(String[] args) {
        List61B<String> someList = new SLList<String>(); //左父右子, 创建一个SLList
        someList.addFirst("elk");  //调用SLList.addFirst()
        someList.addLast("dwell");
        someList.addLast("on");
        someList.addLast("existential");
        someList.addLast("crises");
        someList.print();
    }
}