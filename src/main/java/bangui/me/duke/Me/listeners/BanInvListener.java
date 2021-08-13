package bangui.me.duke.Me.listeners;

import bangui.me.duke.Me.utils.BanMenuUtils;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BanInvListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Player List")) {
            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {

                Player whoToBan = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                BanMenuUtils.openConfirmBanMenu(p, whoToBan);


            }
        }else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Ban EM")){

            if (e.getCurrentItem().getType() == Material.BARRIER) {
                BanMenuUtils.openBanMenu(p);
            }else if (e.getCurrentItem().getType() == Material.WOODEN_AXE){
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                p.getServer().getBanList(BanList.Type.NAME).addBan(name, "Banned by ban em!", null, null);
                p.sendMessage(ChatColor.GREEN + "Banned Player!");
            }
            e.setCancelled(true);
        }
    }
}
