package com.example.asus.amindatacolector.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.asus.amindatacolector.R;
import com.example.asus.amindatacolector.Utils.ImagePickerUtil;
import com.example.asus.amindatacolector.Utils.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import io.fabric.sdk.android.Fabric;

import static android.app.Activity.RESULT_OK;
import static com.example.asus.amindatacolector.Fragments.ThreeFragment.RequestPermissionCode;


public class ThreeFragment extends Fragment
{
    View view;


    RadioGroup check_interact2, check_interact3;

    RadioButton resultRadiobtn2, resultRadiobtn3, aminVisitor, customerVisit, male, female, nextYes, nextNo;

    EditText edt_organ1, edt_organ2 , edt_personal_profile2, edt_personal_profile3,
             edt_personal_profile4, edt_contacts1, edt_contacts2,edt_contacts3, edt_contacts4, edt_contacts5,
             edt_result1, edt_result3, edt_result4, edt_result5;

    ImageView ImageViewHolder;

    Button register_btn_register, btn_capture_picture;

    private String codedImage = "";

    int radioButtonId1, index1;
    View radioButton1;

    int radioButtonId2, index2;
    View radioButton2;

//    EditText imageName;

    ProgressDialog progressDialog ;

    Intent intent ;

    public  static final int RequestPermissionCode  = 1 ;

    EditText editText_imagename;

    Bitmap bitmap;

    boolean check = true;

    String GetImageNameFromEditText;

    String ImageNameFieldOnServer = "image_name" ;

    String ImagePathFieldOnServer = "image_path" ;

    String ImageUploadPathOnSever ="https://aminib.site/adcapi/personal_card.php" ;

    Context context;
    private ContentResolver contentResolver;


