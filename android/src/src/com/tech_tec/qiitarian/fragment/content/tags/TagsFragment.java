package com.tech_tec.qiitarian.fragment.content.tags;

import java.util.Iterator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.auth.AuthInfo;
import com.tech_tec.qiitarian.model.auth.pref.AuthInfoPreferences;
import com.tech_tec.qiitarian.model.tags.Tag;
import com.tech_tec.qiitarian.model.tags.Tags;
import com.tech_tec.qiitarian.task.tags.FetchTagsAsyncTask;

public class TagsFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tags, null);
        
        GridView gridView = (GridView)view.findViewById(R.id.grid_tags);
        final ArrayAdapter<Tag> adapter = new TagArrayAdapter(getActivity());
        gridView.setAdapter(adapter);
        
        //サンプル------------------------------------------
        AuthInfo authInfo = new AuthInfoPreferences(getActivity()).load();
        int page = 1;
        new FetchTagsAsyncTask(authInfo.getUrlName(), page, new FetchTagsAsyncTask.Callback() {
            @Override
            public void onSuccess(Tags tags) {
                Iterator<Tag> iterator = tags.getTagIterator();
                while (iterator.hasNext()) {
                    Tag tag = iterator.next();
                    adapter.add(tag);
                }
            }
            
            @Override
            public void onError() {
                Toast.makeText(getActivity(), "通信エラーです", Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onEmpty() {
                Toast.makeText(getActivity(), "一つもタグをフォローしていません", Toast.LENGTH_SHORT).show();
            }
        }).execute();
        //サンプル------------------------------------------
        
        return view;
    }
    
}
