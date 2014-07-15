package com.elveskevtar.helix.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityHydrogenBondFacilitator extends TileEntity implements
		ISidedInventory {

	public ItemStack[] itemStacks = new ItemStack[7];

	public float cubeRotation;
	public int texture;

	public TileEntityHydrogenBondFacilitator() {
		this.cubeRotation = 0;
	}

	@Override
	public void updateEntity() {
		cubeRotation += 32;
		if (cubeRotation >= 360)
			cubeRotation = 0;
		if (cubeRotation % 2 == 0)
			texture++;
	}

	@Override
	public int getSizeInventory() {
		return itemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return itemStacks[var1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.itemStacks[par1] != null) {
			ItemStack itemstack;
			if (this.itemStacks[par1].stackSize <= par2) {
				itemstack = this.itemStacks[par1];
				this.itemStacks[par1] = null;
				return itemstack;
			} else {
				itemstack = this.itemStacks[par1].splitStack(par2);
				if (this.itemStacks[par1].stackSize == 0) {
					this.itemStacks[par1] = null;
				}
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		itemStacks[var1] = var2;
		if (var2 != null && var2.stackSize > getInventoryStackLimit()) {
			var2.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return "Hydrogen Bond Facilitator";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false
				: var1.getDistanceSq((double) xCoord + 0.5D,
						(double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return null;
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack var2, int var3) {
		return isItemValidForSlot(var1, var2);
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack var2, int var3) {
		return false;
	}
}
