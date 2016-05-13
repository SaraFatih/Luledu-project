package com.luledu.commands;



import com.luledu.edumod.AddAssignment;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ReadText extends CommandBase{

	@Override
	public String getCommandName() {
		return "readText";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/readText";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] p_71515_2_) {
		if(sender instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) sender ;
			//sender.addChatMessage(new ChatComponentText(AddAssignment.text));
		
	}

}
}