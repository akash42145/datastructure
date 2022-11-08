package com.exam.lowestcommonmanager.up;

import java.util.Arrays;

public class LowestCommonManagerUP {

	public static void main(String[] args) {

		EmployeeTree top = buildEmployeeTree();

		System.out.println("Lowestcommon Manager for M and V = > Expected is: E and Actual is: "
				+ findCommonManager(top, new EmployeeTree("M"), new EmployeeTree("V")).getManager().getName());
		
		System.out.println("Lowestcommon Manager for L and F = > Expected is: B and Actual is: "
				+ findCommonManager(top, new EmployeeTree("L"), new EmployeeTree("F")).getManager().getName());
		
		System.out.println("Lowestcommon Manager for N and S = > Expected is: F and Actual is: "
				+ findCommonManager(top, new EmployeeTree("N"), new EmployeeTree("S")).getManager().getName());
		
		System.out.println("Lowestcommon Manager for H and J = > Expected is: A and Actual is: "
				+ findCommonManager(top, new EmployeeTree("H"), new EmployeeTree("J")).getManager().getName());
		
		System.out.println("Lowestcommon Manager for J and K = > Expected is: D and Actual is: "
				+ findCommonManager(top, new EmployeeTree("J"), new EmployeeTree("K")).getManager().getName());
		
		System.out.println("Lowestcommon Manager for H and C = > Expected is: H and Actual is: "
				+ findCommonManager(top, new EmployeeTree("H"), new EmployeeTree("C")).getManager().getName());


	}

	private static ManagerResult findCommonManager(EmployeeTree top, EmployeeTree one, EmployeeTree two) {

		int noOfSearchReports = 0;

		EmployeeTree lowestCommonMgr = null;

		for (EmployeeTree e : top.directReportees) {
			ManagerResult common = findCommonManager(e, one, two);

			if (common.getNoOfSearchReportsFoundInTree() == 2) {
				return common;
			}

			noOfSearchReports = noOfSearchReports + common.getNoOfSearchReportsFoundInTree();
		}		

		if (top.getName().equals(one.getName()) || top.getName().equals(two.getName())) {
			noOfSearchReports++;
		}
		
		if (noOfSearchReports == 2) {
			lowestCommonMgr = top;

		}

		return new ManagerResult(noOfSearchReports, lowestCommonMgr);
	}

	private static class ManagerResult {

		private int noOfSearchReportsFoundInTree;

		private EmployeeTree manager;

		public ManagerResult(int noOfSearchReportsFoundInTree, EmployeeTree manager) {

			this.noOfSearchReportsFoundInTree = noOfSearchReportsFoundInTree;
			this.manager = manager;
		}

		public int getNoOfSearchReportsFoundInTree() {
			return noOfSearchReportsFoundInTree;
		}

		public EmployeeTree getManager() {
			return manager;
		}

		@Override
		public String toString() {
			return "noOfSearchReportsFoundInTree=" + noOfSearchReportsFoundInTree + ", manager=" + manager;
		}

	}
	
	/*
	 *                            A
	 *                         /  |  \
	 *                        /   |   \
	 *                       /    |    \
	 *                      /     |     \
	 *                    B       C      D
	 *                 /  |  \   / \    / \
	 *               E    F   G  H  I  J   K
	 *            /   \  / \   \
	 *           L    M  N  O   P
	 *          / \          \
	 *         Q   R          S
	 *            / \
	 *           U   V 
	 *               
	 * 
	 * Approach : Iterate through each direct reports sub tree and search whether reportees found, If found the increment the count 
	 * if both reportees found then return the result to calling.
	 * 
	 */

	private static EmployeeTree buildEmployeeTree() {
		EmployeeTree top = new EmployeeTree("A");

		EmployeeTree B = new EmployeeTree("B");
		EmployeeTree C = new EmployeeTree("C");
		EmployeeTree D = new EmployeeTree("D");

		top.addDirectReportees(Arrays.asList(B, C, D));

		EmployeeTree E = new EmployeeTree("E");
		EmployeeTree F = new EmployeeTree("F");
		EmployeeTree G = new EmployeeTree("G");

		B.addDirectReportees(Arrays.asList(E, F, G));

		EmployeeTree H = new EmployeeTree("H");
		EmployeeTree I = new EmployeeTree("I");
		C.addDirectReportees(Arrays.asList(H, I));

		EmployeeTree J = new EmployeeTree("J");
		EmployeeTree K = new EmployeeTree("K");
		D.addDirectReportees(Arrays.asList(J, K));

		EmployeeTree L = new EmployeeTree("L");
		EmployeeTree M = new EmployeeTree("M");
		E.addDirectReportees(Arrays.asList(L, M));

		EmployeeTree N = new EmployeeTree("N");
		EmployeeTree O = new EmployeeTree("O");
		F.addDirectReportees(Arrays.asList(N, O));

		EmployeeTree P = new EmployeeTree("P");
		G.addDirectReportees(Arrays.asList(P));

		EmployeeTree Q = new EmployeeTree("Q");
		EmployeeTree R = new EmployeeTree("R");
		L.addDirectReportees(Arrays.asList(Q, R));

		EmployeeTree U = new EmployeeTree("U");
		EmployeeTree V = new EmployeeTree("V");
		R.addDirectReportees(Arrays.asList(U, V));
		
		EmployeeTree S = new EmployeeTree("S");
		O.addDirectReportees(Arrays.asList(S));

		return top;
	}

}
