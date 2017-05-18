package com.mytrendin.gsonlibrary;

import android.util.Log;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetColor {


    HttpURLConnection httpURLConnection;
    Gson gson;
    URL url;
    Color color;
    List<Model> list;

    public List<Model> data(){

        gson = new Gson();
        color = new Color();
        String data= getJSONfromurl();
        color = gson.fromJson(data,color.getClass());
        int arm= color.getColorsArray().size();
        list = new ArrayList<>();

        for(int i = 0;i<arm;i++) {
            String colorname = color.getColorsArray().get(i).getColorName();
            String hexvalue = color.getColorsArray().get(i).getHexValue();

            Model model = new Model();
            model.setColorName(colorname);
            model.setHexValue(hexvalue);
            list.add(model);
            Log.i("HItesh",""+hexvalue);
        }
        return list;
    }

    public String getJSONfromurl(){

        String url1 ="http://192.168.43.87/data/color.json";
        String jsondata = null;

        try {
            url = new URL(url1);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            StringBuffer buffer = new StringBuffer();
            while ((line=reader.readLine())!=null){

                buffer.append(line);
                 }
            jsondata = buffer.toString();

    } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

     return jsondata;
    }


}