package com.bwsw;

/**
 * Created by maximkholmansky on 30/10/16.
 */
public class ClientResponse {

    private int responseCode;
    private String body;

        public ClientResponse(int responseCode, String body)
        {
            this.responseCode = responseCode;
            this.body = body;

        }
        public int getResponseCode()
        {
            return responseCode;
        }
        public String getBody()
        {
            return body;
        }
}
