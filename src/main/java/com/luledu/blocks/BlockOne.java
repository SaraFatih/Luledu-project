package com.luledu.blocks;

import com.luledu.edumod.EduMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
//import net.minecraftforge.fml.common.registry.GameRegistry;

//import com.sara.myMod.MyMod;

public class BlockOne extends Block{
	String name = "one";
	public BlockOne() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setBlockTextureName(EduMod.MODID+":one");
		setBlockName("one");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setResistance(5F);
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe",2);
		setBlockUnbreakable();
	}
	
	public String getName(){
		return name;
	}
}
