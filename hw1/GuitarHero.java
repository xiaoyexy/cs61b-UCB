//package hw1;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdAudio;
//import hw1.synthesizer.GuitarString;
import synthesizer.GuitarString;

public class GuitarHero {

    private static final double CONCERT = 440.0;
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static GuitarString[] strings = new GuitarString[37];


    public static void main(String[] args) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new GuitarString(CONCERT * Math.pow(2, (i - 24) / 12.0));
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                try {
                    int index = KEYBOARD.indexOf(key); // invalid return -1
                    strings[index].pluck();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid keyboard input");
                }
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < strings.length; i++) {
                sample += strings[i].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < strings.length; i++) {
                strings[i].tic();
            }
        }
    }
}
