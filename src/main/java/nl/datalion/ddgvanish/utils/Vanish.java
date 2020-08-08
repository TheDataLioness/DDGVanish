package nl.datalion.ddgvanish.utils;

import nl.datalion.ddgvanish.DDGVanish;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Vanish {

    private ArrayList<UUID> vanished;
    private BossBar vanishBar;

    public Vanish(){
        vanished = new ArrayList<>();
        vanishBar = Bukkit.createBossBar("Vanished", BarColor.RED, BarStyle.SOLID);
    }

    /**
     * Returns value if player is vanished or not
     * @param player Instance of Player class
     * @return boolean
     */
    public boolean isVanished(final Player player){
        return vanished.contains(player.getUniqueId());
    }

    /**
     * Vanish | Let player dissapear from the server.
     * @param player Instance of Player class
     */
    public void setVanished(final Player player){

        // Added UUID to ArrayList
        UUID uuid = player.getUniqueId();
        if(!isVanished(player)) vanished.add(uuid);

        // Add bossbar to player
        vanishBar.addPlayer(player);

        // Remove player
        Collection<? extends Player> onlinePlayers = DDGVanish.getInstance().getServer().getOnlinePlayers();
        for (Player onlinePlayer: onlinePlayers){
            // Don't hide player if player has bypass permission
            if(onlinePlayer.hasPermission("ddgvanish.bypass")) continue;
            onlinePlayer.hidePlayer(DDGVanish.getInstance(), player);
        }
    }

    /**
     * Unvanish | Let player appear in the server again.
     * @param player Instance of Player class
     */
    public void unsetVanished(final  Player player){

        // Remove UUID out of ArrayList
        UUID uuid = player.getUniqueId();
        if(isVanished(player)) vanished.remove(uuid);

        // Remove BossBar from player
        vanishBar.removePlayer(player);

        // Add player back
        Collection<? extends Player> onlinePlayers = DDGVanish.getInstance().getServer().getOnlinePlayers();
        for (Player onlinePlayer: onlinePlayers){
            // Player wasn't hidden for bypass player before so just skip again
            if(onlinePlayer.hasPermission("ddgvanish.bypass")) continue;

            onlinePlayer.hidePlayer(DDGVanish.getInstance(), player);
        }
    }
}
