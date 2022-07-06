package moredefences.entities.bullet;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;

import moredefences.content.blocks.*;

import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class FreezeBulletType extends BasicBulletType {
    public float freezeChance = 0.2f;
    public float freezeRadius = 150f;
    public int maxTargetSize = 2; // range: [1 - 2]
    
    public FreezeBulletType(float speed, float damage){
        this.speed = speed;
        this.damage = damage;
    }
    // TODO: make a radius of 0 only affect blocks that were directly hit by this projectile
    @Override
    public void despawned(Bullet b){
        super.despawned(b);
        if (freezeRadius > 0) {
            Units.nearbyBuildings(b.x, b.y, freezeRadius, cons(other -> {
                if (other.team != b.owner.team) {
                    Rand().setSeed(b.id+other.id+other.x+other.y+b.x+b.y);
                    Tile t = Vars.world.tile(Mathf.round(other.x / 8), Mathf.round(other.y / 8));
                    Block o = t.block();
                    if ((o.size >= 1 && o.size <= Math.min(2, Math.max(1, maxTargetSize))) && Rand().random(0,1) <= freezeChance) {
                        t.setAir();
                        if (o.size == 1) {
                            t.setBlock(MDBlocks.frozenwall, b.owner.team);
                        } else {
                            t.setBlock(MDBlocks.frozenwalllarge, b.owner.team);
                        }
                    }
                }
            }));
        }
    }
}
