package com.example.student.myapplication123;


public class Intersect {

    double x = 55.874546;
    double y = 37.642770;
    double coords[][] = new double[1000][3];
    int n;

    void readc(double xl, double yl, double coordsl[][]) {
        x=xl;
        y=yl;
        coords = coordsl;
    }


    public boolean inspecting() {

        boolean inspect = false;

        for (int i = 0; i < n; i++) {
            if (((x - coords[i][0]) * (x - coords[i][0]) + (y - coords[i][1]) * (y - coords[i][1])) <= (coords[i][2] * coords[i][2])) {
                inspect = true;
                break;
            }
        }
        return inspect;
    }
}