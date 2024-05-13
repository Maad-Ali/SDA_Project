package org.example;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {


        public static  Properties props;

        public static  void readpropirtes(String configration)
        {
             props = new Properties();
            try {
                props.load(new FileInputStream(configration));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


