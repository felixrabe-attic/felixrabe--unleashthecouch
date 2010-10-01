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
import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;

import edu.umd.cs.piccolo.PCanvas;
import edu.umd.cs.piccolo.PLayer;
import edu.umd.cs.piccolox.PFrame;

public class UnleashTheCouch extends PFrame {
    
    private static final long serialVersionUID = 1L;
    
    JsonNode jsonNode;
    
    public UnleashTheCouch(String couchDbDocUrl) throws JsonProcessingException, IOException {
        super("Unleash The Couch", false, null);
        JsonNode jsonNode = Utils.getJSON(couchDbDocUrl);
        this.jsonNode = jsonNode;
    }

    public void initialize() {
        getCanvas().removeInputEventListener(getCanvas().getZoomEventHandler());
        getCanvas().removeInputEventListener(getCanvas().getPanEventHandler());
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: UnleashTheCouch http://yourhost:port/database/docid");
            System.exit(1);
        }
        String couchDbDocUrl = args[0];
        try {
            new UnleashTheCouch(couchDbDocUrl);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
