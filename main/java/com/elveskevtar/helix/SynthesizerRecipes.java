package com.elveskevtar.helix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class SynthesizerRecipes {
	private static final SynthesizerRecipes synthesizingBase = new SynthesizerRecipes();
	private Map synthesizingList = new HashMap();
	private Map productList = new HashMap();
	private static final String __OBFID = "CL_00000085";

	public static SynthesizerRecipes synthesizing() {
		return synthesizingBase;
	}

	private SynthesizerRecipes() {
		Item item = new Item();
		ItemStack lapis = new ItemStack(Items.dye);
		item.setDamage(lapis, 4);
		addRecipe(new ItemStack(Items.redstone), lapis, new ItemStack(
				Helix.adenine));
		addRecipe(new ItemStack(Items.redstone), lapis, new ItemStack(
				Helix.guanine));
		addRecipe(new ItemStack(Items.redstone), lapis, new ItemStack(
				Helix.cytosine));
		addRecipe(new ItemStack(Items.redstone), lapis, new ItemStack(
				Helix.thymine));
	}

	public void addRecipe(ItemStack reactant1, ItemStack reactant2,
			ItemStack product) {
		synthesizingList.put(reactant1, reactant2);
		productList.put(product, productList.size());
	}

	public ItemStack getSynthesizingResult(ItemStack reactant1,
			ItemStack reactant2) {
		ArrayList<ItemStack> products = new ArrayList<ItemStack>();
		Iterator iterator = synthesizingList.entrySet().iterator();
		Entry entry = null;
		Integer j = 0;
		do {
			if (!iterator.hasNext()) {
				break;
			}
			entry = (Entry) iterator.next();
			if (sameStacks(reactant1, (ItemStack) entry.getKey())
					&& sameStacks(reactant2, (ItemStack) entry.getValue())) {
				for (int i = 0; i < productList.keySet().toArray().length; i++) {
					if (productList.values().toArray()[i] == j) {
						products.add((ItemStack) (productList.keySet()
								.toArray()[i]));
					}
				}
			}
			j++;
		} while (true);
		if (products.size() != 0)
			return products.get((int) (Math.random() * products.size()));
		else
			return null;
	}

	private boolean sameStacks(ItemStack reactant, ItemStack mapValue) {
		return mapValue.getItem() == reactant.getItem()
				&& (mapValue.getItemDamage() == 32767 || mapValue
						.getItemDamage() == reactant.getItemDamage());
	}

	public Map getSynthesizinglist() {
		return synthesizingList;
	}
}