package com.example.asus.amindatacolector.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.asus.amindatacolector.Model.Data;
import com.example.asus.amindatacolector.R;
import com.example.asus.amindatacolector.Utils.Utils;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


public class CustomAdapter extends BaseAdapter
{
    private Context context;
    public ArrayList<Data> data = new ArrayList<>();
    private LayoutInflater inflater = null;
    private String username;
    public ImageView imageVisitor;
    String codedImage = "";
//    private String url = "https://aminib.site/adcapi/personal_card.php";
//    public CustomAdapter(Context context, ArrayList<Data> data)
//    {
//        this.context = context;
//        this.data = data;
//    }

    public CustomAdapter(Context ctx, ArrayList<Data> data, String companyName)
    {
        this.context = ctx;
        this.data = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.username = companyName;
    }

    public int getCount()
    {
        if (data.size() <= 0)
            return 1;
        return data.size();
    }

    public Object getItem(int position)
    {
        return position;
    }

    public long getItemId(int position)
    {
        return position;
    }

    public static class ViewHolder
    {
        public TextView visitorFromBudget;
        public TextView visitorCustomer;
        public TextView companyName;
        public TextView companyResearch;
        public TextView gender;
        public TextView nameAndFamilyNAme;
        public TextView fieldOfExpertise;
        public TextView organizationLevel;
        public TextView cellPhone;
        public TextView directPhone;
        public TextView fax;
        public TextView email;
        public TextView postAddres;
        public TextView agreedServices;
        public TextView needToNextVisit;
        public TextView relationalName;
        public TextView relationalPhone;
        public TextView description;
        public ImageView image;
    }

    public View getView(final int position, View convertView, ViewGroup parent)
    {

        View vi = convertView;
        final ViewHolder holder;

        if (vi == null)
        {
            vi = inflater.inflate(R.layout.data, null);

            holder = new ViewHolder();
            holder.visitorFromBudget = (TextView) vi.findViewById(R.id.visitorFromBudget);
            holder.visitorCustomer = (TextView) vi.findViewById(R.id.visitorCustomer);
            holder.companyName = (TextView) vi.findViewById(R.id.companyName);
            holder.companyResearch = (TextView) vi.findViewById(R.id.companyResearch);
            holder.gender = (TextView) vi.findViewById(R.id.gender);
            holder.nameAndFamilyNAme = (TextView) vi.findViewById(R.id.nameAndFamilyName);
            holder.fieldOfExpertise = (TextView) vi.findViewById(R.id.fieldOfExpertise);
            holder.organizationLevel = (TextView) vi.findViewById(R.id.organizationLevel);
            holder.cellPhone = (TextView) vi.findViewById(R.id.cellPhone);
            holder.directPhone = (TextView) vi.findViewById(R.id.directPhone);
            holder.fax = (TextView) vi.findViewById(R.id.fax);
            holder.email = (TextView) vi.findViewById(R.id.email);
            holder.postAddres = (TextView) vi.findViewById(R.id.postAddres);
            holder.agreedServices = (TextView) vi.findViewById(R.id.agreedServices);
            holder.needToNextVisit = (TextView) vi.findViewById(R.id.needToNextVisit);
            holder.relationalName = (TextView) vi.findViewById(R.id.relationalName);
            holder.relationalPhone = (TextView) vi.findViewById(R.id.relationalPhone);
            holder.description = (TextView) vi.findViewById(R.id.description);
            holder.image = (ImageView) vi.findViewById(R.id.image);



            vi.setTag(holder);
        } else
        {
            holder = (ViewHolder) vi.getTag();
        }

        if (data.size() == 0)
        {
            holder.visitorFromBudget.setText("No Data");
            holder.visitorCustomer.setText("No Data");
            holder.companyName.setText("No Data");
            holder.companyResearch.setText("No Data");
            holder.gender.setText("No Data");
            holder.nameAndFamilyNAme.setText("No Data");
            holder.fieldOfExpertise.setText("No Data");
            holder.organizationLevel.setText("No Data");
            holder.cellPhone.setText("No Data");
            holder.directPhone.setText("No Data");
            holder.fax.setText("No Data");
            holder.postAddres.setText("No Data");
            holder.agreedServices.setText("No Data");
            holder.needToNextVisit.setText("No Data");
            holder.relationalName.setText("No Data");
            holder.relationalPhone.setText("No Data");
            holder.description.setText("No Data");
            holder.image.setImageBitmap(null);
        } else
        {

            holder.visitorFromBudget.setText(data.get(position).getVisitorFromBudget());
            holder.visitorCustomer.setText(data.get(position).getVisitorCustomer());
            holder.companyName.setText(data.get(position).getCompanyName());
            holder.companyResearch.setText(data.get(position).getCompanyResearch());
            holder.gender.setText(data.get(position).getGender());
            holder.nameAndFamilyNAme.setText(data.get(position).getNameAndFamilyName());
            holder.fieldOfExpertise.setText(data.get(position).getFieldOfExpertise());
            holder.organizationLevel.setText(data.get(position).getOrganizationLevel());
            holder.cellPhone.setText(data.get(position).getCellPhone());
            holder.directPhone.setText(data.get(position).getDirectPhone());
            holder.fax.setText(data.get(position).getFax());
            holder.email.setText(data.get(position).getEmail());
            holder.postAddres.setText(data.get(position).getPostAddres());
            holder.agreedServices.setText(data.get(position).getAgreedServices());
            holder.needToNextVisit.setText(data.get(position).getNeedToNextVisit());
            holder.relationalName.setText(data.get(position).getRelationalName());
            holder.relationalPhone.setText(data.get(position).getRelationalPhone());
            holder.description.setText(data.get(position).getDescription());

//            Picasso.with(context)
//                    .load("https://aminib.site/adcapi/personal_card.php")
//                    .into(imageVisitor);

        }
        return vi;
    }
}

