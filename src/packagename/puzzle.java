package packagename;

public class puzzle {
	
	
	public static int detectEquivalentAdjacentPairs(int[][] arr) {
		int dup = 0;
		
		for(int i = 0; i < arr.length; i ++) {
			for(int o = 1; o < arr[i].length; o ++) {
				if(arr[i][o] == arr[i][o-1]) {
					dup++;
				}
			}
		}
		
		return dup;
	}
	
	public static String checkDuplicates(int[][] arr) {
		String huh = "";
		int num = 0;	
		
		
		for(int x = 1; x < 16; x++) {
			num = 0;
			for(int i = 0; i < arr.length; i ++) {
				for(int o = 1; o < arr[i].length; o ++) {
					if(arr[i][o] == x) {
						num++;
					}
				}
			}
			if( num > 1) {
				huh += x + ": " + num + " \n";
			}

		}
		
		return huh;
	}
	
	
	public static int[][] shiftRight(int[][] arr, int shift, int row) {
		int[][] newarr =new int[5][5];
		
		for(int i = 0; i < newarr.length; i ++) {
			for(int o = 0; o < newarr[i].length; o ++) {
				newarr[i][o] = arr[i][o];
			}
		}
		
		for(int j = 0; j < arr[row].length; j++) {
			newarr[row][((j + shift) % 5)] = arr[row][j];
		}
		
		for(int j = 0; j < arr[row].length; j++) {
			arr[row][j] = newarr[row][j];
		}
		
		return arr;
	}
	
	public static int[][] shiftUp(int[][] arr, int shift, int col) {
		int[][] newarr =new int[5][5];
		
		for(int i = 0; i < newarr.length; i ++) {
			for(int o = 0; o < newarr[i].length; o ++) {
				newarr[i][o] = arr[i][o];
			}
		}
		
		for(int j = 0; j < arr[col].length; j++) {
			newarr[((j + shift) % 5)][col] = arr[j][col];
		}
		
		for(int j = 0; j < arr[col].length; j++) {
			arr[j][col] = newarr[j][col];
		}
		
		return arr;
	}
}
