package nl.datalion.ddgvanish.commands;

import nl.datalion.ddgvanish.DDGVanish;
import nl.datalion.ddgvanish.utils.Vanish;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Making sure CommandSender is a Player
        if(!(sender instanceof Player)){
            sender.sendMessage(DDGVanish.getPrefix() + DDGVanish.color("&cAlleen spelers kunnen dit command gebruiken!"));
            return false;
        }

        Player player = (Player) sender;
        Vanish vanishUtil = DDGVanish.getVanishUtil();

        // Vanish Player
        if(!vanishUtil.isVanished(player)){
            vanishUtil.setVanished(player);
            player.sendMessage(DDGVanish.getPrefix() + DDGVanish.color("&aPoof! You are Vanished"));
            return true;
        }

        // Unvanish Player
        if(vanishUtil.isVanished(player)){
            vanishUtil.unsetVanished(player);
            player.sendMessage(DDGVanish.getPrefix() + DDGVanish.color("&aPoof! You are Unvanished"));
            return true;
        }

        return false;
    }
}
