package me.javipepe.freeze.Listeners;

import me.javipepe.freeze.main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by javipepe on 4/06/15.
 */
public class MoveListener implements Listener {

    @EventHandler
    public static void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        if(main.frozen.contains(p)){
            e.setCancelled(true);
            
            return;
        }
    }
}
