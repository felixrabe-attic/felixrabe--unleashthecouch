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

import org.codehaus.jackson.JsonNode;

/**
 * @author Felix Rabe
 * 
 */
public class UnleashObject {
    
    protected final static String UNLEASHTHECOUCH_VIEW_TYPE = "unleashthecouch (Piccolo2D/Java2D) view";

    private JsonNode jsonRootNode;

    public UnleashObject(JsonNode jsonRootNode) {
        this.jsonRootNode = jsonRootNode;
    }

    public String getType() {
        return Utils.getStringFromObject(jsonRootNode, "@Type", UNLEASHTHECOUCH_VIEW_TYPE);
    }
}
