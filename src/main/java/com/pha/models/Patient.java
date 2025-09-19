/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.models;

public class Patient {

    private int pid;
    private int age;
    private int gender; // 1 = Male, 2 = Female
    private double height; // in cm
    private double weight; // in kg

    public Patient(int pid, int age, int gender, double height, double weight) {
        this.pid = pid;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public int getPid() {
        return pid;
    }

    public int getAge() {
        return age;
    }

    public int getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getBMI() {
        // convert height to meters
        double heightM = height / 100.0;
        return weight / (heightM * heightM);
    }

    @Override
    public String toString() {
        return pid + " " + age + " " + gender + " " + weight + " " + height;
    }
}
