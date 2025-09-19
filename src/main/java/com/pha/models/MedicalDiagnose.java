/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.models;

public class MedicalDiagnose implements Comparable<MedicalDiagnose> {
    private Patient patient;
    private Laboratory lab;

    private int bmiScore;
    private int bpScore;
    private int fbsScore;
    private int cholScore;
    private int hdlScore;
    private int ldlScore;
    private int tgScore;
    private int a1cScore;

    private int total;
    private int diagnose;

    public MedicalDiagnose(Patient patient, Laboratory lab) {
        this.patient = patient;
        this.lab = lab;

        // Compute mapped values
        this.bmiScore = lab.mapBMI(patient.getBMI());
        this.bpScore = lab.mapBP(lab.getSbp(), lab.getDbp());
        this.fbsScore = lab.mapFBS(lab.getFbs());
        this.cholScore = lab.mapCholesterol(lab.getChol());
        this.hdlScore = lab.mapHDL(lab.getHdl());
        this.ldlScore = lab.mapLDL(lab.getLdl());
        this.tgScore = lab.mapTG(lab.getTg());
        this.a1cScore = lab.mapA1C(lab.getA1c());

        this.total = getTotal();
        this.diagnose = classifyDiagnose();
    }

    public char convertGender(int gender) {
        return (gender == 1) ? 'M' : 'F';
    }

    public int getTotal() {
        return bmiScore + bpScore + fbsScore + cholScore +
               hdlScore + ldlScore + tgScore + a1cScore;
    }

    public int classifyDiagnose() {
        if (total <= 11) return 1;
        if (total <= 15) return 2;
        if (total <= 20) return 3;
        if (total <= 28) return 4;
        return 5;
    }

    public String getCondition() {
        switch (diagnose) {
            case 1: return "Excellent";
            case 2: return "Very Good";
            case 3: return "Good";
            case 4: return "Bad";
            case 5: return "Critical";
            default: return "Unknown";
        }
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public Laboratory getLaboratory() {
        return lab;
    }

    @Override
    public int compareTo(MedicalDiagnose other) {
        return Integer.compare(this.diagnose, other.diagnose);
    }

    @Override
    public String toString() {
        return patient.getPid() + " " + patient.getAge() + " " +
               convertGender(patient.getGender()) + " " +
               bmiScore + " " + bpScore + " " + fbsScore + " " +
               cholScore + " " + hdlScore + " " + ldlScore + " " +
               tgScore + " " + a1cScore + " " +
               total + " " + diagnose + " " + getCondition();
    }
}

