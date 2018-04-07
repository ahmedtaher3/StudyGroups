package com.example.ataher.studygroups;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ataher.studygroups.Helper.HelperMethods;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroupSearch extends AppCompatActivity {
    String[] spinnerListDefualt = {};
    Button joinButtton;
    ArrayList<String> UniversityName, CollegeName, CollegeID, LevelName, LevelID, SubjectName, SubjectID;
    MaterialBetterSpinner UniversitySpinner, collegeSpinner, LevelSpinner, SubjectSpinner;
    ArrayAdapter<String> UniversitySpinnerAdapter, CollegeSpinnerAdapter, LeveSpinnerAdapter, SubjectSpinnerAdapter;
    String UniversityNameFilter, CollegeIDFilter, LevelIDFilter;
    String GroupUniName, GroupCollegeName, GroupLevelName, GroupSubjectName, GroupSubjectID, GroupUserID;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_searsh);

        populateListCategory();

        firebaseAuth = FirebaseAuth.getInstance();


        GroupUserID = firebaseAuth.getCurrentUser().getUid();
        UniversityName = new ArrayList<String>();
        CollegeName = new ArrayList<String>();
        CollegeID = new ArrayList<String>();
        LevelID = new ArrayList<String>();
        LevelName = new ArrayList<String>();
        SubjectName = new ArrayList<String>();
        SubjectID = new ArrayList<String>();

        UniversitySpinner = (MaterialBetterSpinner) findViewById(R.id.university_design_spinner);
        collegeSpinner = (MaterialBetterSpinner) findViewById(R.id.college_design_spinner);
        LevelSpinner = (MaterialBetterSpinner) findViewById(R.id.level_design_spinner);
        SubjectSpinner = (MaterialBetterSpinner) findViewById(R.id.subject_design_spinner);

        UniversitySpinnerAdapter = new ArrayAdapter<String>(GroupSearch.this, android.R.layout.simple_dropdown_item_1line, spinnerListDefualt);
        CollegeSpinnerAdapter = new ArrayAdapter<String>(GroupSearch.this, android.R.layout.simple_dropdown_item_1line, spinnerListDefualt);
        LeveSpinnerAdapter = new ArrayAdapter<String>(GroupSearch.this, android.R.layout.simple_dropdown_item_1line, spinnerListDefualt);
        SubjectSpinnerAdapter = new ArrayAdapter<String>(GroupSearch.this, android.R.layout.simple_dropdown_item_1line, spinnerListDefualt);

        UniversitySpinner.setAdapter(UniversitySpinnerAdapter);
        collegeSpinner.setAdapter(CollegeSpinnerAdapter);
        LevelSpinner.setAdapter(LeveSpinnerAdapter);
        SubjectSpinner.setAdapter(SubjectSpinnerAdapter);
        joinButtton = (Button) findViewById(R.id.joinBtn);

        UniversitySpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GroupUniName = adapterView.getItemAtPosition(i).toString();
                CollegeName.clear();
                CollegeID.clear();
                Toast.makeText(GroupSearch.this, GroupUniName, Toast.LENGTH_SHORT).show();
                HelperMethods.showDialog(GroupSearch.this, "Wait", "Loading...");
                JsonArrayRequest request = new JsonArrayRequest("https://necrophiliac-monito.000webhostapp.com/StudyGroups/College.php?UniversityName=" + UniversityNameFilter, new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);


                                CollegeName.add(jsonObject.getString("Name"));
                                CollegeID.add(jsonObject.getString("ID"));


                            } catch (JSONException e) {
                                e.printStackTrace();
                                HelperMethods.hideDialog(GroupSearch.this);

                            }
                        }


                        HelperMethods.hideDialog(GroupSearch.this);

                        collegeSpinner.setAdapter(new ArrayAdapter<String>(GroupSearch.this, android.R.layout.simple_dropdown_item_1line, CollegeName));
                    }
                }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                RequestQueue requestQueue = Volley.newRequestQueue(GroupSearch.this);
                requestQueue.add(request);

            }
        });

        collegeSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GroupCollegeName = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(GroupSearch.this, GroupCollegeName, Toast.LENGTH_SHORT).show();
                LevelID.clear();
                LevelName.clear();
                CollegeIDFilter = CollegeID.get(i);
                HelperMethods.showDialog(GroupSearch.this, "Wait", "Loading...");
                JsonArrayRequest request = new JsonArrayRequest("https://necrophiliac-monito.000webhostapp.com/StudyGroups/Level.php?CollegeID=" + CollegeIDFilter, new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);


                                LevelName.add(jsonObject.getString("Name"));
                                LevelID.add(jsonObject.getString("ID"));


                            } catch (JSONException e) {
                                e.printStackTrace();
                                HelperMethods.hideDialog(GroupSearch.this);

                            }
                        }

                        HelperMethods.hideDialog(GroupSearch.this);

                        LevelSpinner.setAdapter(new ArrayAdapter<String>(GroupSearch.this, android.R.layout.simple_dropdown_item_1line, LevelName));
                    }
                }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<String, String>();

                        params.put("UniversityNameFilter", UniversityNameFilter);


                        return params;


                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(GroupSearch.this);
                requestQueue.add(request);


            }
        });

        LevelSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                GroupLevelName = adapterView.getItemAtPosition(i).toString();
                LevelIDFilter = LevelID.get(i);
                Toast.makeText(GroupSearch.this, GroupLevelName, Toast.LENGTH_SHORT).show();
                SubjectName.clear();

                HelperMethods.showDialog(GroupSearch.this, "Wait", "Loading...");
                JsonArrayRequest request = new JsonArrayRequest("https://necrophiliac-monito.000webhostapp.com/StudyGroups/Subject.php?LevelID=" + LevelIDFilter, new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);


                                SubjectName.add(jsonObject.getString("Name"));
                                SubjectID.add(jsonObject.getString("ID"));



                            } catch (JSONException e) {
                                e.printStackTrace();
                                HelperMethods.hideDialog(GroupSearch.this);

                            }
                        }

                        HelperMethods.hideDialog(GroupSearch.this);

                        SubjectSpinner.setAdapter(new ArrayAdapter<String>(GroupSearch.this, android.R.layout.simple_dropdown_item_1line, SubjectName));
                    }
                }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                RequestQueue requestQueue = Volley.newRequestQueue(GroupSearch.this);
                requestQueue.add(request);


            }
        });

        SubjectSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GroupSubjectName = adapterView.getItemAtPosition(i).toString();
                GroupSubjectID = SubjectID.get(i);
                Toast.makeText(GroupSearch.this, GroupSubjectName + GroupSubjectID , Toast.LENGTH_SHORT).show();
            }
        });


        joinButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HelperMethods.showDialog(GroupSearch.this, "Wait", "Loading...");
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://necrophiliac-monito.000webhostapp.com/StudyGroups/NewGroup.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(GroupSearch.this, response, Toast.LENGTH_SHORT).show();
                        HelperMethods.hideDialog(GroupSearch.this);
                        startActivity(new Intent(GroupSearch.this , Home.class));

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(GroupSearch.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                        HelperMethods.hideDialog(GroupSearch.this);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<String, String>();

                        params.put("Group_UniName", GroupUniName);
                        params.put("Group_CollegeName", GroupCollegeName);
                        params.put("Group_LevelName", GroupLevelName);
                        params.put("Group_SubjectName", GroupSubjectName);
                        params.put("Group_SubjectID", GroupSubjectID);
                        params.put("Group_UserID", GroupUserID);


                        return params;


                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(GroupSearch.this);
                requestQueue.add(stringRequest);


            }
        });

    }


    private void populateListCategory() {

        HelperMethods.showDialog(GroupSearch.this, "Wait", "Loading...");
        JsonArrayRequest request = new JsonArrayRequest("https://necrophiliac-monito.000webhostapp.com/StudyGroups/University.php", new com.android.volley.Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);


                        UniversityName.add(jsonObject.getString("Name"));
                        UniversityNameFilter = UniversityName.get(i);


                    } catch (JSONException e) {
                        e.printStackTrace();
                        HelperMethods.hideDialog(GroupSearch.this);

                    }
                }

                HelperMethods.hideDialog(GroupSearch.this);

                UniversitySpinner.setAdapter(new ArrayAdapter<String>(GroupSearch.this, android.R.layout.simple_dropdown_item_1line, UniversityName));
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}








