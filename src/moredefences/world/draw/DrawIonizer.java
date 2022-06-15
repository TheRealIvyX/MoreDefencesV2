package moredefences.world.draw;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.content.Items;
import moredefences.content.items.MDItems; // thanks to Mnemotechnician#9967 for helping making this work
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.draw.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;

public class DrawIonizer extends DrawBlock{
    public TextureRegion graphiteRegion, beamRegion, radiumRegion, leadRegion, radiumPieceRegion;
    @Override
    public void draw(Building build){
        Draw.alpha(build.items.get(Items.graphite) / build.itemCapacity);
        Draw.rect(graphiteRegion, build.x, build.y);
            
        Draw.alpha(0);
        if (build.items.get(Items.graphite) >= 1 && build.items.get(Items.lead) >= 2 && build.power.status == 1f) {Draw.alpha(1);};
        Draw.rect(beamRegion, build.x, build.y);
          
        Draw.alpha(build.items.get(MDItems.radium) / build.itemCapacity);
        Draw.rect(radiumRegion, build.x, build.y);
            
        Draw.alpha(build.items.get(Items.lead) / build.itemCapacity);
        Draw.rect(leadRegion, build.x, build.y);
          
        Draw.alpha(build.items.get(MDItems.radium) / build.itemCapacity);
        Draw.rect(radiumPieceRegion, build.x, build.y);
      
        Draw.alpha(1);
    }
    @Override
    public void load(Block block){
        graphiteRegion = Core.atlas.find(block.name + "-graphite");
        beamRegion = Core.atlas.find(block.name + "-beams");
        radiumRegion = Core.atlas.find(block.name + "-radium");
        leadRegion = Core.atlas.find(block.name + "-lead");
        radiumPieceRegion = Core.atlas.find(block.name + "-radium-piece");
    }
}
