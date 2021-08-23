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


public class BanInvListener implements Listener {
    Duke plugin;
    BanMenuUtils banMenu;

    public BanInvListener(Duke plugin, BanMenuUtils banMenu) {
        this.plugin = plugin;
        this.banMenu = banMenu;
    }



    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {


        Player p = (Player) e.getWhoClicked();

        if (banMenu.isBanGUI(e.getClickedInventory())) {
            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {

                Player whoToBan = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                BanMenuUtils.openConfirmBanMenu(p, whoToBan);
                e.setCancelled(true);


            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.WHITE + "[" + ChatColor.AQUA + "Ban EM" + ChatColor.WHITE + "]")) {

            if (e.getCurrentItem().getType() == Material.BARRIER) {
                banMenu.openMenu(p);
                //ban
            } else if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                p.getServer().getBanList(BanList.Type.NAME).addBan(name, plugin.getConfig().getString("BanReason"), null, null);
                Bukkit.getPlayer(name).kickPlayer(ChatColor.RED + "Ban em" + " " + name + " " + "Has been removed from the server");
                p.sendMessage(ChatColor.GREEN + "Banned" + name + "!");
                System.out.println(ChatColor.WHITE + "[" + ChatColor.RED + "BAN EM" + ChatColor.WHITE + "]" + " " + ChatColor.RED + "Just banned" + " " + name + "!");
                //warn
            } else if (e.getCurrentItem().getType() == Material.PAPER) {
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                System.out.println(ChatColor.RED + "This feature is not available atm! Sorry for the inconvenience");
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
