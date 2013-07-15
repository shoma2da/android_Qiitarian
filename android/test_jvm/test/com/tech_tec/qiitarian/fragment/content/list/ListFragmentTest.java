package com.tech_tec.qiitarian.fragment.content.list;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.fragment.content.list.ListFragment;

import android.view.LayoutInflater;
import android.view.View;

public class ListFragmentTest {
    
    @Test
    public void fragment_listをviewとして読み込んでいるか() {
        View mockView = mock(View.class);
        LayoutInflater mockInflater = mock(LayoutInflater.class);
        when(mockInflater.inflate(R.layout.fragment_list, null)).thenReturn(mockView);
        
        ListFragment listFragment = new ListFragment();
        View result = listFragment.onCreateView(mockInflater, null, null);
        
        assertSame(mockView, result);
    }
    
}