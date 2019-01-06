package tjeit.kr.deliveryserverpractice.datas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String user_id;
    private String name;
    private String email;
    private String phone;
    private int billing_bank;
    private String billing_account;
    private String type;
    private double latitude;
    private double longitude;
    private String address;
    private String profile_image;

    private Bank bank;

//    JSON을 이용해서 사용자 정보를 추출 메쏘드
    public static User getUserFromJson(JSONObject json) {
        User user = new User();

        try {
            user.setId(json.getInt("id"));
            user.setUser_id(json.getString("user_id"));
            user.setName(json.getString("name"));
            user.setEmail(json.getString("email"));
            user.setPhone(json.getString("phone"));
            user.setBilling_bank(json.getInt("billing_bank"));
            user.setBilling_account(json.getString("billing_account"));
            user.setType(json.getString("type"));
            user.setLatitude(json.getDouble("latitude"));
            user.setLongitude(json.getDouble("longitude"));
            user.setAddress(json.getString("address"));
            user.setProfile_image(json.getString("profile_image"));

//            Bank 같은 데이터클래스를 세팅
//            JSON -> Bank 클래스 추출 => Bank 클래스에 작성

            Bank userBank = Bank.getBankFromJson(json.getJSONObject("bank_code"));
            user.setBank(userBank);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBilling_bank() {
        return billing_bank;
    }

    public void setBilling_bank(int billing_bank) {
        this.billing_bank = billing_bank;
    }

    public String getBilling_account() {
        return billing_account;
    }

    public void setBilling_account(String billing_account) {
        this.billing_account = billing_account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
