//package com.example.asus.amindatacolector.Fragments;
//
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import com.example.asus.amindatacolector.Adapter.CustomAdapter;
//import com.example.asus.amindatacolector.Model.Data;
//import com.example.asus.amindatacolector.R;
//import com.example.asus.amindatacolector.Utils.Utils;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
//public class TwoFragment extends Fragment
//{
//    View view;
//    EditText edt_search_profile_fragment_two;
//    ImageView ic_search;
////    ListView lstpost2;
////    ArrayList<Data> data2 = new ArrayList<>();
////    CustomAdapter customAdapter2;
//
//    public TwoFragment()
//    {
//
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
//    {
//        view = inflater.inflate(R.layout.fragment_two_search, container, false);
//
//        initDeclare();
//
////        try
////        {
////            lstpost2 = (ListView) view.findViewById(R.id.lstPosts2);
////            customAdapter2 = new CustomAdapter(getActivity().getApplicationContext(), data2);
////            lstpost2.setAdapter(customAdapter2);
////        }
////        catch (NullPointerException e)
////        {
////            e.fillInStackTrace();
////        }
//        return view;
//    }
//
//    public void initDeclare()
//    {
//        edt_search_profile_fragment_two = (EditText)view.findViewById(R.id.edt_search_profile_fragment_two);
//        ic_search = (ImageView)view.findViewById(R.id.ic_search);
//    }
//
//    //=========================================
////    private class getAllMessage extends AsyncTask<Void,Void,String>
////    {
////        Context context;
////
////        public getAllMessage(Context context)
////        {
////            this.context = context;
////        }
////
////        @Override
////        protected void onPreExecute()
////        {
////            super.onPreExecute();
////        }
////
////        @Override
////        protected String doInBackground(Void... voids)
////        {
////            String Address = "https://aminib.site/adcapi/all_message.php";
////            return Utils.getData(Address);
////        }
////
////        @Override
////        protected void onPostExecute(String jsonData)
////        {
////            if (jsonData != null)
////            {
////                try
////                {
////                    JSONArray jsonArray = new JSONArray(jsonData);
////                    for (int i=0 ; i<jsonArray.length() ; i++)
////                    {
////                        JSONObject jsonObject = jsonArray.getJSONObject(i);
////
////                        String visitorFromBudget = jsonObject.getString("visitorFromBudget");
////                        String visitorCustomer = jsonObject.getString("visitorCustomer");
////                        String companyName = jsonObject.getString("companyName");
////                        String companyResearch = jsonObject.getString("companyResearch");
////                        String gender = jsonObject.getString("gender");
////                        String nameAndFamilyName = jsonObject.getString("nameAndFamilyName");
////                        String fieldOfExpertise = jsonObject.getString("fieldOfExpertise");
////                        String organizationLevel = jsonObject.getString("organizationLevel");
////                        String cellPhone = jsonObject.getString("cellPhone");
////                        String directPhone = jsonObject.getString("directPhone");
////                        String fax = jsonObject.getString("fax");
////                        String email = jsonObject.getString("email");
////                        String postAddres = jsonObject.getString("postAddres");
////                        String agreedServices = jsonObject.getString("agreedServices");
////                        String needToNextVisit = jsonObject.getString("needToNextVisit");
////                        String relationalName = jsonObject.getString("relationalName");
////                        String relationalPhone = jsonObject.getString("relationalPhone");
////                        String description = jsonObject.getString("description");
////
////                        data2.add(new Data(visitorFromBudget,visitorCustomer, companyName, companyResearch,gender, nameAndFamilyName,
////                                fieldOfExpertise, organizationLevel, cellPhone, directPhone, fax,
////                                email, postAddres, agreedServices, needToNextVisit, relationalName, relationalPhone,
////                                description));
//////                        ((BaseAdapter)lstPosts.getAdapter()).notifyDataSetChanged();
////                    }
////                    ((BaseAdapter) lstpost2.getAdapter()).notifyDataSetChanged();
////                }
////                catch (Exception e)
////                {
////                    e.fillInStackTrace();
////                }
////            }
////            else
////                Toast.makeText(context, "اطلاعاتی موجود نیست", Toast.LENGTH_LONG).show();
////        }
////    }
//}
