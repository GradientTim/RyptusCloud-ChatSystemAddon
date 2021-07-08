package de.ryptusmedia.ryptuscloud.addons.event;

import de.ryptusmedia.minecraft.cloudsystem.ryptuscloud.api.CloudAPI;
import de.ryptusmedia.minecraft.cloudsystem.ryptuscloud.player.NodePlayer;
import de.ryptusmedia.ryptuscloud.addons.ChatSystemAddon;
import de.ryptusmedia.ryptuscloud.addons.config.ChatSystemConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BukkitChatEvent implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onAsyncChatEvent(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        asyncPlayerChatEvent.setCancelled(true);
        Player player = asyncPlayerChatEvent.getPlayer();
        String message = asyncPlayerChatEvent.getMessage();

        NodePlayer nodePlayer = CloudAPI.getAPI().getNodePlayer(player.getUniqueId());
        ChatSystemConfig config = ChatSystemAddon.getAddon().getConfig(new ChatSystemConfig());
        if (nodePlayer == null || config == null) return;
        Bukkit.broadcastMessage(config.getFormat(player, nodePlayer.getHighestPermissionTeam(CloudAPI.getAPI().getPermissionManager().getPermissionTeams()), message));
    }

}
