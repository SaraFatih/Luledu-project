package com.luledu.blocks;

import com.luledu.edumod.AddAssignment;
import com.luledu.edumod.EduMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TileEntityVisitor extends TileEntity {

	public String assignmentText = "Nothing";
    public void processActivate(EntityPlayer par5EntityPlayer, World world) {
            world.notifyBlockChange(xCoord, yCoord, zCoord, EduMod.bookBlock);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound nbt)
{
    super.readFromNBT(nbt);
    this.assignmentText = nbt.getString("assignmentText");
}

@Override
public void writeToNBT(NBTTagCompound nbt)
{
    super.writeToNBT(nbt);
    nbt.setString("assignmentText",assignmentText);
}
	
	
	
}
