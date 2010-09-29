/*
 * Copyright 2010 Felix Rabe

 * This file is part of unleashthecouch.

 * unleashthecouch is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * unleashthecouch is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with unleashthecouch.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.felixrabe.unleashthecouch;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author Felix Rabe
 *
 */
public class Utils {

    public static String getDocument(String couchDbDocUrl) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(couchDbDocUrl);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                entity.writeTo(baos);
                return new String(baos.toByteArray(), "UTF-8");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * @param couchDbDocUrl
     * @return UnleashObject representing the CouchDB document
     */
    public static UnleashObject openObject(String couchDbDocUrl) {
        String jsonString = Utils.getDocument(couchDbDocUrl);
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        try {
            JsonNode jsonRootNode = jsonObjectMapper.readTree(jsonString);
            UnleashObject obj = new UnleashObject(jsonRootNode);
            return obj;
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
}
