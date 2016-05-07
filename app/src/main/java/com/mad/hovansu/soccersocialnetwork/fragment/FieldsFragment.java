package com.mad.hovansu.soccersocialnetwork.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mad.hovansu.soccersocialnetwork.R;
import com.mad.hovansu.soccersocialnetwork.activity.CreateFieldActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class FieldsFragment extends Fragment {
    private Button btnCreateField;

    public FieldsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fields, container, false);
        btnCreateField = (Button) v.findViewById(R.id.btn_create_field);
        btnCreateField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateFieldActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return v;
    }


}
