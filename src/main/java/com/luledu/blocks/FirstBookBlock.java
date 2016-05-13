package com.luledu.blocks;

import com.luledu.edumod.EduMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class FirstBookBlock extends BlockContainer{
	String name = "blockBook";
	public FirstBookBlock(int id) {
		super(Material.rock);
		
		GameRegistry.registerBlock(this, name);
		setBlockTextureName(EduMod.MODID+":blockBook");
		setBlockName(name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setResistance(5F);
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe",2);
	}
	
	public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if(!world.isRemote)
        {
                TileEntityVisitor t = (TileEntityVisitor) world.getTileEntity(par2, par3, par4);
                t.processActivate(par5EntityPlayer, world);
                
                EduMod.proxy.openMyGui(t.assignmentText); 
        }
        return true;
    }
	public boolean hasTileEntity(int metadata)
    {
        return true;
    }
        
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		try
        {
            return new TileEntityVisitor();
        }
        catch (Exception var3)
        {
            throw new RuntimeException(var3);
        }
	
	}
	
}
