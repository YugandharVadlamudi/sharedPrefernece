package com.example.kiran.sharedprefernece;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kiran on 16-11-2015.
 */
public class displayUserName extends Activity
{
    TextView TVdispay,TVWelcome;
    SharedPreferences sp_get;
    LinearLayout LLVDisplay;
    RelativeLayout RLWelcome;
    Button BTLogin;
    Intent Intenct_first_screen;
    RelativeLayout.LayoutParams RLP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_username);
        sp_get=getSharedPreferences("Username",MODE_PRIVATE);
        TVdispay=(TextView)findViewById(R.id.TVdispay);
        TVdispay.setTextSize(80);
        TVdispay.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        TVdispay.setGravity(Gravity.CENTER_VERTICAL);
        TVdispay.setText(sp_get.getString("UserName",null).toString());
    }
    /*
    * shared prefernece clear method*/
    public void SharedpreferenceClear(View arg0)
    {
        sp_get=getSharedPreferences("Username",MODE_PRIVATE);
        sp_get.edit().putString("UserName","").commit();
        sp_get.getAll();
        Intenct_first_screen=new Intent(displayUserName.this,UserLogin.class);
        startActivity(Intenct_first_screen);

    }
}
