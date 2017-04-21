package com.acadgild.s12_a4_custom_list_and_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ListFragment;

public class Websites extends ListFragment implements OnItemClickListener {


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ListFragAdapter(getActivity(), Data.ICON_INDEXES, Data.NAMES, Data.DESCS));
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), Data.NAMES[position], Toast.LENGTH_SHORT).show();
    }

    public class ListFragAdapter extends BaseAdapter {

        Context context;
        LayoutInflater inflater;

        int[] iconsIndexes;
        String[] names, descs;

        ImageView iconIV;
        TextView nameTV, descTV;

        public ListFragAdapter(Context context, int[] iconsIndexes, String[] names, String[] descs) {
            this.context = context;
            this.iconsIndexes = iconsIndexes;
            this.names = names;
            this.descs = descs;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            convertView = inflater.inflate(R.layout.adapter_list_frag, null);

            iconIV = (ImageView) convertView.findViewById(R.id.icon_iv);
            nameTV = (TextView) convertView.findViewById(R.id.name_tv);
            descTV = (TextView) convertView.findViewById(R.id.desc_tv);

            iconIV.setImageResource(iconsIndexes[position]);
            iconIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), Data.NAMES[position], Toast.LENGTH_SHORT).show();

                }
            });
            nameTV.setText(names[position]);
            descTV.setText(descs[position]);


            return convertView;
        }
    }

}
