package moredefences.content.items;

import arc.graphics.*;
import mindustry.type.*;

public class MDItems{
    public static Item
        aluminum, tin, cobalt, nickel, radium, radiode;

    public static void load(){
        aluminum = new Item("aluminum", Color.valueOf("bdffdf")){{
            //explosiveness = 0.2f;
            //radioactivity = 0.2f;
            //cost = 1.6f;
            hardness = 2;
        }};
        tin = new Item("tin", Color.valueOf("bfab7d")){{
            cost = 0.3f;
            hardness = 1;
        }};
        cobalt = new Item("cobalt", Color.valueOf("a8b0e6")){{
            hardness = 1;
        }};
        nickel = new Item("nickel", Color.valueOf("E7DEA4")){{ // formerly zinc, which was formerly iron
            hardness = 2;
        }};
        radium = new Item("radium", Color.valueOf("661C1C")){{
            hardness = 3;
            radioactivity = 1.05f;
            explosiveness = 0.4f;
        }};
        radiode = new Item("radiode", Color.valueOf("DD291C")){{
            cost = 1.1f;
            radioactivity = 0.65f;
            explosiveness = 0.1f;
        }};
    }
}
