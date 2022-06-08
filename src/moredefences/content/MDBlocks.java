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
    multishot, /*twothreecannon,*/ beehive;

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
            shoot = new ShootSpread(8, 1f);
            //shootSound = Sounds.railgun;
            //coolant = consumeCoolant(0.2f);
            ammo(
                Items.lead, MDBullets.multishotLead,
                Items.coal, MDBullets.multishotCoal,
                Items.silicon, MDBullets.multishotSili
            );
            coolant = consumeCoolant(0.2f);
        }};
        // twothreecannon
        beehive = new ItemTurret("beehive"){{
            requirements(Category.turret, with(
                Items.copper, 95,
                Items.lead, 110,
                Items.graphite, 45,
                Items.titanium, 50
            ));
            size = 2;
            health = 540;
            reload = 10;
            inaccuracy = 0.5f;
            range = 100f;
            rotateSpeed = 2.5f;
            targetAir = false;
            maxAmmo = 60;
            //ejectEffect = Fx.shellEjectSmall;
            shoot = new ShootSpread(3, 15f);
            ammo(
                Items.lead, MDBullets.beehiveLead
            );
            coolant = consumeCoolant(0.2f*0.8f);
        }};
    }
}
