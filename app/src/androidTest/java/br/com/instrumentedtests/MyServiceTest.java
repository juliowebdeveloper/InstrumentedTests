package br.com.instrumentedtests;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertNotNull;


/**
 * Created by Shido on 28/02/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MyServiceTest {

    @Rule
    public MyServiceTestRule myServiceRule = new MyServiceTestRule();

    //Bind ou created antes de cada metodo com a anotação @Test e destruido ou unbound após completado

    @Test
    public void testService(){
        try {
            myServiceRule.startService((new Intent(InstrumentationRegistry.getTargetContext(), MyService.class)));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testBind(){
        try {
            IBinder binder = myServiceRule.bindService(new Intent(InstrumentationRegistry.getTargetContext(), MyService.class));
            MyService service = ((MyService.LocalBinder) binder).getService();//Usando o bindService e depois disso pegando o service desse bind
            assertNotNull("Bound Service is null",service);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
