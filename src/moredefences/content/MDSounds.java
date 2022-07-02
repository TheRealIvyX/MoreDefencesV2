package moredefences.content.audio;

import arc.*;
import arc.assets.*;
import arc.assets.loaders.SoundLoader.*;
import arc.audio.*;
import mindustry.*;

import static mindustry.Vars.*;

// code "borrowed" from progression ministry. i removed the prog mats loadsound function and used the vanilla one but im keeping the credits here anyways just in case
/**
 * @author GlennFolker
 * For how to make this. Just copy over and adjust the code.
 */
public class MDSounds{
    public static Sound

    iceBreak = new Sound(),
    iceHit = new Sound();

    public static void load() {
        if(Vars.headless) return;

        iceBreak = Vars.tree.loadSound("icebreak");
        iceHit = Vars.tree.loadSound("icehit");
    }
}
