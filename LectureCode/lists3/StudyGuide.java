package LectureCode.lists3;

import java.util.Arrays;

public class StudyGuide {

//    public static void display(Deck array) {
//        for(int i : array.cards){
//            System.out.println(i);
//
//    }

    public static void main(String[] args) {
        Deck dingie = new Deck();
        dingie.cards[3] = 3;
        System.out.println(Arrays.toString(dingie.cards));


        Deck pilates = new Deck();
        pilates.cards[1] = 2;
        System.out.println(Arrays.toString(dingie.cards));
        System.out.println(Arrays.toString(pilates.cards));

        int[] newArrWhoDis = {2, 2, 4, 1, 3};
        dingie.cards = pilates.cards;
        pilates.cards = newArrWhoDis;
        newArrWhoDis = null;
        System.out.println(Arrays.toString(dingie.cards));
        System.out.println(Arrays.toString(pilates.cards));
    }
}
