package com.example.user.likipiarestaurants;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TabFragment3 extends android.support.v4.app.Fragment {
    private Button btn;
    private Button mLunch;
    private Button mSupper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_tab_fragment3, container, false);



        mSupper=(Button) rootView.findViewById(R.id.supperubc);
        mSupper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View rootView) {
                Intent intent = new Intent(getActivity(), SupperVision.class);
                startActivity(intent);
            }
        });
        mLunch = (Button) rootView.findViewById(R.id.lunchubc);
        mLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View rootView) {
                Intent intent = new Intent(getActivity(), LunchVision.class);
                startActivity(intent);
            }
        });

        btn = (Button) rootView.findViewById(R.id.myButton);
        btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View rootView) {

                Intent intent = new Intent(getActivity(), BreakfastVision.class);
                startActivity(intent);




            }


        });


        return rootView;


    }
}