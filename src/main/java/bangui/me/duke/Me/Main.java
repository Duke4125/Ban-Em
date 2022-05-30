
/*

LEGAL!
If you are looking at this code without the permission from - Duke AKA Dukx
Then you are braking the Rules of this resource!
If you edit/change/re-produce this code in any way you are breaking the TOS!

TOS
---

DO NOT decompile this plugin
DO NOT re-upload this plugin
DO NOT attempt to change the plugins code and re-upload!

If you do any of these you are breaking the TOS and this is a legal issue!
 */



package bangui.me.duke.Me;

import bangui.me.duke.Me.commands.BanGUICommand;
import bangui.me.duke.Me.commands.HelpCommand;
import bangui.me.duke.Me.commands.InfoCommand;
import bangui.me.duke.Me.listeners.BanInvListener;
import bangui.me.duke.Me.utils.BanMenuUtils;
import org.bukkit.ChatColor;
import bangui.me.duke.Me.commands.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

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
        System.out.println(ChatColor.BLUE + "BAN EM: All working! - VER.1.2");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        int pluginId = 12511;
        Metrics metrics = new Metrics(this, pluginId);

        BanMenuUtils banMenu = new BanMenuUtils(this);

        Objects.requireNonNull(getCommand("banem")).setExecutor(new BanGUICommand(this, banMenu));

        Objects.requireNonNull(getCommand("BanemReload")).setExecutor(new ReloadCommand(this));

        Objects.requireNonNull(getCommand("BanemHelp")).setExecutor(new HelpCommand(this));

        Objects.requireNonNull(getCommand("Baneminfo")).setExecutor(new InfoCommand(this));

        getServer().getPluginManager().registerEvents(new BanInvListener(this, banMenu), this);




        Logger logger = this.getLogger();

        new UpdateChecker(this, 95286).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info(ChatColor.GREEN + "There is no new update atm! You are upto date :)");
            } else {
                logger.info(ChatColor.RED + "There is a new update available, Download here https://www.spigotmc.org/resources/ban-em-the-easy-ban-gui-plugin.95286/");
                logger.info(ChatColor.RED + "Why should you update? Keeping the plugin upto date will get you tons of cool features and can fix bugs!");
            }
        });
    }


    public void onDisable() {
        System.out.println(ChatColor.RED + "Ban-EM Closing! Come back soon!");
    }
}
