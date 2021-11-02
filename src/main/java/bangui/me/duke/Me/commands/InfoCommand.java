package bangui.me.duke.Me.commands;

import bangui.me.duke.Me.Duke;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {
    Duke plugin;
    public InfoCommand(Duke plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ban-em.open")) {
                
                p.sendMessage(ChatColor.WHITE + "------------------------------------------------------------------------");
                p.sendMessage(ChatColor.RED + "Ban-EM Info!");
                p.sendMessage(ChatColor.WHITE + "VER 1.2");
                p.sendMessage(ChatColor.DARK_RED + "");
                p.sendMessage(ChatColor.WHITE + "------------------------------------------------------------------------");

            }else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Noperm")));
            }
        }
        return true;
    }
}