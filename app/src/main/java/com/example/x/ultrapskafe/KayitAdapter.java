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
    private List<Masa> mMasaListesi;

    public KayitAdapter(Activity activity, List<Masa> masalar) {
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

        if (mti.equals("1") && md.equals("0")) {
            imageView.setImageResource(R.drawable.m10);
        }
        if (mti.equals("1") && md.equals("1")){
            imageView.setImageResource(R.drawable.m11);
        }
        if (mti.equals("2") && md.equals("0")) {
            imageView.setImageResource(R.drawable.m20);
        }
        if (mti.equals("2") && md.equals("1")){
            imageView.setImageResource(R.drawable.m21);
        }
        if (mti.equals("3") && md.equals("0")) {
            imageView.setImageResource(R.drawable.m30);
        }

        if (mti.equals("3") && md.equals("1")){
            imageView.setImageResource(R.drawable.m31);
        }


        textView.setText("MASANO: "+masa.getMASA_NO()+" MASATURUID: "+masa.getMASA_TURU_ID()+" MASADURUMU: "+masa.getMASA_DURUMU());

        return satirView;


    }


}
