package tjeit.kr.deliveryserverpractice.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import tjeit.kr.deliveryserverpractice.R;
import tjeit.kr.deliveryserverpractice.datas.Bank;

public class BankSpinnerAdapter extends ArrayAdapter<Bank> {

    Context mContext;
    List<Bank> mList;
    LayoutInflater inf;

    public BankSpinnerAdapter(Context context, List<Bank> list){
        super(context, R.layout.bank_spinner_list_item, list);

        this.mContext = context;
        this.mList = list;
        this.inf = LayoutInflater.from(mContext);
    }

    @Override
    public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = inf.inflate(R.layout.bank_spinner_list_item,null);
        }

        ImageView logoImg = row.findViewById(R.id.logoImg);
        TextView bankNameTxt = row.findViewById(R.id.bankNameTxt);

        Bank data = mList.get(position);

        Glide.with(mContext).load(data.getLogo()).into(logoImg);
        bankNameTxt.setText(data.getName());

        return row;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = inf.inflate(R.layout.bank_spinner_list_item,null);
        }

        ImageView logoImg = row.findViewById(R.id.logoImg);
        TextView bankNameTxt = row.findViewById(R.id.bankNameTxt);

        Bank data = mList.get(position);

        Glide.with(mContext).load(data.getLogo()).into(logoImg);
        bankNameTxt.setText(data.getName());

        return row;
    }
}
