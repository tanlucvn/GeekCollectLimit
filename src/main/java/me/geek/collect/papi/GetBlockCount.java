package me.geek.collect.papi;

import me.geek.collect.GeekCollectLimit;
import me.geek.collect.api.PlayerData;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GetBlockCount implements Placeholder {

    @Override
    public String process(Player player, String identifier) {
        if (player != null) {

            String materialName = identifier.toLowerCase();
            Material material = Material.matchMaterial(materialName);

            if (material != null) {
                PlayerData playerData = GeekCollectLimit.getPlayerData(player.getUniqueId());
                if (playerData != null) {
                    int collectAmount = playerData.getCollectAmount(material);
                    return String.valueOf(collectAmount);
                }
            }
        }
        return "0";
    }
}
