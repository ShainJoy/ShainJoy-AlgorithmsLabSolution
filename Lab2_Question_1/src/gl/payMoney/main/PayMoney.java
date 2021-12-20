package gl.payMoney.main;

import java.util.Scanner;

public class PayMoney {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int target, temp;
		
		//transaction array size is received from user and array is created
		System.out.println("Enter size of transaction array ");
		int transSze = sc.nextInt();
		int[] trans = new int[transSze];
		
		//populating values to array received from user
		System.out.println("Enter the values of array ");
		for(int i = 0; i < transSze; i++) {
			trans[i] = sc.nextInt();
		}
		
		//receiving a count from user, how many times the target to be checked
		System.out.println("Enter the total no of targets that needs to be achieved ");
		int noOfTargets = sc.nextInt();
		
		//Loop allows user check target multiple times. If target is achieved
		//it will show in how many transactions or it will show, target is not achieved. 
		for (int i = 0; i < noOfTargets; i++) {
			System.out.println("Enter the value of target ");
			target = sc.nextInt();
			temp = targetMet(trans,target);
			if (temp == -1) {
				System.out.println("Given target is not achieved");
			}else {
				System.out.println("Target achieved after " + temp + " transactions");
			}
			System.out.println();
		}
		sc.close();
	}

	//method accepts transactions array and target as parameter 
	//it checks the target is achieved or not by summing up the elements of array
	//returns position of element if target achieved else -1
	static int targetMet(int[] ary, int target) {
		int sum = 0;
		for(int i =0; i < ary.length; i++) {
			sum += ary[i];
			if (sum >= target) {
				return i+1;
			}
		}
		return -1;
	}

}
