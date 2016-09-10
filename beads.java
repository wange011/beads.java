/*
ID: wange011
PROG: beads
LANG: JAVA
 */


import java.io.*;
import java.util.*;
public class beads {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		
		int N = Integer.parseInt(in.readLine());
		String input = in.readLine();
		
		int totalMax = 0;
		
		char[] beadsNew = new char[N];
		for(int x = 0; x<N; x++){
			int c = x;
			//makes N possible arrays at "break points" and tries every 
			//possible combination for the max number of beads
			for(int j = 0; j<N; j++){
					beadsNew[j] = input.charAt(c % N);
					c++;
			}
		
			int consUp = 1;
			int consDown = 1;
			
			//counts number of consecutive going up
			for(int i = 0; i<N-1; i++){
				
				//if you start with whites
				int whites = 0;
				for(int a = 0; a<N-1; a++){
					if(beadsNew[a] == 'w'){
						whites++;
					}
					else{
						break;
					}
				}
				
				//replaces the whites with the first non-white 
				//unless all the beads are white 
				if(whites < N-1){
					for(int a= 0; a<whites; a++){
						beadsNew[a] = beadsNew[whites+1];
					}
				
				}
				
				//if you don't start with whites
				if(beadsNew[i] == beadsNew[i+1] || beadsNew[i+1] == 'w'){
					//replaces the white with the original non-white
					//since after the whites, the color may be the same
					if(beadsNew[i+1] == 'w'){
						beadsNew[i+1] = beadsNew[i];
					}
					consUp++;
				}	
				
				else{
					break;
				}
				
			}
			
			//counts number of consecutive going down
			for(int i = N-1; i>0; i--){
				
				//if you start with whites
				int whites = 0;
				for(int a = N-1; a>0; a--){
					if(beadsNew[a] == 'w'){
						whites++;
					}
					else{
						break;
					}
				}
				
				//replaces the whites with the first non-white 
				//unless all the beads are white 
				if(whites < N-1){
					for(int a = N-1; a>N-1-whites; a--){
						beadsNew[a] = beadsNew[N-1-whites];
					}
				
				}
				
				//if you don't start with whites
				if(beadsNew[i] == beadsNew[i-1] || beadsNew[i-1] == 'w'){
					//replaces the white with the original non-white
					//since after the whites, the color may be the same
					if(beadsNew[i-1] == 'w'){
						beadsNew[i-1] = beadsNew[i];
					}
					consDown++;
				}
			
				else{
					break;
				}
			
			}
		
		//checks for maximum sum
		int max = 0;	
		if(consUp == N || consDown == N){
			max = N;
		}
		
		else{
			max = consUp + consDown;
		}
		
		if(max > totalMax){
			totalMax = max;
		}
		
		}
		
		
		out.println(totalMax);
		out.close();
		in.close();
		System.exit(0);
	}
	
}	