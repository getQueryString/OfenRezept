package main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        ItemStack schwert = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = schwert.getItemMeta();
        meta.setDisplayName("Schwert");
        meta.spigot().setUnbreakable(true);
        schwert.setItemMeta(meta);

        FurnaceRecipe recipe = new FurnaceRecipe(schwert, Material.DIAMOND);
        FurnaceRecipe recipe1 = new FurnaceRecipe(new ItemStack(Material.DIAMOND), schwert.getType()); // ?
        Bukkit.addRecipe(recipe);
        Bukkit.addRecipe(recipe1);                                                                     // ?

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBurn(FurnaceBurnEvent e) {
        if (e.getFuel().getType() == Material.WOOD_SWORD) ;
        e.setBurnTime(5000);
    }

}
