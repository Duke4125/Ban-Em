package bangui.me.main.Me.commands;

import bangui.me.main.Me.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class HelpCommand implements CommandExecutor {
    Main plugin;
    public HelpCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ban-em.open")) {

                p.sendMessage(ChatColor.WHITE + "------------------------------------------------------------------------");
                p.sendMessage(ChatColor.RED + "Ban-EM Help!");
                p.sendMessage(ChatColor.WHITE + " ");
                p.sendMessage(ChatColor.DARK_RED + "Commands:");
                p.sendMessage(ChatColor.RED + "/banem - opens the banem menu!");
                p.sendMessage(ChatColor.RED + "/banemreload - reloads the plugin");
                p.sendMessage(ChatColor.WHITE + " ");
                p.sendMessage(ChatColor.DARK_RED + "How to get support:");
                p.sendMessage(ChatColor.RED + "Join the support discord - https://discord.gg/tr8Wku6NrE%22");
                        p.sendMessage(ChatColor.WHITE + " ");
                p.sendMessage(ChatColor.RED + "Plugin made by Dukx AKA Duke have questions? Dm Dukx#6969 on discord!");
                p.sendMessage(ChatColor.WHITE + "------------------------------------------------------------------------");

            }else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("Noperm"))));
            }
        }
        return true;
    }
}