package com.tech_tec.qiitarian.fragment.content.list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.markupartist.android.widget.PullToRefreshListView;
import com.markupartist.android.widget.PullToRefreshListView.OnRefreshListener;
import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.items.Item;
import com.tech_tec.qiitarian.task.list.FetchItemsAsyncTask;
import com.tech_tec.qiitarian.task.list.ProgressShowCallback;
import com.tech_tec.qiitarian.task.list.SetItemsForListCallback;
import com.tech_tec.qiitarian.task.list.FetchItemsAsyncTask.UiCallback;

public class ItemsFragment extends Fragment {
    
    private PullToRefreshListView mListView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, null);
        mListView = (PullToRefreshListView)view.findViewById(R.id.list);
        return view;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        final ArrayAdapter<Item> adapter = new ItemArrayAdapter(getActivity());
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new GotoDetailOnItemClickListener(getActivity()));
        mListView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                SetItemsForListCallback callback = new SetItemsForListCallback(adapter);
                UiCallback uiCallback = new ProgressShowCallback(mListView);
                new FetchItemsAsyncTask(callback, uiCallback).execute();
            }
        });
    }
    
}
