package com.luledu.blocks;

import com.luledu.edumod.EduMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBlack extends Block{

	public static boolean answer;
	String name = "black";
	
	public BlockBlack(){
		
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setBlockTextureName(EduMod.MODID+":black");
		setBlockName("black");
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
