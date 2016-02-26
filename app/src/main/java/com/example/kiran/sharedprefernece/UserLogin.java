package com.example.kiran.sharedprefernece;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends Activity {
    EditText UserName,Passworld;
    String EdUserNameString,EdPasswordString,name_get;
    Button Login;
    SharedPreferences SP_object,sp_get;
    SharedPreferences.Editor Sp_objec_eidtor;
    Intent Intent_username_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*check purpose*/
                sp_get=getSharedPreferences("Username",MODE_PRIVATE);
       // String check=sp_get.contains("UserName");
        name_get=sp_get.getString("UserName","").toString();

        if(!name_get.equals(""))
        {
            Intent_username_screen=new Intent(getApplicationContext(),displayUserName.class);
            startActivity(Intent_username_screen);
        }
        else {
            setContentView(R.layout.activity_user_login);
            Login = (Button) findViewById(R.id.BtLogin);
            Login.setOnClickListener(new EdValidation());
        }
    }
    /*
    * class
    * */
    class EdValidation implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            UserName=(EditText)findViewById(R.id.EdUName);
            Passworld=(EditText)findViewById(R.id.EdPassword);
            EdUserNameString=UserName.getText().toString();
            EdPasswordString=Passworld.getText().toString();
            if(EdUserNameString.equals(EdPasswordString))
            {
                Toast.makeText(getApplicationContext(),"compared with Case Sensitive",Toast.LENGTH_LONG).show();
                /*got next activity*/
                SP_object=getSharedPreferences("Username",MODE_PRIVATE);
                Sp_objec_eidtor=SP_object.edit();
                Sp_objec_eidtor.putString("UserName",EdPasswordString);
                Sp_objec_eidtor.apply();
                Intent_username_screen=new Intent(getApplicationContext(),displayUserName.class);
                startActivity(Intent_username_screen);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"difference with capitals",Toast.LENGTH_LONG).show();
            }
        }
    }/*Class EdValidation*/

}
