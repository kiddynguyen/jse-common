package com.me.common.http.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * @author tunm2
 */
public class NativeHttpClient {
    
    private static final int CONN_TIMEOUT = 3000;   // millisecond
    private static final int READ_TIMEOUT = 5000;   // milliseconds
    
    private static Logger logger = Logger.getLogger(NativeHttpClient.class);
    
    public HttpResponse get(String domain, String uri, String query) {
        HttpResponse resp = new HttpResponse();
        
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(domain);
        if (uri != null && !uri.isEmpty())
            urlBuilder.append(uri);
        if (query != null && !query.isEmpty())
            urlBuilder.append("?").append(query);
        logger.info("REQUEST URL: " + urlBuilder.toString());
        BufferedReader reader = null;

        try {
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(CONN_TIMEOUT);
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setRequestProperty("Content-Length", query == null ? "0" : String.valueOf(query.length())); // header
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setAllowUserInteraction(false);
            conn.connect();
            
            // parse response
            StringBuilder content = new StringBuilder();
            InputStream instream = conn.getInputStream(); // stream between client and server
            reader = new BufferedReader(new InputStreamReader(instream));
            String line;
            while ((line = reader.readLine()) != null)
                content.append(line);
            
            resp.setStatus(conn.getResponseCode());
            resp.setContent(content.toString());
        } catch (SocketTimeoutException ex) {
            logger.error(ex.getMessage());
            return HttpResponse.ERR_SOCKET_TIMEOUT;
        } catch (IOException ex) {
            logger.error(ex.getMessage());
            return HttpResponse.ERR_UNKNOWN;
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException i) {}
        }
        
        return resp;
    }
    
    public HttpResponse get(String domain, String uri, Map<String, Object> params) {
        String query = "";
        if (params != null && !params.isEmpty()) {
            StringBuilder qbuilder = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                qbuilder.append(param.getKey()).append("=").append(param.getValue()).append("&");
            }
            qbuilder.deleteCharAt(qbuilder.length()-1);
            query = qbuilder.toString();
        }
        
        return get(domain, uri, query);
    }

    public HttpResponse post(String domain, String uri, String query) {
        HttpResponse resp = new HttpResponse();
        
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(domain);
        if (uri != null && !uri.isEmpty())
            urlBuilder.append(uri);
        
        DataOutputStream writer = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(CONN_TIMEOUT);
            conn.setReadTimeout(READ_TIMEOUT);
            
            // header
            conn.setRequestProperty("Content-Length", query == null ? "0" : String.valueOf(query.length()));
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); // default
            
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setAllowUserInteraction(false);
            conn.connect();
            
            writer = new DataOutputStream(conn.getOutputStream());
            writer.writeBytes(query);
            writer.flush();
            
            StringBuilder response = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null)
                response.append(line);
            
            resp.setStatus(conn.getResponseCode());
            resp.setContent(response.toString());
        } catch (SocketTimeoutException ex) {
            logger.error(ex.getMessage());
            return HttpResponse.ERR_SOCKET_TIMEOUT;
        } catch (IOException ex) {
            logger.error(ex.getMessage());
            return HttpResponse.ERR_UNKNOWN;
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (writer != null)
                    writer.close();
            } catch (IOException i) {}
        }
        
        return resp;
    }
    
    public HttpResponse post(String domain, String uri, Map<String, Object> params) throws UnsupportedEncodingException {
        String query = "";
        if (params != null && !params.isEmpty()) {
            StringBuilder qbuilder = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                String pname = param.getKey();
                String pval = URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8");
                qbuilder.append(pname).append("=").append(pval).append("&");
            }
            query = qbuilder.toString().substring(0, qbuilder.length()-1);
        }
        
        return post(domain, uri, query);
    }
}