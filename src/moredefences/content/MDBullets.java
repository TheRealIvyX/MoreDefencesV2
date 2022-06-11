package moredefences.content.bullets;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.gen.*;
import mindustry.graphics.*;

public class MDBullets{
    public static BulletType

    // turret projectiles
    multishotLead, multishotCoal, multishotSili, beehiveLead, bubblerWater, bubblerSlag, bubblerOil, bubblerCryo, carbineTin, carbineAluminum,
    clusterPyra, clusterBlast, clusterPlast, clusterSurge, coilgunNickel, firenadoSlag, hellfirePyra, hellfireSpore,
    instantLead, instantSili, instantTitanium, minelayerMine;

    public static void load(){
        multishotLead = new BasicBulletType(3f, 7f){{ // speed, dmg
            ammoMultiplier = 1f;
            //frontColor = Color.valueOf("EAC2A9");
            //backColor = Color.valueOf("B8705C");
        }};
        multishotCoal = new BasicBulletType(3f, 6f){{ // speed, dmg
            ammoMultiplier = 1f;
            status = StatusEffects.burning;
        }};
        multishotSili = new BasicBulletType(2f, 8f){{ // speed, dmg
            ammoMultiplier = 2f;
            homingPower = 1f;
            lifetime = 70f;
        }};
        
        beehiveLead = new BasicBulletType(4.5f, 8f){{ // speed, dmg
            ammoMultiplier = 2f;
            homingPower = 1f;
            pierce = true;
            lifetime = 120f;
            homingPower = 0.075f;
            homingRange = 80f;
            frontColor = Color.valueOf("ffff00");
            backColor = Color.valueOf("000000");
            width = 3f;
            height = 4f;
            collidesAir = false;
            sprite = "moredefences-striped-bullet";
        }};
        
        bubblerWater = new LiquidBulletType(Liquids.water){{ // liquid
            damage = 0.5f;
            status = StatusEffects.wet;
            lifetime = 420f;
            pierce = true;
            drag = 0.025f;
        }};
        bubblerSlag = new LiquidBulletType(Liquids.slag){{ // liquid
            damage = 1.6f;
            status = StatusEffects.melting;
            lifetime = 180f;
            pierce = true;
            drag = 0.025f;
        }};
        bubblerOil = new LiquidBulletType(Liquids.oil){{ // liquid
            damage = 1.2f;
            status = StatusEffects.tarred;
            lifetime = 240f;
            pierce = true;
            drag = 0.025f;
        }};
        bubblerCryo = new LiquidBulletType(Liquids.cryofluid){{ // liquid
            damage = 0.25f;
            status = StatusEffects.freezing;
            lifetime = 240f;
            pierce = true;
            drag = 0.025f;
        }};
        
        carbineTin = new LaserBoltBulletType(6f, 30f){{ // speed, dmg
            ammoMultiplier = 2f;
            lifetime = 30f;
            reloadMultiplier = 2.15f;
            width = 3f;
            height = 13f;
            frontColor = Color.valueOf("ffffff");
            backColor = Color.valueOf("333333");
        }};
        carbineAluminum = new LaserBoltBulletType(9f, 60f){{ // speed, dmg
            ammoMultiplier = 5f;
            lifetime = 20f;
            width = 5f;
            height = 14f;
            frontColor = Color.valueOf("ffffff");
            backColor = Color.valueOf("69deca");
        }};
        
        clusterPyra = new ArtilleryBulletType(5f, 0f){{ // speed, dmg
            ammoMultiplier = 2f;
            hitEffect = Fx.blastExplosion;
            knockback = 0.8f;
            lifetime = 120f;
            width = 13f;
            height = 13f;
            collidesTiles = false;
            splashDamageRadius = 25f;
            splashDamage = 35f;
            status = StatusEffects.burning;
            frontColor = Color.valueOf("e89c46");
            backColor = Color.valueOf("ff8700");
            trailEffect = Fx.incendTrail;
        }};
        clusterBlast = new ArtilleryBulletType(5f, 0f){{ // speed, dmg
            ammoMultiplier = 4f;
            hitEffect = Fx.blastExplosion;
            knockback = 0.8f;
            lifetime = 110f;
            width = 14f;
            height = 14f;
            collidesTiles = false;
            splashDamageRadius = 45f;
            splashDamage = 45f;
            status = StatusEffects.blasted;
            frontColor = Color.valueOf("e85e46");
            backColor = Color.valueOf("ffdfd1");
        }};
        clusterPlast = new ArtilleryBulletType(5f, 0f){{ // speed, dmg
            ammoMultiplier = 2f;
            hitEffect = Fx.plasticExplosion;
            knockback = 1f;
            lifetime = 120f;
            width = 13f;
            height = 13f;
            collidesTiles = false;
            splashDamageRadius = 35f;
            splashDamage = 40f;
            frontColor = Color.valueOf("ffffff");
            backColor = Color.valueOf("8cff00");
            fragBullet = new BasicBulletType(2.5f, 10, "bullet"){{ // fun fact: this is literally just artilleryPlasticFrag from before it got banished in b136
                width = 10f;
                height = 12f;
                shrinkY = 1f;
                lifetime = 15f;
                backColor = Pal.plastaniumBack;
                frontColor = Pal.plastaniumFront;
                despawnEffect = Fx.none;
                collidesAir = false;
            }};
            fragBullets = 12;
        }};
        clusterSurge = new ArtilleryBulletType(6f, 0f){{ // speed, dmg
            ammoMultiplier = 2f;
            hitEffect = Fx.blastExplosion;
            knockback = 1f;
            lifetime = 100f;
            width = 15f;
            height = 15f;
            collidesTiles = false;
            splashDamageRadius = 45f;
            splashDamage = 55f;
            status = StatusEffects.shocked;
            frontColor = Color.valueOf("FFF484");
            backColor = Color.valueOf("F3E979");
            lightning = 2;
            lightningLength = 7;
        }};
        
        coilgunNickel = new BasicBulletType(15f, 450f){{ // speed, dmg
            ammoMultiplier = 1f; 
            splashDamage = 350f;
            splashDamageRadius = 16f;
            frontColor = Color.valueOf("ffffff");
            backColor = Color.valueOf("d1f1ff");
            collidesAir = false;
            width = 2;
            height = 15;
            hitSound = Sounds.explosionbig;
            hitShake = 2f;
        }};
        
        firenadoSlag = new LiquidBulletType(Liquids.slag){{ // liquid
            damage = 20f;
            status = StatusEffects.melting;
            pierce = true;
            pierceCap = 4;
            knockback = 2f;
            ammoMultiplier = 0.06666666667f;
            statusDuration = 360f;
            puddleSize = 3f;
            speed = 7f;
        }};
        
        hellfirePyra = new MissileBulletType(7.5f, 1200f){{ // speed, dmg
            ammoMultiplier = 1f; 
            splashDamage = 900f;
            splashDamageRadius = 32f;
            frontColor = Color.valueOf("ff9c63");
            backColor = Color.valueOf("b3683d");
            collidesAir = false;
            width = 15;
            height = 15;
            hitSound = Sounds.explosionbig;
            homingPower = 0.1f;
            hitShake = 6f;
            status = StatusEffects.burning;
            fragBullets = 20;
            fragBullet = new BasicBulletType(12f, 2, "bullet"){{
                status = StatusEffects.burning;
            }};
        }};
        hellfireSpore = new MissileBulletType(7.5f, 650f){{ // speed, dmg
            ammoMultiplier = 1f; 
            splashDamage = 550f;
            splashDamageRadius = 32f;
            frontColor = Color.valueOf("9854ff");
            backColor = Color.valueOf("5827a3");
            collidesAir = false;
            width = 15;
            height = 15;
            hitSound = Sounds.explosionbig;
            homingPower = 0.1f;
            hitShake = 4f;
            status = StatusEffects.burning;
            fragBullets = 20;
            fragBullet = new BasicBulletType(12f, 2, "bullet"){{
                status = StatusEffects.sporeSlowed;
                statusDuration = 120f;
                homingPower = 0.2f;
            }};
        }};
        
        instantLead = new BasicBulletType(16f, 22f){{ // speed, dmg
            ammoMultiplier = 3f;
            lifetime = 12f;
            collidesGround = false;
        }};
        instantSili = new BasicBulletType(20f, 18f){{ // speed, dmg
            ammoMultiplier = 5f;
            reloadMultiplier = 1.5f;
            lifetime = 9f;
            homingPower = 12f;
            collidesGround = false;
        }};
        instantTitanium = new BasicBulletType(13f, 44f){{ // speed, dmg
            ammoMultiplier = 4f;
            reloadMultiplier = 0.6f;
            lifetime = 15f;
            pierce = true;
            pierceCap = 3;
            collidesGround = false;
        }};
        
        minelayerMine = new BasicBulletType(6f, 25f){{ // speed, dmg
            ammoMultiplier = 4f;
            reloadMultiplier = 0.6f;
            lifetime = 1200f;
            collidesAir = false;
            width = 10f;
            height = 10f;
            shrinkY = 0f;
            shrinkX = 0f;
            splashDamage = 45f;
            splashDamageRadius = 45f; // buff to 60 post-rework
            drag = 0.065f;
            status = StatusEffects.blasted;
            sprite = "moredefences-mine";
        }};
    }
}
