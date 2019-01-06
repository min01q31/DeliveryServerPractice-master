package tjeit.kr.deliveryserverpractice;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tjeit.kr.deliveryserverpractice.adapters.BankSpinnerAdapter;
import tjeit.kr.deliveryserverpractice.datas.Bank;
import tjeit.kr.deliveryserverpractice.utils.ConnectServer;

public class EditProfileActivity extends BaseActivity {

    BankSpinnerAdapter mBankSpinnerAdapter;
    List<Bank> bankList = new ArrayList<Bank>();


    private android.widget.Spinner bankSpinner;
    private android.widget.EditText accountNumberEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
//        서버에서 은행 목록을 받아와서 Spinner에 뿌려주기.

        mBankSpinnerAdapter = new BankSpinnerAdapter(mContext, bankList);
        bankSpinner.setAdapter(mBankSpinnerAdapter);

        getBanksFromServer();



    }

    void getBanksFromServer() {
        ConnectServer.getRequestBank(mContext, new ConnectServer.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                Log.d("은행응답", json.toString());

                try {
                    int code = json.getInt("code");
                    if (code == 200) {
                        JSONObject data = json.getJSONObject("data");
                        JSONArray banks = data.getJSONArray("banks");

                        for (int i = 0 ; i < banks.length() ; i++ ) {
                            JSONObject bankJson = banks.getJSONObject(i);
                            Bank bank = Bank.getBankFromJson(bankJson);

                            bankList.add(bank);

                        }

                        mBankSpinnerAdapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void bindViews() {
        this.accountNumberEdt = (EditText) findViewById(R.id.accountNumberEdt);
        this.bankSpinner = (Spinner) findViewById(R.id.bankSpinner);
    }
}
