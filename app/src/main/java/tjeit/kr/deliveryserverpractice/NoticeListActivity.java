package tjeit.kr.deliveryserverpractice;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tjeit.kr.deliveryserverpractice.adapters.NoticeAdapter;
import tjeit.kr.deliveryserverpractice.datas.Announcement;
import tjeit.kr.deliveryserverpractice.utils.ConnectServer;

public class NoticeListActivity extends BaseActivity {

    List<Announcement> announcementList = new ArrayList<Announcement>();
    NoticeAdapter mAdapter;

    private android.widget.ListView noticeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_list);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        mAdapter = new NoticeAdapter(mContext, announcementList);
        noticeListView.setAdapter(mAdapter);

        getNoticeFromServer();
    }

    private void getNoticeFromServer() {
        ConnectServer.getRequestNotice(mContext, new ConnectServer.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                try {
                    int code = json.getInt("code");
                    if (code == 200) {
                        JSONObject data = json.getJSONObject("data");

                        JSONArray announcements = data.getJSONArray("announcements");
                        for (int i=0; i < announcements.length() ; i++ ) {
                            JSONObject announcement = announcements.getJSONObject(i);
                            Announcement an = Announcement.getAnnouncementFromJson(announcement);

                            announcementList.add(an);
                        }

                        mAdapter.notifyDataSetChanged();


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void bindViews() {

        this.noticeListView = (ListView) findViewById(R.id.noticeListView);
    }
}
