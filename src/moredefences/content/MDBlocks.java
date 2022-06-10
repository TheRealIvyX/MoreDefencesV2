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
import moredefences.content.items.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class MDBlocks{
    public static Block

    // turrets
    multishot, beehive, bubbler, carbine, cluster;

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
            range = 120f;
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
            range = 160f;
            rotateSpeed = 2.5f;
            targetAir = false;
            maxAmmo = 60;
            //ejectEffect = Fx.shellEjectSmall;
            shoot = new ShootSpread(3, 15f);
            ammo(
                Items.lead, MDBullets.beehiveLead
            );
            coolant = consumeCoolant(0.2f);
            coolantMultiplier = 0.8f;
        }};
        bubbler = new LiquidTurret("bubbler"){{
            requirements(Category.turret, with(
                Items.lead, 125,
                Items.titanium, 25,
                Items.metaglass, 75
            ));
            size = 2;
            health = 600;
            reload = 3;
            inaccuracy = 45f;
            range = 200f;
            rotateSpeed = 5f;
            //ejectEffect = Fx.shellEjectSmall;
            shoot = new ShootSpread(8, 45f);
            ammo(
                Liquids.water, MDBullets.bubblerWater,
                Liquids.slag, MDBullets.bubblerSlag,
                Liquids.oil, MDBullets.bubblerOil,
                Liquids.cryofluid, MDBullets.bubblerCryo
            );
        }};
        carbine = new ItemTurret("carbine"){{
            requirements(Category.turret, with(
                MDItems.aluminum, 20,
                MDItems.cobalt, 85,
                Items.silicon, 45
            ));
            size = 2;
            health = 620;
            reload = 75;
            inaccuracy = 0f;
            range = 180f;
            rotateSpeed = 4f;
            maxAmmo = 50;
            recoil = 5f;
            shootSound = Sounds.shootSnap;
            //ejectEffect = Fx.shellEjectSmall;
            ammo(
                MDItems.tin, MDBullets.carbineTin,
                MDItems.aluminum, MDBullets.carbineAluminum
            );
            coolant = consumeCoolant(0.2f);
        }};
        cluster = new ItemTurret("cluster"){{
            requirements(Category.turret, with(
                Items.copper, 250,
                Items.graphite, 240,
                Items.thorium, 250,
                Items.surgeAlloy, 200
            ));
            size = 4;
            health = 1600;
            reload = 90;
            inaccuracy = 3f;
            range = 360f;
            rotateSpeed = 4f;
            recoil = 6f;
            shootSound = Sounds.artillery;
            ammoUseEffect = Fx.casing3Double;
            velocityRnd = 0.3f;
            ammoPerShot = 5;
            shake = 3.25f;
            cooldownTime = 0.03f;
            ammoEjectBack = 5;
            targetAir = false;
            shoot = new ShootSpread(12, 0f);
            ammo(
                Items.pyratite, MDBullets.clusterPyra,
                Items.blastCompound, MDBullets.clusterBlast,
                Items.plastanium, MDBullets.clusterPlast,
                Items.surgeAlloy, MDBullets.clusterSurge
            );
            coolant = consumeCoolant(0.2f);
            coolantMultiplier = 0.5f;
        }};
    }
}
