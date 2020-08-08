package nl.datalion.ddgvanish;

import nl.datalion.ddgvanish.utils.Vanish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Collection;

public class EventListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        // Define variables Im using multiple times
        Player player = e.getPlayer();
        Collection<? extends Player> onlinePlayers = DDGVanish.getInstance().getServer().getOnlinePlayers();
        Vanish vanishUtil = DDGVanish.getVanishUtil();

        // Check if joined player is Vanished
        if(DDGVanish.getVanishUtil().isVanished(player)){
            vanishUtil.setVanished(player);
        }

        // Check if players online are vanished and hide them for the player
        // Only need to run this if player doesn't have bypass permission.
        if(player.hasPermission("ddgvanish.bypass")) return;

        for (Player onlinePlayer: onlinePlayers){
            if(vanishUtil.isVanished(onlinePlayer)) vanishUtil.setVanished(player);
        }

    }

}
