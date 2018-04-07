package com.example.ataher.studygroups;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ataher.studygroups.Helper.HelperMethods;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

public class AddNewItem extends AppCompatActivity {

    RadioButton word_radio_btn, excel_radio_btn, pdf_radio_btn;
    EditText file_link, video_link, file_desc, image_desc, video_desc;
    ImageView add_image;
    Button file_add_btn, image_add_btn, video_add_btn;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);

/*
        file_link = (EditText) findViewById(R.id.add_item_file_link);
        video_link = (EditText) findViewById(R.id.add_item_video_link);
        file_desc = (EditText) findViewById(R.id.add_item_file_desc);
        image_desc = (EditText) findViewById(R.id.add_item_image_desc);
        video_desc = (EditText) findViewById(R.id.add_item_video_desc);
        add_image = (ImageView) findViewById(R.id.add_item_image);
        file_add_btn = (Button) findViewById(R.id.add_item_file_upload_btn);
        image_add_btn = (Button) findViewById(R.id.add_item_image_upload_btn);
        video_add_btn = (Button) findViewById(R.id.add_item_video_upload_btn);
        firebaseAuth = FirebaseAuth.getInstance();

        final TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("File");
        spec.setContent(R.id.tab1);
        spec.setIndicator("File");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Image");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Image");
        host.addTab(spec);

        spec = host.newTabSpec("Video");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Video");
        host.addTab(spec);

        file_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                StringRequest stringRequest = new StringRequest(Request.Method.POST, "", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(AddNewItem.this, response, Toast.LENGTH_SHORT).show();
                        Log.i("response : ", response);
                        HelperMethods.hideDialog(AddNewItem.this);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddNewItem.this, error + "", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        itme_desc = file_desc.getText().toString();
                        item_username = itemPlace.getText().toString();
                        item_userid = itemType.getText().toString();
                        item_time = itemType.getText().toString();


                        Map<String, String> params = new HashMap<String, String>();

                        params.put("Desc", itme_desc);
                        params.put("Type", item_type);
                        params.put("Kind", item_kind);
                        params.put("userName", item_username);
                        params.put("userID", item_userid);
                        params.put("Time", item_time);


                        return params;


                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(AddNewItem.this);
                requestQueue.add(stringRequest);


            }
        });


        image_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        video_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

   /* public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_pdf_file:
                if (checked)
                    Toast.makeText(this, "PDF", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_word_file:
                if (checked)
                    Toast.makeText(this, "word", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_excel_file:
                if (checked)
                    Toast.makeText(this, "excel", Toast.LENGTH_SHORT).show();
                break;
        }


    }*/

}