//        class likeRequest extends AsyncTask<Void, Void, String>
//        {
//            private final String visitorFromBudget;
//            private final String visitorCustomer;
//            private final String gender;
//            private final String nameAndFamilyName;
//            private final String fieldOfExpertise;
//            private final String organizationLevel;
//            private final String cellPhone;
//            private final String directPhone;
//            private final String fax;
//            private final String email;
//            private final String agreedServices;
//            private final String needToNextVisit;
//            private final String relationalName;
//            private final String relationalPhone;
//            private final String description;
//            private final String companyName;
//            private final String companyResearch;
//            private final String postAddres;
//
//            ViewHolder viewHolder;
//
//            public likeRequest(String visitorFromBudget, String visitorCustomer, String companyName, String companyResearch, String gender, String nameAndFamilyName, String fieldOfExpertise, String organizationLevel, String cellPhone, String directPhone, String fax, String email, String postAddres, String agreedServices, String needToNextVisit, String relationalName, String relationalPhone, String description, ViewHolder viewHolder)
//            {
//                this.visitorFromBudget = visitorFromBudget;
//                this.visitorCustomer = visitorCustomer;
//                this.companyName = companyName;
//                this.companyResearch = companyResearch;
//                this.gender = gender;
//                this.nameAndFamilyName = nameAndFamilyName;
//                this.fieldOfExpertise = fieldOfExpertise;
//                this.organizationLevel = organizationLevel;
//                this.cellPhone = cellPhone;
//                this.directPhone = directPhone;
//                this.fax = fax;
//                this.email = email;
//                this.postAddres = postAddres;
//                this.agreedServices = agreedServices;
//                this.needToNextVisit = needToNextVisit;
//                this.relationalName = relationalName;
//                this.relationalPhone = relationalPhone;
//                this.description = description;
//                this.viewHolder = viewHolder;
//            }
//
//            @Override
//            protected void onPreExecute()
//            {
//                super.onPreExecute();
//            }
//
//            @Override
//            protected String doInBackground(Void... voids)
//            {
//                String Address = "https://aminib.site/adcapi/register.php";
//                HashMap hashMap = new HashMap();
//
//                hashMap.put("visitorFromBudget", visitorFromBudget);
//                hashMap.put("visitorCustomer", visitorCustomer);
//                hashMap.put("companyName", companyName);
//                hashMap.put("companyResearch", companyResearch);
//                hashMap.put("gender", gender);
//                hashMap.put("nameAndFamilyName", nameAndFamilyName);
//                hashMap.put("fieldOfExpertise", fieldOfExpertise);
//                hashMap.put("organizationLevel", organizationLevel);
//                hashMap.put("cellPhone", cellPhone);
//                hashMap.put("directPhone", directPhone);
//                hashMap.put("fax", fax);
//                hashMap.put("email", email);
//                hashMap.put("postAddres", postAddres);
//                hashMap.put("agreedServices", agreedServices);
//                hashMap.put("needToNextVisit", needToNextVisit);
//                hashMap.put("relationalName", relationalName);
//                hashMap.put("relationalPhone", relationalPhone);
//                hashMap.put("description", description);
////                hashMap.put("viewHolder", viewHolder);
//
//                return Utils.sendData(Address, hashMap);
//            }
//
//            @Override
//            protected void onPostExecute(String s)
//            {
//                Toast.makeText(context,s,Toast.LENGTH_LONG).show();
//            }
//        }
//
//        return vi;
//    }

//    public void sendImageRequest()
//    {
//        String url = "https://aminib.site/adcapi/personal_card.php";
//
//        Response.Listener<String> listener = new Response.Listener<String>()
//        {
//            @Override
//            public void onResponse(String response)
//            {
//                downloadImage(response);
//            }
//        };
//
//        Response.ErrorListener errorListener = new Response.ErrorListener()
//        {
//            @Override
//            public void onErrorResponse(VolleyError error)
//            {
//                Toast.makeText(context,
//                        error.getMessage() , Toast.LENGTH_SHORT ).show();
//            }
//        };
//
//        StringRequest request = new StringRequest(Request.Method.GET, url, listener, errorListener)
//        {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError
//            {
//                Map<String, String> params = new Hashtable<String, String>();
//                String image = "image";
//                params.get(image);
//                params.get("name");
//                return params;
//            }
//        };
//        request.setRetryPolicy(new DefaultRetryPolicy(1000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//    }
//
//    private void downloadImage(String url)
//    {
//        Response.Listener<Bitmap> listener = new Response.Listener<Bitmap>()
//        {
//            @Override
//            public void onResponse(Bitmap response)
//            {
//                imageVisitor.setImageBitmap(response);
//            }
//        };
//
//        Response.ErrorListener errorListener = new Response.ErrorListener()
//        {
//            @Override
//            public void onErrorResponse(VolleyError error)
//            {
//                Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        };
//
//        ImageRequest request = new ImageRequest(url, listener, 0, 0, null, null, errorListener);
//    }

