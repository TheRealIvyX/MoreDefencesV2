package moredefences.content.blocks;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import moredefences.content.bullets.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class MDBlocks{
    public static Block

    // turrets
    multishot;

    public static void load(){
        multishot = new ItemTurret("multishot"){{
            requirements(Category.turret, with(
                Items.copper, 60,
                Items.lead, 20
            ));
            size = 1;
            //hideDetails = false;
            health = 200;
            reload = 60;
            inaccuracy = 3f;
            range = 100f;
            rotateSpeed = 5f;
            shots = 8;
            spread = 1f;
            //shootSound = Sounds.railgun;
            //coolant = consumeCoolant(0.2f);
            ammo(
                Items.lead, MDBullets.multishotLead,
                Items.coal, MDBullets.multishotCoal,
                Items.silicon, MDBullets.multishotSili
            );
        }};
    }
}
