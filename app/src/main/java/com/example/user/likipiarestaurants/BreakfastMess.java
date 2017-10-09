package com.example.user.likipiarestaurants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BreakfastMess extends AppCompatActivity {
    private DatabaseReference mDatabaseUsers;
    private RecyclerView mBlogList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_mess);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDatabaseUsers = FirebaseDatabase.getInstance().getReference().child("MESS Breakfast");
        mBlogList = (RecyclerView) findViewById(R.id.blog_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));
        mDatabaseUsers.keepSynced(true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<BreakfastUBCShow, BreakfastUBC.BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<BreakfastUBCShow, BreakfastUBC.BlogViewHolder>(
                BreakfastUBCShow.class,
                R.layout.menu_row_messbreakfast,
                BreakfastUBC.BlogViewHolder.class,
                mDatabaseUsers

        ) {
            @Override
            protected void populateViewHolder(BreakfastUBC.BlogViewHolder viewHolder, BreakfastUBCShow model, int position) {

                viewHolder.setMeal1(model.getMeal1());
                viewHolder.setMeal2(model.getMeal2());
                viewHolder.setMeal3(model.getMeal3());
                viewHolder.setMeal4(model.getMeal4());
                viewHolder.setMeal5(model.getMeal5());
                viewHolder.setMeal6(model.getMeal6());
                viewHolder.setMeal7(model.getMeal7());
                viewHolder.setMeal8(model.getMeal8());
                viewHolder.setMeal9(model.getMeal9());
                viewHolder.setMeal10(model.getMeal10());


            }
        };
        mBlogList.setAdapter(firebaseRecyclerAdapter);


    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setMeal1(String meal1) {
            TextView Meal1 = (TextView) mView.findViewById(R.id.editText);
            Meal1.setText(meal1);
        }
        public void setMeal2(String meal2) {
            TextView Meal2 = (TextView) mView.findViewById(R.id.editText2);
            Meal2.setText(meal2);
        }
        public void setMeal3(String meal3) {
            TextView Meal3 = (TextView) mView.findViewById(R.id.editText3);
            Meal3.setText(meal3);
        }
        public void setMeal4(String meal4) {
            TextView Meal4 = (TextView) mView.findViewById(R.id.editText4);
            Meal4.setText(meal4);
        }
        public void setMeal5(String meal5) {
            TextView Meal5 = (TextView) mView.findViewById(R.id.editText5);
            Meal5.setText(meal5);
        }
        public void setMeal6(String meal6) {
            TextView Meal6 = (TextView) mView.findViewById(R.id.editText6);
            Meal6.setText(meal6);
        }
        public void setMeal7(String meal7) {
            TextView Meal7 = (TextView) mView.findViewById(R.id.editText8);
            Meal7.setText(meal7);
        }
        public void setMeal8(String meal8) {
            TextView Meal8 = (TextView) mView.findViewById(R.id.editText8);
            Meal8.setText(meal8);
        }
        public void setMeal9(String meal9) {
            TextView Meal9 = (TextView) mView.findViewById(R.id.editText9);
            Meal9.setText(meal9);
        }
        public void setMeal10(String meal10) {
            TextView Meal10 = (TextView) mView.findViewById(R.id.editText10);
            Meal10.setText(meal10);
        }
    }
}
