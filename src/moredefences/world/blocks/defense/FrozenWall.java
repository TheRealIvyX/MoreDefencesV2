package moredefences.world.blocks.defense;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;

import moredefences.content.audio.*;

public class FrozenWall extends Wall{ // special block created by units
    
    public FrozenWall(String name){
        super(name);
        placeOverlapRange = -1f;
        rebuildable = false;
        createRubble = false;
        drawTeamOverlay = false;
        destroySound = Sounds.none;
    }
    public class FrozenWallBuild extends WallBuild{
        @Override
        public float handleDamage(float amount){
            if (health - amount > 0) MDSounds.icehit.at(x, y, Mathf.random(0.9,1.1))
            return amount;
        }
        @Override
        public void afterDestroyed(){
            super.afterDestroyed();
            MDSounds.icebreak.at(x, y, Mathf.random(0.9,1.1))
        }
    }
}
