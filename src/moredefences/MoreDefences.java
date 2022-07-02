package moredefences;

import arc.*;
import arc.func.*;
import arc.graphics.g2d.*;
import arc.scene.ui.*;
import arc.util.*;
import mindustry.game.EventType.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.ui.dialogs.*;
import mindustry.ui.dialogs.SettingsMenuDialog.*;
import mindustry.ui.dialogs.SettingsMenuDialog.SettingsTable.*;
import mindustry.content.*;
import mindustry.world.*;
import mindustry.world.blocks.units.*;
import mindustry.type.*;

import static arc.Core.*;
import static mindustry.Vars.*;
import static mindustry.type.ItemStack.with;

import moredefences.content.items.*;
import moredefences.content.bullets.*;
import moredefences.content.units.*;
import moredefences.content.blocks.*;

public class MoreDefences extends Mod{

    public MoreDefences(){
        Log.info("hello from moredefences.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("moredefences-multishot")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
        // "borrowed" from erekir expansion (EmanuelG-Gaming/erekir-expansion)
        Events.on(ContentInitEvent.class, e -> {
           // add unit lines to factories and reconstructors
           // cannoneer unit line
           addToFabricator(
              Blocks.groundFactory,
              new UnitFactory.UnitPlan(MDUnits.cannoneer, (float) 25 * 60, with(Items.silicon, 30, Items.graphite, 15))
           );
           addToReconstructor(Blocks.additiveReconstructor, MDUnits.cannoneer, MDUnits.artilleryman);
           addToReconstructor(Blocks.multiplicativeReconstructor, MDUnits.artilleryman, MDUnits.ordnance);
           addToReconstructor(Blocks.exponentialReconstructor, MDUnits.ordnance, MDUnits.mortar);
           addToReconstructor(Blocks.tetrativeReconstructor, MDUnits.mortar, MDUnits.howitzer);
           // swarmer unit line
           addToFabricator(
              Blocks.airFactory,
              new UnitFactory.UnitPlan(MDUnits.swarmer, (float) 20 * 60, with(Items.silicon, 20, Items.pyratite, 5, Items.titanium, 5))
           );
           addToReconstructor(Blocks.additiveReconstructor, MDUnits.swarmer, MDUnits.bee);
           addToReconstructor(Blocks.multiplicativeReconstructor, MDUnits.bee, MDUnits.hornet);
           addToReconstructor(Blocks.exponentialReconstructor, MDUnits.hornet, MDUnits.messenger);
           addToReconstructor(Blocks.tetrativeReconstructor, MDUnits.messenger, MDUnits.communicator);
        });
    }
    
    @Override
    public void init(){ // code "borrowed" from progression ministry (good mod btw)
        if(!headless){ // btw can someone please explain to me what the fuck generics are
            LoadedMod md = mods.locateMod("moredefences");
            md.meta.displayName = "[cyan]More[blue]Defences [red]V2[]";
            md.meta.author = "[cyan]" + md.meta.author;
        }
    }

    @Override
    public void loadContent(){
        MDSounds.load();
        //MDStatuses.load();
        //MDLiquids.load();
        MDItems.load();
        MDBullets.load();
        MDUnits.load();
        MDBlocks.load();
        //MDSectors.load();
        //MDPlanets.load();
        //MDTechTree.load();
    }
    // also "borrowed" from erekir expansion
    public void addToFabricator(Block bloc, UnitFactory.UnitPlan plan) {
        if (!(bloc instanceof UnitFactory)) return;
        
        UnitFactory factory = (UnitFactory) bloc;
        factory.plans.add(plan);
        
        factory.configurable = true;
        factory.init();
    }
    
    public void addToReconstructor(Block bloc, UnitType unit, UnitType upgrade) {
        if (!(bloc instanceof Reconstructor)) return;
        
        Reconstructor recon = (Reconstructor) bloc;
        recon.addUpgrade(unit, upgrade);
    }
}
