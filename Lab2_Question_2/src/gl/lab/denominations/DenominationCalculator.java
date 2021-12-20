package gl.lab.denominations;

import java.util.Scanner;

/** This class helps the user to identify minimum number of denominations required for 
 * as amount. It lets the user to feed-in the denominations initially and enter the required 
 * amount. It uses the 'Scanner' and 'SortDenominations' classes as well.
 */
public class DenominationCalculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SortDenominations sd = new SortDenominations();
		
		//Gets the total number of denominations from user and creates 2 arrays
		//one for storing denominations and other for storing qty of respective denominations
		System.out.println("Enter the size of currency denominations ");
		int denomSize = sc.nextInt();
		int[] denominations = new int[denomSize];
		int[] denoQty = new int[denomSize];
		
		//receives denominations to the array
		System.out.println("Enter the currency denominations value ");
		for (int i = 0; i < denomSize; i++) {
			denominations[i] = sc.nextInt();
		}
		
		//sorting array in descending order
		sd.sortDescending(denominations, 0, denominations.length-1);

		//gets amount from user to find denominations
		System.out.println("Enter the amount you want to pay ");
		int amount = sc.nextInt();
		
		int count, balance,calculated = 0;
		
		/*looping through the array, starting from the biggest element
		* and finds the max qty of each denomination required to meet the mentioned amount.
		* the qty is stored to denoQty array
		*/
		for (int i = 0; i < denominations.length; i++) {
			balance = amount - calculated;
			count = 0;
			if (denominations[i] > 0) {
				count = balance / denominations[i];
				calculated = calculated + (denominations[i]*count);
				denoQty[i] = count;
			}
			if(calculated >= amount) {
				break;
			}
		}
		
		//printing denominations: if it could find exact denomination for the required amount,
		//it prints. else says 'can't get exact denomination'.
		if (calculated == amount) {
			for(int i = 0; i < denoQty.length; i++) {
				if(denoQty[i] > 0) {
					System.out.println(denominations[i] + " : " + denoQty[i]);
				}
			}
		}else {
			System.out.println("Can't get exact denominations!");
		}
		
		sc.close();
	}
}
