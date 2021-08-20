package bangui.me.duke.Me;

import bangui.me.duke.Me.commands.BanGUICommand;
import bangui.me.duke.Me.commands.HelpCommand;
import bangui.me.duke.Me.listeners.BanInvListener;
import org.bukkit.ChatColor;
import bangui.me.duke.Me.commands.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Duke extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println(ChatColor.RED + "BAN EM LOADED!");
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ChatColor.RED + "BAN EM: Loading GUI");
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ChatColor.RED + "BAN EM: Loading mats");
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ChatColor.RED + "BAN EM: Loading Commands");
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ChatColor.RED + "BAN EM: Optimised!");
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ChatColor.RED + "Ban EM: Bstats Loaded!");
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ChatColor.BLUE + "BAN EM: All working! - VER.0.7");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        int pluginId = 12511;
        Metrics metrics = new Metrics(this, pluginId);

        getCommand("banem").setExecutor(new BanGUICommand(this));

        getCommand("BanemReload").setExecutor(new ReloadCommand(this));

        getCommand("BanemHelp").setExecutor(new HelpCommand(this));

        getServer().getPluginManager().registerEvents(new BanInvListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
