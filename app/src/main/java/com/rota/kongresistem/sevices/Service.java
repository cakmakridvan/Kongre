package com.rota.kongresistem.sevices;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Service {

    private static String NAMESPACE = "KongreSistemiWS";
    private static String URLRotaWebServisApplication = "https://kongresistemi.com/webservis/rpc/KongreSistemiWSService.php";
    private static final int WS_TIMEOUT = 10000;
    public static final String Main_URL = "https://www.kongresistemi.com/webservis/";

    public static String OpenSession(String username, String password) {

        String METHOD_NAME = "Login";
        String SOAP_ACTION = NAMESPACE + METHOD_NAME;
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        request.addProperty("username", username);
        request.addProperty("password", password);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);
        HttpTransportSE httpTransport = new HttpTransportSE(URLRotaWebServisApplication, WS_TIMEOUT);
        SoapObject result = null;

        String sonuc = "false";
        try {
            httpTransport.call(SOAP_ACTION, envelope);
            result = (SoapObject) envelope.getResponse();
            sonuc = result.toString();

        }catch (Exception e) {
            e.printStackTrace();
            sonuc = "false";

        }

        return sonuc;
    }

    public static String GetEtkinlik(String userID) {

        String method_Projects = "etkinlik_bilgileri.php";

        DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
        HttpGet httppost = new HttpGet(Main_URL + method_Projects + "?" + "ID=" + userID);
// Depends on your web service
        httppost.setHeader("Content-type", "application/json");

        InputStream inputStream = null;
        String result = null;
        try {
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            inputStream = entity.getContent();
            // json is UTF-8 by default
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            result = sb.toString();
        } catch (Exception e) {
            // Oops
            return "false";
        } finally {
            try {

                if (inputStream != null) inputStream.close();

            } catch (Exception squish) {
                return "false";
            }
        }
        return result;
    }

    public static String GetBildiri(String bildiriID) {

        String method_Projects = "bildiri_bilgileri.php";

        DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
        HttpGet httppost = new HttpGet(Main_URL + method_Projects + "?" + "ID=" + bildiriID);
// Depends on your web service
        httppost.setHeader("Content-type", "application/json");

        InputStream inputStream = null;
        String result = null;
        try {
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            inputStream = entity.getContent();
            // json is UTF-8 by default
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            result = sb.toString();
        } catch (Exception e) {
            // Oops
            return "false";
        } finally {
            try {

                if (inputStream != null) inputStream.close();

            } catch (Exception squish) {
                return "false";
            }
        }
        return result;
    }
}
