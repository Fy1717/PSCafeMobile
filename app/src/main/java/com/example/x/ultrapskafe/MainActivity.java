package com.example.x.ultrapskafe;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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

public class MainActivity extends AppCompatActivity {
    ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste=(ListView) findViewById(R.id.listView);
        WebServisIleDoldur();
    }


    private  void WebServisIleDoldur(){

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);


        String masalar_url="http://tunalisimitcisi.com/MasaDurum.asmx/MasalariGetir";

        List<String> masalar_list=new ArrayList<>();


        HttpURLConnection baglanti=null;


        try {

            URL url = new URL(masalar_url);

            baglanti=(HttpURLConnection) url.openConnection();


            int baglanti_durumu=baglanti.getResponseCode();


            if (baglanti_durumu==HttpURLConnection.HTTP_OK){

                BufferedInputStream stream= new BufferedInputStream(baglanti.getInputStream());


                DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();

                DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();

                Document document=documentBuilder.parse(stream);


                NodeList masalarNodeList=document.getElementsByTagName("Masalar");


                for (int i=0;i<masalarNodeList.getLength(); i++){

                    Element element =(Element) masalarNodeList.item(i);


                    NodeList nodeListID=element.getElementsByTagName("ID");

                    NodeList nodeListMASA_NO=element.getElementsByTagName("MASA_NO");

                    NodeList nodeListMASA_TURU_ID=element.getElementsByTagName("MASA_TURU_ID");

                    NodeList nodeListMASA_DURUM=element.getElementsByTagName("MASA_DURUM");

                    NodeList nodeListKOL_SAYISI=element.getElementsByTagName("KOL_SAYISI");

                    NodeList nodeListUCRET=element.getElementsByTagName("UCRET");


                    String ID=nodeListID.item(0).getFirstChild().getNodeValue ();

                    String MASA_NO=nodeListMASA_NO.item(0).getFirstChild().getNodeValue();

                    String MASA_TURU_ID=nodeListMASA_TURU_ID.item(0).getFirstChild().getNodeValue();

                    String MASA_DURUM=nodeListMASA_DURUM.item(0).getFirstChild().getNodeValue();

                    String KOL_SAYISI=nodeListKOL_SAYISI.item(0).getFirstChild().getNodeValue();

                    String UCRET=nodeListUCRET.item(0).getFirstChild().getNodeValue();

                    Masa Masa = new Masa(ID,MASA_NO,MASA_TURU_ID,MASA_DURUM);

                }

            }

        }catch (Exception e)
        {

            Log.e("XML PARSE HATASI ",e.getMessage().toString());


        }finally {

            if (baglanti !=null){

                baglanti.disconnect();

            }

        }


        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,masalar_list);

        liste.setAdapter(adapter);

    }
}

