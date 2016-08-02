package eu.epitech.eip.streetrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class QuestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");
        MyAdapter adapter = null;
        String[] namelist = {"Do 1 kill", "Do 10 kills", "Do 100 kills"};
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("id", userid);
        String re = new Connection().performPostCall("profile.php", params);
        String kill = "";
        try {
            JSONObject jo = new JSONObject(re);
            kill = jo.getString("kills");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] desclist = {"Courant: " + kill + "/1", "Courant: " + kill + "/10", "Courant: " + kill + "/100"};
        if (Integer.valueOf(kill) >= 1)
            desclist[0] = "Done";
        if (Integer.valueOf(kill) >= 10)
            desclist[1] = "Done";
        if (Integer.valueOf(kill) >= 100)
            desclist[2] = "Done";
        ListView listview;
        listview = (ListView)findViewById(R.id.listView);
        adapter = new MyAdapter(this, namelist, desclist);
        listview.setAdapter(adapter);
    }
}
