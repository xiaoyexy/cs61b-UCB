package proj0;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet b) {
        return sqrt(pow((this.xxPos - b.xxPos), 2) + pow((this.yyPos - b.yyPos), 2));
    }

    public double calcForceExertedBy(Planet b) {
        return (this.mass * b.mass * 6.67 * pow(10, -11)) / pow(this.calcDistance(b), 2);
    }

    public double calcForceExertedByX(Planet b) {
        double F = this.calcForceExertedBy(b);
        double R = this.calcDistance(b);
        double Fx = F * (b.xxPos - this.xxPos) / R;
        return Fx;
    }

    public double calcForceExertedByY(Planet b) {
        double F = this.calcForceExertedBy(b);
        double R = this.calcDistance(b);
        double Fy = F * (b.yyPos - this.yyPos) / R;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netX = 0;
        for (Planet i : allPlanets) {
            if (this.equals(i)) {
                continue;
            }
            netX += this.calcForceExertedByX(i);
        }
        return netX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double netY = 0;
        for (Planet i : allPlanets) {
            if (this.equals(i)) {
                continue;
            }
            netY += this.calcForceExertedByY(i);
        }
        return netY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }


}