    public ThreeFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_three_listing, container, false);

        EnableRuntimePermissionToAccessCamera();

        initDeclare();

        radioButtonId1 = check_interact2.getCheckedRadioButtonId();
        radioButton1 = check_interact2.findViewById(radioButtonId1);
        index1 = check_interact2.indexOfChild(radioButton1);

        radioButtonId2 = check_interact3.getCheckedRadioButtonId();
        radioButton2 = check_interact3.findViewById(radioButtonId2);
        index2 = check_interact3.indexOfChild(radioButton2);

        click();

        clickToSend();

        onClick();

        return view;
    }

    public ContentResolver getContentResolver()
    {
        return contentResolver;
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

        check_interact2 = (RadioGroup)view.findViewById(R.id.check_interact2);
        check_interact3 = (RadioGroup)view.findViewById(R.id.check_interact3);

        aminVisitor     = (RadioButton) view.findViewById(R.id.aminVisitor);
        customerVisit   = (RadioButton) view.findViewById(R.id.customerVisit);
        male            = (RadioButton) view.findViewById(R.id.male);
        female          = (RadioButton) view.findViewById(R.id.female);
        nextYes         = (RadioButton) view.findViewById(R.id.nextYes);
        nextNo          = (RadioButton) view.findViewById(R.id.nextNo);

        resultRadiobtn2 = (RadioButton)check_interact2.getChildAt(index1);
        resultRadiobtn3 = (RadioButton)check_interact3.getChildAt(index2);

        edt_organ1      = (EditText)view.findViewById(R.id.edt_organ1);
        edt_organ2      = (EditText)view.findViewById(R.id.edt_organ2);
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

        editText_imagename = (EditText)view.findViewById(R.id.editText_imagename);

        ImageViewHolder       = (ImageView)view.findViewById(R.id.ImageViewHolder);

        register_btn_register = (Button)view.findViewById(R.id.register_btn_register);
        btn_capture_picture   = (Button)view.findViewById(R.id.btn_capture_picture);
    }

    private void click()
    {
        ImageViewHolder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");

                    startActivityForResult(intent, 0);
                }
                catch (Exception e)
                {
                    e.getStackTrace();
                }
            }
        });
    }

    private void clickToSend()
    {
        btn_capture_picture.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    GetImageNameFromEditText = editText_imagename.getText().toString();
                    ImageUploadToServerFunction();
                }
                catch (NullPointerException e)
                {
                    e.fillInStackTrace();
                }

            }
        });
    }

    public void onClick()
    {

        register_btn_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


                String check1 = aminVisitor.getText().toString();

                String check2 = customerVisit.getText().toString();

                String organ1 = edt_organ1.getText().toString();
                String organ2 = edt_organ2.getText().toString();

                String check3 = resultRadiobtn2.getText().toString();

                String personal_profile2 = edt_personal_profile2.getText().toString();
                String personal_profile3 = edt_personal_profile3.getText().toString();
                String personal_profile4 = edt_personal_profile4.getText().toString();
                String contacts1 = edt_contacts1.getText().toString();
                String contacts2 = edt_contacts2.getText().toString();
                String contacts3 = edt_contacts3.getText().toString();
                String contacts4 = edt_contacts4.getText().toString();
                String contacts5 = edt_contacts5.getText().toString();
                String result1 = edt_result1.getText().toString();
                String check4 = resultRadiobtn2.getText().toString();
                String result2 = edt_result3.getText().toString();
                String result3 = edt_result4.getText().toString();
                String result4 = edt_result5.getText().toString();


                try
                {


                    if (
                            check1.equals("") || check2.equals("") ||   organ1.equalsIgnoreCase("") || organ2.equalsIgnoreCase("")  ||  check3.equals("") || personal_profile3.equalsIgnoreCase("") || personal_profile2.equalsIgnoreCase("") || personal_profile4.equalsIgnoreCase("") || contacts1.equalsIgnoreCase("") || contacts2.equalsIgnoreCase("") || contacts3.equalsIgnoreCase("") || contacts4.equalsIgnoreCase("") || contacts5.equalsIgnoreCase("") || result1.equalsIgnoreCase("")  || check4.equalsIgnoreCase("") || result2.equalsIgnoreCase("")  || result3.equalsIgnoreCase("") || result4.equalsIgnoreCase(""))
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "لطفا همه موارد را درج کنید", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        new registerRequest
                                (
                                        check1, check2, organ1, organ2,  check3,
                                        personal_profile2, personal_profile3, personal_profile4,
                                        contacts1, contacts2, contacts3, contacts4, contacts5,
                                        result1, check4, result2, result3, result4, getActivity().getApplicationContext()
                                ).execute();

                        Log.e("Done", "Successfully");
                    }
                }
                catch (NullPointerException e)
                {
                    e.fillInStackTrace();
                }
//
//                if (codedImage.equals(""))
//                {
//                    Toast.makeText(getActivity().getApplicationContext(), "لطفا عکس انتخاب کنید", Toast.LENGTH_SHORT).show();
//                }
//
//                else
//                {
//
//                }
//                GetImageNameFromEditText = imageName.getText().toString();

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        click();
        super.onSaveInstanceState(outState);
    }

    // Star activity for result method to Set captured image on image view after click.
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == 0)
//        {
//            if(resultCode == RESULT_OK)
//            {
//                if (data.getData() != null)
//                {
//                    Uri uri = data.getData();

                    try
                    {

                        // Adding captured image in bitmap.
//                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                        bitmap = (Bitmap)data.getExtras().get("data");
                        ImageViewHolder.setImageBitmap(bitmap);

                        // adding captured image in imageview.
//                        ImageViewHolder.setImageBitmap(bitmap);

                    } catch (NullPointerException e)
                    {

                        e.printStackTrace();
                    }
