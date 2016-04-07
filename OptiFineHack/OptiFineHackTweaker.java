package org.multimc.hacks;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OptiFineHackTweaker implements ITweaker
{
    private List<String> args;

    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile)
    {
        this.args = new ArrayList(args);
        this.args.add("--gameDir");
        this.args.add(gameDir.getAbsolutePath());
        this.args.add("--assetsDir");
        this.args.add(assetsDir.getAbsolutePath());
        this.args.add("--version");
        this.args.add(profile);
    }

    public void injectIntoClassLoader(LaunchClassLoader classLoader)
    {
        classLoader.registerTransformer("optifine.OptiFineClassTransformer");
    }

    public String getLaunchTarget()
    {
        return "net.minecraft.client.main.Main";
    }

    public String[] getLaunchArguments()
    {
        return args.toArray(new String[this.args.size()]);
    }
}
