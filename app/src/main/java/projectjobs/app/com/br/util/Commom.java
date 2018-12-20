package projectjobs.app.com.br.util;

import java.util.HashMap;
import java.util.Map;

import projectjobs.app.com.br.R;

import static android.provider.Settings.Global.getString;

public class Commom {

    public static final String STRING_URL_BASE = "http://jobappliances.herokuapp.com/api/v1/";
    public static final String CHAVE_ID = "ID";

    public static Map<String,String> headers(){
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "vibe2018");
        return map;
    }

}
