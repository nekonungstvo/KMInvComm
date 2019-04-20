package KMInvComm;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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
                commandSender.sendMessage("§e----------- §fHelp: nrp §e--------------------§f\n" +
                        "Эта команда используется для получения НРП-предметов, например кирки или табличек.\n" +
                        "§e/nrp tools §f- кирка и топор.\n" +
                        "§e/nrp sign §f- рамки и таблички.\n" +
                        "§e/nrp bigsign §f- большая табличка.\n" +
                        "§e/nrp microtools §f- инструменты для работы с микроблоками.\n" +
                        "§e/nrp fire §f- огниво.\n" +
                        "§e/nrp bag §f- мешок.\n" +
                        "§e/nrp chest §f- сундук-ловушка.\n"
                );
                return true;
            }
            if (args[0].equals("tools")) {
                String[] commandText = new String[2];
                commandText[0] = "give " + playerName + " diamond_pickaxe 1 0 {display: {Name:\"§fАлмазная кирка\", Lore:[\"§4НРП\"]}, ench: [{id:34, lvl:5},{id:33, lvl:1}]}";
                commandText[1] = "give " + playerName + " diamond_axe 1 0 {display: {Name:\"§fАлмазный топор\", Lore:[\"§4НРП\"]}, ench: [{id:34, lvl:5}, {id:33, lvl:1}]}";
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
            }
            if (args[0].equals("signs") || args[0].equals("sign")) {
                String[] commandText = new String[2];
                commandText[0] = "give " + playerName + " sign 16 0";
                commandText[1] = "give " + playerName + " item_frame 64 0";
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
            }
            if (args[0].equals("microtools")) {
                String[] commandText = new String[3];
                commandText[0] = "give " + playerName + " yegamolchattels:iron_chisel 1 0 {display: {Name:\"§fСтамеска для обработки\",Lore:[\"§4НРП\"]}, ench: [{id:34, lvl:5}] }";
                commandText[1] = "give " + playerName + " yegamolchattels:club_hammer 1 0 {display: {Name:\"§fКувалда\",Lore:[\"§4НРП\"]}, ench: [{id:34, lvl:5}]}";
                commandText[2] = "give " + playerName + " yegamolchattels:iron_chisel_point 1 0 {display: {Name: \"§fКузнечная стамеска\", Lore:[\"§4НРП\"]}, ench: [{id:34, lvl:5}] }";
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
            }
            if (args[0].equals("fire")) {
                String commandText = "give " + playerName + " flint_and_steel 1 0 {display: {Name:\"§fОгниво\", Lore:[\"§4НРП\"]} }";
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
            if (args[0].equals("bag")) {
                String commandText = "give " + playerName + " 5979 1 0 {display: {Name:\"§4НРП\"} }";
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
            if (args[0].equals("chest")) {
                String commandText = "give " + playerName + " 0146 1 0 {display: {Name:\"§4НРП\"} }";
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
            if (args[0].equals("bigsign")) {
                String commandText = "give " + playerName + " 0196 1 0 {display: {Name:\"§4НРП\"} }";
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


        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> list = new ArrayList<String>();

        //list of commands
        String[] tabs = {"chest", "sign", "bigsign", "bag", "tools", "fire", "microtools"};


        //if the user started in the command eg. with "/game c", the list will add as prefix the "check" command
        if (cmd.equals("nrp")) {
            for (String s : tabs) {
                if (s.startsWith(args[0]))
                    list.add(s);
            }
        }

        return list;
    }

}
