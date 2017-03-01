package br.com.instrumentedtests;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Shido on 28/02/2017.
 */
@RunWith(AndroidJUnit4.class)
public class SimpleMathTest {


    @Test
    public void addTest(){
        assertEquals("Addition not performed corretly", 5, 3+2);
    }


    @Test
    public void addDiff(){
        assertEquals("ASubtraction not performed corretly", 5, 12-7);
    }


}
