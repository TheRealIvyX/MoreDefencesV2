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
    multishotLead, multishotCoal, multishotSili, /*2-3*/ beehiveLead;

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
        }};
        
        // 2-3
        
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
            sprite = "more-defences-ivyx-striped-bullet";
        }};
    }
}
