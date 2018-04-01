package com.example.asus.amindatacolector;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.amindatacolector.Adapter.CustomAdapter;
import com.example.asus.amindatacolector.Model.Data;
import com.example.asus.amindatacolector.Utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Main2Activity extends AppCompatActivity
{
    ListView lstPosts;
    ArrayList<Data> datas = new ArrayList<>();
    CustomAdapter customAdapter;
    String Username;
    String UserCompany;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        try
        {


            Intent intent = getIntent();
            Username = intent.getStringExtra("companyName");
            UserCompany = intent.getStringExtra("companyResearch");
            Toast.makeText(getApplicationContext(), Username, Toast.LENGTH_LONG).show();

            lstPosts = (ListView) findViewById(R.id.lstPosts);
            customAdapter = new CustomAdapter(this, datas, Username);
            lstPosts.setAdapter(customAdapter);

            new getAllMessage(getApplicationContext()).execute();
        }
        catch (NullPointerException e)
        {
            e.fillInStackTrace();
        }
    }
    private class getAllMessage extends AsyncTask<Void,Void,String>
    {
        Context context;
        ProgressDialog progressDialog;

        public getAllMessage(Context context)
        {
            this.context = context;
        }

        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(Main2Activity.this);
            progressDialog.setMessage("شکیبا باشید... :)");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids)
        {
            String Address = "https://aminib.site/adcapi/all_message.php";
            return Utils.getData(Address);
        }

        @Override
        protected void onPostExecute(String jsonData)
        {
            progressDialog.dismiss();
            if (jsonData != null)
            {
                try
                {
                    JSONArray jsonArray = new JSONArray(jsonData);
                    for (int i=0 ; i<jsonArray.length() ; i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String visitorFromBudget = jsonObject.getString("visitorFromBudget");
                        String visitorCustomer = jsonObject.getString("visitorCustomer");
                        String companyName = jsonObject.getString("companyName");
                        String companyResearch = jsonObject.getString("companyResearch");
                        String gender = jsonObject.getString("gender");
                        String nameAndFamilyName = jsonObject.getString("nameAndFamilyName");
                        String fieldOfExpertise = jsonObject.getString("fieldOfExpertise");
                        String organizationLevel = jsonObject.getString("organizationLevel");
                        String cellPhone = jsonObject.getString("cellPhone");
                        String directPhone = jsonObject.getString("directPhone");
                        String fax = jsonObject.getString("fax");
                        String email = jsonObject.getString("email");
                        String postAddres = jsonObject.getString("postAddres");
                        String agreedServices = jsonObject.getString("agreedServices");
                        String needToNextVisit = jsonObject.getString("needToNextVisit");
                        String relationalName = jsonObject.getString("relationalName");
                        String relationalPhone = jsonObject.getString("relationalPhone");
                        String description = jsonObject.getString("description");

                        datas.add(new Data(visitorFromBudget,visitorCustomer, companyName, companyResearch,gender, nameAndFamilyName,
                                fieldOfExpertise, organizationLevel, cellPhone, directPhone, fax,
                                email, postAddres, agreedServices, needToNextVisit, relationalName, relationalPhone,
                                description));
//                        ((BaseAdapter)lstPosts.getAdapter()).notifyDataSetChanged();
                    }
                    ((BaseAdapter)lstPosts.getAdapter()).notifyDataSetChanged();
                }
                catch (Exception e)
                {
                    e.fillInStackTrace();
                }
            }
            else
                Toast.makeText(context, "اطلاعاتی موجود نیست", Toast.LENGTH_LONG).show();
        }
    }
}
