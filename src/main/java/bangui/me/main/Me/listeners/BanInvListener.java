package bangui.me.main.Me.listeners;

import bangui.me.main.Me.Main;
import bangui.me.main.Me.utils.BanMenuUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class BanInvListener implements Listener {
    Main plugin;
    BanMenuUtils banMenu;

    public BanInvListener(Main plugin, BanMenuUtils banMenu) {
        this.plugin = plugin;
        this.banMenu = banMenu;
    }

    @EventHandler
    public void playerMoveEvent(PlayerMoveEvent pme) {
    }


    @EventHandler


    public void onMenuClick(InventoryClickEvent e) throws Exception {


        e.getCurrentItem().getType();


        Player p = (Player) e.getWhoClicked();


        if (banMenu.isBanGUI(e.getClickedInventory())) {

            if (e.getCurrentItem() == null) {
                return;
            }
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
                    e.setCancelled(true);
                } else if (e.getCurrentItem().getType() == Material.EXPERIENCE_BOTTLE) {
                    String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                    Player playerwhoisban = Bukkit.getPlayer(name);
                    playerwhoisban.removePotionEffect(PotionEffectType.BLINDNESS);
                    playerwhoisban.removePotionEffect(PotionEffectType.SLOW);
                    playerwhoisban.removePotionEffect(PotionEffectType.INVISIBILITY);
                    playerwhoisban.removePotionEffect(PotionEffectType.JUMP);
                    playerwhoisban.playEffect(playerwhoisban.getEyeLocation(), Effect.DRAGON_BREATH, 0);
                    //playerwhoisban.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.GREEN + "Cleansed" + name + "!");
                    System.out.println(ChatColor.WHITE + "[" + ChatColor.RED + "BAN EM" + ChatColor.WHITE + "]" + " " + ChatColor.RED + "Just Cleansed" + " " + name + "!");
                    p.playNote(p.getEyeLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
                    e.setCancelled(true);
                } else if (e.getCurrentItem().getType() == Material.ICE) {
                    String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                    Player playerwhoisban = Bukkit.getPlayer(name);
                    playerwhoisban.addPotionEffect((new PotionEffect(PotionEffectType.SLOW, 20000, 50)));
                    playerwhoisban.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 200));
                    p.sendMessage(ChatColor.GREEN + "Froze" + name + "!");
                    System.out.println(ChatColor.WHITE + "[" + ChatColor.RED + "BAN EM" + ChatColor.WHITE + "]" + " " + ChatColor.RED + "Just Froze" + " " + name + "!");
                    p.playNote(p.getEyeLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
                    e.setCancelled(true);
                } else if (e.getCurrentItem().getType() == Material.RED_BED) {
                    String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                    Player playerwhoisban = Bukkit.getPlayer(name);
                    Location bedloc = playerwhoisban.getBedSpawnLocation();
                    p.teleport(bedloc);
                    playerwhoisban.playEffect(playerwhoisban.getBedSpawnLocation(), Effect.DRAGON_BREATH, 0);
                    p.sendMessage(ChatColor.GREEN + "TP'd to" + name + "'s Bed!'");
                    System.out.println(ChatColor.WHITE + "[" + ChatColor.RED + "BAN EM" + ChatColor.WHITE + "]" + " " + ChatColor.RED + "Just Gone TO " + " " + name + "'s Bed!");
                    p.playNote(p.getEyeLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
        e.setCancelled(true);
    }
}




