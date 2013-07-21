package com.tech_tec.qiitarian.model.items;

import java.io.IOException;

import android.graphics.Bitmap;


public class User {
    
    private UserName mUserName;
    private UserProfileImg mUserProfileImg;
    
    public User(UserName userName, UserProfileImg userProfileImg) {
        mUserName = userName;
        mUserProfileImg = userProfileImg;
    }
    
    public Bitmap fetchIconImg() throws IOException {
        return mUserProfileImg.fetchImg();
    }
    
    public String getUserName() {
        return mUserName.toString();
    }
    
}
