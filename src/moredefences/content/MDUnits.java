package moredefences.content.units;

import arc.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.struct.ObjectMap.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.meta.*;

@SuppressWarnings("unchecked")
public class MDUnits{
    // "borrowed" from progression ministry, which "borrowed" from endless rusting, which "borrowed" from progression ministry, which "borrowed" from betamindy
    // temporarily disabled since no new unit types have been added yet
    /*private static final Entry<Class<? extends Entityc>, Prov<? extends Entityc>>[] types = new Entry[]{
        prov(SentryUnit.class, SentryUnit::new),
        prov(FlareUnit.class, FlareUnit::new),
        prov(SwordUnit.class, SwordUnit::new)
    };

    private static final ObjectIntMap<Class<? extends Entityc>> idMap = new ObjectIntMap<>();

    //
    // * Internal function to flatmap {@code Class -> Prov} into an {@link Entry}.
    // * @author GlennFolker
    //
    private static <T extends Entityc> Entry<Class<T>, Prov<T>> prov(Class<T> type, Prov<T> prov){
        Entry<Class<T>, Prov<T>> entry = new Entry<>();
        entry.key = type;
        entry.value = prov;
        return entry;
    }

    //
    // * Setups all entity IDs and maps them into {@link EntityMapping}.
    // * @author GlennFolker
    // 

    private static void setupID(){
        for(
            int i = 0,
            j = 0,
            len = EntityMapping.idMap.length;

            i < len;

            i++
        ){
            if(EntityMapping.idMap[i] == null){
                idMap.put(types[j].key, i);
                EntityMapping.idMap[i] = types[j].value;

                if(++j >= types.length) break;
            }
        }
    }

    //
    // * Retrieves the class ID for a certain entity type.
    // * @author GlennFolker
    // 
    public static <T extends Entityc> int classID(Class<T> type){
        return idMap.get(type, -1);
    }*/

    /* notes to self
    MechUnit::create; for ground units
    constructor = UnitEntity::create; for air units
    UnitWaterMove::create; for naval units
    LegsUnit::create; for spider units
    */
    
    public static UnitType

    // cannoneer unit line
    cannoneer;

    public static void load(){
        //setupID();
        // cannoneer unit line
        cannoneer = new UnitType("cannoneer-mech"){{
            health = 140f;
            speed = 0.5f;
            flying = false;
            itemCapacity = 10f;
            range = 224f;
            constructor = MechUnit::create;

            weapons.add(new Weapon("cannoneer-weapon"){{
                top = false;
                rotate = false;
                alternate = true;
                x = 3.8f;
                y = 3f;
                reload = 10f;
                ejectEffect = Fx.casing1;

                bullet = new BasicBulletType(7f, 6f){{ // speed, dmg
                    width = 10f;
                    height = 14f;
                    frontColor = Color.valueOf("aeff00");
                    backColor = Color.valueOf("95db00");
                    lifetime = 32f;
                    status = StatusEffects.corroded;
                }};
            }});
        }};
    }
}
