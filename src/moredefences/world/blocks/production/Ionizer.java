package moredefences.world.blocks.production;

import arc.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.annotations.Annotations.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;

public class Ionizer extends GenericCrafter{
    public @Load("@-bottom") TextureRegion bottomRegion
    public @Load("@-graphite") TextureRegion graphiteRegion
    public @Load("@-beams") TextureRegion beamRegion
    public @Load("@-radium") TextureRegion radiumRegion
    public @Load("@-lead") TextureRegion leadRegion
    public @Load("@-radium-piece") TextureRegion radiumPieceRegion
    public @Load("@") TextureRegion topRegion
    public Ionizer(String name){
        super(name);
    }
    public class IonizerBuild extends GenericCrafterBuild{
        @Override
        public void draw(){
            
            Draw.alpha(1);
            Draw.rect(bottomRegion, x, y);
            
            Draw.alpha(items.get(Items.graphite) / itemCapacity);
            Draw.rect(graphiteRegion, x, y);
            
            Draw.alpha(0);
            if (items.get(Items.graphite) >= 1 && items.get(Items.lead) >= 2 && power.status == true) Draw.alpha(1);
            Draw.rect(beamRegion, x, y);
          
            Draw.alpha(items.get(MDItems.radium) / itemCapacity);
            Draw.rect(radiumRegion, x, y);
            
            Draw.alpha(items.get(Items.lead) / itemCapacity);
            Draw.rect(bottomRegion, x, y);
          
            Draw.alpha(items.get(MDItems.radium) / itemCapacity);
            Draw.rect(radiumPieceRegion, x, y);
          
            Draw.alpha(1);
            super.draw();
        }
    }
}
