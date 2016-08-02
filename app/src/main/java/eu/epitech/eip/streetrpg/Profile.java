package eu.epitech.eip.streetrpg;


import java.util.HashMap;

/**
 * Created by LAT on 18/7/2016.
 */
public class Profile {
    private HashMap<String, String> params;
    private String str;

    public Profile(HashMap<String, String> params) {
        this.params = params;
    }

    public String getResult() {
        try {
        Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str;
    }

    public void connectionProcess() {
        new Thread(new Runnable() {
            public void run() {
                Connection conn = new Connection();
                str = conn.performPostCall("profile.php", params);
                return ;
            }
        }).start();
    }
}
