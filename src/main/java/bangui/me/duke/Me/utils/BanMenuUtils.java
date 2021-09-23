package bangui.me.duke.Me.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.bukkit.Material.DIAMOND_SWORD;



public class BanMenuUtils implements Listener {

    private JavaPlugin plugin;
    private List<Inventory> pages;
    Pattern pattern = Pattern.compile("\\d+");
    private static ItemStack next = new ItemStack(Material.ARROW);

    static {
        ItemMeta nextMeta = next.getItemMeta();
        nextMeta.setDisplayName(ChatColor.DARK_PURPLE + "Next Page");
        next.setItemMeta(nextMeta);
    }

    public BanMenuUtils (JavaPlugin plugin) {

        this.plugin = plugin;
    }

    public boolean isBanGUI(Inventory inv) {
        return pages.contains(inv);
    }

    public void openMenu(Player player) {

        pages = new ArrayList<>();
        Inventory currentPage = newPage();
        int i = 0;

        for (Player online: Bukkit.getOnlinePlayers()) {

            if (i == 53) {
                i = 0;
                currentPage.setItem(53, next);
                currentPage = newPage();
            }

            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta sm = (SkullMeta) playerHead.getItemMeta();
            sm.setOwningPlayer(player);
            ItemMeta player_meta = playerHead.getItemMeta();
            playerHead.setItemMeta(sm);
            ItemMeta meta = playerHead.getItemMeta();

            meta.setDisplayName(ChatColor.WHITE + player.getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.WHITE + "Player Health: " + ChatColor.RED + Math.round(player.getHealth()) + "/" +  Math.round(player.getHealthScale()));
            lore.add(ChatColor.WHITE + "Player Ping: " + ChatColor.RED + player.getPing());
            lore.add(ChatColor.WHITE + "Player Is op: " + ChatColor.RED + player.isOp());
            lore.add(ChatColor.WHITE + "Player UUID:" + ChatColor.RED + " " +  player.getUniqueId());
            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            currentPage.addItem(playerHead);
        }

        if (!pages.isEmpty()) player.openInventory(pages.get(0));
    }

    private Inventory newPage() {

        Inventory inven = Bukkit.createInventory(null, 54, ChatColor.GREEN + String.format("Players: (Page %d)", pages.size() + 1));
        pages.add(inven);

        return pages.get(pages.size() - 1);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (!next.isSimilar(event.getCurrentItem())) return;
        if (!pages.contains(event.getClickedInventory())) return;

        Matcher m = pattern.matcher(ChatColor.stripColor(event.getView().getTitle()));
        if (m.find()) {
            event.getWhoClicked().openInventory(pages.get(Integer.parseInt(m.group())));
        }
    }


    public static void openConfirmBanMenu(Player p, Player whoToBan) {
        Inventory confirmBanMenu = Bukkit.createInventory(p, 9, ChatColor.WHITE + "[" + ChatColor.AQUA + "Ban EM" + ChatColor.WHITE + "]");


        //ban them
        ItemStack ban = new ItemStack(DIAMOND_SWORD, 1);
        ItemMeta ban_meta = ban.getItemMeta();
        ban_meta.setDisplayName(ChatColor.AQUA + "BAN EM!!");
        ban_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> lore_ban = new ArrayList<>();
        ban_meta.setLore(lore_ban);
        ban.setItemMeta(ban_meta);
        confirmBanMenu.setItem(0, ban);

        //Add player
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta sm = (SkullMeta) playerHead.getItemMeta();
        sm.setOwningPlayer(whoToBan);
        sm.setDisplayName(ChatColor.WHITE + whoToBan.getDisplayName());
        ArrayList<String> lore_com = new ArrayList<>();
        lore_com.add(ChatColor.GREEN + "This is the player you are going to ban!");
        sm.setLore(lore_com);
        playerHead.setItemMeta(sm);
        confirmBanMenu.setItem(4, playerHead);

        //Cancel option
        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(ChatColor.RED + "EXIT!");
        cancel_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> lore_can = new ArrayList<>();
        lore_can.add(ChatColor.DARK_RED + "Exit back to the player list");
        cancel_meta.setLore(lore_can);
        cancel.setItemMeta(cancel_meta);
        confirmBanMenu.setItem(8, cancel);

        //warns
        ItemStack warn = new ItemStack(Material.PAPER, 1);
        ItemMeta warn_meta = cancel.getItemMeta();
        warn_meta.setDisplayName(ChatColor.GOLD + "WARN");
        ArrayList<String> lore_war = new ArrayList<>();
        lore_war.add(ChatColor.YELLOW + "DONT USE! THIS WILL BRAKE THE PLUGIN -" + " WILL WORK IN THE NEXT FEW UPDATES");
        warn_meta.setLore(lore_war);
        warn.setItemMeta(warn_meta);
        confirmBanMenu.setItem(2, warn);

        //kick player
        ItemStack kick = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta kick_meta = kick.getItemMeta();
        kick_meta.setDisplayName(ChatColor.DARK_AQUA + "KICK!");
        kick_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> lore_kik = new ArrayList<>();
        kick_meta.setLore(lore_kik);
        kick.setItemMeta(kick_meta);
        confirmBanMenu.setItem(1, kick);

        p.openInventory(confirmBanMenu);
    }
}
