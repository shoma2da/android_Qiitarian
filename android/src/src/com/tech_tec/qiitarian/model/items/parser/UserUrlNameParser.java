package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.UserUrlName;

public class UserUrlNameParser {
    
    public UserUrlName parser(JSONObject object) throws JSONException {
        String userName = object.getString("url_name");
        return new UserUrlName(userName);
    }
    
}
