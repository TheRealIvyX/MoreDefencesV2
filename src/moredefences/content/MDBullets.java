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
    multishotLead, multishotCoal, multishotSili;

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
    }
}
