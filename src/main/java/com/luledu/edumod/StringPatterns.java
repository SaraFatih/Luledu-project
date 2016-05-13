package com.luledu.edumod;

import com.google.common.base.Splitter;

public class StringPatterns {
	public static void main(String [ ] args){
		/*
		String teacherURL="https://docs.google.com/document/d/1lqkIlxzKWEIDPBFcp85ayH3yJVaKGsgZpmBdKtAFx2I/pub";
		String teacherURLextracted = teacherURL.substring(teacherURL.indexOf("d/") + 2, teacherURL.indexOf("/pub"));
		String httpURL = "https://www.googleapis.com/drive/v2/files/" + teacherURLextracted + "?key=AIzaSyBj4N7uYMIE5qkDugddrV_fXhgzx-rW4xE";
		System.out.println(httpURL);
		System.out.println(teacherURLextracted);
		String str = "ABC[ This is the text to be extracted ]";    
		String result = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
		System.out.println(result);
		
		String x = "stackoverflow";
		String [] y = x.split("");
		int i;
		for(i=0;i<y.length;i++){
			System.out.println(y[i]);
			
		}
		*/
		for(final String token : Splitter.fixedLength(4).split("Thequickbrownfoxjumps")){
			
		    System.out.println(token);
		}
	}
}
