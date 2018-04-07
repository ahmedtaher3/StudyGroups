package com.example.ataher.studygroups;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ataher.studygroups.Helper.HelperMethods;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Mygroups extends AppCompatActivity {

    ListView groupsListView;
    ArrayAdapter groupsAdapter;
    ArrayList<String> subIds = new ArrayList<String>();
    ArrayList<String> subnames = new ArrayList<String>();
    String[] groupsIdsArray;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mygroups);

        groupsListView = (ListView) findViewById(R.id.groupsListView1);
        firebaseAuth = FirebaseAuth.getInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mygroups.this, GroupSearch.class));
            }
        });

        HelperMethods.showDialog(Mygroups.this, "Please Wait", "Loading ...");
        JsonArrayRequest request = new JsonArrayRequest("https://necrophiliac-monito.000webhostapp.com/StudyGroups/MyGroups.php?UserID=" +firebaseAuth.getCurrentUser().getUid(), new com.android.volley.Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);


                        subIds.add(jsonObject.getString("ID"));
                        subnames.add(jsonObject.getString("Name"));


                    } catch (JSONException e) {
                        e.printStackTrace();
                        HelperMethods.hideDialog(Mygroups.this);

                    }
                }

                HelperMethods.hideDialog(Mygroups.this);

                groupsAdapter = new ArrayAdapter<String>(Mygroups.this, android.R.layout.simple_dropdown_item_1line, subnames);
                groupsAdapter.notifyDataSetChanged();
                groupsListView.setAdapter(groupsAdapter);
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

        groupsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(new Intent(Mygroups.this , GroupsContent.class));

            }
        });
    }


}
