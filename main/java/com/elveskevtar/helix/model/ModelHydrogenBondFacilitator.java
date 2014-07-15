package com.elveskevtar.helix.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

import com.elveskevtar.helix.tileentity.TileEntityHydrogenBondFacilitator;

public class ModelHydrogenBondFacilitator extends ModelBase {

	public ModelRenderer Base1;
	public ModelRenderer Base2;
	public ModelRenderer Cube1;
	public ModelRenderer Cube2;
	public ModelRenderer Cube3;
	public ModelRenderer Cube4;
	public ModelRenderer Cube5;
	public ModelRenderer Cube6;
	public ModelRenderer Cube7;
	public ModelRenderer Cube8;
	public ModelRenderer Cube9;
	public ModelRenderer Cube10;
	public ModelRenderer Cube11;
	public ModelRenderer Cube12;
	public ModelRenderer Cube13;
	public ModelRenderer Cube14;
	public ModelRenderer Cube15;
	public ModelRenderer Cube16;

	public ModelHydrogenBondFacilitator() {
		textureWidth = 64;
		textureHeight = 64;
		Base1 = new ModelRenderer(this, 0, 0);
		Base1.addBox(0f, 0f, 0f, 16, 1, 16);
		Base1.setRotationPoint(0F, 0F, 0F);
		Base1.setTextureSize(64, 64);
		Base1.mirror = true;
		Base2 = new ModelRenderer(this, 0, 17);
		Base2.addBox(0f, 0f, 0f, 14, 1, 14);
		Base2.setRotationPoint(1F, 1F, 1F);
		Base2.setTextureSize(64, 64);
		Base2.mirror = true;
		Cube1 = new ModelRenderer(this, 0, 32);
		Cube1.addBox(-1F, -1F, -1F, 2, 2, 2);
		Cube1.setRotationPoint(2F, 5F, 2F);
		Cube1.setTextureSize(64, 64);
		Cube1.mirror = true;
		Cube2 = new ModelRenderer(this, 8, 32);
		Cube2.addBox(-1F, -1F, -1F, 2, 2, 2);
		Cube2.setRotationPoint(5F, 5F, 2F);
		Cube2.setTextureSize(64, 64);
		Cube2.mirror = true;
		Cube3 = new ModelRenderer(this, 16, 32);
		Cube3.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube3.setRotationPoint(8F, 5F, 2F);
		Cube3.setTextureSize(64, 64);
		Cube3.mirror = true;
		Cube4 = new ModelRenderer(this, 24, 32);
		Cube4.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube4.setRotationPoint(11F, 5F, 2F);
		Cube4.setTextureSize(64, 64);
		Cube4.mirror = true;
		Cube5 = new ModelRenderer(this, 32, 32);
		Cube5.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube5.setRotationPoint(14F, 5F, 2F);
		Cube5.setTextureSize(64, 64);
		Cube5.mirror = true;
		Cube6 = new ModelRenderer(this, 40, 32);
		Cube6.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube6.setRotationPoint(14F, 5F, 5F);
		Cube6.setTextureSize(64, 64);
		Cube6.mirror = true;
		Cube7 = new ModelRenderer(this, 48, 32);
		Cube7.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube7.setRotationPoint(14F, 5F, 8F);
		Cube7.setTextureSize(64, 64);
		Cube7.mirror = true;
		Cube8 = new ModelRenderer(this, 56, 32);
		Cube8.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube8.setRotationPoint(14F, 5F, 11F);
		Cube8.setTextureSize(64, 64);
		Cube8.mirror = true;
		Cube9 = new ModelRenderer(this, 0, 36);
		Cube9.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube9.setRotationPoint(14F, 5F, 14F);
		Cube9.setTextureSize(64, 64);
		Cube9.mirror = true;
		Cube10 = new ModelRenderer(this, 8, 36);
		Cube10.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube10.setRotationPoint(2F, 5F, 5F);
		Cube10.setTextureSize(64, 64);
		Cube10.mirror = true;
		Cube11 = new ModelRenderer(this, 16, 36);
		Cube11.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube11.setRotationPoint(2F, 5F, 8F);
		Cube11.setTextureSize(64, 64);
		Cube11.mirror = true;
		Cube12 = new ModelRenderer(this, 24, 36);
		Cube12.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube12.setRotationPoint(2F, 5F, 11F);
		Cube12.setTextureSize(64, 64);
		Cube12.mirror = true;
		Cube13 = new ModelRenderer(this, 32, 36);
		Cube13.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube13.setRotationPoint(2F, 5F, 14F);
		Cube13.setTextureSize(64, 64);
		Cube13.mirror = true;
		Cube14 = new ModelRenderer(this, 40, 36);
		Cube14.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube14.setRotationPoint(5F, 5F, 14F);
		Cube14.setTextureSize(64, 64);
		Cube14.mirror = true;
		Cube15 = new ModelRenderer(this, 48, 36);
		Cube15.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube15.setRotationPoint(8F, 5F, 14F);
		Cube15.setTextureSize(64, 64);
		Cube15.mirror = true;
		Cube16 = new ModelRenderer(this, 56, 36);
		Cube16.addBox(-1f, -1f, -1f, 2, 2, 2);
		Cube16.setRotationPoint(11F, 5F, 14F);
		Cube16.setTextureSize(64, 64);
		Cube16.mirror = true;
	}

