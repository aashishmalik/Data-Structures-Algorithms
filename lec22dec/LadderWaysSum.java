package lec22dec;

import java.util.ArrayList;

public class LadderWaysSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getBoardPath(0,10));
	}

	public static ArrayList<String> getBoardPath(int current,int end)
	{
		if(current==end)
		{
			ArrayList<String> br =new ArrayList<>();
			br.add("");
			return br;
		}
		if(current>=end)
		{
			ArrayList<String> br =new ArrayList<>();
			return br;
		}
		
		ArrayList<String> mr=new ArrayList<>(); //my  result
		for(int dice=1;dice<=6;dice++) {
			ArrayList<String> rr= getBoardPath(current + dice,end);
			for(String val:rr) {
			mr.add(dice+val);
			}
		}
		return mr;
}
}
