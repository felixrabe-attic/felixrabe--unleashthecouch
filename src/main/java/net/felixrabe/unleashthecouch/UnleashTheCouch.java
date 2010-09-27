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
import edu.umd.cs.piccolo.PLayer;
import edu.umd.cs.piccolo.PNode;
import edu.umd.cs.piccolo.nodes.PPath;
import edu.umd.cs.piccolo.nodes.PText;
import edu.umd.cs.piccolox.PFrame;
import edu.umd.cs.piccolox.handles.PBoundsHandle;

public class UnleashTheCouch extends PFrame {
    
    private static final long serialVersionUID = 1L;
    
    public UnleashTheCouch() {
        super("Unleash The Couch", false, null);
    }

    public void initialize() {
        final PLayer layer = getCanvas().getLayer();
        PNode text = new PText("URL of CouchDB database:");
        layer.addChild(text);
        // layer.addChild(new PText("Example: http://localhost:5984/employees"));
    }
    
    public static void main(String[] args) {
        new UnleashTheCouch();
    }

}
