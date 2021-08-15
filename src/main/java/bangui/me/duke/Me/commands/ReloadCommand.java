package bangui.me.duke.Me.commands;


import bangui.me.duke.Me.Duke;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class ReloadCommand implements CommandExecutor {
    Duke plugin;
    public ReloadCommand(Duke plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ban-em.reload")) {

               plugin.reloadConfig();
                p.sendMessage(plugin.getConfig().getString("ReloadMessage"));
            }else {
                p.sendMessage(plugin.getConfig().getString("Noperm"));
            }
        }
        return true;
    }
}

