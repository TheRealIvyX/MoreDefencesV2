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
    clusterPyra, clusterBlast, clusterPlast, clusterSurge, coilgunZinc;

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
        
        coilgunZinc = new BasicBulletType(15f, 450f){{ // speed, dmg
            ammoMultiplier = 1f; 
            splashDamage = 350f;
            splashDamageRadius = 16f;
            frontColor = Color.valueOf("ffffff");
            backColor = Color.valueOf("d1f1ff");
            collidesAir = false;
            width = 2;
            length = 15;
            hitSound = Sounds.explosionBig;
            hitShake = 2f;
        }};
    }
}
