package com.elveskevtar.helix.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.elveskevtar.helix.container.ContainerHydrogenBondFacilitator;
import com.elveskevtar.helix.tileentity.TileEntityHydrogenBondFacilitator;

public class GUIHydrogenBondFacilitator extends GuiContainer {

	private TileEntityHydrogenBondFacilitator entity;

	public GUIHydrogenBondFacilitator(InventoryPlayer inventoryPlayer,
			TileEntityHydrogenBondFacilitator entity) {
		super(new ContainerHydrogenBondFacilitator(inventoryPlayer, entity));
		this.entity = entity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(new ResourceLocation("helixmod",
				"textures/gui/synthesizerGUI.png"));
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}
