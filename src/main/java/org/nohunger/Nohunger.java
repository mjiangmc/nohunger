package org.nohunger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public final class Nohunger extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NoHunger 插件已启用！");
    }

    @Override
    public void onDisable() {
        getLogger().info("NoHunger 插件已关闭！");
    }

    // 如果要掉饱和度了就设置饥饿值
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            event.setCancelled(true);
            ((Player) event.getEntity()).setFoodLevel(20);
            ((Player) event.getEntity()).setSaturation(20.0f);
        }
    }

    // 确保玩家进服时也拥有满饥饿值
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setFoodLevel(20);
        player.setSaturation(20.0f);
    }
}
