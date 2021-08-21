package bangui.me.duke.Me;

import bangui.me.duke.Me.commands.BanGUICommand;
import bangui.me.duke.Me.commands.HelpCommand;
import bangui.me.duke.Me.listeners.BanInvListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import bangui.me.duke.Me.commands.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Logger;

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
        System.out.println(ChatColor.BLUE + "BAN EM: All working! - VER.0.8");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        int pluginId = 12511;
        Metrics metrics = new Metrics(this, pluginId);

        getCommand("banem").setExecutor(new BanGUICommand(this));

        getCommand("BanemReload").setExecutor(new ReloadCommand(this));

        getCommand("BanemHelp").setExecutor(new HelpCommand(this));

        getServer().getPluginManager().registerEvents(new BanInvListener(this), this);

        Logger logger = this.getLogger();

        new UpdateChecker(this, 95286).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("There is not a new update available.");
            } else {
                logger.info(ChatColor.RED + "There is a new update available, Download here https://www.spigotmc.org/resources/ban-em-the-easy-ban-gui-plugin.95286/");
                logger.info(ChatColor.RED + "Why should you update? Keeping the plugin upto date will get you tons of cool features and can fix bugs!");
            }
        });
    }


    public void onDisable() {
        // Plugin shutdown logic
    }
}
