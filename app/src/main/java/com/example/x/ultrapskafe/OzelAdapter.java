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

public class OzelAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Masa> mMasaListesi;

    public OzelAdapter(Activity activity, List<Masa> masalar) {
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mMasaListesi = masalar;
    }

    @Override
    public int getCount() {
        return mMasaListesi.size();
    }

    @Override
    public Masa getItem(int position) {
        return mMasaListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;

        satirView = mInflater.inflate(R.layout.satir, null);
        TextView textView =
                (TextView) satirView.findViewById(R.id.yazi);
        ImageView imageView =
                (ImageView) satirView.findViewById(R.id.simge);

        Masa masa = mMasaListesi.get(position);


        String md= masa.getMASA_DURUMU();

        String mti= masa.getMASA_TURU_ID();

        if (mti=="1" && md=="0") {
            imageView.setImageResource(R.drawable.m10);
        }
        if (mti=="1" && md=="1"){
            imageView.setImageResource(R.drawable.m11);
        }
        if (mti=="2" && md=="0") {
            imageView.setImageResource(R.drawable.m20);
        }
        if (mti=="2" && md=="1"){
            imageView.setImageResource(R.drawable.m21);
        }
        if (mti=="3" && md=="0") {
            imageView.setImageResource(R.drawable.m30);
        }

        if (mti=="3" && md=="1"){
            imageView.setImageResource(R.drawable.m31);
        }

        textView.setText("MASANO: "+masa.getMASA_NO()+" MASATURUID: "+masa.getMASA_TURU_ID()+" MASADURUMU: "+masa.getMASA_DURUMU());

        return satirView;


    }


}
