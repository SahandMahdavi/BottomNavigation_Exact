package com.example.asus.amindatacolector.Fragments;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.example.asus.amindatacolector.R;
import com.example.asus.amindatacolector.Utils.Utils;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import javax.xml.transform.Result;

public class ThreeFragment extends Fragment
{
    View view;

    EditText check_interact1, check_interact2, check_result2;

    EditText edt_organ1, edt_organ2 ,edt_personal_profile1, edt_personal_profile2, edt_personal_profile3,
             edt_personal_profile4, edt_contacts1, edt_contacts2,edt_contacts3, edt_contacts4, edt_contacts5,
             edt_result1, edt_result3, edt_result4, edt_result5;

    ImageView imageView;

    Button register_btn_register, btn_picture;

    private String codedImage = "";


    public ThreeFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_three_listing, container, false);

        initDeclare();
        onClick();

        return view;
    }

    private class registerRequest extends AsyncTask<Void,Void,String>
    {

        private final String visitorFromBudget;
        private final String visitorCustomer;
        private final String gender;
        private final String nameAndFamilyName;
        private final String fieldOfExpertise;
        private final String organizationLevel;
        private final String cellPhone;
        private final String directPhone;
        private final String fax;
        private final String email;
        private final String agreedServices;
        private final String needToNextVisit;
        private final String relationalName;
        private final String relationalPhone;
        private final String description;
        private final String companyName;
        private final String companyResearch;
        private final String postAddres;

        Context context;

        public registerRequest(String visitorFromBudget, String visitorCustomer, String companyName, String companyResearch, String gender, String nameAndFamilyName, String fieldOfExpertise, String organizationLevel, String cellPhone, String directPhone, String fax, String email, String postAddres, String agreedServices, String needToNextVisit, String relationalName, String relationalPhone, String description, Context context)
        {
            this.visitorFromBudget = visitorFromBudget;
            this.visitorCustomer = visitorCustomer;
            this.companyName = companyName;
            this.companyResearch = companyResearch;
            this.gender = gender;
            this.nameAndFamilyName = nameAndFamilyName;
            this.fieldOfExpertise = fieldOfExpertise;
            this.organizationLevel = organizationLevel;
            this.cellPhone = cellPhone;
            this.directPhone = directPhone;
            this.fax = fax;
            this.email = email;
            this.postAddres = postAddres;
            this.agreedServices = agreedServices;
            this.needToNextVisit = needToNextVisit;
            this.relationalName = relationalName;
            this.relationalPhone = relationalPhone;
            this.description = description;

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
            String Address = "https://aminib.site/adcapi/register.php";
            HashMap hashMap = new HashMap();

            hashMap.put("visitorFromBudget", visitorFromBudget);
            hashMap.put("visitorCustomer", visitorCustomer);
            hashMap.put("companyName", companyName);
            hashMap.put("companyResearch", companyResearch);
            hashMap.put("gender", gender);
            hashMap.put("nameAndFamilyName", nameAndFamilyName);
            hashMap.put("fieldOfExpertise", fieldOfExpertise);
            hashMap.put("organizationLevel", organizationLevel);
            hashMap.put("cellPhone", cellPhone);
            hashMap.put("directPhone", directPhone);
            hashMap.put("fax", fax);
            hashMap.put("email", email);
            hashMap.put("postAddres", postAddres);
            hashMap.put("agreedServices", agreedServices);
            hashMap.put("needToNextVisit", needToNextVisit);
            hashMap.put("relationalName", relationalName);
            hashMap.put("relationalPhone", relationalPhone);
            hashMap.put("description", description);

//            hashMap.put("context", context);

            return Utils.sendData(Address,hashMap);
        }

        @Override
        protected void onPostExecute(String s)
        {
            Toast.makeText(context,s,Toast.LENGTH_LONG).show();
        }
    }

    public void initDeclare()
    {
        check_interact1 = (EditText)view.findViewById(R.id.check_interact1);
        check_interact2 = (EditText)view.findViewById(R.id.check_interact2);
        check_result2   = (EditText)view.findViewById(R.id.check_result2);

        edt_organ1      = (EditText)view.findViewById(R.id.edt_organ1);
        edt_organ2      = (EditText)view.findViewById(R.id.edt_organ2);
        edt_personal_profile1 = (EditText)view.findViewById(R.id.edt_personal_profile1);
        edt_personal_profile2 = (EditText)view.findViewById(R.id.edt_personal_profile2);
        edt_personal_profile3 = (EditText)view.findViewById(R.id.edt_personal_profile3);
        edt_personal_profile4 = (EditText)view.findViewById(R.id.edt_personal_profile4);
        edt_contacts1   = (EditText)view.findViewById(R.id.edt_contacts1);
        edt_contacts2   = (EditText)view.findViewById(R.id.edt_contacts2);
        edt_contacts3   = (EditText)view.findViewById(R.id.edt_contacts3);
        edt_contacts4   = (EditText)view.findViewById(R.id.edt_contacts4);
        edt_contacts5   = (EditText)view.findViewById(R.id.edt_contacts5);
        edt_result1     = (EditText)view.findViewById(R.id.edt_result1);
        edt_result3     = (EditText)view.findViewById(R.id.edt_result3);
        edt_result4     = (EditText)view.findViewById(R.id.edt_result4);
        edt_result5     = (EditText)view.findViewById(R.id.edt_result5);

        imageView       = (ImageView)view.findViewById(R.id.imageView);

        register_btn_register = (Button)view.findViewById(R.id.register_btn_register);
        btn_picture           = (Button)view.findViewById(R.id.btn_picture);
    }

    public void onClick()
    {
        register_btn_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//                Toast.makeText(getActivity().getApplicationContext(), "Registered succesfully",
//                        Toast.LENGTH_SHORT).show();
//
//                getActivity().finish();

                String check1 = check_interact1.getText().toString();
                String check2 = check_interact2.getText().toString();
                String check3 = check_result2.getText().toString();
                String organ1 = edt_organ1.getText().toString();
                String organ2 = edt_organ2.getText().toString();
                String personal_profile1 = edt_personal_profile1.getText().toString();
                String personal_profile2 = edt_personal_profile2.getText().toString();
                String personal_profile3 = edt_personal_profile3.getText().toString();
                String personal_profile4 = edt_personal_profile4.getText().toString();
                String contacts1 = edt_contacts1.getText().toString();
                String contacts2 = edt_contacts2.getText().toString();
                String contacts3 = edt_contacts3.getText().toString();
                String contacts4 = edt_contacts4.getText().toString();
                String contacts5 = edt_contacts5.getText().toString();
                String result1 = edt_result1.getText().toString();
                String result2 = edt_result3.getText().toString();
                String result3 = edt_result4.getText().toString();
                String result4 = edt_result5.getText().toString();

                try
                {


                    if (
                            check1.equals("") || check2.equals("") || check3.equals("") || organ1.equalsIgnoreCase("") || organ2.equalsIgnoreCase("") || personal_profile1.equalsIgnoreCase("") || personal_profile2.equalsIgnoreCase("") || personal_profile3.equalsIgnoreCase("") || personal_profile4.equalsIgnoreCase("") || contacts1.equalsIgnoreCase("") || contacts2.equalsIgnoreCase("") || contacts3.equalsIgnoreCase("") || contacts4.equalsIgnoreCase("") || contacts5.equalsIgnoreCase("") || result1.equalsIgnoreCase("") || result2.equalsIgnoreCase("") || result3.equalsIgnoreCase("") || result4.equalsIgnoreCase(""))
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "لطفا همه موارد را درج کنید", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        new registerRequest
                                (
                                        check1, check2, organ1, organ2,
                                        personal_profile1, personal_profile2, personal_profile3, personal_profile4,
                                        contacts1, contacts2, contacts3, contacts4, contacts5,
                                        result1, check3, result2, result3, result4, getActivity().getApplicationContext()
                                ).execute();
                    }
                }
                catch (NullPointerException e)
                {
                    e.fillInStackTrace();
                }
            }
        });
        //click();
    }

//    private void click()
//    {
//        imageView.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                try
//                {
//                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                    startActivityForResult(intent, 0);
//                }
//                catch (Exception e)
//                {
//                    e.getStackTrace();
//                }
//            }
//        });
//    }

//    @Override
//    public void onSaveInstanceState(Bundle outState)
//    {
//        click();
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data)
//    {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
//        imageView.setImageBitmap(bitmap);
//    }
}
