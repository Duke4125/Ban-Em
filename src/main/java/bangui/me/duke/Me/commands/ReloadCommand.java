package bangui.me.duke.Me.commands;


import bangui.me.duke.Me.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;


public class ReloadCommand implements CommandExecutor {
    Main plugin;
    public ReloadCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ban-em.reload")) {

                plugin.reloadConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("ReloadMessage"))));
            }else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("Noperm"))));
            }
        }
        return true;
    }
}

