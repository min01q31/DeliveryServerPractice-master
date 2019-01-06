package tjeit.kr.deliveryserverpractice.datas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Calendar;

public class Announcement implements Serializable {

    private int id;
    private Calendar created_at = Calendar.getInstance();
    private String title;
    private String content;

//    JSON -> 클래스 객체 리턴 메쏘드 (실질적 파싱)

    public static Announcement getAnnouncementFromJson(JSONObject json) {
        Announcement announcement = new Announcement();

        try {
            announcement.setId(json.getInt("id"));
            announcement.setTitle(json.getString("title"));
            announcement.setContent(json.getString("content"));

//            TODO : 작성 일시를 받아서 Calendar에 세팅.
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return announcement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Calendar created_at) {
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
