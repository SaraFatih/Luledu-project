package com.luledu.blocks;

//import com.sara.myMod.MyMod;

import com.luledu.edumod.EduMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
//import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockDivide extends Block{
	String name = "divide";
	public BlockDivide() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setBlockTextureName(EduMod.MODID+":divide");
		setBlockName("divide");
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
