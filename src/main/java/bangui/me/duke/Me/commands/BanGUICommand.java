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
    BanMenuUtils  banMenu;

    public BanGUICommand(Duke plugin, BanMenuUtils banMenu) {
        this.plugin = plugin;
        this.banMenu = banMenu;
    }

    @Override
    public boolean onCommand (CommandSender sender, Command command, String label, String[]args){
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ban-em.open")) {

                banMenu.openMenu(p);
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Noperm")));
            }
        }
        return true;
    }
}


