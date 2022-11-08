package com.exam.lowestcommonmanager.bottom;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {

	public static void main(String[] args) {
		
		//Build Employee Tree
		EmployeeTree B = new EmployeeTree("B");
		EmployeeTree C = new EmployeeTree("C");
		EmployeeTree D =new EmployeeTree("D");
		EmployeeTree E =new EmployeeTree("E");
		EmployeeTree F =new EmployeeTree("F");
		EmployeeTree G =new EmployeeTree("G");
		EmployeeTree H =new EmployeeTree("H");
		EmployeeTree I =new EmployeeTree("I");
		EmployeeTree J =new EmployeeTree("J");
		EmployeeTree K =new EmployeeTree("K");
		EmployeeTree L =new EmployeeTree("L");
		EmployeeTree M =new EmployeeTree("M");
		
		EmployeeTree topManager = buildTree(B,C,D,E,F,G,H,I,J,K,L,M);
		
		//Find Lowest Common Manager
		
		EmployeeTree commonManager = lowestCommonManager(topManager, I, M);
		
		System.out.println(commonManager.getName());

	}

	private static EmployeeTree lowestCommonManager(EmployeeTree topManager, EmployeeTree one, EmployeeTree two) {

		

		if (one == null && two == null)
			return topManager;
		else if (one == null) {
			return two;
		} else if (two == null) {
			return one;
		} else {
			return commonManager(one , two);
		}

		
	}

	private static EmployeeTree commonManager(EmployeeTree one, EmployeeTree two) {
		EmployeeTree lowest = null;
		List<EmployeeTree> oneManagers = new ArrayList<>();

		List<EmployeeTree> twoManagers = new ArrayList<>();
		
		while(one.getReportingManager() != null) {
			oneManagers.add(one.getReportingManager());
			one = one.getReportingManager();
		}
		
		while(two.getReportingManager() != null) {
			twoManagers.add(two.getReportingManager());
			two = two.getReportingManager();
		}
		
		if(oneManagers.size() < twoManagers.size()) {
			 lowest = findManager(oneManagers, twoManagers);
		}
		else {
			lowest = findManager(twoManagers, oneManagers);
		}
		return lowest;
	}

	private static EmployeeTree findManager(List<EmployeeTree> oneManagers, List<EmployeeTree> twoManagers) {
		
		for(EmployeeTree manager : twoManagers) {
			if(oneManagers.contains(manager))
				return manager;
		}
		
		return null;
	}

	/*
	 *                            A
	 *                        /   |   \
	 *                        B   C    D
	 *                       / \  |    |
	 *                      E   F G    H
	 *                     /   / \ \
	 *                    I   J  K  L
	 *                           |
	 *                           M
	 * 
	 */
	private static EmployeeTree buildTree(EmployeeTree B, EmployeeTree C, EmployeeTree D, EmployeeTree E, EmployeeTree F, EmployeeTree G, EmployeeTree H, EmployeeTree I, EmployeeTree J, EmployeeTree K, EmployeeTree L, EmployeeTree M) {
		
		EmployeeTree ceo = new EmployeeTree("A", null);
		
		
		
		ceo.addAsManager(new EmployeeTree[] { B, C, D });

		B.addAsManager(new EmployeeTree[] { E, F });
		C.addAsManager(new EmployeeTree[] { G });
		D.addAsManager(new EmployeeTree[] { H });

		E.addAsManager(new EmployeeTree[] { I });
		F.addAsManager(new EmployeeTree[] { J, K });
		G.addAsManager(new EmployeeTree[] { L });

		K.addAsManager(new EmployeeTree[] { M });

		return ceo;
	}

}
