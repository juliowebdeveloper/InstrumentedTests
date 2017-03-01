package br.com.instrumentedtests;

import android.app.Activity;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.filters.RequiresDevice;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Shido on 28/02/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    //MainActivity será instanciada antes de cada metodo anotado com @Test ser executado
    @Rule
    public MainActivityTestRule<MainActivity> mainActivityActivityTestRule = new MainActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testUI(){
        Activity activity = mainActivityActivityTestRule.getActivity();
        assertNotNull(activity.findViewById(R.id.helloTV));//Checando se está nulo
        TextView helloView = (TextView) activity.findViewById(R.id.helloTV);
        assertTrue(helloView.isShown());//Checando se está aparecendo na tela
        assertEquals("Hello World!", helloView.getText()); //Checando o conteudo.
        assertEquals(InstrumentationRegistry.getTargetContext().getResources().getString(R.string.hello_name),
                helloView.getText()); //Pegando no string.xml

    }

    @Test
    @RequiresDevice
    public void testRequiresDevice(){
        Log.d("MAINACTIVITYTEST", "This test requires a device");
        Activity activity = mainActivityActivityTestRule.getActivity();
        assertNotNull("Activity is not avaliable", activity);
    }


    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.N)
    public void testRequiresSDKNougat(){
        Log.d("MAINACTIVITYTEST", "This test requires sdk >= Nougat");
        Activity activity = mainActivityActivityTestRule.getActivity();
        assertNotNull("Activity is not avaliable", activity);
    }


    @Test
    @LargeTest
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.N)
    public void testLarge(){
        Log.d("MAINACTIVITYTEST", "This is a large test");
        Activity activity = mainActivityActivityTestRule.getActivity();
        assertNotNull("Activity is not avaliable", activity);
    }
}
