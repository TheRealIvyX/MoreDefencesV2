package moredefences.content.units;

import arc.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.struct.ObjectMap.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
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
    cannoneer, artilleryman, ordnance, mortar, howitzer;

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
        ((Reconstructor) Blocks.additiveReconstructor).upgrades.addAll(new UnitType[]{cannoneer, artilleryman});
    }
}
