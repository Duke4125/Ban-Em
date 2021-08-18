package bangui.me.duke.Me;

import bangui.me.duke.Me.commands.BanGUICommand;
import bangui.me.duke.Me.listeners.BanInvListener;
import org.bukkit.ChatColor;
import bangui.me.duke.Me.commands.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Duke extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println(ChatColor.RED + "BAN EM LOADED!");
        System.out.println(ChatColor.RED + "BAN EM: Loading GUI");
        System.out.println(ChatColor.RED + "BAN EM: Loading mats");
        System.out.println(ChatColor.RED + "BAN EM: Loading Commands");
        System.out.println(ChatColor.RED + "BAN EM: Optimised!");
        System.out.println(ChatColor.BLUE + "BAN EM: All working! - VER.0.3");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("banem").setExecutor(new BanGUICommand(this));

        getCommand("BanemReload").setExecutor(new ReloadCommand(this));

        getServer().getPluginManager().registerEvents(new BanInvListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
