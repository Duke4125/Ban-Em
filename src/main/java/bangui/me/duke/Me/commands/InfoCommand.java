package bangui.me.duke.Me.commands;

import bangui.me.duke.Me.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class InfoCommand implements CommandExecutor {
    Main plugin;
    public InfoCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ban-em.open")) {
                
                p.sendMessage(ChatColor.WHITE + "------------------------------------------------------------------------");
                p.sendMessage(ChatColor.RED + "Ban-EM Info!");
                p.sendMessage(ChatColor.WHITE + "VER 1.3");
                p.sendMessage(ChatColor.DARK_RED + "");
                p.sendMessage(ChatColor.WHITE + "------------------------------------------------------------------------");

            }else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("Noperm"))));
            }
        }
        return true;
    }
}