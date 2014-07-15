package com.elveskevtar.helix;

import net.minecraft.item.Item;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class HelixEvents {

	@SubscribeEvent
	public void ItemCraftedEvent(ItemCraftedEvent event) {
		if (event.crafting.getItem() == Item
				.getItemFromBlock(Helix.synthesizer))
			event.player.triggerAchievement(Helix.synAchievement);
	}
}