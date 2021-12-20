package gl.lab.denominations;

public class SortDenominations {
	// using merge sort algorithm to sort denominations
	
	public void sortDescending(int[] ary, int lft, int right) {
		
		if (lft < right) {
			int mid = (lft + right)/2;
			sortDescending(ary, lft, mid);
			sortDescending(ary, mid+1, right);
			
			msMerge(ary, lft, mid, right);
		}
	}
	
	private void msMerge(int[] ary, int lh, int mid, int rh) {
		
		int lhLn = mid - lh + 1;
		int rhLn = rh - mid;
		
		int[] lhAry = new int[lhLn];
		int[] rhAry = new int[rhLn];
				
		
		for (int i = 0; i < lhLn; i++)
			lhAry[i] = ary[lh + i];
		for (int j = 0; j < rhLn; j++)
			rhAry[j] = ary[mid + 1 + j];
		
		int i, j, k;
		i = 0;
		j = 0;
		k = lh;
		
		while (i < lhLn && j < rhLn) {
			if (lhAry[i] >= rhAry[j]) {	//change
				ary[k] = lhAry[i];
				i++;
			} else {
				ary[k] = rhAry[j];
				j++;
			}
			k++;
		}
		
		while (i < lhLn) {
			ary[k] = lhAry[i];
			i++;
			k++;
		}
		while (j < rhLn) {
			ary[k] = rhAry[j];
			j++;
			k++;
		}
	}
}
