package moredefences.content.audio;

import arc.*;
import arc.assets.*;
import arc.assets.loaders.SoundLoader.*;
import arc.audio.*;
import mindustry.*;

import static mindustry.Vars.*;

// code "borrowed" from progression ministry
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
    /*protected static Sound loadSound(String soundName){
        String name = "sounds/" + soundName;
        String path = Vars.tree.get(name + ".ogg").exists() ? name + ".ogg" : name + ".mp3";

        Sound sound = new Sound();

        AssetDescriptor<?> desc = Core.assets.load(path, Sound.class, new SoundParameter(sound));
        desc.errored = Throwable::printStackTrace;

        return sound;
    }*/
}
