package proj0;

public class NBody {

    public static double readRadius(String file) {
        In in = new In(file);
        int N = in.readInt();
        double r = in.readDouble();
        in.close();
        return r;
    }

    public static Planet[] readPlanets(String file) {
        In in = new In(file);
        int N = in.readInt();
        double r = in.readDouble();
        Planet[] bodies = new Planet[N];
        for (int i = 0; i < N; i++) {
            double n1 = in.readDouble();
            double n2 = in.readDouble();
            double n3 = in.readDouble();
            double n4 = in.readDouble();
            double n5 = in.readDouble();
            String n6 = in.readString();
            bodies[i] = new Planet(n1, n2, n3, n4, n5, n6);
        }
        in.close();
        return bodies;
    }

    public static void main(String[] args) {
        // args input: T, dt, filename
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        // draw the background
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");


        // draw planets
        for (Planet body : planets) {
            body.draw();
        }

        // animation
        StdDraw.enableDoubleBuffering();
        double t = 0;
        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];
        while (t < T) {
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
                planets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }


        // output
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }

}
