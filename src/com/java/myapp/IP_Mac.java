package com.java.myapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IP_Mac {

    public static void main(String[] args) {
        Dialog.setLAF();
        int error = -1;
        Selectfile Select = new Selectfile();
        try {

            if (Select.getChooser().getSelectedFile().getName().contains(".txt")) {
                new File(Select.getChooser().getSelectedFile().getPath().split(".txt")[0] + ".csv").delete();
                BufferedReader br = new BufferedReader(new FileReader(Select.getFile()));
                String pathOutput = Select.getFile().getPath().split("\\.")[0] + ".csv";
                Wait wait = new Wait();
                Sub(br, pathOutput);
                wait.dispose();
                System.exit(0);
            } else {
                Wait wait = new Wait();
                for (File fileFolder : Select.getFile().listFiles()) {
                    if (fileFolder.getName().contains(".csv")) {
                        fileFolder.delete();
                    }
                    if (fileFolder.getName().contains(".txt")) {
                        BufferedReader br = new BufferedReader(new FileReader(fileFolder));
                        String pathOutput = fileFolder.getPath().split("\\.")[0] + ".csv";
                        Sub(br, pathOutput);
                    }
                }
                wait.dispose();
                System.exit(0);
            }
        } catch (NullPointerException ex) {
            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            error++;
            Dialog.FileError(Select.getFileFolder()[0].getName());
        }
    }

    private static void Sub(BufferedReader br, String path) throws IOException {
        String line;
        String str;
        String all = "";
        while ((line = br.readLine()) != null) {
            String[] arr1 = line.split("\\.");
            String[] arr2 = line.split(",");
            if (arr1.length >= 4) {
                String s1 = line.split(" ")[0];
                String[] s2 = line.split(":");
                if (s2.length >= 5) {
                    str = line.substring(arr1[0].length() - 2, s1.length()) + "," + line.substring(s2[0].length() - 2);
                } else {
                    str = line.substring(arr1[0].length() - 2, s1.length()) + ",";
                }
                String str2 = str.split(" ")[0];
                all += (str2 + "\n");
            }
        }
        br.close();
        FileWriter IP_Mac;
        IP_Mac = new FileWriter(path, true);
        Writer.IP_Mac(IP_Mac, all);
    }

}
