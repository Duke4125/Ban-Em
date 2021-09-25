package bangui.me.duke.Me.listeners;

import bangui.me.duke.Me.Duke;
import bangui.me.duke.Me.utils.BanMenuUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;
import java.util.Vector;


public class BanInvListener implements Listener {
    Duke plugin;
    BanMenuUtils banMenu;

    public BanInvListener(Duke plugin, BanMenuUtils banMenu) {
        this.plugin = plugin;
        this.banMenu = banMenu;
    }


    @EventHandler

    public void onMenuClick(InventoryClickEvent e) {
        if (e.getCurrentItem().getType() == null) {
            return;
        }

        Player p = (Player) e.getWhoClicked();

        if (banMenu.isBanGUI(e.getClickedInventory())) {
            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                e.setCancelled(true);
                Player whoToBan = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
                BanMenuUtils.openConfirmBanMenu(p, whoToBan);
                p.playNote(p.getEyeLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.WHITE + "[" + ChatColor.AQUA + "Ban EM" + ChatColor.WHITE + "]")) {
            if (e.getCurrentItem().getType() == Material.BARRIER) {
                p.playNote(p.getEyeLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
                banMenu.openMenu(p);
                //ban
            } else {
                e.getCurrentItem().getType();
                if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                    String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                    p.getServer().getBanList(BanList.Type.NAME).addBan(name, plugin.getConfig().getString("BanReason"), null, null);
                    Bukkit.getPlayer(name).kickPlayer(ChatColor.RED + "Ban em" + " " + name + " " + "Has been removed from the server");
                    p.sendMessage(ChatColor.GREEN + "Banned" + name + "!");
                    System.out.println(ChatColor.WHITE + "[" + ChatColor.RED + "BAN EM" + ChatColor.WHITE + "]" + " " + ChatColor.RED + "Just banned" + " " + name + "!");
                    p.playNote(p.getEyeLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
                    //warn
                } else if (e.getCurrentItem().getType() == Material.PAPER) {
                    String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                    System.out.println(ChatColor.RED + "This feature is not available atm! Sorry for the inconvenience");
                    p.sendMessage(ChatColor.RED + "This feature is not available atm!");
                    p.playNote(p.getEyeLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
                    e.setCancelled(true);
                    //kick
                } else if (e.getCurrentItem().getType() == Material.IRON_SWORD) {
                    String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                    Bukkit.getPlayer(name).kickPlayer(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("KickReason")));
                    p.sendMessage(ChatColor.GREEN + "kicked" + name + "!");
                    System.out.println(ChatColor.WHITE + "[" + ChatColor.RED + "BAN EM" + ChatColor.WHITE + "]" + " " + ChatColor.RED + "Just kicked" + " " + name + "!");
                    p.playNote(p.getEyeLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
                    e.setCancelled(true);

                } else if (e.getCurrentItem().getType() == Material.INK_SAC) {
                    String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                    Player playerwhoisban = Bukkit.getPlayer(name);
                    playerwhoisban.addPotionEffect((new PotionEffect(PotionEffectType.BLINDNESS, 20000, 10)));
                    playerwhoisban.addPotionEffect((new PotionEffect(PotionEffectType.SLOW, 20000, 50)));
                    playerwhoisban.addPotionEffect((new PotionEffect(PotionEffectType.INVISIBILITY, 20000, 50)));
                    p.sendMessage(ChatColor.GREEN + "Blinded" + name + "!");
                    System.out.println(ChatColor.WHITE + "[" + ChatColor.RED + "BAN EM" + ChatColor.WHITE + "]" + " " + ChatColor.RED + "Just blinded" + " " + name + "!");
                    p.playNote(p.getEyeLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
                    //playerwhoisban.setGameMode(GameMode.SPECTATOR);
                    e.setCancelled(true);
                } else if (e.getCurrentItem().getType() == Material.EXPERIENCE_BOTTLE) {
                    String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                    Player playerwhoisban = Bukkit.getPlayer(name);
                    playerwhoisban.removePotionEffect(PotionEffectType.BLINDNESS);
                    playerwhoisban.removePotionEffect(PotionEffectType.SLOW);
                    playerwhoisban.removePotionEffect(PotionEffectType.INVISIBILITY);
                    //playerwhoisban.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.GREEN + "Cleansed" + name + "!");
                    System.out.println(ChatColor.WHITE + "[" + ChatColor.RED + "BAN EM" + ChatColor.WHITE + "]" + " " + ChatColor.RED + "Just Cleansed" + " " + name + "!");
                    p.playNote(p.getEyeLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            }
        }
    }
}
