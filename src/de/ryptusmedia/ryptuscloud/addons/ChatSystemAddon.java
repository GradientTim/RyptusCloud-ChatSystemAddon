package de.ryptusmedia.ryptuscloud.addons;

import de.ryptusmedia.minecraft.cloudsystem.ryptuscloud.SpigotCloudLibrary;
import de.ryptusmedia.minecraft.cloudsystem.ryptuscloud.addon.CloudAddon;
import de.ryptusmedia.minecraft.cloudsystem.ryptuscloud.utilities.annotions.Addon;
import de.ryptusmedia.ryptuscloud.addons.event.BukkitChatEvent;

@Addon(name = "ChatSystemAddon", version = 1.0, authors = { "StonksCloud" }, description = "Format the ChatSystem with the RyptusCloud implementation.")
public class ChatSystemAddon extends CloudAddon {

    private static ChatSystemAddon addon;

    public ChatSystemAddon(Class<?> clazz) {
        super(clazz);
    }

    public ChatSystemAddon() {}

    @Override
    public void onEnable() {
        addon = this;
        SpigotCloudLibrary.getService().getServer().getPluginManager().registerEvents(new BukkitChatEvent(), SpigotCloudLibrary.getService());
    }

    public static ChatSystemAddon getAddon() {
        return addon;
    }

}
