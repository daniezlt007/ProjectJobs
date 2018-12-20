package projectjobs.app.com.br.util;

import android.content.Context;
import android.net.ConnectivityManager;

/*
* Verificação de internet
* */

public class InternetAvailable {

    public static Boolean isConnectionAvailable(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isConnectedOrConnecting();
    }

}
