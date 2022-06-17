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

// import moredefences.world.blocks.production.*;
import moredefences.world.draw.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class MDBlocks{
    public static Block

    // turrets
    multishot, beehive, bubbler, carbine, cluster, coilgun, firenado, hellfire, instant, minelayer, shrapnel,
    tearer,
    // production - drills
    coalExtractor, farmer, frigid, largeWext, nickelExtractor, thoriumExtractor,
    // production - crafters
    filter, ionizer, sifter, sterilizer, tinRefurbish;

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
            range = 360f;
            rotateSpeed = 4f;
            recoil = 6f;
            shootSound = Sounds.artillery;
            ammoUseEffect = Fx.casing3Double;
            velocityRnd = 0.3f;
            inaccuracy = 12f;
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
        coilgun = new ItemTurret("coilgun"){{ // coligun
            requirements(Category.turret, with(
                Items.copper, 120,
                Items.lead, 120,
                MDItems.nickel, 80
            ));
            size = 3;
            health = 1120;
            reload = 100;
            inaccuracy = 0f;
            range = 360f;
            rotateSpeed = 10f;
            recoil = 3f;
            shootSound = Sounds./*[[*/bigshot/*]]*/;
            ammoPerShot = 20;
            maxAmmo = 40;
            targetAir = false;
            ammo(
                MDItems.nickel, MDBullets.coilgunNickel
            );
            coolant = consumeCoolant(0.2f);
            coolantMultiplier = 0.8f;
        }};
        firenado = new LiquidTurret("firenado"){{
            requirements(Category.turret, with(
                //MDItems.bronze, 500,
                MDItems.aluminum, 500, //300
                MDItems.cobalt, 230,
                MDItems.radiode, 200,
                Items.thorium, 170,
                Items.surgeAlloy, 150
            ));
            size = 4;
            health = 2400;
            reload = 100;
            inaccuracy = 25f;
            range = 260f;
            rotateSpeed = 10f;
            recoil = 5f;
            velocityRnd = 0.9f;
            shootSound = Sounds.splash;
            shootEffect = Fx.shootLiquid;
            ammoPerShot = 15;
            maxAmmo = 90;
            shootCone = 45f;
            shoot = new ShootSpread(180, 0f);
            liquidCapacity = 90f;
            ammo(
                Liquids.slag, MDBullets.firenadoSlag
            );
        }};
        hellfire = new ItemTurret("hellfire"){{
            requirements(Category.turret, with(
                Items.copper, 240,
                Items.lead, 240,
                MDItems.nickel, 80,
                Items.silicon, 120,
                Items.graphite, 120,
                Items.titanium, 60,
                Items.thorium, 40,
                Items.phaseFabric, 20,
                Items.surgeAlloy, 10
            ));
            size = 4;
            health = 1120;
            reload = 300;
            inaccuracy = 0f;
            range = 460f;
            rotateSpeed = 3f;
            recoil = 3f;
            shootSound = Sounds./*[[*/bigshot/*]]*/;
            ammoPerShot = 40;
            maxAmmo = 80;
            targetAir = false;
            ammo(
                Items.pyratite, MDBullets.hellfirePyra,
                Items.sporePod, MDBullets.hellfireSpore
            );
            coolant = consumeCoolant(0.2f);
            coolantMultiplier = 0.5f;
        }};
        instant = new ItemTurret("instant"){{
            requirements(Category.turret, with(
                Items.graphite, 40,
                Items.titanium, 70,
                Items.thorium, 45
            ));
            size = 2;
            health = 560;
            reload = 6;
            inaccuracy = 1f;
            range = 170f;
            rotateSpeed = 50f;
            targetGround = false;
            //ejectEffect = Fx.shellEjectSmall;
            shoot = new ShootAlternate(5f);
            ammo(
                Items.lead, MDBullets.instantLead,
                Items.silicon, MDBullets.instantSili,
                Items.titanium, MDBullets.instantTitanium
            );
            coolant = consumeCoolant(0.2f);
            coolantMultiplier = 0.5f;
        }};
        minelayer = new ItemTurret("minelayer"){{
            requirements(Category.turret, with(
                Items.graphite, 45,
                Items.titanium, 30,
                Items.silicon, 60
            ));
            size = 2;
            health = 800;
            reload = 300;
            inaccuracy = 15f;
            range = 170f;
            rotateSpeed = 5f;
            targetAir = false;
            velocityRnd = 0.3f;
            //ejectEffect = Fx.shellEjectSmall;
            shoot = new ShootSpread(5, 0f); // buff bullet count to 6 post-rework
            ammo(
                Items.blastCompound, MDBullets.minelayerMine
            );
        }};
        shrapnel = new ItemTurret("shrapnel"){{
            requirements(Category.turret, with(
                Items.copper, 50,
                Items.lead, 50,
                Items.titanium, 75
            ));
            size = 2;
            health = 450;
            reload = 180;
            inaccuracy = 2f;
            range = 172f;
            rotateSpeed = 2f;
            targetAir = false;
            ammoPerShot = 4;
            //ejectEffect = Fx.shellEjectSmall;
            ammo(
                Items.lead, MDBullets.shrapnelLead,
                Items.metaglass, MDBullets.shrapnelMeta,
                Items.titanium, MDBullets.shrapnelTitanium
            );
            coolant = consumeCoolant(0.3f);
            coolantMultiplier = 2f/1.5f;
        }};
        tearer = new ItemTurret("tearer"){{
            requirements(Category.turret, with(
                Items.copper, 10,
                Items.titanium, 25
            ));
            size = 1;
            health = 200;
            reload = 2;
            inaccuracy = 1f;
            range = 170f;
            rotateSpeed = 15f;
            targetGround = false;
            //ejectEffect = Fx.shellEjectSmall;
            shoot = new ShootAlternate(3f);
            ammo(
                Items.scrap, MDBullets.tearerScrap,
                Items.lead, MDBullets.tearerLead
            );
        }};
        // production - drills
        coalExtractor = new GenericCrafter("coal-extractor"){{
            requirements(Category.production, with(
                Items.copper, 30,
                Items.lead, 40,
                Items.graphite, 30
            ));
            size = 2;
            health = 200;
            hasPower = true;
            hasItems = true;
            craftTime = 180f;

            consumePower(0.35f);
            
            outputItem = new ItemStack(Items.coal, 1);
        }};
        farmer = new AttributeCrafter("farmer"){{
            requirements(Category.production, with(
                Items.copper, 30,
                Items.lead, 50,
                Items.graphite, 35,
                Items.silicon, 25,
                Items.plastanium, 10
            ));
            size = 3;
            health = 600;
            hasLiquids = true;
            hasPower = true;
            hasItems = true;
            itemCapacity = 30;
            liquidCapacity = 100f;

            craftEffect = Fx.none;
            envRequired |= Env.spores;
            attribute = Attribute.spores;

            legacyReadWarmup = true;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawCultivator(),
                new DrawRegion("-top")
            );
            maxBoost = 2f;

            craftTime = 100;
            consumePower(125f / 60f);
            consumeLiquid(Liquids.water, 36f / 60f);
            
            outputItem = new ItemStack(Items.sporePod, 3);
        }};
        frigid = new SolidPump("frigid"){{
            requirements(Category.production, with(
                MDItems.cobalt, 35,
                Items.metaglass, 65,
                Items.plastanium, 45
            ));
            size = 3;
            health = 420;
            hasPower = true;
            pumpAmount = 0.08f;
            updateEffect = Fx.shootBigSmoke;
            // drillEffect = Fx.freezing;
            liquidCapacity = 20f;
            rotateSpeed = 0f;
            result = Liquids.cryofluid;

            consumePower(3f);
        }};
        largeWext = new SolidPump("large-water-extractor"){{
            requirements(Category.production, with(
                Items.lead, 60,
                Items.graphite, 60,
                Items.silicon, 50,
                Items.titanium, 45,
                Items.plastanium, 60,
                Items.thorium, 60
            ));
            size = 3;
            health = 360;
            hasPower = true;
            pumpAmount = 0.3f;
            liquidCapacity = 120f;
            rotateSpeed = 1.2f;
            attribute = Attribute.water;
            result = Liquids.water;

            consumePower(210f / 60f);
        }};
        nickelExtractor = new GenericCrafter("nickel-extractor"){{
            requirements(Category.production, with(
                Items.copper, 20,
                Items.lead, 10,
                Items.graphite, 10
            ));
            size = 2;
            health = 200;
            hasPower = true;
            hasItems = true;
            craftTime = 150f;
            drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-rotator"){{
                spinSprite = true;
                rotateSpeed = 3.91f;
            }}, new DrawRegion("-top"));

            consumePower(0.4f);
            
            outputItem = new ItemStack(MDItems.nickel, 1);
        }};
        thoriumExtractor = new GenericCrafter("thorium-extractor"){{
            requirements(Category.production, with(
                Items.titanium, 60,
                Items.graphite, 90,
                Items.silicon, 90,
                Items.copper, 110,
                Items.thorium, 30
            ));
            size = 3;
            health = 200;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            craftTime = 400f;

            consumePower(2.25f);
            consumeLiquid(Liquids.cryofluid, 10f / 60f);
            
            outputItem = new ItemStack(Items.thorium, 1);
        }};
        // production - crafters
        filter = new GenericCrafter("filter"){{
            requirements(Category.crafting, with(
                Items.copper, 45
            ));
            size = 1;
            health = 40;
            hasPower = true;
            hasItems = true;
            craftTime = 6f;
            
            consumeItem(Items.sand, 2);
            //consumeItems(with(Items.tungsten, 2, Items.graphite, 3));
            
            outputItem = new ItemStack(MDItems.tin, 1);
        }};
        ionizer = new GenericCrafter("ionizer"){{
            requirements(Category.crafting, with(
                Items.lead, 35,
                Items.graphite, 25,
                Items.thorium, 60,
                Items.plastanium, 20
            ));
            size = 2;
            health = 160;
            hasPower = true;
            hasItems = true;
            craftTime = 30f;
            itemCapacity = 30;
            updateEffect = Fx.none;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawIonizer(), new DrawDefault());

            consumePower(1f);
            consumeItems(with(Items.graphite, 1, Items.lead, 2));
            
            outputItem = new ItemStack(MDItems.radium, 3);
        }};
        sifter = new GenericCrafter("sifter"){{
            requirements(Category.crafting, with(
                Items.copper, 40,
                Items.lead, 30
            ));
            size = 1;
            health = 40;
            hasPower = true;
            hasItems = true;
            craftTime = 6f;
            itemCapacity = 30;
            
            consumeItem(Items.sand, 7);
            
            outputItem = new ItemStack(Items.scrap, 2);
        }};
        sterilizer = new GenericCrafter("sterilizer"){{
            requirements(Category.crafting, with(
                MDItems.tin, 80,
                Items.graphite, 120,
                Items.titanium, 80,
                Items.plastanium, 90,
                MDItems.radium, 70
            ));
            size = 3;
            health = 720;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            craftTime = 60f;
            itemCapacity = 30;
            updateEffect = Fx.fuelburn;
            drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-rotator"){{
                rotateSpeed = 3.4f;
            }}, new DrawRegion("-top"));

            consumePower(3f);
            consumeItems(with(MDItems.radium, 3, Items.sand, 12));
            consumeLiquid(Liquids.oil, 0.15f);
            
            outputItem = new ItemStack(MDItems.radiode, 3);
        }};
        tinRefurbish = new GenericCrafter("tin-refurbish"){{
            requirements(Category.crafting, with(
                MDItems.tin, 20,
                Items.copper, 35,
                Items.lead, 25
            ));
            size = 2;
            health = 170;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            craftTime = 45f;
            
            consumePower(0.5f);
            consumeItem(MDItems.tin, 2);
            consumeLiquid(Liquids.water, 0.02f);
            
            outputItem = new ItemStack(MDItems.aluminum, 1);
        }};
    }
}
