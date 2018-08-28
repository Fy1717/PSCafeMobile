package com.example.x.ultrapskafe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.util.Log;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Kayitlar extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitlar);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefresh.setOnRefreshListener(this);

        ImageView geri = (ImageView) findViewById(R.id.geri);

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Kayitlar.this, Anasayfa.class);
                startActivity(i);
            }
        });

        final List<Kayıt> kayitlar = new ArrayList<>();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String kayitlar_url = "http://tunalisimitcisi.com/MasaDurum.asmx/KayitlariGetir";
        HttpURLConnection baglanti = null;

        try {

            URL url = new URL(kayitlar_url);
            baglanti = (HttpURLConnection) url.openConnection();
            int baglanti_durumu = baglanti.getResponseCode();
            if (baglanti_durumu == HttpURLConnection.HTTP_OK) {

                BufferedInputStream stream = new BufferedInputStream(baglanti.getInputStream());

                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

                Document document = documentBuilder.parse(stream);

                final NodeList kayitlarNodeList = document.getElementsByTagName("Kayitlar");

                for (int i = 0; i < kayitlarNodeList.getLength(); i++) {

                    Element element = (Element) kayitlarNodeList.item(i);

                    NodeList nodeListID = element.getElementsByTagName("ID");

                    NodeList nodeListMASA_NO = element.getElementsByTagName("MASA_NO");

                    NodeList nodeListYAPILAN_ISLER = element.getElementsByTagName("YAPILAN_ISLER");

                    NodeList nodeListTARIH_SAAT = element.getElementsByTagName("TARIH_SAAT");

                    NodeList nodeListKAZANC = element.getElementsByTagName("KAZANC");

                    String ID = "";
                    String MASA_NO = "";
                    String YAPILAN_ISLER = "";
                    String TARIH_SAAT = "";
                    String KAZANC = "";

                    try {

                        ID = nodeListID.item(0).getFirstChild().getNodeValue();

                        MASA_NO = nodeListMASA_NO.item(0).getFirstChild().getNodeValue();

                        YAPILAN_ISLER = nodeListYAPILAN_ISLER.item(0).getFirstChild().getNodeValue();

                        TARIH_SAAT = nodeListTARIH_SAAT.item(0).getFirstChild().getNodeValue();

                        KAZANC = nodeListKAZANC.item(0).getFirstChild().getNodeValue();


                    } catch (Exception e) {
                        KAZANC = "0";
                    }


                    kayitlar.add(new Kayıt(ID, MASA_NO, YAPILAN_ISLER, TARIH_SAAT, KAZANC));

                }
                final ListView listemiz = (ListView) findViewById(R.id.liste);
                KayitAdapter kayitAdapter = new KayitAdapter(this, kayitlar);

                listemiz.setAdapter(kayitAdapter);

            }

        } catch (Exception e) {

            Log.e("XML PARSE HATASI ", e.getMessage().toString());


        } finally {

            if (baglanti != null) {

                baglanti.disconnect();

            }

        }

    }

    private void loadCity() {

        if (swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        }
    }


    @Override
    public void onRefresh() {
        Toast.makeText(getApplicationContext(), "Yenilendi", Toast.LENGTH_SHORT).show();
        loadCity();
    }
}


