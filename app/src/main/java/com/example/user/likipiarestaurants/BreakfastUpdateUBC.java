package com.example.user.likipiarestaurants;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BreakfastUpdateUBC extends AppCompatActivity {
    private DatabaseReference mDatabaseUsers;
    private FirebaseAuth mAuth;
    private EditText m1;
    private EditText m2;
    private EditText m3;
    private EditText m4;
    private EditText m5;
    private EditText m6;
    private EditText m7;
    private EditText m8;
    private EditText m9;
    private EditText m10;
    private Button mb2;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_update_ubc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDatabaseUsers= FirebaseDatabase.getInstance().getReference().child("UBC Breakfast");
        mAuth= FirebaseAuth.getInstance();
        m1=(EditText)findViewById(R.id.editText);
        m2=(EditText)findViewById(R.id.editText2);
        m3=(EditText)findViewById(R.id.editText3);
        m4=(EditText)findViewById(R.id.editText4);
        m5=(EditText)findViewById(R.id.editText5);
        m6=(EditText)findViewById(R.id.editText6);
        m7=(EditText)findViewById(R.id.editText7);
        m8=(EditText)findViewById(R.id.editText8);
        m9=(EditText)findViewById(R.id.editText9);
        m10=(EditText)findViewById(R.id.editText10);
        mb2=(Button)findViewById(R.id.button2);
        mProgress=new ProgressDialog(this);

        mb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });

    }

    private void update() {
        final String me1 = m1.getText().toString().trim();
        final String me2 = m2.getText().toString().trim();
        final String me3 = m3.getText().toString().trim();
        final String me4 = m4.getText().toString().trim();
        final String me5 = m5.getText().toString().trim();
        final String me6 = m6.getText().toString().trim();
        final String me7 = m7.getText().toString().trim();
        final String me8 = m8.getText().toString().trim();
        final String me9= m9.getText().toString().trim();
        final String me10 = m10.getText().toString().trim();
        final String user_id=mAuth.getCurrentUser().getUid();

        mProgress.setMessage("Sending");
        mProgress.show();

        mDatabaseUsers.child(user_id).child("meal1").setValue(me1);
        mDatabaseUsers.child(user_id).child("meal2").setValue(me2);
        mDatabaseUsers.child(user_id).child("meal3").setValue(me3);
        mDatabaseUsers.child(user_id).child("meal4").setValue(me4);
        mDatabaseUsers.child(user_id).child("meal5").setValue(me5);
        mDatabaseUsers.child(user_id).child("meal6").setValue(me6);
        mDatabaseUsers.child(user_id).child("meal7").setValue(me7);
        mDatabaseUsers.child(user_id).child("meal8").setValue(me8);
        mDatabaseUsers.child(user_id).child("meal9").setValue(me9);
        mDatabaseUsers.child(user_id).child("meal10").setValue(me10);

        mProgress.dismiss();

        Intent mainIntent = new Intent(BreakfastUpdateUBC.this, PostActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(mainIntent);
        Toast.makeText(BreakfastUpdateUBC.this,"your Menu has been updated",Toast.LENGTH_LONG).show();

    }
}
