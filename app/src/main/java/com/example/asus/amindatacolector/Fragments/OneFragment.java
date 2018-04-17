package com.example.asus.amindatacolector.Fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.asus.amindatacolector.Adapter.CustomAdapter;
import com.example.asus.amindatacolector.Model.Data;
import com.example.asus.amindatacolector.R;
import com.example.asus.amindatacolector.Utils.Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class OneFragment extends Fragment
{
    View view;

    ListView lstPosts;
    ArrayList<Data> datas = new ArrayList<>();
    CustomAdapter customAdapter;
    String Username;
    String UserCompany;
    Context context;

    public OneFragment()
    {

    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_one_profile, container, false);


        try
        {
//            Intent intent = getActivity().getIntent();
//            Username = intent.getStringExtra("companyName");
//            UserCompany = intent.getStringExtra("companyResearch");
//            Toast.makeText(getActivity().getApplicationContext(), Username, Toast.LENGTH_LONG).show();

            lstPosts = (ListView) view.findViewById(R.id.lstPosts);
            customAdapter = new CustomAdapter(context, datas, Username);
            lstPosts.setAdapter(customAdapter);

            new getAllMessage(context).execute();
        }
        catch (Exception e)
        {
            e.getLocalizedMessage();
        }

        return view;
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
                catch (JSONException e)
                {
                    e.fillInStackTrace();
                }
            }
            else
                Toast.makeText(context, "اطلاعاتی موجود نیست", Toast.LENGTH_LONG).show();
        }
    }
}
