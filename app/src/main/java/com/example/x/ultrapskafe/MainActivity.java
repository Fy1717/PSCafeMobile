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

public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefresh.setOnRefreshListener(this);

        ImageView geri = (ImageView) findViewById(R.id.geri);

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Anasayfa.class);
                startActivity(i);
            }
        });


        final List<Masa> masalar = new ArrayList<>();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String masalar_url = "http://tunalisimitcisi.com/MasaDurum.asmx/MasalariGetir";
        HttpURLConnection baglanti = null;


        try {

            URL url = new URL(masalar_url);

            baglanti = (HttpURLConnection) url.openConnection();


            int baglanti_durumu = baglanti.getResponseCode();

            if (baglanti_durumu == HttpURLConnection.HTTP_OK) {
                BufferedInputStream stream = new BufferedInputStream(baglanti.getInputStream());

                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(stream);

                final NodeList masalarNodeList = document.getElementsByTagName("Masalar");

                for (int i = 0; i < masalarNodeList.getLength(); i++) {

                    Element element = (Element) masalarNodeList.item(i);


                    NodeList nodeListID = element.getElementsByTagName("ID");
                    NodeList nodeListMASA_NO = element.getElementsByTagName("MASA_NO");
                    NodeList nodeListMASA_TURU_ID = element.getElementsByTagName("MASA_TURU_ID");
                    NodeList nodeListMASA_DURUM = element.getElementsByTagName("MASA_DURUM");
                    NodeList nodeListKOL_SAYISI = element.getElementsByTagName("KOL_SAYISI");
                    NodeList nodeListACILIS_SAATI = element.getElementsByTagName("ACILIS_SAATI");
                    NodeList nodeListKAPANIS_SAATI = element.getElementsByTagName("KAPANIS_SAATI");
                    NodeList nodeListUCRET = element.getElementsByTagName("UCRET");

                    String ID = nodeListID.item(0).getFirstChild().getNodeValue();
                    String MASA_NO = nodeListMASA_NO.item(0).getFirstChild().getNodeValue();
                    String MASA_TURU_ID = nodeListMASA_TURU_ID.item(0).getFirstChild().getNodeValue();
                    String MASA_DURUM = nodeListMASA_DURUM.item(0).getFirstChild().getNodeValue();
                    String KOL_SAYISI = nodeListKOL_SAYISI.item(0).getFirstChild().getNodeValue();
                    String ACILIS_SAATI = nodeListACILIS_SAATI.item(0).getFirstChild().getNodeValue();
                    String KAPANIS_SAATI = nodeListKAPANIS_SAATI.item(0).getFirstChild().getNodeValue();
                    String UCRET = nodeListUCRET.item(0).getFirstChild().getNodeValue();

                    masalar.add(new Masa(ID, MASA_NO, MASA_TURU_ID, MASA_DURUM, KOL_SAYISI, ACILIS_SAATI, KAPANIS_SAATI, UCRET));

                }
                final ListView listemiz = (ListView) findViewById(R.id.liste);
                OzelAdapter adaptorumuz = new OzelAdapter(this, masalar);
                listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("MASA  " + masalar.get(i).getMASA_NO());
                        builder.setMessage(" Açılış Saati  : " + masalar.get(i).getACILIS_SAATI() + "\n Kapanış Saati  : " + masalar.get(i).getKAPANIS_SAATI() + "\n Kol Sayısı  : " + masalar.get(i).getKOL_SAYISI());


                        builder.show();
                    }
                });
                listemiz.setAdapter(adaptorumuz);

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


