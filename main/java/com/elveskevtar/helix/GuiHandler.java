package com.elveskevtar.helix;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.elveskevtar.helix.container.ContainerHydrogenBondFacilitator;
import com.elveskevtar.helix.container.ContainerNucleotideSynthesizer;
import com.elveskevtar.helix.gui.GUIHydrogenBondFacilitator;
import com.elveskevtar.helix.gui.GUINucleotideSynthesizer;
import com.elveskevtar.helix.tileentity.TileEntityHydrogenBondFacilitator;
import com.elveskevtar.helix.tileentity.TileEntityNucleotideSynthesizer;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityNucleotideSynthesizer) {
			return new ContainerNucleotideSynthesizer(player.inventory,
					(TileEntityNucleotideSynthesizer) tileEntity);
		} else if (tileEntity instanceof TileEntityHydrogenBondFacilitator) {
			return new ContainerHydrogenBondFacilitator(player.inventory,
					(TileEntityHydrogenBondFacilitator) tileEntity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityNucleotideSynthesizer) {
			return new GUINucleotideSynthesizer(player.inventory,
					(TileEntityNucleotideSynthesizer) tileEntity);
		} else if (tileEntity instanceof TileEntityHydrogenBondFacilitator) {
			return new GUIHydrogenBondFacilitator(player.inventory,
					(TileEntityHydrogenBondFacilitator) tileEntity);
		}
		return null;
	}
}
