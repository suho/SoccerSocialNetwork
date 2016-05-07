package com.mad.hovansu.soccersocialnetwork.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mad.hovansu.soccersocialnetwork.R;
import com.mad.hovansu.soccersocialnetwork.activity.CreateMatchActivity;

import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {

    private Button btnCreateMatch;
    private ListView listView;

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

        listView = (ListView) v.findViewById(R.id.listView);
        listView.setAdapter(new MatchAdapter(getContext()));

        return v;
    }

    class MatchInfo {
        String name;
        Date date;
        int player;

        MatchInfo(String name, Date date, int player){
            this.name = name;
            this.date = date;
            this.player = player;
        }

        public String getName(){
            return name;
        }

        public Date getDate(){
            return date;
        }

        public int getPlayer(){
            return player;
        }

    }

    class ViewHolder {
        TextView txtName;
        TextView txtDate;
        TextView txtPlayer;
        int id;
    }

    class MatchAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;
        private ArrayList<MatchInfo> info = new ArrayList<>();

        public MatchAdapter(Context context){
            this.context = context;
            inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return info.size();
        }

        @Override
        public Object getItem(int i) {
            return info.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if(view == null){
                holder = new ViewHolder();
                view = inflater.inflate(R.layout.list_item_match, null);
                holder.txtName = (TextView) view.findViewById(R.id.text_name);
                holder.txtDate = (TextView) view.findViewById(R.id.text_date);
                holder.txtPlayer = (TextView) view.findViewById(R.id.text_player);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.txtName.setId(position);
            holder.txtDate.setId(position);
            holder.txtPlayer.setId(position);
            holder.id = position;

            return view;
        }
    }


}
