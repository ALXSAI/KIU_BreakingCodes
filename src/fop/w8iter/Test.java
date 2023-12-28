package fop.w8iter;

import java.util.Iterator;

public class Test {

	
	public static void main(String[] args)
	{
		String x = "12";
		String x2 = "23";
		int[] x3 = {1,2,3};
		int y = x.hashCode();
		int y2 = x2.hashCode();
		System.out.println(y2);
		x2 += x;
		 y2 = x2.hashCode();
		System.out.println(y);
		System.out.println(y2);
		char[] bak = x2.toCharArray();
		x2 = "";
		for(int i  = 0; i < 2; i++)
		{
			x2 += bak[i];
		}
		 y2 = x2.hashCode();
			System.out.println(y2);
	}
}
