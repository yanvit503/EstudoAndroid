package com.saojose.estudoapi.Requisicoes;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.saojose.estudoapi.Model.Pais;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

public class RequisicaoHttp extends AsyncTask<Void, Void, ArrayList<Pais>> {

    @Override
    protected ArrayList<Pais> doInBackground(Void... voids) {

        StringBuilder resposta = new StringBuilder();
        String linha;

        URL url = null;
        try {

            //força o app a confiar no certificado da API ( não seguro )
            trustEveryone(); // <- copiei da internet

            url = new URL("https://192.168.1.5:45455/api/teste/");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream is = new BufferedInputStream(connection.getInputStream());

            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            while ((linha = rd.readLine()) != null) {
                resposta.append(linha);
            }

            connection.disconnect();

        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type listType = new TypeToken<ArrayList<Pais>>(){}.getType();
        Log.println(Log.DEBUG,"req",resposta.toString());
        return new Gson().fromJson(resposta.toString(), listType);
    }

    private void trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }});
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[]{new X509TrustManager(){
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {}
                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {}
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }}}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(
                    context.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}