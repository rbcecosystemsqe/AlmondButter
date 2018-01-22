package com.ecosystems.qe.framework;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class EcoConfig {

    private EcoConfig() {
    }

    private static Properties ecoproperties;

    public static void loadproperties() {

        System.out.println("loadproperties");
        EcoConfig frameconfig = new EcoConfig();
        ecoproperties = new Properties();

        InputStream cfginput = null;
        try {
            cfginput = new FileInputStream(new File(System.getProperty("user.dir") +
                    "/src/test/resources/butter.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("read butter properties: " + cfginput);
        BufferedReader freader = new BufferedReader(new InputStreamReader(cfginput, StandardCharsets.UTF_8));

        try {
            ecoproperties.load(freader);
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println("load butter properties");
        try {
            cfginput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            freader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String option) {
        System.out.println("EcoConfig option:" + option);
        System.out.println("EcoConfig ecoproperties:" + ecoproperties);
        String value = null;
        if (ecoproperties == null) {
            loadproperties();
            value = ecoproperties.getProperty(option);
            System.out.println("EcoConfig option:" + value);
            if (value == null) {
                return "";
            }
        } else {
            value = ecoproperties.getProperty(option);
        }
        return value;
    }

    public static long timeout() {
        String waittime = get("wait");
        if (waittime == null || waittime.trim().equals("")) {
            return 60L;
        }
        return Long.parseLong(waittime);
    }
}
