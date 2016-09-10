package com.qft3.maimeng.infoModule.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qft3.maimeng.R;
import com.qft3.maimeng.bean.InfoListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qj on 2016/9/7.
 */
public class InforListAdapter extends BaseAdapter {
    private List<InfoListBean> infoListBeen = new ArrayList<>();
    private Context mContext;

    public InforListAdapter(List<InfoListBean> infoListBeen, Context mContext) {
        this.infoListBeen = infoListBeen;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return infoListBeen == null ? 0 : infoListBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return infoListBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ListViewHolder listViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_info_fragment_layout, parent, false);
            listViewHolder = new ListViewHolder(view);
        } else {
            listViewHolder = (ListViewHolder) view.getTag();
        }

        return view;
    }

    class ListViewHolder {
        @BindView(R.id.item_info_fragment_iv)
        public ImageView imageView;
        @BindView(R.id.item_info_fragment_tv)
        public TextView titleTxt;
        @BindView(R.id.item_info_fragment_date_tv)
        public TextView dateTxt;

        public ListViewHolder(View view) {
            view.setTag(this);
            ButterKnife.bind(this, view);

        }
    }
}
