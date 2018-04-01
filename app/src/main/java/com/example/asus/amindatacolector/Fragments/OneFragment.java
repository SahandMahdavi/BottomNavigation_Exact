package com.example.asus.amindatacolector.Fragments;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.Toast;

import com.example.asus.amindatacolector.Main2Activity;
import com.example.asus.amindatacolector.R;
import com.example.asus.amindatacolector.Utils.Utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class OneFragment extends Fragment
{
    View view;
    EditText edt_organ_in1, edt_organ_in2;
    Button login_login_btn;

    public OneFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_one_profile, container, false);

        initDeclare();
        onClick();

        return view;
    }

    private class loginRequest extends AsyncTask<Void,Void,String>
    {
        private final String companyName;
        private final String companyResearch;

        Context context;

        public loginRequest(String companyName, String companyResearch, Context context)
        {
            this.companyName = companyName;
            this.companyResearch = companyResearch;

            this.context = context;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids)
        {
            String Address = "https://aminib.site/adcapi/login.php";
            HashMap hashMap = new HashMap();

            hashMap.put("companyName",companyName);
            hashMap.put("companyResearch",companyResearch);

            return Utils.sendData(Address,hashMap);
        }

        @Override
        protected void onPostExecute(String s)
        {
            Toast.makeText(context,s,Toast.LENGTH_LONG).show();
            if (s.equals("مشاهده اطلاعات"))
            {
                Intent i = new Intent(getActivity(), Main2Activity.class);
                i.putExtra("companyName", companyName);
//                i.putExtra("companyResearch",companyResearch);
                startActivity(i);
//                startActivity(new Intent(getActivity(), Main2Activity.class));
            }
        }
    }

    public void initDeclare()
    {
        edt_organ_in1 = (EditText)view.findViewById(R.id.edt_organ_in1);
        edt_organ_in2 = (EditText)view.findViewById(R.id.edt_organ_in2);

        login_login_btn  = (Button)view.findViewById(R.id.login_login_btn);
    }


    public void onClick()
    {
        login_login_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    //startActivity(new Intent(getActivity(), Main2Activity.class));
                    String organ_in1 = edt_organ_in1.getText().toString();
                    String organ_in2 = edt_organ_in2.getText().toString();

                    if (organ_in1.equals("") || organ_in2.equals(""))
                    {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "برای ورود فیلد های بالا را تکمیل کنید..", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        new loginRequest(organ_in1, organ_in2, getActivity().getApplicationContext()).execute();
//                        startActivity(new Intent(getActivity(), Main2Activity.class));
                    }
                }

                catch (NullPointerException e)
                {
                    e.fillInStackTrace();
                }
            }
        });
    }
}
