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

import static arc.Core.*;
import static mindustry.Vars.*;

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

}
