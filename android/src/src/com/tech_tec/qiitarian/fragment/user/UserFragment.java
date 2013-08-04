package com.tech_tec.qiitarian.fragment.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.common.UserUrlName;

public class UserFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
        
        FetchUserAsyncTask task = new FetchUserAsyncTask(new UserUrlName("himara2"), new FetchUserCallback(getActivity()));
        task.execute();
        
        return view;
    }
    
}
