package moredefences.content.audio;

import arc.*;
import arc.assets.*;
import arc.assets.loaders.SoundLoader.*;
import arc.audio.*;
import mindustry.*;

import static mindustry.Vars.*;

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