//                }
//            }
//        }
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState)
//    {
//        click();
//        super.onSaveInstanceState(outState);
//    }

    // Requesting runtime permission to access camera.
    public void EnableRuntimePermissionToAccessCamera()
    {

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.CAMERA))
        {

            // Printing toast message after enabling runtime permission.
            Toast.makeText(getActivity(), "CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else
        {

            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }

    // Upload captured image online on server function.
    public void ImageUploadToServerFunction()
    {

        ByteArrayOutputStream byteArrayOutputStreamObject;

        byteArrayOutputStreamObject = new ByteArrayOutputStream();

        // Converting bitmap image to jpeg format, so by default image will upload in jpeg format.
        bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStreamObject);

        byte[] byteArrayVar = byteArrayOutputStreamObject.toByteArray();

        final String ConvertImage = android.util.Base64.encodeToString(byteArrayVar, android.util.Base64.DEFAULT);

        @SuppressLint("StaticFieldLeak")
        class AsyncTaskUploadClass extends AsyncTask<Void, Void, String>
        {

            @Override
            protected void onPreExecute()
            {

                super.onPreExecute();

                // Showing progress dialog at image upload time.
                progressDialog = ProgressDialog.show(getActivity(), "عکس در حال ارسال است", "لطفا شکیبا باشید...", false, false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                // Dismiss the progress dialog after done uploading.
                progressDialog.dismiss();

                // Printing uploading success message coming from server on android app.
                Toast.makeText(getActivity(),string1,Toast.LENGTH_LONG).show();

                // Setting image as transparent after done uploading.
                ImageViewHolder.setImageResource(android.R.color.transparent);


            }

            @Override
            protected String doInBackground(Void... params) {

                ImageProcessClass imageProcessClass = new ImageProcessClass();

                HashMap<String,String> HashMapParams = new HashMap<String,String>();

                HashMapParams.put(ImageNameFieldOnServer, GetImageNameFromEditText);

                HashMapParams.put(ImagePathFieldOnServer, ConvertImage);

                String FinalData = imageProcessClass.ImageHttpRequest(ImageUploadPathOnSever, HashMapParams);

                return FinalData;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();

        AsyncTaskUploadClassOBJ.execute();
        }
    }

    class ImageProcessClass
    {

    public String ImageHttpRequest(String requestURL,HashMap<String, String> PData) {

        StringBuilder stringBuilder = new StringBuilder();

        try {

            URL url;
            HttpURLConnection httpURLConnectionObject ;
            OutputStream OutPutStream;
            BufferedWriter bufferedWriterObject ;
            BufferedReader bufferedReaderObject ;
            int RC ;

            url = new URL(requestURL);

            httpURLConnectionObject = (HttpURLConnection) url.openConnection();

            httpURLConnectionObject.setReadTimeout(19000);

            httpURLConnectionObject.setConnectTimeout(19000);

            httpURLConnectionObject.setRequestMethod("POST");

            httpURLConnectionObject.setDoInput(true);

            httpURLConnectionObject.setDoOutput(true);

            OutPutStream = httpURLConnectionObject.getOutputStream();

            bufferedWriterObject = new BufferedWriter(

                    new OutputStreamWriter(OutPutStream, "UTF-8"));

            bufferedWriterObject.write(bufferedWriterDataFN(PData));

            bufferedWriterObject.flush();

            bufferedWriterObject.close();

            OutPutStream.close();

            RC = httpURLConnectionObject.getResponseCode();

            if (RC == HttpsURLConnection.HTTP_OK) {

                bufferedReaderObject = new BufferedReader(new InputStreamReader(httpURLConnectionObject.getInputStream()));

                stringBuilder = new StringBuilder();

                String RC2;

                while ((RC2 = bufferedReaderObject.readLine()) != null){

                    stringBuilder.append(RC2);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private String bufferedWriterDataFN(HashMap<String, String> HashMapParams) throws UnsupportedEncodingException
    {

        StringBuilder stringBuilderObject;

        stringBuilderObject = new StringBuilder();

        for (Map.Entry<String, String> KEY : HashMapParams.entrySet()) {

            boolean check = true;
            if (check)

                check = false;
            else
                stringBuilderObject.append("&");

            stringBuilderObject.append(URLEncoder.encode(KEY.getKey(), "UTF-8"));

            stringBuilderObject.append("=");

            stringBuilderObject.append(URLEncoder.encode(KEY.getValue(), "UTF-8"));
        }

        return stringBuilderObject.toString();
    }

    public void onRequestPermissionsResult(int RC, String per[], int[] PResult)
    {
        Context context = null;
        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {


                    Toast.makeText(context,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(context,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
}
