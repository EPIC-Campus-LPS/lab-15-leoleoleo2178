package packagename;
import java.util.Random;
public class puzzlerunner {

	public static void main(String[] args) {
		Random random = new Random();
		int[][] bored = new int[5][5];
		
		for(int i = 0; i < bored.length; i ++) {
			for(int o = 0; o < bored[i].length; o ++) {
				bored[i][o] = random.nextInt(15) + 1;
			}
		}
		
		for(int i = 0; i < bored.length; i ++) {
			for(int o = 0; o < bored[i].length; o ++) {
				System.out.print(bored[i][o] + " ");
			}
			System.out.println(" ");
		}
		
		System.out.println("\nPairs: " + puzzle.detectEquivalentAdjacentPairs(bored));
		System.out.println(puzzle.checkDuplicates(bored));
		
		puzzle.shiftRight(bored, 43, 0);
		
		for(int i = 0; i < bored.length; i ++) {
			for(int o = 0; o < bored[i].length; o ++) {
				System.out.print(bored[i][o] + " ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		System.out.println(" ");
		puzzle.shiftUp(bored, 43, 0);
		
		for(int i = 0; i < bored.length; i ++) {
			for(int o = 0; o < bored[i].length; o ++) {
				System.out.print(bored[i][o] + " ");
			}
			System.out.println(" ");
		}

	}

}
