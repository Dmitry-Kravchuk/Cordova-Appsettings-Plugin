package com.kradmi.cordova.appsettings;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaPreferences;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Locale;

public class AppSettings extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    	JSONObject options = new JSONObject();
        if (action.equals("get")) {
        	try{
                CordovaPreferences prefs = webView.getPreferences();
                for(int i=0;i<args.length();i++){
        	        String key = args.getString(i).toLowerCase(Locale.getDefault());
                    String value = prefs.getString(key, null);
                    if (value != null) {
                        options.put(key, value);
                    }
                }
                callbackContext.success(options);
        	} catch (Exception ex) {
            	callbackContext.error(0);
            }
            return true;
        }
        return false;
    }
}
