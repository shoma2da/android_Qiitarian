package com.tech_tec.qiitarian.model.items.parser;

import java.io.InputStream;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Items;

public class ItemsParser {
    
    private ItemParser mItemParser;
    
    public ItemsParser() {
        mItemParser = createItemParser();
    }
    
    public Items parse(InputStream input) throws JSONException {
        String content = inputToString(input);
        JSONArray jsonArray = new JSONArray(content);
        return parse(jsonArray);
    }
    
    String inputToString(InputStream input) {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(input);
        while(scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        return builder.toString();
    }
    
    public Items parse(JSONArray jsonArray) throws JSONException {
        Items items = new Items();
        
        int arrayLenght = jsonArray.length();
        for (int i = 0; i < arrayLenght; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Item item = mItemParser.parser(jsonObject);
            items.add(item);
        }
        
        return items;
    }
    
    ItemParser createItemParser() {
        return new ItemParser();
    }
}
