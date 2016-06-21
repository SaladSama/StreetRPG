package eu.epitech.eip.streetrpg;

import android.content.Intent;

/**
 * Created by LAT on 23/5/2016.
 */

public class Main {
    private MainActivity ma;

    public Main(MainActivity mActivity) {
        ma = mActivity;
    }

    public void changeToLoginView() {
        new Thread(new Runnable() {
            public void run() {
                Intent intent = new Intent(ma, LoginActivity.class);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ma.startActivity(intent);
                return ;
            }
        }).start();
    }
}
