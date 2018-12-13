package karunyatest1;

import java.util.ArrayList;

public class ArrayListAsiignment {
	int i;

	public static void main(String[] args) {
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("white");
		alist.add("orange");
		alist.add("red");
		alist.add("yellow");
		alist.add("green");

		for (String t : alist)
		{
			System.out.println(t);
		}
		 
        
		
		  System.out.println("Have Dinner in a restaurant." + alist.contains ("red")); 
		  } 
		 //System.out.println("Today is Friday.");
		 
	}


// Adding "Steve" at the fourth position
// alist.add(3, "Steve");

// displaying elements
// System.out.println(alist);
