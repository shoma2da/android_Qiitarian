package com.tech_tec.qiitarian.model.items.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.tech_tec.qiitarian.model.items.StockCount;

public class StockCountParser {
    
    public StockCount parse(JSONObject object) throws JSONException {
        int stockCount = object.getInt("stock_count");
        return new StockCount(stockCount);
    }
    
}