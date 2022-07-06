package moredefences.content.units;

import arc.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import arc.struct.*;
import arc.struct.ObjectMap.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.effect.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;

import moredefences.entities.bullet.*;

import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

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
    cannoneer, artilleryman, ordnance, mortar, howitzer,
    // swarmer unit line
    swarmer, bee, hornet, messenger, communicator,
    // bombardier unit line
    bombardier, pelter, showerer, avalanche, tundra;

    public static void load(){
        //setupID();
        // cannoneer unit line
        cannoneer = new UnitType("cannoneer-mech"){{
            health = 140f;
            speed = 0.5f;
            flying = false;
            itemCapacity = 10;
            range = 224f;
            constructor = MechUnit::create;
            immunities.addAll(StatusEffects.corroded);

            weapons.add(new Weapon("moredefences-cannoneer-weapon"){{
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
        artilleryman = new UnitType("artilleryman-mech"){{
            health = 500f;
            speed = 0.3f;
            flying = false;
            hitSize = 11f;
            itemCapacity = 25;
            range = 280f;
            constructor = MechUnit::create;
            immunities.addAll(StatusEffects.corroded);
            targetAir = false;

            weapons.add(new Weapon("moredefences-artilleryman-weapon"){{
                top = true;
                rotate = false;
                alternate = true;
                x = 5.6f;
                y = 0f;
                reload = 60f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.artillery;
                velocityRnd = 0.2f;
                inaccuracy = 7f;
                shake = 1f;
                shoot = new ShootSpread(3, 0f);

                bullet = new ArtilleryBulletType(5f, 0f){{ // speed, dmg
                    splashDamage = 20f;
                    splashDamageRadius = 25f;
                    knockback = 0.8f;
                    hitEffect = Fx.flakExplosion;
                    width = 8f;
                    height = 8f;
                    collidesTiles = true;
                    collides = true;
                    frontColor = Color.valueOf("aeff00");
                    backColor = Color.valueOf("95db00");
                    lifetime = 56f;
                    status = StatusEffects.corroded;
                }};
            }});
        }};
        ordnance = new UnitType("ordnance-mech"){{
            health = 900f;
            speed = 0.6f;
            flying = false;
            hitSize = 15f;
            armor = 6f;
            itemCapacity = 40;
            range = 260f;
            constructor = LegsUnit::create;
            immunities.addAll(StatusEffects.corroded);
            targetAir = false;
            legCount = 4;
            legLength = 13f;
            legForwardScl = 0.8f;
            legMoveSpace = 1.4f;
            legBaseOffset = 2f;
            allowLegStep = true;
            hovering = true;

            weapons.add(new Weapon("moredefences-ordnance-cannon"){{
                top = true;
                rotate = true;
                mirror = false;
                x = 0f;
                y = 0f;
                reload = 90f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.artillery;
                inaccuracy = 0f;
                shake = 1f;

                bullet = new ArtilleryBulletType(4f, 0f){{ // speed, dmg
                    splashDamage = 80f;
                    splashDamageRadius = 40f;
                    knockback = 1.75f;
                    hitEffect = Fx.flakExplosion;
                    width = 15f;
                    height = 15f;
                    collidesTiles = false;
                    collides = true;
                    frontColor = Color.valueOf("aeff00");
                    backColor = Color.valueOf("95db00");
                    lifetime = 80f;
                    status = StatusEffects.corroded;
                    hitShake = 1f;
                    fragBullets = 7;
                    fragRandomSpread = 60f;
                    fragBullet = new BasicBulletType(5f, 3f){{ // speed, dmg
                        width = 2f;
                        height = 2.8f;
                        frontColor = Color.valueOf("aeff00");
                        backColor = Color.valueOf("95db00");
                        status = StatusEffects.corroded;
                        lifetime = 20f;
                    }};
                }};
            }});
        }};
        mortar = new UnitType("mortar-mech"){{
            health = 8000f;
            speed = 0.4f;
            flying = false;
            hitSize = 21f;
            armor = 9f;
            itemCapacity = 90;
            range = 360f;
            constructor = LegsUnit::create;
            immunities.addAll(StatusEffects.corroded);
            targetAir = false;
            legCount = 5;
            legLength = 30f;
            legForwardScl = 0.8f;
            legMoveSpace = 1f;
            legPairOffset = 3f;
            legBaseOffset = 10f;
            legExtension = -15f;
            allowLegStep = true;
            legSpeed = 0.1f;
            shadowElevation = 0.5f;
            hovering = true;
            rotateSpeed = 7f;

            weapons.add(new Weapon("moredefences-mortar-cannon"){{
                top = true;
                rotate = true;
                mirror = false;
                x = 0f;
                y = -8f;
                reload = 260f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.artillery;
                inaccuracy = 0f;
                shake = 5f;

                bullet = new ArtilleryBulletType(3f, 0f){{ // speed, dmg
                    splashDamage = 200f;
                    splashDamageRadius = 90f;
                    knockback = 2.4f;
                    hitEffect = Fx.flakExplosion;
                    width = 20f;
                    height = 20f;
                    collidesTiles = false;
                    collides = true;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("95db00");
                    lifetime = 120f;
                    status = StatusEffects.corroded;
                    hitShake = 2f;
                    fragBullets = 15;
                    fragRandomSpread = 160f;
                    fragBullet = new ArtilleryBulletType(7f, 0f){{ // speed, dmg
                        width = 6f;
                        height = 9f;
                        splashDamage = 30f;
                        splashDamageRadius = 16f;
                        frontColor = Color.valueOf("aeff00");
                        backColor = Color.valueOf("95db00");
                        collidesTiles = false;
                        collides = true;
                        status = StatusEffects.corroded;
                        lifetime = 30f;
                        fragBullets = 3;
                        fragBullet = new BasicBulletType(5f, 2f){{ // speed, dmg
                            width = 2f;
                            height = 2.8f;
                            frontColor = Color.valueOf("aeff00");
                            backColor = Color.valueOf("95db00");
                            status = StatusEffects.corroded;
                            lifetime = 10f;
                        }};
                    }};
                }};
            }});
        }};
        howitzer = new UnitType("howitzer-mech"){{
            health = 18000f;
            speed = 0.2f;
            flying = false;
            hitSize = 30f;
            armor = 10f;
            itemCapacity = 140;
            range = 480f;
            constructor = LegsUnit::create;
            immunities.addAll(StatusEffects.corroded);
            legCount = 7;
            legLength = 75f;
            legForwardScl = 0.8f;
            legMoveSpace = 0.7f;
            legPairOffset = 3f;
            legBaseOffset = 8f;
            legExtension = -20f;
            allowLegStep = true;
            legSpeed = 0.06f;
            mechLandShake = 1f;
            shadowElevation = 0.5f;
            hovering = true;
            rotateSpeed = 3f;

            weapons.add(new Weapon("moredefences-howitzer-cannon"){{
                top = true;
                rotate = true;
                mirror = false;
                x = 0f;
                y = -15f;
                reload = 300f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.artillery;
                inaccuracy = 3f;
                rotateSpeed = 1f;
                shake = 15f;
                shoot = new ShootSpread(3, 7.5f);

                bullet = new ArtilleryBulletType(4f, 0f){{ // speed, dmg
                    splashDamage = 150f;
                    splashDamageRadius = 120f;
                    knockback = 3.5f;
                    hitEffect = Fx.flakExplosion;
                    width = 18f;
                    height = 18f;
                    collidesTiles = false;
                    collides = true;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("95db00");
                    lifetime = 120f;
                    status = StatusEffects.corroded;
                    hitShake = 12f;
                    fragBullets = 17;
                    fragRandomSpread = 120f;
                    fragBullet = new ArtilleryBulletType(6f, 0f){{ // speed, dmg
                        width = 6f;
                        height = 9f;
                        splashDamage = 25f;
                        splashDamageRadius = 44f;
                        frontColor = Color.valueOf("ffffff");
                        backColor = Color.valueOf("95db00");
                        collidesTiles = false;
                        collides = true;
                        status = StatusEffects.corroded;
                        homingPower = 0.2f;
                        homingRange = 96f;
                        lifetime = 30f;
                        hitShake = 5f;
                    }};
                }};
            }});
            weapons.add(new Weapon("moredefences-cannoneer-weapon"){{
                top = true;
                rotate = true;
                mirror = true;
                x = 12f;
                y = 7f;
                reload = 20f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.missile;
                inaccuracy = 3f;

                bullet = new MissileBulletType(6f, 45f){{ // speed, dmg
                    knockback = 3.5f;
                    hitEffect = Fx.flakExplosion;
                    width = 7f;
                    height = 8f;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("95db00");
                    trailColor = Color.valueOf("95db00");
                    lifetime = 60f;
                    status = StatusEffects.corroded;
                }};
            }});
            weapons.add(new Weapon("moredefences-artilleryman-weapon"){{
                top = true;
                rotate = true;
                mirror = true;
                x = 18f;
                y = -5f;
                reload = 25f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.missile;
                inaccuracy = 3f;

                bullet = new MissileBulletType(2.5f, 99f){{ // speed, dmg
                    knockback = 3.5f;
                    hitEffect = Fx.flakExplosion;
                    width = 7f;
                    height = 8f;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("95db00");
                    trailColor = Color.valueOf("95db00");
                    lifetime = 60f;
                    status = StatusEffects.corroded;
                }};
            }});
        }};
        
        // swarmer unit line
        swarmer = new UnitType("swarmer-ship"){{
            health = 200f;
            armor = 5f;
            speed = 2f;
            flying = true;
            itemCapacity = 0;
            range = 45f;
            drag = 0.01f;
            accel = 0.075f;
            engineOffset = 6f;
            rotateSpeed = 5f;
            createWreck = false;
            circleTarget = true;
            constructor = UnitEntity::create;
            targetFlags = new BlockFlag[]{BlockFlag.turret, BlockFlag.battery, null};

            weapons.add(new Weapon(){{
                reload = 35f;
                ejectEffect = Fx.none;
                shootSound = Sounds.explosion;

                bullet = new BombBulletType(1f, 0f){{ // speed, dmg
                    sprite = "clear";
                    width = 0f;
                    height = 0f;
                    hitEffect = Fx.pulverize;
                    shootEffect = Fx.none;
                    lifetime = 10f;
                    status = StatusEffects.burning;
                    splashDamageRadius = 50;
                    splashDamage = 60;
                    instantDisappear = true;
                    killShooter = true;
                    hittable = false;
                    collidesAir = true;
                    makeFire = true;
                }};
            }});
        }};
        bee = new UnitType("bee-ship"){{
            health = 550f;
            armor = 2f;
            speed = 2.3f;
            flying = true;
            itemCapacity = 10;
            range = 120f;
            drag = 0.01f;
            accel = 0.07f;
            engineOffset = 7.5f;
            rotateSpeed = 3f;
            circleTarget = true;
            faceTarget = false;
            physics = false; // makes bee unable to collide with other units, making it not glue itself to its target if said target is an air unit
            constructor = UnitEntity::create;
            targetFlags = new BlockFlag[]{BlockFlag.turret, BlockFlag.battery, null};

            weapons.add(new Weapon("moredefences-artillery-mount-2"){{
                top = true;
                rotate = true;
                mirror = true;
                x = 3f;
                y = 0f;
                reload = 2f;
                alternate = true;
                inaccuracy = 6f;

                bullet = new BasicBulletType(6f, 6f){{ // speed, dmg
                    lifetime = 20f;
                    pierceCap = 2;
                    pierceBuilding = true;
                    buildingDamageMultiplier = 0.666f;
                }};
            }});
        }};
        hornet = new UnitType("hornet-ship"){{
            health = 1000f;
            armor = 7f;
            speed = 2f;
            flying = true;
            itemCapacity = 25;
            range = 240f;
            drag = 0.01f;
            accel = 0.2f;
            hitSize = 20f;
            engineOffset = 13.5f;
            lowAltitude = true;
            rotateSpeed = 2f;
            targetAir = false;
            constructor = UnitEntity::create;
            targetFlags = new BlockFlag[]{BlockFlag.turret, BlockFlag.battery, null};

            weapons.add(new Weapon("moredefences-hornet-cannon"){{
                top = true;
                rotate = true;
                mirror = false;
                x = 0f;
                y = -3f;
                reload = 120f;
                ejectEffect = Fx.casing3Double;
                inaccuracy = 2f;
                shake = 1f;
                shootSound = Sounds.artillery;

                bullet = new ArtilleryBulletType(3f, 0f){{ // speed, dmg
                    lifetime = 80f;
                    splashDamage = 66f;
                    splashDamageRadius = 33;
                    frontColor = Color.valueOf("bf92f9");
                    backColor = Color.valueOf("6d56bf");
                    width = 22f;
                    height = 20f;
                    keepVelocity = false;
                    hitShake = 1f;
                    fragBullets = 8;
                    fragBullet = new ArtilleryBulletType(6f, 0f){{ // speed, dmg
                        lifetime = 50f;
                        splashDamage = 22f;
                        splashDamageRadius = 15;
                        frontColor = Color.valueOf("bf92f9");
                        backColor = Color.valueOf("6d56bf");
                        width = 14f;
                        height = 15f;
                        keepVelocity = false;
                        fragBullets = 3;
                        fragBullet = new MissileBulletType(1f, 4f){{ // speed, dmg
                            splashDamage = 13f;
                            splashDamageRadius = 10;
                            frontColor = Color.valueOf("bf92f9");
                            backColor = Color.valueOf("6d56bf");
                            trailColor = Color.valueOf("352378");
                            keepVelocity = false;
                        }};
                    }};
                }};
            }});
        }};
        messenger = new UnitType("messenger-ship"){{
            health = 8500f;
            armor = 7f;
            speed = 1f;
            hitSize = 55;
            flying = true;
            itemCapacity = 60;
            range = 250f;
            drag = 0.017f;
            accel = 0.04f;
            engineOffset = 0f;
            lowAltitude = true;
            rotateSpeed = 2f;
            constructor = UnitEntity::create;
            targetFlags = new BlockFlag[]{BlockFlag.turret, BlockFlag.battery, null};

            weapons.add(new Weapon("moredefences-messenger-minigun"){{
                top = true;
                rotate = true;
                mirror = false;
                rotateSpeed = 4f;
                x = 0f;
                y = -7f;
                reload = 1f;
                inaccuracy = 6f;
                recoil = 2f;

                bullet = new BasicBulletType(7.5f, 6f){{ // speed, dmg
                    lifetime = 20f;
                    pierceCap = 2;
                    pierceBuilding = true;
                    keepVelocity = false;
                    status = StatusEffects.burning;
                    statusDuration = 200;
                    width = 9f;
                    height = 12f;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("ffaa00");
                }};
            }});
            weapons.add(new Weapon("moredefences-messenger-cannon"){{
                top = true;
                x = 16f;
                y = -1f;
                reload = 75f;
                inaccuracy = 1f;
                alternate = true;
                shootSound = Sounds.artillery;
                shake = 5f;

                bullet = new ArtilleryBulletType(7f, 0f){{ // speed, dmg
                    lifetime = 60f;
                    keepVelocity = false;
                    width = 19f;
                    height = 17f;
                    splashDamage = 102;
                    splashDamageRadius = 27;
                    frontColor = Color.valueOf("bf92f9");
                    backColor = Color.valueOf("6d56bf");
                    hitShake = 4f;
                    fragBullets = 24;
                    fragBullet = new ArtilleryBulletType(2f, 0f){{ // speed, dmg
                        lifetime = 30f;
                        keepVelocity = false;
                        width = 12f;
                        height = 13f;
                        splashDamage = 16;
                        splashDamageRadius = 16;
                        frontColor = Color.valueOf("bf92f9");
                        backColor = Color.valueOf("6d56bf");
                        hitShake = 2f;
                    }};
                }};
            }});
        }};
        communicator = new UnitType("communicator-ship"){{
            health = 24000f;
            armor = 9f;
            speed = 0.5f;
            flying = true;
            itemCapacity = 110;
            hitSize = 100f;
            range = 560f;
            drag = 0.005f;
            accel = 0.02f;
            engineOffset = 7f;
            rotateSpeed = 1f;
            faceTarget = false;
            lowAltitude = true;
            constructor = UnitEntity::create;
            targetFlags = new BlockFlag[]{BlockFlag.turret, BlockFlag.battery, null};

            abilities.add(new UnitSpawnAbility(hornet, (float)60*65, 0f, 26f));
            abilities.add(new UnitSpawnAbility(bee, (float)60*25, 13f, -16f));
            abilities.add(new UnitSpawnAbility(bee, (float)60*25, -13f, -16f));
            
            weapons.add(new Weapon("moredefences-transmitter"){{
                top = true;
                rotate = true;
                mirror = false;
                rotateSpeed = 6f;
                x = 0f;
                y = 8f;
                reload = 9f;
                inaccuracy = 2f;
                recoil = 1.5f;
                xRand = 10f;
                shoot.shots = 4;
                shoot.shotDelay = 2f;
                shootSound = Sounds.shootBig;

                bullet = new BasicBulletType(8.5f, 18f){{ // speed, dmg
                    lifetime = 60f;
                    pierceCap = 4;
                    pierceBuilding = true;
                    keepVelocity = false;
                    status = StatusEffects.burning;
                    statusDuration = 400;
                    width = 10f;
                    height = 20f;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("ffaa00");
                    makeFire = true;
                }};
            }});
            weapons.add(new Weapon("moredefences-gatling-gun"){{
                top = true;
                rotate = true;
                rotateSpeed = 6f;
                x = 24f;
                y = 15f;
                reload = 30f;
                alternate = true;
                inaccuracy = 1f;
                shootSound = Sounds.missile;
                shoot.shots = 3;
                shoot.shotDelay = 5f;

                bullet = new MissileBulletType(6.5f, 25f){{ // speed, dmg
                    lifetime = 60f;
                    width = 7f;
                    height = 8f;
                    splashDamage = 44f;
                    splashDamageRadius = 12f;
                    frontColor = Color.valueOf("bf92f9");
                    backColor = Color.valueOf("6d56bf");
                }};
            }});
            weapons.add(new Weapon("moredefences-gatling-gun"){{
                top = true;
                rotate = true;
                rotateSpeed = 6f;
                x = 38f;
                y = -4f;
                reload = 35f;
                alternate = true;
                inaccuracy = 1f;
                shootSound = Sounds.missile;
                shoot.shots = 3;
                shoot.shotDelay = 7f;

                bullet = new MissileBulletType(7.25f, 30f){{ // speed, dmg
                    lifetime = 60f;
                    width = 7f;
                    height = 8f;
                    splashDamage = 50f;
                    splashDamageRadius = 18f;
                    frontColor = Color.valueOf("bf92f9");
                    backColor = Color.valueOf("6d56bf");
                }};
            }});
        }};
        
        // bombardier unit line
        bombardier = new UnitType("bombardier-ship"){{
            health = 135f;
            speed = 2f;
            flying = true;
            itemCapacity = 20;
            range = 140f;
            drag = 0.01f;
            accel = 0.08f;
            faceTarget = false;
            circleTarget = true;
            targetAir = false;
            constructor = UnitEntity::create;
            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.turret, null};

            weapons.add(new Weapon(){{
                reload = 24f;
                ejectEffect = Fx.none;
                shootSound = Sounds.none;
                x = 2f;
                y = 0f;
                shootY = 0f;
                shoot.shots = 3;
                shoot.shotDelay = 2f;
                velocityRnd = 1f;
                minShootVelocity = 0.75f;
                shootCone = 180f;
                inaccuracy = 15f;

                bullet = new BombBulletType(0.7f, 0f){{ // speed, dmg
                    width = 5f;
                    height = 7f;
                    hitEffect = Fx.flakExplosion;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    status = StatusEffects.blasted;
                    splashDamage = 9;
                    splashDamageRadius = 30;
                    rangeOverride = 140;
                }};
            }});
        }};
        pelter = new UnitType("pelter-ship"){{
            health = 435f;
            speed = 1.7f;
            flying = true;
            itemCapacity = 30;
            range = 140f;
            hitSize = 14f;
            drag = 0.02f;
            accel = 0.08f;
            engineOffset = 9f;
            engineSize = 4f;
            circleTarget = true;
            // physics = false;
            constructor = UnitEntity::create;
            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.turret, null};

            weapons.add(new Weapon(){{
                reload = 24f;
                ejectEffect = Fx.none;
                shootSound = Sounds.none;
                x = 2f;
                y = 0f;
                shootY = 0f;
                velocityRnd = 1f;
                minShootVelocity = 0.75f;
                shootCone = 180f;
                inaccuracy = 15f;

                bullet = new BombBulletType(0.7f, 0f){{ // speed, dmg
                    width = 9f;
                    height = 12f;
                    hitEffect = Fx.flakExplosion;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    status = StatusEffects.blasted;
                    splashDamage = 40;
                    splashDamageRadius = 45;
                    rangeOverride = 140;
                    fragBullets = 8;
                    fragBullet = new LiquidBulletType(Liquids.oil){{ // liquid
                        damage = 4f;
                        status = StatusEffects.tarred;
                        lifetime = 480f;
                        pierce = true;
                        pierceBuilding = true;
                        drag = 0.075f;
                    }};
                }};
            }});
            weapons.add(new Weapon("moredefences-pelter-gun"){{
                top = true;
                mirror = true;
                x = 2.8f;
                y = 7f;
                reload = 6f;
                alternate = true;
                inaccuracy = 2f;

                bullet = new BasicBulletType(6f, 6f){{ // speed, dmg
                    lifetime = 20f;
                    pierceArmor = true;
                    collidesTiles = false;
                }};
            }});
        }};
        showerer = new UnitType("showerer-ship"){{
            health = 800f;
            speed = 1.4f;
            flying = true;
            itemCapacity = 50;
            range = 140f;
            hitSize = 14f;
            drag = 0.03f;
            accel = 0.08f;
            engineOffset = 10f;
            engineSize = 3.25f;
            circleTarget = true;
            targetAir = false;
            faceTarget = false;
            constructor = UnitEntity::create;
            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.turret, null};

            weapons.add(new Weapon(){{
                reload = 30f;
                ejectEffect = Fx.none;
                shootSound = Sounds.none;
                x = 0f;
                y = 0f;
                mirror = false;
                shootY = 0f;
                velocityRnd = 1f;
                minShootVelocity = 0.75f;
                shootCone = 180f;
                inaccuracy = 15f;

                bullet = new BombBulletType(0.7f, 0f){{ // speed, dmg
                    width = 12f;
                    height = 16f;
                    hitEffect = Fx.flakExplosion;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    status = StatusEffects.blasted;
                    splashDamage = 50;
                    splashDamageRadius = 60;
                    rangeOverride = 140;
                    fragBullets = 17;
                    fragLifeMin = 0.5f;
                    fragLifeMax = 2f;
                    fragBullet = new BombBulletType(12f, 0f){{ // speed, dmg
                        width = 5f;
                        height = 7f;
                        hitEffect = Fx.flakExplosion;
                        shootEffect = Fx.none;
                        smokeEffect = Fx.none;
                        splashDamage = 9f;
                        splashDamageRadius = 30f;
                        status = StatusEffects.blasted;
                    }};
                }};
            }});
        }};
        avalanche = new UnitType("avalanche-ship"){{
            health = 4000f;
            armor = 5f;
            speed = 1f;
            flying = true;
            itemCapacity = 90;
            range = 288f;
            hitSize = 34f;
            drag = 0.01f;
            accel = 0.1f;
            engineOffset = 11f;
            engineSize = 6f;
            circleTarget = true;
            faceTarget = false;
            constructor = UnitEntity::create;
            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.turret, null};

            weapons.add(new Weapon(){{
                reload = 120f;
                ejectEffect = Fx.none;
                shootSound = Sounds.plasmadrop;
                x = 0f;
                y = 0f;
                mirror = false;
                shootY = 0f;
                velocityRnd = 1f;
                minShootVelocity = 0.25f;
                shootCone = 180f;
                inaccuracy = 15f;

                bullet = new BasicBulletType(4f, 0f){{ // speed, dmg
                    sprite = "moredefences-i-bomb"; // i literally just copy and pasted the code for quad's bomb here and modified it lmao
                    width = height = 30f;

                    rangeOverride = 280f;
                    ignoreRotation = true;

                    backColor = Color.valueOf("#6ecdec");
                    frontColor = Color.valueOf("#ffffff");

                    hitSound = Sounds.plasmaboom;

                    shootCone = 180f;
                    ejectEffect = Fx.none;
                    hitShake = 5f;

                    collidesAir = false;

                    lifetime = 70f;

                    despawnEffect = new Effect(40f, 100f, e -> {
                        color(Color.valueOf("#6ecdec"));
                        stroke(e.fout() * 2f);
                        float circleRad = 4f + e.finpow() * 96f;
                        Lines.circle(e.x, e.y, circleRad);
                        
                        color(Color.valueOf("#6ecdec"));
                        for(int i = 0; i < 3; i++){
                            Drawf.tri(e.x, e.y, 6f, 70f * e.fout(), (i*120)-90);
                        }
                        for(int i = 0; i < 3; i++){
                            Drawf.tri(e.x, e.y, 6f, 45f * e.fout(), (i*120)+90);
                        }
                        
                        color();
                        for(int i = 0; i < 3; i++){
                            Drawf.tri(e.x, e.y, 6f, 25f * e.fout(), (i*120)-90);
                        }
                        for(int i = 0; i < 3; i++){
                            Drawf.tri(e.x, e.y, 6f, 12.5f * e.fout(), (i*120)+90);
                        }
                        
                        Drawf.light(e.x, e.y, circleRad * 1.6f, Color.valueOf("#6ecdec"), e.fout());
                    });
                    hitEffect = Fx.massiveExplosion;
                    keepVelocity = false;
                    spin = 4f;
                    drag = 4f;

                    shrinkX = shrinkY = 0.7f;

                    collides = false;

                    splashDamage = 175f;
                    splashDamageRadius = 100f;
                    status = StatusEffects.freezing;
                    statusDuration = 360f;
                    
                    fragBullets = 2;
                    fragBullet = new ArtilleryBulletType(2f, 0f){{ // speed, dmg
                        sprite = "moredefences-d-bomb";
                        width = 10f;
                        height = 10f;
                        frontColor = Color.valueOf("#ffffff");
                        backColor = Color.valueOf("#6ecdec");
                        spin = 6f;
                        status = StatusEffects.freezing;
                        keepVelocity = false;
                        hitShake = 2f;
                        collides = false;
                        hitEffect = Fx.flakExplosion;
                        despawnEffect = Fx.shockwave;
                        splashDamage = 75f;
                        splashDamageRadius = 24f;
                    }};
                }};
            }});
            weapons.add(new Weapon("moredefences-avalanche-weapon"){{
                top = true;
                mirror = true;
                rotate = true;
                x = 5f;
                y = 5f;
                reload = 10f;
                alternate = true;
                inaccuracy = 2f;

                bullet = new BasicBulletType(8f, 15f){{ // speed, dmg
                    width = 7f;
                    height = 9f;
                    frontColor = Color.valueOf("#6ecdec");
                    backColor = Color.valueOf("#5091a6");
                    lifetime = 32f;
                    status = StatusEffects.freezing;
                    keepVelocity = false;
                    buildingDamageMultiplier = 0.35f;
                }};
            }});
            weapons.add(new Weapon("moredefences-avalanche-weapon"){{
                top = true;
                mirror = true;
                rotate = true;
                x = 5f;
                y = -5f;
                reload = 33f;
                alternate = true;
                inaccuracy = 2f;

                bullet = new BasicBulletType(10f, 20f){{ // speed, dmg
                    width = 7f;
                    height = 9f;
                    frontColor = Color.valueOf("#6ecdec");
                    backColor = Color.valueOf("#5091a6");
                    lifetime = 30f;
                    status = StatusEffects.freezing;
                    keepVelocity = false;
                    buildingDamageMultiplier = 0.35f;
                }};
            }});
        }};
        tundra = new UnitType("tundra-ship"){{
            health = 20000f;
            armor = 10f;
            speed = 0.75f;
            flying = true;
            itemCapacity = 230;
            range = 600f;
            hitSize = 80f;
            drag = 0.01f;
            accel = 0.1f;
            rotateSpeed = 0.75f;
            engineOffset = 11f;
            engineSize = 6.5f;
            circleTarget = true;
            faceTarget = false;
            constructor = UnitEntity::create;
            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.turret, null};

            weapons.add(new Weapon(){{
                reload = 120f;
                ejectEffect = Fx.none;
                shootSound = Sounds.plasmadrop;
                x = 0f;
                y = 0f;
                mirror = false;
                shootY = 0f;
                velocityRnd = 1f;
                minShootVelocity = 0.25f;
                shootCone = 180f;
                inaccuracy = 15f;

                bullet = new FreezeBulletType(4f, 0f){{ // speed, dmg
                    sprite = "moredefences-plus-bomb"; // i literally just copy and pasted the code for quad's bomb here and modified it lmao
                    width = height = 30f;

                    rangeOverride = 150f;
                    ignoreRotation = true;

                    backColor = Color.valueOf("#6ecdec");
                    frontColor = Color.valueOf("#ffffff");

                    hitSound = Sounds.plasmaboom;

                    shootCone = 180f;
                    ejectEffect = Fx.none;
                    hitShake = 9f;

                    collidesAir = false;

                    lifetime = 140f;
                    hittable = false;

                    despawnEffect = MultiEffect(
                        new Effect(40f, 100f, e -> {
                            color(Color.valueOf("#6ecdec"));
                            stroke(e.fout() * 2f);
                            float circleRad = 4f + e.finpow() * 146f;
                            Lines.circle(e.x, e.y, circleRad);
                            
                            color(Color.valueOf("#6ecdec"));
                            for(int i = 0; i < 5; i++){
                                Drawf.tri(e.x, e.y, 6f, 70f * e.fout(), (i*72)-90);
                            }
                            for(int i = 0; i < 5; i++){
                                Drawf.tri(e.x, e.y, 6f, 45f * e.fout(), (i*72)+90);
                            }
                            
                            color();
                            for(int i = 0; i < 5; i++){
                                Drawf.tri(e.x, e.y, 6f, 25f * e.fout(), (i*72)-90);
                            }
                            for(int i = 0; i < 5; i++){
                                Drawf.tri(e.x, e.y, 6f, 12.5f * e.fout(), (i*72)+90);
                            }
                            
                            Drawf.light(e.x, e.y, circleRad * 1.6f, Color.valueOf("#6ecdec"), e.fout());
                        }),
                        new Effect(500f, 30f, e -> {
                            randLenVectors(e.id, 30, (Math.min(Interp.pow3Out.apply(e.fin()*3f), 1f)) * 180, (x, y) -> {
                                Draw.color(Color.valueOf("#ffffff"));
                                Draw.alpha(0.6f);
                                Fill.circle(e.x + x, e.y + y, e.fout() * 28);
                            });
                        })
                    );
                    hitEffect = Fx.massiveExplosion;
                    keepVelocity = false;
                    spin = 2f;
                    drag = 4f;

                    shrinkX = shrinkY = 0.45f;

                    collides = false;

                    splashDamage = 400f;
                    splashDamageRadius = 150f;
                    status = StatusEffects.freezing;
                    statusDuration = 720f;
                    
                    fragBullets = 10;
                    fragBullet = new ArtilleryBulletType(2f, 0f){{ // speed, dmg
                        sprite = "moredefences-d-bomb";
                        width = 10f;
                        height = 10f;
                        frontColor = Color.valueOf("#ffffff");
                        backColor = Color.valueOf("#6ecdec");
                        spin = 6f;
                        status = StatusEffects.freezing;
                        keepVelocity = false;
                        hitShake = 2f;
                        collides = false;
                        hitEffect = Fx.flakExplosion;
                        despawnEffect = Fx.shockwave;
                        splashDamage = 45f;
                        splashDamageRadius = 24f;
                    }};
                }};
            }});
            weapons.add(new Weapon("moredefences-railgun-cannon"){{
                top = true;
                mirror = false;
                rotate = true;
                x = 0f;
                y = 2f;
                reload = 100f;
                alternate = true;
                inaccuracy = 0f;
                shootSound = Sounds.bigshot;

                bullet = new BasicBulletType(15f, 400f){{ // speed, dmg
                    width = 8f;
                    height = 20f;
                    hitSound = Sounds.explosionbig;
                    frontColor = Color.valueOf("#ffffff");
                    backColor = Color.valueOf("#00aaff");
                    lifetime = 35f;
                    status = StatusEffects.disarmed;
                    statusDuration = 60f;
                    splashDamage = 350f;
                    splashDamageRadius = 8f;
                }};
            }});
        }};
    }
}
