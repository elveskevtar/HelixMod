package com.elveskevtar.helix.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.elveskevtar.helix.container.ContainerNucleotideSynthesizer;
import com.elveskevtar.helix.tileentity.TileEntityNucleotideSynthesizer;

public class GUINucleotideSynthesizer extends GuiContainer {

	private TileEntityNucleotideSynthesizer entity;

	public GUINucleotideSynthesizer(InventoryPlayer inventoryPlayer,
			TileEntityNucleotideSynthesizer entity) {
		super(new ContainerNucleotideSynthesizer(inventoryPlayer, entity));
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
		int i1;
		if (entity.burnTime > 0) {
			i1 = entity.getBurnTimeRemainingScaled(12);
			drawTexturedModalRect(x + 44, y + 36 + 12 - i1, 176, 12 - i1,
					14, i1 + 2);
		}
		i1 = entity.getCookProgressScaled(24);
		drawTexturedModalRect(x + 87, y + 34, 176, 14, i1 + 1, 16);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int var1, int var2) {
		fontRendererObj.drawString("Nucleotide Synthesizer", 8, 6, 4210752);
		fontRendererObj.drawString(
				StatCollector.translateToLocal("container.inventory"), 8,
				ySize - 96 + 2, 4210752);
	}
}
