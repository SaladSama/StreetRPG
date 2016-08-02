package eu.epitech.eip.streetrpg;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by LAT on 19/7/2016.
 */
public class Skill {
    private String name;
    private String description;
    private int mp_cost;
    private int attack;
    private int health;

    public Skill(String id) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        String re = new Connection().performPostCall("skill.php", params);
        try {
            JSONObject jo = new JSONObject(re);
            name = jo.getString("name");
            description = jo.getString("description");
            mp_cost = Integer.valueOf(jo.getString("mp"));
            attack = Integer.valueOf(jo.getString("attack"));
            health = Integer.valueOf(jo.getString("health"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMp_cost() {
        return mp_cost;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }
}
