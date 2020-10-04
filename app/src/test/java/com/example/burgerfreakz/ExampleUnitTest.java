package com.example.burgerfreakz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private shoppingcart shoppingcart;
    private Customize customize;

    @Before
    public void setup(){
        shoppingcart = new shoppingcart();
        customize = new Customize();
    }


    @Test
    public void serviceCharge(){
        float result = shoppingcart.Service(840,100);
        assertEquals(37,result,0.1);
    }

    @Test
    public void Total(){
        float result = shoppingcart.Tot(100,5);
        assertEquals(500,result,0.1);
    }

    @Test
    public void discountedTotal(){
        float result = shoppingcart.discountedTotal(850,100);
        assertEquals(750,result,0.1);
    }

    @Test
    public void netTotal(){
        float result = shoppingcart.netTotal(950,15,100);
        assertEquals(865,result,0.1);
    }

    @Test
    public void large(){
        float result = customize.largePrice("500");
        assertEquals(530,result,0.1);
    }

}