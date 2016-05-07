package com.mad.hovansu.soccersocialnetwork.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mad.hovansu.soccersocialnetwork.R;
import com.mad.hovansu.soccersocialnetwork.activity.CreateFieldActivity;
import com.mad.hovansu.soccersocialnetwork.activity.DetailFieldActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FieldsFragment extends Fragment {
    private Button btnCreateField;
    private ListView listView;

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

        listView = (ListView) v.findViewById(R.id.listView);
        listView.setAdapter(new FieldAdapter(getContext()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(), DetailFieldActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return v;
    }

    private ArrayList<FieldInfo> createFieldData(){
        ArrayList<FieldInfo> list = new ArrayList<>();
        list.add(new FieldInfo("Sân MU", "255 Tôn Đức Thắng"));
        list.add(new FieldInfo("Sân Cẩm Lệ", "100 Trường Chinh"));
        list.add(new FieldInfo("Sân Hòa Khánh", "20 Nam Cao"));
        list.add(new FieldInfo("Sân Sơn Trà", "22 Ngô Quyền"));
        list.add(new FieldInfo("Sân Thanh Khê", "10 Trần Cao Vân"));
        return list;
    }

    class FieldInfo {
        String name;
        String address;

        FieldInfo(String name, String address){
            this.name = name;
            this.address = address;
        }

        public String getName(){
            return name;
        }

        public String getAddress(){
            return address;
        }

    }

    class ViewHolder {
        TextView txtName;
        TextView txtAddress;
        int id;
    }

    class FieldAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;
        private ArrayList<FieldInfo> info = new ArrayList<>();

        public FieldAdapter(Context context){
            this.context = context;
            inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            info = createFieldData();
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
                view = inflater.inflate(R.layout.list_item_field, null);
                holder.txtName = (TextView) view.findViewById(R.id.text_name);
                holder.txtAddress = (TextView) view.findViewById(R.id.text_address);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.txtName.setId(position);
            holder.txtAddress.setId(position);
            holder.id = position;
            holder.txtName.setText(info.get(position).getName());
            holder.txtAddress.setText(info.get(position).getAddress());
            return view;
        }
    }

}