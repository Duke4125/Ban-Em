package bangui.me.duke.Me.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

import static org.bukkit.Material.DIAMOND_SWORD;
import static org.bukkit.Material.PLAYER_HEAD;


public class BanMenuUtils {

    public static void openBanMenu(Player p) {
        ArrayList<Player> list = new ArrayList<>(p.getServer().getOnlinePlayers());

        Inventory bangui = Bukkit.createInventory(p, 45, ChatColor.RED + "Player List");

        for (Player player : list) {

            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta sm = (SkullMeta) playerHead.getItemMeta();
            sm.setOwningPlayer(player);
            ItemMeta player_meta = playerHead.getItemMeta();
            playerHead.setItemMeta(sm);
            ItemMeta meta = playerHead.getItemMeta();

            meta.setDisplayName(player.getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Player Health: " + ChatColor.RED + player.getHealth());
            lore.add(ChatColor.GOLD + "EXP: " + ChatColor.AQUA + player.getExp());
            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            bangui.addItem(playerHead);
            {
                p.openInventory(bangui);
            }
        }
    }
    public static void openConfirmBanMenu(Player p, Player whoToBan) {
        Inventory confirmBanMenu = Bukkit.createInventory(p, 9, ChatColor.AQUA + "Ban EM");


        //ban them
        ItemStack ban = new ItemStack(DIAMOND_SWORD, 1);
        ItemMeta ban_meta = ban.getItemMeta();
        ban_meta.setDisplayName(ChatColor.DARK_BLUE + "BAN");
        ArrayList<String> lore_ban = new ArrayList<>();
        lore_ban.add(ChatColor.AQUA + "BAN EM!!!!!");
        ban_meta.setLore(lore_ban);
        ban.setItemMeta(ban_meta);
        confirmBanMenu.setItem(0, ban);

        //Add player
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta sm = (SkullMeta) playerHead.getItemMeta();
        sm.setOwningPlayer(whoToBan);
        ItemMeta player_meta = playerHead.getItemMeta();
        sm.setDisplayName(whoToBan.getDisplayName());
        ArrayList<String> lore_com = new ArrayList<>();
        lore_com.add(ChatColor.GREEN + "This is the player you are going to ban!");
        sm.setLore(lore_com);
        playerHead.setItemMeta(sm);
        confirmBanMenu.setItem(4, playerHead);

        //Cancel option
        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(ChatColor.RED + "EXIT!");
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
        lore_war.add(ChatColor.YELLOW + "Warn Player - [This feature is not upto date: pls expect bugs/wait for it to work to its fullest!]");
        warn_meta.setLore(lore_war);
        warn.setItemMeta(warn_meta);
        confirmBanMenu.setItem(2, warn);

        //kick player
        ItemStack kick = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta kick_meta = kick.getItemMeta();
        kick_meta.setDisplayName(ChatColor.DARK_AQUA + "KICK!");
        ArrayList<String> lore_kik = new ArrayList<>();
        lore_kik.add(ChatColor.DARK_RED + "Exit back to the player list");
        kick_meta.setLore(lore_kik);
        kick.setItemMeta(kick_meta);
        confirmBanMenu.setItem(1, kick);

        p.openInventory(confirmBanMenu);
    }
}

