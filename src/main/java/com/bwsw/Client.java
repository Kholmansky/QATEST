package com.bwsw;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

/**
 * Created by maximkholmansky on 30/10/16.
 */
public class Client {

    public static ClientResponse sendGetRequest(String url) throws Exception {
        HttpResponse<String> response = Unirest.get(url).asString();
        ClientResponse clientResponse = new ClientResponse(response.getStatus(),response.getBody());
        return clientResponse;
    }
}
