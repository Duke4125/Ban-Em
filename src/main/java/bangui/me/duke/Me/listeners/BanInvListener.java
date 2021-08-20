package bangui.me.duke.Me.listeners;

import bangui.me.duke.Me.Duke;
import bangui.me.duke.Me.utils.BanMenuUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerKickEvent;

import java.util.Map;
import java.util.UUID;

public class BanInvListener implements Listener {
    Duke plugin;
    public BanInvListener(Duke plugin) {
        this.plugin= plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {


        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Player List")) {
            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {

                Player whoToBan = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                BanMenuUtils.openConfirmBanMenu(p, whoToBan);
                e.setCancelled(true);


            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Ban EM")) {

            if (e.getCurrentItem().getType() == Material.BARRIER) {
                BanMenuUtils.openBanMenu(p);
                //ban
            } else if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                p.getServer().getBanList(BanList.Type.NAME).addBan(name, "Banned by ban em!", null, null);
                Bukkit.getPlayer(name).kickPlayer(ChatColor.RED + "Ban em" + " " + name + " " + "Has been removed from the server");
                p.sendMessage(ChatColor.GREEN + "Banned" + name + "!");
                System.out.println(ChatColor.WHITE + "[" + ChatColor.RED + "BAN EM" + ChatColor.WHITE + "]" + " " + ChatColor.RED + "Just banned" + " " + name + "!");
                //warn
            } else if (e.getCurrentItem().getType() == Material.PAPER) {
                 int warn = 0;
                 int addwarn = 1;
                 int add = warn + addwarn;
                 String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                 p.sendMessage(ChatColor.GREEN + "Warned" + name + "!" + " " + "They now have " + add);
                 System.out.println(ChatColor.WHITE + "[" + ChatColor.RED + "BAN EM" + ChatColor.WHITE + "]" + " " + ChatColor.RED + "Just warned" + " " + name + "!" + " " + "They now have" + add);
                 e.setCancelled(true);
                    //kick
            } else if (e.getCurrentItem().getType() == Material.IRON_SWORD) {
                    String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                    Bukkit.getPlayer(name).kickPlayer(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("KickReason")));
                    p.sendMessage(ChatColor.GREEN + "kicked" + name + "!");
                    System.out.println(ChatColor.WHITE + "[" + ChatColor.RED + "BAN EM" + ChatColor.WHITE + "]" + " " + ChatColor.RED + "Just kicked" + " " + name + "!");
                    e.setCancelled(true);
                }
            }
        }
    }

