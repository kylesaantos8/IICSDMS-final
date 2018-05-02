package com.iicsdms.tris.iicsdms2;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Tris on 14/03/2018.
 */

class SeenStatus {

    String line;
    InputStream inputStream;

    private static final String test = "Test";

    String seen(String linkSeen, String mailId, String logEmail)
    {
        try
        {
            URL url = new URL(linkSeen);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            String data1 = URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(mailId.trim(),"UTF-8") +"&"+
                    URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(logEmail.trim(),"UTF-8");

            bufferedWriter.write(data1);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

            line = bufferedReader.readLine();
            bufferedReader.close();
            inputStream.close();

            httpURLConnection.disconnect();

        } catch(Exception e)
        {
            e.printStackTrace();
        }

        return line;
    }

    void seenUpdate(String linkSeen, String id, String update, String logEmail)
    {
        try
        {
            URL url = new URL(linkSeen);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            String data1 = URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(id.trim(),"UTF-8")+
                    "&"+URLEncoder.encode("update", "UTF-8")+"="+URLEncoder.encode(update.trim(),"UTF-8")+
                    "&"+URLEncoder.encode("mail", "UTF-8")+"="+URLEncoder.encode(logEmail.trim(),"UTF-8");
            bufferedWriter.write(data1);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

            line = bufferedReader.readLine();
            bufferedReader.close();
            inputStream.close();


            httpURLConnection.disconnect();

        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    void seenUpdate(String linkSeen, String mailId, String update, String timeStamp, String logEmail)
    {
//        try
//        {
//            URL url = new URL(linkSeen);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestMethod("POST");
//            httpURLConnection.setDoOutput(true);
//            httpURLConnection.setDoInput(true);
//
//            OutputStream outputStream = httpURLConnection.getOutputStream();
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
//
//            String data1 = URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(mailId.trim(),"UTF-8")+
//                    "&"+URLEncoder.encode("update", "UTF-8")+"="+URLEncoder.encode(update.trim(),"UTF-8")+
//                    "&"+URLEncoder.encode("time", "UTF-8")+"="+URLEncoder.encode(timeStamp.trim(),"UTF-8")+
//                    "&"+URLEncoder.encode("logEmail", "UTF-8")+"="+URLEncoder.encode(logEmail.trim(),"UTF-8");
//            bufferedWriter.write(data1);
//            bufferedWriter.flush();
//            bufferedWriter.close();
//            outputStream.close();
//
//            inputStream = httpURLConnection.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
//
//            line = bufferedReader.readLine();
//            bufferedReader.close();
//            inputStream.close();
//
//
//            httpURLConnection.disconnect();
//
//        } catch(Exception e)
//        {
//            e.printStackTrace();
//        }
    }

    void response(String link, String id, String email, String response, String timeStamp)
    {
        try
        {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            String data1 = URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(id.trim(),"UTF-8")+
                    "&"+URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email.trim(),"UTF-8")+
                    "&"+URLEncoder.encode("status", "UTF-8")+"="+URLEncoder.encode(response.trim(),"UTF-8")+
                    "&"+URLEncoder.encode("date", "UTF-8")+"="+URLEncoder.encode(timeStamp.trim(),"UTF-8");
            bufferedWriter.write(data1);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

            line = bufferedReader.readLine();
            bufferedReader.close();
            inputStream.close();


            httpURLConnection.disconnect();

        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    String responseSeen(String link, String id, String email)
    {
        try
        {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            String data1 = URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(id.trim(),"UTF-8")+
                    "&"+URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email.trim(),"UTF-8");
            bufferedWriter.write(data1);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

            line = bufferedReader.readLine();
            bufferedReader.close();
            inputStream.close();


            httpURLConnection.disconnect();

            return line;
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
