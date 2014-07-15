package com.elveskevtar.helix.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.elveskevtar.helix.tileentity.TileEntityHydrogenBondFacilitator;

public class ContainerHydrogenBondFacilitator extends Container {

	private EntityPlayer player;
	private TileEntityHydrogenBondFacilitator entity;

	public ContainerHydrogenBondFacilitator(InventoryPlayer inventoryPlayer,
			TileEntityHydrogenBondFacilitator entity) {
		this.player = inventoryPlayer.player;
		this.entity = entity;
		this.addSlotToContainer(new Slot(entity, 0, 0, 0));
		this.addSlotToContainer(new Slot(entity, 1, 20, 0));
		this.addSlotToContainer(new Slot(entity, 2, 40, 0));
		this.addSlotToContainer(new Slot(entity, 3, 60, 0));
		this.addSlotToContainer(new Slot(entity, 4, 80, 0));
		this.addSlotToContainer(new Slot(entity, 5, 100, 0));
		this.addSlotToContainer(new FacilitatorSlot(entity, 6, 0, 20));
		this.bindPlayerInventory(inventoryPlayer);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
						8 + j * 18, 84 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return false;
	}

	private class FacilitatorSlot extends Slot {

		private int amountCrafted;

		public FacilitatorSlot(IInventory par1iInventory, int par2, int par3,
				int par4) {
			super(par1iInventory, par2, par3, par4);
		}

		@Override
		public boolean isItemValid(ItemStack stack) {
			return false;
		}

		@Override
		public ItemStack decrStackSize(int par1) {
			if (getHasStack())
				amountCrafted += Math.min(par1, getStack().stackSize);
			return super.decrStackSize(par1);
		}

		@Override
		public void onCrafting(ItemStack itemStack, int par1) {
			amountCrafted += par1;
			onCrafting(itemStack);
		}

		public void onCrafting(ItemStack itemstack) {
			itemstack.onCrafting(player.worldObj, player, amountCrafted);
			amountCrafted = 0;
		}
	}
}
