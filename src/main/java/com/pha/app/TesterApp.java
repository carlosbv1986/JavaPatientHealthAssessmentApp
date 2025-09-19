/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pha.app;

import com.pha.models.*;
import java.io.*;
import java.util.*;

public class TesterApp {

    public static void main(String[] args) {
        List<MedicalDiagnose> diagnoses = new ArrayList<MedicalDiagnose>();

        Scanner sc = null;
        try {
            sc = new Scanner(new File("MedicalRecords.txt"));
            while (sc.hasNext()) {
                int pid = sc.nextInt();
                int age = sc.nextInt();
                int gender = sc.nextInt();
                double weight = sc.nextDouble();
                double height = sc.nextDouble();
                int sbp = sc.nextInt();
                int dbp = sc.nextInt();
                double fbs = sc.nextDouble();
                double chol = sc.nextDouble();
                double ldl = sc.nextDouble();
                double hdl = sc.nextDouble();
                double tg = sc.nextDouble();
                double a1c = sc.nextDouble();

                Patient p = new Patient(pid, age, gender, height, weight);
                Laboratory lab = new Laboratory(sbp, dbp, fbs, chol, hdl, ldl, tg, a1c);
                MedicalDiagnose md = new MedicalDiagnose(p, lab);

                diagnoses.add(md);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        // Sort by diagnose
        Collections.sort(diagnoses);

        // Write converted output
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("ConvertedMedicalRecords.txt"));
            for (MedicalDiagnose md : diagnoses) {
                pw.println(md.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }
}
