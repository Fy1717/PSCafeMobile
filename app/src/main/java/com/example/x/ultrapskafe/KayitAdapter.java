package com.example.x.ultrapskafe;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class KayitAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Kayıt> mKayitListesi;

    public KayitAdapter(Activity activity, List<Kayıt> kayitlar) {
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mKayitListesi = kayitlar;
    }

    @Override
    public int getCount() {
        return mKayitListesi.size();
    }

    @Override
    public Kayıt getItem(int position) {
        return mKayitListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View kayitView;

        kayitView = mInflater.inflate(R.layout.kayit, null);
        TextView textView = (TextView) kayitView.findViewById(R.id.yazi2);

        Kayıt kayit = mKayitListesi.get(position);

        textView.setText("MASA "+kayit.getMASA_NO()+"\n"+kayit.getYAPILAN_ISLER()+"\nKazanç:  "+kayit.getKAZANC());

        return kayitView;


    }


}
