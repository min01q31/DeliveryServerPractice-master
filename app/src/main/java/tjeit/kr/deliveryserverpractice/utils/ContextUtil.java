package tjeit.kr.deliveryserverpractice.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ContextUtil {

    private static final String prefName = "DeliveryPref";

    private static final String TOKEN = "TOKEN";

//    get, set 작업

    public static void setToken(Context context, String inputToken) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putString(TOKEN, inputToken).apply();
    }

    public static String getToken(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return pref.getString(TOKEN, "");
    }

}
