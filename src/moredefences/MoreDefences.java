package moredefences;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

import moredefences.content.blocks.*;
import moredefences.content.bullets.*;

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
                dialog.cont.image(Core.atlas.find("more-defences-ivyx-multishot")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }
    
    @Override
    public void init(){ // code "borrowed" from progression ministry (good mod btw)
        if(!headless){ // btw can someone please explain to me what the fuck generics are
            LoadedMod md = mods.locateMod("more-defences-ivyx");
            md.meta.displayName = "[cyan]More[blue]Defences [red]V2[]";
            md.meta.author = "[cyan]" + md.meta.author;
        }
    }

    @Override
    public void loadContent(){
        //MDStatuses.load();
        //MDLiquids.load();
        //MDItems.load();
        MDBullets.load();
        //MDUnits.load();
        MDBlocks.load();
        //MDSectors.load();
        //MDPlanets.load();
        //MDTechTree.load();
    }

}
