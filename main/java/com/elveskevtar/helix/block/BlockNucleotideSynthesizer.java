package com.elveskevtar.helix.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.elveskevtar.helix.Helix;
import com.elveskevtar.helix.tileentity.TileEntityNucleotideSynthesizer;

import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNucleotideSynthesizer extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon sides;

	public BlockNucleotideSynthesizer(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int metadata, float what, float these,
			float are) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking())
			return false;
		player.openGui(Helix.instance, 0, world, x, y, z);
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityNucleotideSynthesizer();
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		top = reg.registerIcon("helixmod:synthesizer_top");
		sides = reg.registerIcon("helixmod:synthesizer_side");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 0 || side == 1 ? top : sides;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block,
			int metadata) {
		TileEntityNucleotideSynthesizer entity = (TileEntityNucleotideSynthesizer) world
				.getTileEntity(x, y, z);
		if (entity != null) {
			for (int i1 = 0; i1 < entity.getSizeInventory(); ++i1) {
				ItemStack itemstack = entity.getStackInSlot(i1);

				if (itemstack != null) {
					float f = new Random().nextFloat() * 0.8F + 0.1F;
					float f1 = new Random().nextFloat() * 0.8F + 0.1F;
					float f2 = new Random().nextFloat() * 0.8F + 0.1F;

					while (itemstack.stackSize > 0) {
						int j1 = new Random().nextInt(21) + 10;

						if (j1 > itemstack.stackSize) {
							j1 = itemstack.stackSize;
						}
						itemstack.stackSize -= j1;
						EntityItem entityitem = new EntityItem(world,
								(double) ((float) x + f),
								(double) ((float) y + f1),
								(double) ((float) z + f2), new ItemStack(
										itemstack.getItem(), j1,
										itemstack.getItemDamage()));
						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound(
									(NBTTagCompound) itemstack.getTagCompound()
											.copy());
						}
						float f3 = 0.05F;
						entityitem.motionX = (double) ((float) new Random()
								.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) new Random()
								.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double) ((float) new Random()
								.nextGaussian() * f3);
						world.spawnEntityInWorld(entityitem);
					}
				}
			}
			world.func_147453_f(x, y, z, block);
		}
		super.breakBlock(world, x, y, z, block, metadata);
	}
}