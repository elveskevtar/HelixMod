package com.elveskevtar.helix.tileentity;

import com.elveskevtar.helix.SynthesizerRecipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityNucleotideSynthesizer extends TileEntity implements
		ISidedInventory {
	
	public ItemStack[] itemStacks = new ItemStack[4];

	public int currentItemBurnTime;
	public int burnTime;
	public int cookTime;

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
		if (itemStacks[par1] != null) {
			ItemStack itemstack;
			if (itemStacks[par1].stackSize <= par2) {
				itemstack = itemStacks[par1];
				itemStacks[par1] = null;
				return itemstack;
			} else {
				itemstack = itemStacks[par1].splitStack(par2);
				if (itemStacks[par1].stackSize == 0) {
					itemStacks[par1] = null;
				}
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		if (itemStacks[var1] != null) {
			ItemStack itemstack = itemStacks[var1];
			itemStacks[var1] = null;
			return itemstack;
		} else {
			return null;
		}
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
		return "Nucleotide Synthesizer";
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

	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int var) {
		return cookTime * var / 200;
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int var) {
		if (currentItemBurnTime == 0) {
			currentItemBurnTime = 200;
		}
		return burnTime * var / currentItemBurnTime;
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

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList nbttaglist = compound.getTagList("Items", 10);
		itemStacks = new ItemStack[getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");
			if (b0 >= 0 && b0 < itemStacks.length) {
				itemStacks[b0] = ItemStack
						.loadItemStackFromNBT(nbttagcompound1);
			}
		}
		burnTime = compound.getShort("BurnTime");
		cookTime = compound.getShort("CookTime");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setShort("BurnTime", (short) burnTime);
		compound.setShort("CookTime", (short) cookTime);
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < itemStacks.length; ++i) {
			if (itemStacks[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				itemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		compound.setTag("Items", nbttaglist);
	}

	@Override
	public void updateEntity() {
		boolean flag = burnTime > 0;
		boolean flag1 = false;
		if (burnTime > 0) {
			--burnTime;
		}
		if (!worldObj.isRemote) {
			if (burnTime == 0 && canSynthesize()) {
				currentItemBurnTime = burnTime = getItemBurnTime(itemStacks[2]);
				if (burnTime > 0) {
					flag1 = true;
					if (itemStacks[2] != null) {
						--itemStacks[2].stackSize;
						if (itemStacks[2].stackSize == 0) {
							itemStacks[2] = itemStacks[2].getItem()
									.getContainerItem(itemStacks[2]);
						}
					}
				}
			}
			if (burnTime > 0 && canSynthesize()) {
				++cookTime;
				if (cookTime == 200) {
					cookTime = 0;
					synthesize();
					flag1 = true;
				}
			} else {
				cookTime = 0;
			}
			if (flag != burnTime > 0) {
				flag1 = true;
				validate();
				worldObj.setTileEntity(xCoord, yCoord, zCoord, this);
			}
		}
		if (flag1) {
			markDirty();
		}
	}

	public boolean canSynthesize() {
		if (itemStacks[0] == null || itemStacks[1] == null) {
			return false;
		} else {
			ItemStack itemstack = SynthesizerRecipes.synthesizing()
					.getSynthesizingResult(itemStacks[0], itemStacks[1]);
			if (itemstack == null)
				return false;
			if (itemStacks[3] == null)
				return true;
			if (!itemStacks[3].isItemEqual(itemstack)) {
				for (int i = 0; i < 20; i++) {
					itemstack = SynthesizerRecipes
							.synthesizing()
							.getSynthesizingResult(itemStacks[0], itemStacks[1]);
					if (itemStacks[3].isItemEqual(itemstack)) {
						int result = itemStacks[3].stackSize
								+ itemstack.stackSize;
						return result <= getInventoryStackLimit()
								&& result <= itemStacks[3].getMaxStackSize();
					}
				}
				return false;
			}
			int result = itemStacks[3].stackSize + itemstack.stackSize;
			return result <= getInventoryStackLimit()
					&& result <= itemStacks[3].getMaxStackSize();
		}
	}

	public static int getItemBurnTime(ItemStack itemstack) {
		if (itemstack == null) {
			return 0;
		} else {
			Item item = itemstack.getItem();
			if (item instanceof ItemBlock
					&& Block.getBlockFromItem(item) != Blocks.air) {
				Block block = Block.getBlockFromItem(item);
				if (block == Blocks.wooden_slab) {
					return 50;
				}
				if (block.getMaterial() == Material.wood) {
					return 100;
				}
				if (block == Blocks.coal_block) {
					return 4000;
				}
			}
			if (item instanceof ItemTool
					&& ((ItemTool) item).getToolMaterialName().equals("WOOD"))
				return 50;
			if (item instanceof ItemSword
					&& ((ItemSword) item).getToolMaterialName().equals("WOOD"))
				return 50;
			if (item instanceof ItemHoe
					&& ((ItemHoe) item).getToolMaterialName().equals("WOOD"))
				return 50;
			if (item == Items.stick)
				return 25;
			if (item == Items.coal)
				return 400;
			if (item == Items.lava_bucket)
				return 5000;
			if (item == Item.getItemFromBlock(Blocks.sapling))
				return 25;
			if (item == Items.blaze_rod)
				return 800;
			return 0;
		}
	}

	public void synthesize() {
		if (canSynthesize()) {
			ItemStack itemstack = SynthesizerRecipes.synthesizing()
					.getSynthesizingResult(itemStacks[0], itemStacks[1]);
			if (itemStacks[3] == null) {
				itemStacks[3] = itemstack.copy();
			} else if (itemStacks[3].getItem() == itemstack.getItem()) {
				itemStacks[3].stackSize += itemstack.stackSize;
			} else {
				for (int i = 0; i < 20; i++) {
					itemstack = SynthesizerRecipes
							.synthesizing()
							.getSynthesizingResult(itemStacks[0], itemStacks[1]);
					if (itemStacks[3].getItem() == itemstack.getItem()) {
						itemStacks[3].stackSize += itemstack.stackSize;
						break;
					}
				}
			}
			--itemStacks[0].stackSize;
			--itemStacks[1].stackSize;
			if (itemStacks[0].stackSize <= 0) {
				itemStacks[0] = null;
			}
			if (itemStacks[1].stackSize <= 0) {
				itemStacks[1] = null;
			}
		}
	}
}
