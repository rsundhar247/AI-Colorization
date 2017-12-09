/*
================================================================================================================
Project - Colorization

Class for Colorization Assignment.
================================================================================================================
*/

package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class Colorization {
	
	static int COLOR_GROUPS = 2;
	static int BW_GROUPS = 2;
	static int MAX_INTENSITY = 255;
	static HashMap<ArrayList<Integer>, ArrayList<Integer>> bwToColorMap = new HashMap<ArrayList<Integer>, ArrayList<Integer>>();
	
	public static void main(String[] args) {
		
		Colorization colorization = new Colorization();
		colorization.learnSample();
		colorization.extractData();
	}
	
	public void learnSample() {
	
		String colorPath = "src//data//color.csv";
		String bwPath = "src//data//input.csv";
		
		String colorCurrentLine = "", bwCurrentLine = "";
		FileReader freader = null, freader1 = null; 
		BufferedReader breader = null, breader1 = null;
		
		try {
			freader = new FileReader(colorPath);
			breader = new BufferedReader(freader);
			
			freader1 = new FileReader(bwPath);
			breader1 = new BufferedReader(freader1);
			
			while ((colorCurrentLine = breader.readLine()) != null && (bwCurrentLine = breader1.readLine()) != null) {
				
				
				//Code for clustering
				
				/*String[] colorVal = colorCurrentLine.split(",");
				ArrayList<Integer> colorValues = new ArrayList<Integer>();
				for(int i = 0; i < colorVal.length; i++) {
					colorValues.add(Integer.parseInt(colorVal[i].trim()));
				}
				
				String[] bwVal = bwCurrentLine.split(",");
				ArrayList<Integer> bwValues = new ArrayList<Integer>();
				for(int i = 0; i < bwVal.length; i++) {
					bwValues.add(Integer.parseInt(bwVal[i].trim()));
				}
				
				bwToColorMap.put(bwGroups(bwValues), colorGroups(colorValues));*/
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (breader != null)
					breader.close();
				if (freader != null)
					freader.close();
				if (breader1 != null)
					breader1.close();
				if (freader1 != null)
					freader1.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void extractData() {
		
		String bwPath = "src//data//data.csv";
		String colorPath = "src//data//output.csv";
		
		String bwCurrentLine = "";
		FileReader freader = null; 
		BufferedReader breader = null;
		try {
			RandomAccessFile randomFile = new RandomAccessFile(colorPath, "rw");
			randomFile.setLength(0);
			
			freader = new FileReader(bwPath);
			breader = new BufferedReader(freader);
			
			while ((bwCurrentLine = breader.readLine()) != null) {
				
				
				//code for constructing output data
				
				
				/*bwCurrentLine = bwCurrentLine.toLowerCase();
				String[] bwVal = bwCurrentLine.split(",");
				ArrayList<Integer> bwValues = new ArrayList<Integer>();
				for(int i = 0; i < bwVal.length; i++) {
					bwValues.add(Integer.parseInt(bwVal[i].trim()));
				}
				
				ArrayList<Integer> asd = bwGroups(bwValues);
				ArrayList<Integer> colorValues = bwToColorMap.get(bwGroups(bwValues));
				StringBuffer sb = new StringBuffer();
				if(colorValues == null) {
				
					System.out.println("Skip");
					continue;
				}
				for(int i = 0; i < colorValues.size(); i++) {
					if(i < colorValues.size()-1)
						sb.append(colorValues.get(i)+",");
					else
						sb.append(colorValues.get(i));
				}
				    
				 long fileLength = randomFile.length();
				 randomFile.seek(fileLength);
				 randomFile.writeBytes(sb+"\n");*/
			}
		
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (breader != null)
					breader.close();
				if (freader != null)
					freader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static int calcDist(int[] color1, int[] color2) {
		Double dist = Math.sqrt(( 2 * Math.pow(color1[0] - color2[0],2) + 4 * Math.pow(color1[1] - color2[1],2) + 3 * Math.pow(color1[2] - color2[2],2) ));
		return dist.intValue();
	}
	
	/*public static ArrayList<Integer> colorGroups(ArrayList<Integer> input) {
		ArrayList<Integer> groups = new ArrayList<Integer>();
		int colorRange = (MAX_INTENSITY + 1)/COLOR_GROUPS;
		
		for(int j = 0; j < input.size(); j++) {
			for(int i = 0; i < COLOR_GROUPS; i++) {
				if((i * colorRange) <= input.get(j) && (((i+1) * colorRange) - 1) >= input.get(j)) {
					groups.add((i * colorRange) + ((colorRange - 1)/2));
					break;
				}
			}
		}
		
		return groups;
	}
	
	public static ArrayList<Integer> bwGroups(ArrayList<Integer> input) {
		ArrayList<Integer> groups = new ArrayList<Integer>();
		int bwRange = (MAX_INTENSITY + 1)/BW_GROUPS;
		
		for(int j = 0; j < input.size(); j++) {
			for(int i = 0; i < COLOR_GROUPS; i++) {
				if((i * bwRange) <= input.get(j) && (((i+1) * bwRange) - 1) >= input.get(j)) {
					groups.add((i * bwRange) + ((bwRange - 1)/2));
					break;
				}
			}
		}
		
		return groups;
	}*/
}