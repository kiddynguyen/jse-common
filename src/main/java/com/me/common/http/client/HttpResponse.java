package com.me.common.http.client;

import com.me.core.util.JSONUtil;

/**
 * @author tunm2
 */
public class HttpResponse {
    public static final int SC_UNKNOWN = -1;
    public static final int SC_CONNECTION_TIMEOUT = -2;
    public static final int SC_SOCKET_TIMEOUT = -3;
    
    public static final HttpResponse ERR_UNKNOWN = new HttpResponse(SC_UNKNOWN);
    public static final HttpResponse ERR_CONNECTION_TIMEOUT = new HttpResponse(SC_SOCKET_TIMEOUT);
    public static final HttpResponse ERR_SOCKET_TIMEOUT = new HttpResponse(SC_SOCKET_TIMEOUT);
    
    private int status;
    private String content;
    
    public HttpResponse() {}
    
    public HttpResponse(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return JSONUtil.toJSONString(this);
    }
}
