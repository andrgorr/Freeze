package me.javipepe.freeze;

import com.connorlinfoot.titleapi.TitleAPI;
import me.javipepe.freeze.Listeners.MoveListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

/**
 * Created by javipepe on 4/06/15.
 */
public class main extends JavaPlugin {

    public static ArrayList<Player> frozen = new ArrayList<>();

    public void onEnable(){
        this.getServer().getPluginManager().registerEvents(new MoveListener(), this);
        //this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String title, String[] args){
        if(cmd.getName().equalsIgnoreCase("freeze")){
            if(!sender.isOp()){
                sender.sendMessage(ChatColor.RED + "No permission.");
                return true;
            }else {
                if(args.length > 2){
                    sender.sendMessage(ChatColor.RED + "Usage /freeze <player> (-u)");
                    return true;
                }
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.RED + "Usage /freeze <player> (-u)");
                    return true;
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    Player s = (Player) sender;

                    if(target == null){
                        sender.sendMessage(ChatColor.RED + "Player not online");
                        return true;
                    }else{
                        frozen.add(target);
                        TitleAPI.sendTitle(target, 22, 22, 22, ChatColor.RED + "" + ChatColor.BOLD + "You have been frozen", ChatColor.YELLOW + "by " + s.getDisplayName());
                        sender.sendMessage(ChatColor.RED + "You have frozen " + ChatColor.RESET + target.getDisplayName());
                        return true;
                    }
                }else if(args.length == 2 && args[1].equalsIgnoreCase("-u")){

                    Player target = Bukkit.getPlayer(args[0]);
                    Player s = (Player) sender;

                    frozen.remove(target);
                    TitleAPI.sendTitle(target, 20, 20, 20, ChatColor.GREEN + "" + ChatColor.BOLD + "You have been unfrozen", ChatColor.YELLOW + "by " + s.getDisplayName());
                    sender.sendMessage(ChatColor.GREEN + "You have unfrozen " + ChatColor.RESET + target.getDisplayName());
                    return true;
                }


            }
        }
        return true;
    }
}
