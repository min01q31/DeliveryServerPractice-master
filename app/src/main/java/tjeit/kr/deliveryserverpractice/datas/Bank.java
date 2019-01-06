package tjeit.kr.deliveryserverpractice.datas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Bank implements Serializable {

    private int id;
    private String code;
    private String name;
    private String logo;


    public static Bank getBankFromJson(JSONObject json) {
        Bank bank = new Bank();

        try {
            bank.setId(json.getInt("id"));
            bank.setCode(json.getString("code"));
            bank.setName(json.getString("name"));
            bank.setLogo(json.getString("logo"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bank;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
