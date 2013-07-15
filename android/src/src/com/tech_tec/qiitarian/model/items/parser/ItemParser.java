package com.tech_tec.qiitarian.model.items.parser;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Uuid;
import com.tech_tec.qiitarian.model.items.meta.User;

public class ItemParser {
    
    public Item parser(JSONObject object) throws JSONException, MalformedURLException {
        Uuid uuid = new UuidParser().parse(object);
        User user = new UserParser().parse(object.getJSONObject("user"));
        
        return new Item();
    }
    
}