package br.com.instrumentedtests;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

/**
 * Created by Shido on 28/02/2017.
 */

public class MainActivityTestRule<A extends Activity> extends ActivityTestRule<A> {
    public MainActivityTestRule(Class<A> activityClass) {
        super(activityClass);
    }

    @Override
    protected Intent getActivityIntent() {
        Log.e("MainActivityTestRule", "prepare the activity's intent");
        return super.getActivityIntent();
    }

    @Override
    protected void beforeActivityLaunched() {
        super.beforeActivityLaunched();
    }

    @Override
    protected void afterActivityLaunched() {
        super.afterActivityLaunched();
    }

    @Override
    protected void afterActivityFinished() {
        super.afterActivityFinished();
    }

}
