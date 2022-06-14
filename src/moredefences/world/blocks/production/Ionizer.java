package moredefences.world.blocks.production;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.content.*;
import moredefences.content.items.MDItems; // thanks to Mnemotechnician#9967 for helping making this work
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

public class Ionizer extends GenericCrafter{
    public TextureRegion bottomRegion, graphiteRegion, beamRegion, radiumRegion, leadRegion, radiumPieceRegion, topRegion;
    public Ionizer(String name){
        super(name);
    }
    public class IonizerBuild extends GenericCrafterBuild{
        @Override
        public void load(Block block){
            super.load();
            
            bottomRegion = Core.atlas.find(name + "-bottom");
            graphiteRegion = Core.atlas.find(name + "-graphite");
            beamRegion = Core.atlas.find(name + "-beams");
            radiumRegion = Core.atlas.find(name + "-radium");
            leadRegion = Core.atlas.find(name + "-lead");
            radiumPieceRegion = Core.atlas.find(name + "-radium-piece");
            topRegion = Core.atlas.find(name);
        }
        
        @Override
        public void draw(){
            Draw.alpha(1);
            Draw.rect(bottomRegion, x, y);
            
            Draw.alpha(items.get(Items.graphite) / itemCapacity);
            Draw.rect(graphiteRegion, x, y);
            
            Draw.alpha(0);
            if (items.get(Items.graphite) >= 1 && items.get(Items.lead) >= 2 && power.status == 1f) Draw.alpha(1);
            Draw.rect(beamRegion, x, y);
          
            Draw.alpha(items.get(MDItems.radium) / itemCapacity);
            Draw.rect(radiumRegion, x, y);
            
            Draw.alpha(items.get(Items.lead) / itemCapacity);
            Draw.rect(bottomRegion, x, y);
          
            Draw.alpha(items.get(MDItems.radium) / itemCapacity);
            Draw.rect(radiumPieceRegion, x, y);
          
            Draw.alpha(1);
            Draw.rect(topRegion, x, y);
        }
    }
}
