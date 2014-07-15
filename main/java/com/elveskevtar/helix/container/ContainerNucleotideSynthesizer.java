package com.elveskevtar.helix.container;

import com.elveskevtar.helix.Helix;
import com.elveskevtar.helix.nucleotide.ItemNucleotide;
import com.elveskevtar.helix.tileentity.TileEntityNucleotideSynthesizer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerNucleotideSynthesizer extends Container {

	private TileEntityNucleotideSynthesizer entity;

	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;

	public ContainerNucleotideSynthesizer(InventoryPlayer inventoryPlayer,
			TileEntityNucleotideSynthesizer entity) {
		this.entity = entity;
		this.addSlotToContainer(new Slot(entity, 0, 29, 17));
		this.addSlotToContainer(new Slot(entity, 1, 58, 17));
		this.addSlotToContainer(new Slot(entity, 2, 44, 53));
		this.addSlotToContainer(new NucleotideSynthesizerSlot(entity, 3, 128,
				35));
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

	public void addCraftingToCrafters(ICrafting par1ICrafting) {
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, entity.cookTime);
		par1ICrafting.sendProgressBarUpdate(this, 1, entity.burnTime);
		par1ICrafting
				.sendProgressBarUpdate(this, 2, entity.currentItemBurnTime);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) crafters.get(i);
			if (lastCookTime != entity.cookTime) {
				icrafting.sendProgressBarUpdate(this, 0, entity.cookTime);
			}
			if (lastBurnTime != entity.burnTime) {
				icrafting.sendProgressBarUpdate(this, 1, entity.burnTime);
			}
			if (lastItemBurnTime != entity.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2,
						entity.currentItemBurnTime);
			}
		}
		lastCookTime = entity.cookTime;
		lastBurnTime = entity.burnTime;
		lastItemBurnTime = entity.currentItemBurnTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			entity.cookTime = par2;
		}
		if (par1 == 1) {
			entity.burnTime = par2;
		}
		if (par1 == 2) {
			entity.currentItemBurnTime = par2;
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);
		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();
			Item item = new Item();
			ItemStack lapis = new ItemStack(Items.dye);
			item.setDamage(lapis, 4);
			Item lapisItem = lapis.getItem();
			if (slot < 4) {
				if (!mergeItemStack(stackInSlot, 31, 40, false)
						&& !mergeItemStack(stackInSlot, 4, 31, false)) {
					return null;
				}
			} else if (stackInSlot.getItem() == Items.redstone) {
				if (!mergeItemStack(stackInSlot, 0, 1, false)) {
					return null;
				}
			} else if (stackInSlot.getItem() == lapisItem) {
				if (!mergeItemStack(stackInSlot, 1, 2, false)) {
					return null;
				}
			} else if (entity.getItemBurnTime(stackInSlot) > 0) {
				if (!mergeItemStack(stackInSlot, 2, 3, false)) {
					return null;
				}
			} else if (slot >= 31 && !mergeItemStack(stackInSlot, 4, 31, false)) {
				return null;
			} else if (slot < 31 && !mergeItemStack(stackInSlot, 31, 40, false)) {
				return null;
			}
			if (stackInSlot.stackSize == 0) {
				slotObject.putStack(null);
			} else {
				slotObject.onSlotChanged();
			}
			if (stackInSlot.stackSize == stack.stackSize) {
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return entity.isUseableByPlayer(var1);
	}

	private class NucleotideSynthesizerSlot extends Slot {

		public NucleotideSynthesizerSlot(IInventory par1iInventory, int par2,
				int par3, int par4) {
			super(par1iInventory, par2, par3, par4);
		}

		@Override
		public boolean isItemValid(ItemStack stack) {
			return false;
		}

		@Override
		public void onPickupFromSlot(EntityPlayer player, ItemStack itemstack) {
			if (itemstack.getItem() instanceof ItemNucleotide)
				player.triggerAchievement(Helix.nucleotideGet);
		}
	}
}
