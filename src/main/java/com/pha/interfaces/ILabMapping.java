/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.interfaces;

public interface ILabMapping {
    int mapBMI(double bmi);
    int mapBP(int sbp, int dbp);
    int mapFBS(double fbs);
    int mapCholesterol(double chol);
    int mapHDL(double hdl);
    int mapLDL(double ldl);
    int mapTG(double tg);
    int mapA1C(double a1c);
}
