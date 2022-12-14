package org.momo;


import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void readFromConfUser(){
        String urlFromConfig = ConfigProvider.URL2;
        System.out.println(urlFromConfig);
    }

}
