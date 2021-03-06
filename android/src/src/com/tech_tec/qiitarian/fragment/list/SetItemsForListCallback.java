package com.tech_tec.qiitarian.fragment.list;

import java.util.Iterator;

import android.widget.ArrayAdapter;

import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.model.items.Items;

public class SetItemsForListCallback implements FetchTask.Callback {
    
    private ArrayAdapter<Item> mAdapter;
    
    public SetItemsForListCallback(ArrayAdapter<Item> adapter) {
        mAdapter = adapter;
    }
    
    @Override
    public void onSuccess(Items items) {
        Iterator<Item> iterator = items.getItemIterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            addToAdapter(item);
        }
    }
    
    private void addToAdapter(Item item) {
        if (alreadyHas(item)) {
            return;
        }
        mAdapter.insert(item, 0);
    }
    
    private boolean alreadyHas(Item item) {
        int size = mAdapter.getCount();
        for (int i = 0; i < size; i++) {
            Item contains = mAdapter.getItem(i);
            boolean equals = item.equals(contains);
            if (equals) { return true; }
        }
        return false;
    }
    
    @Override
    public void onEmptySuccess() {
    }

    @Override
    public void onError() {
    }

}
