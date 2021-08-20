package bangui.me.duke.Me.commands;

import bangui.me.duke.Me.Duke;
import bangui.me.duke.Me.utils.BanMenuUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class BanGUICommand implements CommandExecutor {
    Duke plugin;
    public BanGUICommand(Duke plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ban-em.open")) {

                BanMenuUtils.openBanMenu(p);
            }else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Noperm")));
            }
        }
        return true;
    }
}

