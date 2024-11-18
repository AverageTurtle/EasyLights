package org.skibidi.easyLights;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockDataMeta;

public class LightCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length != 1) return false;
        int light_level = Integer.parseInt(args[0]);
        if(light_level > 15 || light_level < 1) return false;

        if(sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack light = new ItemStack(Material.LIGHT);
            
            BlockDataMeta blockDataMeta = (BlockDataMeta) light.getItemMeta();
            BlockData blockData = light.getType().createBlockData();
            
            ((Levelled) blockData).setLevel(light_level);

            blockDataMeta.setBlockData(blockData);
            light.setItemMeta(blockDataMeta);

            player.getInventory().addItem(light);
        }
        return true;
    }
    
}
