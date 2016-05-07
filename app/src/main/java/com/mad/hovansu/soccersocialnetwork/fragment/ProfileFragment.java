package com.mad.hovansu.soccersocialnetwork.fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mad.hovansu.soccersocialnetwork.R;

import com.mad.hovansu.soccersocialnetwork.bean.UserProfile;
import com.mad.hovansu.soccersocialnetwork.dao.ProfileManagerDao;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private EditText username_profile;
    private EditText email_profile;
    private EditText phone_profile;
    private UserProfile myUserProfiles;
    private ProfileManagerDao profileManagerDao;
    //private int user_id = 2;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        username_profile = (EditText) view.findViewById(R.id.username_profile);
        email_profile = (EditText) view.findViewById(R.id.email_profile);
        phone_profile = (EditText) view.findViewById(R.id.phone_profile);
        profileManagerDao = new ProfileManagerDao(getActivity());
        Bundle bundle = getArguments();
        int user_id = 2;
        if(bundle!=null){
            user_id = bundle.getInt("id_user");
        } else {
            user_id = 2;
        }
        myUserProfiles = profileManagerDao.getInformation(user_id);
        loadDetailProfile();
        return view;
    }

    private void loadDetailProfile() {
        username_profile.setText(myUserProfiles.getUsername());
        email_profile.setText(myUserProfiles.getEmail());
        phone_profile.setText(myUserProfiles.getPhone_number());
    }


}
