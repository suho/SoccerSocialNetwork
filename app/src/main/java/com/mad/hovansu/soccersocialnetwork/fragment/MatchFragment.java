package com.mad.hovansu.soccersocialnetwork.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mad.hovansu.soccersocialnetwork.R;
import com.mad.hovansu.soccersocialnetwork.activity.CreateMatchActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {

    private Button btnCreateMatch;

    public MatchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_match, container, false);
        // Inflate the layout for this fragment
        btnCreateMatch = (Button) v.findViewById(R.id.btn_create_match);
        btnCreateMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateMatchActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return v;
    }


}
