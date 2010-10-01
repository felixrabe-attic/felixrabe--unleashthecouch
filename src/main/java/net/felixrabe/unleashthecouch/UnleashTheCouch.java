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
import java.awt.Color;
import java.io.IOException;
import java.util.Iterator;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;

import edu.umd.cs.piccolo.PLayer;
import edu.umd.cs.piccolo.PNode;
import edu.umd.cs.piccolo.nodes.PText;
import edu.umd.cs.piccolox.PFrame;

public class UnleashTheCouch extends PFrame {
    
    private static final long serialVersionUID = 1L;
    
    private String couchDbDocUrl;
    JsonNode jsonNode;
    
    public UnleashTheCouch(String couchDbDocUrl) throws JsonProcessingException, IOException {
        super("Unleash The Couch", false, null);
        this.couchDbDocUrl = couchDbDocUrl;
        initializeLater();
    }

    private void initializeLater() {
        JsonNode json;
        try {
            json = Utils.getJSON(couchDbDocUrl);
        } catch (JsonProcessingException e) {
            return;
        } catch (IOException e) {
            return;
        }
        
        PLayer layer = getCanvas().getLayer();
        
        for (Iterator<String> it = json.getFieldNames(); it.hasNext(); ) {
            String fieldName = it.next();
            if (!fieldName.startsWith("show:"))
                continue;
            PNode node = new PNode();
            JsonNode subJson = json.get(fieldName);
            JsonNode x = subJson.get("x");
            node.setBounds(subJson.get("x").getValueAsInt(),
                    subJson.get("y").getValueAsInt(), 30, 30);
            node.setPaint(Color.ORANGE);
            layer.addChild(node);
        }
        getCanvas().repaint();
    }

    public void initialize() {
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
