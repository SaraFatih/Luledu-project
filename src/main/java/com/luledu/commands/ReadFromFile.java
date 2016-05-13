package com.luledu.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class ReadFromFile extends CommandBase{
	
	public static int counter;
	
	public int getCounter(){
		return counter;
	}
	
	@Override
	public String getCommandName() {
		return "readFile";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/readFile <question>";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		counter=0;
		//String csvFile = "/Users/home/Downloads/forge-latest/src/main/resources/assets/sara_mymod/homeworkFiles/" + args[0] +".csv";
		String currentUsersHomeDir = System.getProperty("user.home");
		String csvFile = currentUsersHomeDir + "/Downloads/" + args[0] +".csv";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				int s;
				int a;
				String[] questions = line.split(csvSplitBy);
				for(s=1;s<questions.length;s++){
					String[] questionArray = new String[100];
					
					for(a=0;a<questions[s].length();a++){
						
						char c = questions[s].charAt(a);
						if (c != ' ') {
							questionArray[a]= String.valueOf(c);
						}
					}
					
					ShowBlocks mine = new ShowBlocks();
					mine.processCommand(sender, questionArray);
					counter=counter+1;
			}
				
				
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}

}
