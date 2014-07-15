package com.elveskevtar.helix;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.elveskevtar.helix.block.BlockHydrogenBondFacilitator;
import com.elveskevtar.helix.block.BlockNucleotideSynthesizer;
import com.elveskevtar.helix.nucleotide.ItemAdenine;
import com.elveskevtar.helix.nucleotide.ItemCytosine;
import com.elveskevtar.helix.nucleotide.ItemGuanine;
import com.elveskevtar.helix.nucleotide.ItemNucleotide;
import com.elveskevtar.helix.nucleotide.ItemThymine;
import com.elveskevtar.helix.tileentity.TileEntityHydrogenBondFacilitator;
import com.elveskevtar.helix.tileentity.TileEntityHydrogenBondFacilitatorRenderer;
import com.elveskevtar.helix.tileentity.TileEntityNucleotideSynthesizer;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Helix.MODID, version = Helix.VERSION)
public class Helix {
	@Instance(value = Helix.MODID)
	public static Helix instance;

	public static final String MODID = "helixmod";
	public static final String VERSION = "0.1";

	public static HelixAchievementPage achievementPage;
	public static Achievement synAchievement;
	public static Achievement nucleotideGet;

	public static ItemNucleotide adenine;
	public static ItemNucleotide guanine;
	public static ItemNucleotide cytosine;
	public static ItemNucleotide thymine;

	public static BlockNucleotideSynthesizer synthesizer;
	public static BlockHydrogenBondFacilitator facilitator;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		adenine = new ItemAdenine();
		guanine = new ItemGuanine();
		cytosine = new ItemCytosine();
		thymine = new ItemThymine();
		synthesizer = new BlockNucleotideSynthesizer(Material.iron);
		facilitator = new BlockHydrogenBondFacilitator(Material.iron);
		adenine.setTextureName("helixmod:adenine");
		guanine.setTextureName("helixmod:guanine");
		cytosine.setTextureName("helixmod:cytosine");
		thymine.setTextureName("helixmod:thymine");
		synthesizer.setHardness(1.0F).setStepSound(Block.soundTypeMetal)
				.setBlockName("nucleotideSynthesizer")
				.setCreativeTab(CreativeTabs.tabBlock);
		facilitator.setHardness(1.0F).setStepSound(Block.soundTypeMetal)
				.setBlockName("hydrogenBondFacilitator")
				.setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerItem(adenine, "adenine");
		GameRegistry.registerItem(guanine, "guanine");
		GameRegistry.registerItem(cytosine, "cytosine");
		GameRegistry.registerItem(thymine, "thymine");
		GameRegistry.registerBlock(synthesizer, "nucleotideSynthesizer");
		GameRegistry.registerBlock(facilitator, "hydrogenBondFacilitator");
		GameRegistry.registerTileEntity(TileEntityNucleotideSynthesizer.class,
				"0");
		ClientRegistry.registerTileEntity(
				TileEntityHydrogenBondFacilitator.class, "1",
				new TileEntityHydrogenBondFacilitatorRenderer());
		GameRegistry.addShapedRecipe(new ItemStack(Helix.synthesizer),
				new Object[] { "OGO", "BDB", "OGO", 'O', Blocks.obsidian, 'G',
						Blocks.glass, 'B', Blocks.iron_block, 'D',
						Items.diamond });
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		synAchievement = new Achievement("achievement.synAchievement",
				"synAchievement", 0, 0, synthesizer, null).registerStat();
		nucleotideGet = new Achievement("achievement.nucleotideGet",
				"nucleotideGet", 2, 0, adenine, synAchievement).registerStat();
		achievementPage = new HelixAchievementPage("Helix", new Achievement[] {
				synAchievement, nucleotideGet });
		AchievementPage.registerAchievementPage(achievementPage);
		FMLCommonHandler.instance().bus().register(new HelixEvents());
	}
}