	public void render(TileEntityHydrogenBondFacilitator entity) {
		float f5 = 0.0625F;
		Base1.render(f5);
		Base2.render(f5);
		Cube1.rotateAngleX = (float) (Math.PI / 4);
		Cube1.rotateAngleZ = (float) (Math.PI / 4);
		Cube1.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation)) * 0.0625),
				0F);
		Cube1.render(f5);
		GL11.glPopMatrix();
		Cube2.rotateAngleX = (float) (Math.PI / 4);
		Cube2.rotateAngleZ = (float) (Math.PI / 4);
		Cube2.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation) + Math.PI
						/ 2) * 0.0625), 0F);
		Cube2.render(f5);
		GL11.glPopMatrix();
		Cube3.rotateAngleX = (float) (Math.PI / 4);
		Cube3.rotateAngleZ = (float) (Math.PI / 4);
		Cube3.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation)) * 0.0625),
				0F);
		Cube3.render(f5);
		GL11.glPopMatrix();
		Cube4.rotateAngleX = (float) (Math.PI / 4);
		Cube4.rotateAngleZ = (float) (Math.PI / 4);
		Cube4.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation) - Math.PI
						/ 2) * 0.0625), 0F);
		Cube4.render(f5);
		GL11.glPopMatrix();
		Cube5.rotateAngleX = (float) (Math.PI / 4);
		Cube5.rotateAngleZ = (float) (Math.PI / 4);
		Cube5.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation)) * 0.0625),
				0F);
		Cube5.render(f5);
		GL11.glPopMatrix();
		Cube6.rotateAngleX = (float) (Math.PI / 4);
		Cube6.rotateAngleZ = (float) (Math.PI / 4);
		Cube6.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation) + Math.PI
						/ 2) * 0.0625), 0F);
		Cube6.render(f5);
		GL11.glPopMatrix();
		Cube7.rotateAngleX = (float) (Math.PI / 4);
		Cube7.rotateAngleZ = (float) (Math.PI / 4);
		Cube7.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation)) * 0.0625),
				0F);
		Cube7.render(f5);
		GL11.glPopMatrix();
		Cube8.rotateAngleX = (float) (Math.PI / 4);
		Cube8.rotateAngleZ = (float) (Math.PI / 4);
		Cube8.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation) - Math.PI
						/ 2) * 0.0625), 0F);
		Cube8.render(f5);
		GL11.glPopMatrix();
		Cube9.rotateAngleX = (float) (Math.PI / 4);
		Cube9.rotateAngleZ = (float) (Math.PI / 4);
		Cube9.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation)) * 0.0625),
				0F);
		Cube9.render(f5);
		GL11.glPopMatrix();
		Cube10.rotateAngleX = (float) (Math.PI / 4);
		Cube10.rotateAngleZ = (float) (Math.PI / 4);
		Cube10.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation) - Math.PI
						/ 2) * 0.0625), 0F);
		Cube10.render(f5);
		GL11.glPopMatrix();
		Cube11.rotateAngleX = (float) (Math.PI / 4);
		Cube11.rotateAngleZ = (float) (Math.PI / 4);
		Cube11.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation)) * 0.0625),
				0F);
		Cube11.render(f5);
		GL11.glPopMatrix();
		Cube12.rotateAngleX = (float) (Math.PI / 4);
		Cube12.rotateAngleZ = (float) (Math.PI / 4);
		Cube12.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation) + Math.PI
						/ 2) * 0.0625), 0F);
		Cube12.render(f5);
		GL11.glPopMatrix();
		Cube13.rotateAngleX = (float) (Math.PI / 4);
		Cube13.rotateAngleZ = (float) (Math.PI / 4);
		Cube13.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation)) * 0.0625),
				0F);
		Cube13.render(f5);
		GL11.glPopMatrix();
		Cube14.rotateAngleX = (float) (Math.PI / 4);
		Cube14.rotateAngleZ = (float) (Math.PI / 4);
		Cube14.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation) - Math.PI
						/ 2) * 0.0625), 0F);
		Cube14.render(f5);
		GL11.glPopMatrix();
		Cube15.rotateAngleX = (float) (Math.PI / 4);
		Cube15.rotateAngleZ = (float) (Math.PI / 4);
		Cube15.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation)) * 0.0625),
				0F);
		Cube15.render(f5);
		GL11.glPopMatrix();
		Cube16.rotateAngleX = (float) (Math.PI / 4);
		Cube16.rotateAngleZ = (float) (Math.PI / 4);
		Cube16.rotateAngleY = (float) Math.toRadians(entity.cubeRotation);
		GL11.glPushMatrix();
		GL11.glTranslatef(
				0F,
				(float) (Math.sin(Math.toRadians(entity.cubeRotation) + Math.PI
						/ 2) * 0.0625), 0F);
		Cube16.render(f5);
		GL11.glPopMatrix();
	}
}
