package moredefences.content.vfx;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.game.Team;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.Block;

import java.util.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.angle;
import static arc.math.Angles.randLenVectors;
import static mindustry.Vars.renderer;
import static mindustry.Vars.tilesize;

public class MDFx { // "borrowed" from betamindy
    private static final int[] vgld = {0}; //VERY_GOOD_LANGUAGE_DESIGN
    static final Vec2[] vecs = new Vec2[]{new Vec2(), new Vec2(), new Vec2(), new Vec2()};
    private static final Rand rand = new Rand();

    public static final Effect
    tundraBomb1 = new Effect(40f, 100f, e -> {
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
    tundraBomb2 = new Effect(500f, 30f, e -> {
        randLenVectors(e.id, 30, (Math.min(Interp.pow3Out.apply(e.fin()*3f), 1f)) * 180, (x, y) -> {
            Draw.color(Color.valueOf("#ffffff"));
            Draw.alpha(0.6f);
            Fill.circle(e.x + x, e.y + y, e.fout() * 28);
        });
    });
}
