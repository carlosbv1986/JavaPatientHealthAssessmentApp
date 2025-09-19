/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.models;

import com.pha.interfaces.ILabMapping;

public class Laboratory implements ILabMapping {
    private int sbp;   // systolic BP
    private int dbp;   // diastolic BP
    private double fbs;
    private double chol;
    private double hdl;
    private double ldl;
    private double tg;
    private double a1c;

    public Laboratory(int sbp, int dbp, double fbs, double chol,
                      double hdl, double ldl, double tg, double a1c) {
        this.sbp = sbp;
        this.dbp = dbp;
        this.fbs = fbs;
        this.chol = chol;
        this.hdl = hdl;
        this.ldl = ldl;
        this.tg = tg;
        this.a1c = a1c;
    }

    public int getSbp() { return sbp; }
    public int getDbp() { return dbp; }
    public double getFbs() { return fbs; }
    public double getChol() { return chol; }
    public double getHdl() { return hdl; }
    public double getLdl() { return ldl; }
    public double getTg() { return tg; }
    public double getA1c() { return a1c; }

    // --- Mapping Implementations ---

    @Override
    public int mapBMI(double bmi) {
        if (bmi <= 17.9) return 0;
        if (bmi <= 24.9) return 1;
        if (bmi <= 29.9) return 2;
        return 3;
    }

    @Override
    public int mapBP(int sbp, int dbp) {
        if (dbp < 80 && sbp < 130) return 1;
        if (dbp >= 80 && dbp <= 100 && sbp <= 130) return 2;
        if (sbp > 130 && sbp <= 150) return 3;
        if (sbp > 150 && sbp <= 200) return 4;
        return 5;
    }

    @Override
    public int mapFBS(double fbs) {
        if (fbs >= 70 && fbs <= 110) return 1;
        if (fbs <= 140) return 2;
        if (fbs <= 200) return 3;
        if (fbs <= 300) return 4;
        return 5;
    }

    @Override
    public int mapCholesterol(double chol) {
        if (chol >= 50 && chol <= 149) return 1;
        if (chol <= 184) return 2;
        if (chol <= 199) return 3;
        if (chol <= 249) return 4;
        return 5;
    }

    @Override
    public int mapHDL(double hdl) {
        if (hdl <= 39) return 5;
        if (hdl <= 59) return 4;
        if (hdl <= 74) return 3;
        if (hdl <= 99) return 2;
        return 1;
    }

    @Override
    public int mapLDL(double ldl) {
        if (ldl <= 99) return 1;
        if (ldl <= 129) return 2;
        if (ldl <= 159) return 3;
        if (ldl <= 189) return 4;
        return 5;
    }

    @Override
    public int mapTG(double tg) {
        if (tg <= 149) return 1;
        if (tg <= 179) return 2;
        if (tg <= 199) return 3;
        if (tg <= 499) return 4;
        return 5;
    }

    @Override
    public int mapA1C(double a1c) {
        if (a1c <= 6.0) return 1;
        if (a1c <= 7.0) return 2;
        if (a1c <= 8.0) return 3;
        if (a1c <= 9.0) return 4;
        return 5;
    }
}
