package com.elveskevtar.helix.nucleotide;

import net.minecraft.creativetab.CreativeTabs;

public class ItemThymine extends ItemNucleotide {

	public ItemThymine() {
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setUnlocalizedName("thymine");
	}
}
