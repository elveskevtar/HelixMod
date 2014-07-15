package com.elveskevtar.helix.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.elveskevtar.helix.model.ModelHydrogenBondFacilitator;

public class TileEntityHydrogenBondFacilitatorRenderer extends
		TileEntitySpecialRenderer {

	private static final ResourceLocation[] texture = {
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator1.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator2.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator3.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator4.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator5.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator6.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator7.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator8.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator9.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator10.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator11.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator12.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator13.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator14.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator15.png"),
			new ResourceLocation("helixmod",
					"textures/blocks/hydrogenBondFacilitator16.png") };
	private final ModelHydrogenBondFacilitator model = new ModelHydrogenBondFacilitator();

	public void renderTileEntity(TileEntityHydrogenBondFacilitator entity,
			double var2, double var4, double var6, double var8) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) var2, (float) var4, (float) var6);
		bindTexture(texture[entity.texture % 16]);
		model.render(entity);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		renderTileEntity((TileEntityHydrogenBondFacilitator) var1, var2, var4,
				var6, var8);
	}
}
