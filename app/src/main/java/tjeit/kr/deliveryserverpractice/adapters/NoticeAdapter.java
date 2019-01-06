package tjeit.kr.deliveryserverpractice.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tjeit.kr.deliveryserverpractice.R;
import tjeit.kr.deliveryserverpractice.datas.Announcement;

public class NoticeAdapter extends ArrayAdapter<Announcement> {

    Context mContext;
    List<Announcement> mList;
    LayoutInflater inf;

    public NoticeAdapter(Context context, List<Announcement> list) {
        super(context, R.layout.notice_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.notice_list_item, null);
        }

        TextView titleTxt = row.findViewById(R.id.titleTxt);
        TextView contentTxt = row.findViewById(R.id.contentTxt);

        Announcement data = mList.get(position);

        titleTxt.setText(data.getTitle());
        contentTxt.setText(data.getContent());



        return row;

    }
}





