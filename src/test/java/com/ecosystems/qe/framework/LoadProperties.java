package com.ecosystems.qe.framework;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class LoadProperties {

    public  static String readProperties() throws IOException {

        Properties prop = new Properties();

        File fpath = new
                File(System.getProperty("user.dir") +
                "/src/main/resources/butter.properties");
        FileReader fread = new FileReader(fpath);

        prop.load(fread);

        //String parray[];
        String website = "";

        Enumeration KeyValues = prop.keys();
        while (KeyValues.hasMoreElements()) {
            String key = (String) KeyValues.nextElement();
            String value = prop.getProperty(key);
            if (key.equals("usesite")){
                System.out.println("Match KEY: "+key);
                website = value;
            }
            //if (key.equals("herowording")){
            //    herowords = value;
            //}
            System.out.println(key + ":- " + value);
        }
        return website;
    }


}
