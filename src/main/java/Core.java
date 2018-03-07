package KMInvComm;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
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
                commandSender.sendMessage("§e----------- §fHelp: nrp §e--------------------§f\nЭта команда используется для получения НРП-предметов, например кирки или табличек.\n§e/nrp tools §f- кирка и топор.\n§e/nrp signs §f- рамки и таблички.\n§e/nrp microtools §f- инструменты для работы с микроблоками.\n§e/nrp fire §f- огниво.\n");
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
                commandSender.sendMessage("§e----------- §fHelp: lore §e--------------------§f\nЭта команда позволяет игроку изменить описание предмета, который он держит в руке. Обратите внимание, что до подтверждения ГМом предмет не является действительным.\n§e/lore add §f- добавить строки к описанию.\n§e/lore set §f- установить описание.\n");
                return true;
            }
            if (args[0].equals("add") || args[0].equals("set")) {
                String sumArgs = "";
                for (int i = 1; i < args.length; i++) {
                    sumArgs += " " + args[i];
                }
                String action = "";
                if (args[0].equals("add"))
                    action = "\nHe added lore:\n";
                else if (args[0].equals("set"))
                    action = "\nHe set lore:\n";
                ItemStack itemStack = ((Player) commandSender).getItemInHand();
                ItemMeta itemMeta = itemStack.getItemMeta();
                try (FileWriter writer = new FileWriter("logs/lore/lore_current.log", true)) {
                    Date date = new Date();
                    String what = itemStack.toString();
                    writer.write("[" + date.toString() + "] " + commandSender.getName() + " edited following item:\n" + what + action + sumArgs + '\n');
                } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                }
                sumArgs = sumArgs.trim();
                String commandText = args[0] + "lore " + sumArgs;
                BukkitScheduler scheduler = getServer().getScheduler();
                if (
                        scheduler.scheduleSyncDelayedTask(this, new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + commandSender.getName() + " add sr.*");
                                Bukkit.getServer().dispatchCommand(commandSender, "rename &4НЕ ПОДТВЕРЖДЕННЫЙ ПРЕДМЕТ");
                                Bukkit.getServer().dispatchCommand(commandSender, commandText);
                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + commandSender.getName() + " remove sr.*");
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
