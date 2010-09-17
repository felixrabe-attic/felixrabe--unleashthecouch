/*
 * Copyright 2010 Felix Rabe

 * This file is part of UnleashGUI201009.

 * UnleashGUI201009 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * UnleashGUI201009 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with UnleashGUI201009.  If not, see <http://www.gnu.org/licenses/>.
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

public class AskCouchDB {
    
    private String host;
    
    public AskCouchDB(String domain, int port) {
        host = "http://" + domain + ":" + port;
    }
    
    public String httpGet(String path) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(host + path);
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
}
