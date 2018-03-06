package KMInvComm;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitScheduler;

public class Core
extends JavaPlugin
implements Listener {

    private Logger log = Logger.getLogger("Minecraft");

    public void onEnable() {
         this.log.info(String.format("%s is enabled!", this.getDescription().getFullName()));
    }

    public void onDisable() { 
        this.log.info(String.format("%s is disabled!", this.getDescription().getFullName()));
     }

    public boolean onCommand(CommandSender commandSender, Command command, String string, String[] args) {
        if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("§4you must be a player!§f");
                return false;
        }
        String playerName = commandSender.getName();
        if (command.getName().equals("nrp")) {
            if (args.length == 0 || args[0].equals("help")) {
                commandSender.sendMessage("§e----------- §fHelp: nrp §e--------------------§f\nThis command is used to get non-roleplay (NRP, OOC) items, such as pickaxe or sings.\n§e/nrp tools §f- get pickaxe and axe.\n§e/nrp signs §f- get signs and item frames.\n§e/nrp microtools §f- get tools to operate microblocks.\n§e/nrp fire §f- get flint and steel.\n");
                return true;
            }
            if (args[0].equals("tools")) {
                String[] commandText = new String[2];
                commandText[0] = "give "+playerName+" diamond_pickaxe 1 0 {display: {Name:\"§fАлмазная кирка\", Lore:[\"§4НРП\"]}, ench: [{id:34, lvl:5}]}";
                commandText[1] = "give "+playerName+" diamond_axe 1 0 {display: {Name:\"§fАлмазный топор\", Lore:[\"§4НРП\"]}, ench: [{id:34, lvl:5}]}";
                BukkitScheduler scheduler = getServer().getScheduler();
                    if (
                            scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                                @Override
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commandText[0]);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commandText[1]);
                                }
                            }, 1L) == -1) {
                        System.out.println("_Что-то пошло не так, команда не была выполнена!_");
                         return false;
                         }
            return true;
            }if (args[0].equals("signs")) {
                String[] commandText = new String[2];
                commandText[0] = "give "+playerName+" sign 16 0";
                commandText[1] = "give "+playerName+" item_frame 64 0";
                BukkitScheduler scheduler = getServer().getScheduler();
                    if (
                            scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                                @Override
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commandText[0]);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commandText[1]);
                                }
                            }, 1L) == -1) {
                        System.out.println("_Что-то пошло не так, команда не была выполнена!_");
                         return false;
                         }
            return true;
            }if (args[0].equals("microtools")) {
                String[] commandText = new String[3];
                commandText[0] = "give "+playerName+" yegamolchattels:iron_chisel 1 0 {display: {Name:\"§fСтамеска для обработки\",Lore:[\"§4НРП\"]}, ench: [{id:34, lvl:5}] }";
                commandText[1] = "give "+playerName+" yegamolchattels:club_hammer 1 0 {display: {Name:\"§fКувалда\",Lore:[\"§4НРП\"]}, ench: [{id:34, lvl:5}]}";
                commandText[2] = "give "+playerName+" yegamolchattels:iron_chisel_point 1 0 {display: {Name: \"§fКузнечная стамеска\", Lore:[\"§4НРП\"]}, ench: [{id:34, lvl:5}] }";
                BukkitScheduler scheduler = getServer().getScheduler();
                    if (
                            scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                                @Override
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commandText[0]);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commandText[1]);
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commandText[2]);
                                }
                            }, 1L) == -1) {
                        System.out.println("_Что-то пошло не так, команда не была выполнена!_");
                         return false;
                         }
            return true;
            }if (args[0].equals("fire")) {
                String commandText = "give "+playerName+" flint_and_steel 1 0 {display: {Name:\"§fОгниво\", Lore:[\"§4НРП\"]} }";
                BukkitScheduler scheduler = getServer().getScheduler();
                    if (
                            scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                                @Override
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commandText);
                                }
                            }, 1L) == -1) {
                        System.out.println("_Что-то пошло не так, команда не была выполнена!_");
                         return false;
                         }
            return true;
            }
        } else if (command.getName().equals("lore")) {
            if (args.length == 0 || args[0].equals("help")) {
                commandSender.sendMessage("§e----------- §fHelp: lore §e--------------------§f\nThis command allows player to add lore to the item he is currently holding. Note that GameMaster's confirmation is necessary, until than item is called \"UNCONFIRMED ITEM\"\n§e/lore add §f- add multiple lore lines\n§e/lore set §f- set lore for item.\n");
                return true;
            }
            if (args[0].equals("add") || args[0].equals("set")) {
                String sumArgs = "";
                for (int i = 1; i < args.length; i++) {
                    sumArgs += " " + args[i];
                }
                sumArgs = sumArgs.trim();
                String commandText = args[0] + "lore " + sumArgs;
                BukkitScheduler scheduler = getServer().getScheduler();
                if (
                        scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.getServer().dispatchCommand(commandSender, "rename &4НЕ ПОДТВЕРЖДЕННЫЙ ПРЕДМЕТ");
                                Bukkit.getServer().dispatchCommand(commandSender, commandText);
                            }
                        }, 1L) == -1) {
                    System.out.println("_Что-то пошло не так, команда не была выполнена!_");
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
