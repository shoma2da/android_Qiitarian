package com.tech_tec.qiitarian.model.detail;

import java.util.ArrayList;
import java.util.Iterator;

public class Comments {
    
    private ArrayList<Comment> mCommentList = new ArrayList<Comment>();
    
    public Iterator<Comment> getCommentIterator() {
        ArrayList<Comment> copied = new ArrayList<Comment>(mCommentList);
        return copied.iterator();
    }
    
    public void add(Comment Comment) {
        mCommentList.add(Comment);
    }
    
}
