package packagename;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Venue {
	private Seat[][] s;
	
	public Venue(int row, int col, double price) {
		s = new Seat[row][col];
		for(int i = 0; i < row; i++) {
			for(int o = 0; o < col; o++) {
				s[i][o] = new Seat(false, "R", price);
			}
		}
	}
	
	public boolean buyTicket(int row, int col) {
		if (s[row][col].getSold() == false) {
			s[row][col].setSold(true);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isAvailable(int row, int col) {
		if (s[row][col].getSold() == false) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setPremium(int row, double price) {
		for(int i = 0; i < s[row].length; i++) {
			s[row][i].setType("P");
			s[row][i].setPrice(price);
		}
	}
	
	public void setPremium(int row, int colStart, int colEnd, double price) {
		for(int i = colStart; i < colEnd; i++) {
			s[row][i].setType("P");
			s[row][i].setPrice(price);
		}
	}
	
	public void setGA(int row, double price) {
		for(int i = 0; i < s[row].length; i++) {
			s[row][i].setType("G");
			s[row][i].setPrice(price);
		}
	}
	
	public boolean importTickets(String filename) throws IOException{
		File word = new File(filename);
		Scanner sc = new Scanner(word);
		
		while(sc.hasNextLine()) {
			String[] tmp = sc.nextLine().split(",");
			buyTicket(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		}
		
		return true;
		
	}
	
	public double totalRevenue() {
		double profit = 0;
		
		for(int i = 0; i < s.length; i++) {
			for(int o = 0; o < s[i].length; o++) {
				if (s[i][o].getSold()) {
					profit += s[i][o].getprice();
				}
			}
		}
		
		return profit;
	}
	
	public double totalRevenue(int col) {
		double profit = 0;
		
		for(int i = 0; i < s.length; i++) {
			for(int o = col; o < col+1; o++) {
				if (s[i][o].getSold()) {
					profit += s[i][o].getprice();
				}
			}
		}
		
		return profit;
	}
	
	public int totalSold() {
		int profit = 0;
		
		for(int i = 0; i < s.length; i++) {
			for(int o = 0; o < s[i].length; o++) {
				if (s[i][o].getSold()) {
					profit += 1;
				}
			}
		}
		
		return profit;
	}
	
	public double totalSold(int row) {
		double profit = 0;
		
		for(int i = 0; i < s[row].length; i++) {
				if (s[row][i].getSold()) {
					profit += 1;
				}			
		}
		
		return profit;
	}
	
	public void printVenue() {
		String ven = "";
		for(int i = 0; i < s.length; i++) {
			for(int o = 0; o < s[i].length; o++) {
				if (s[i][o].getSold()) {
					ven += "[x] ";
				} else {
					ven += "[ ] ";
				}
			}
			ven += "\n";
		}
		System.out.println(ven);
	}
	
	public void printVenueType() {
		String ven = "";
		for(int i = 0; i < s.length; i++) {
			for(int o = 0; o < s[i].length; o++) {
				ven += "[" + s[i][o].getType() + "] ";
			}
			ven += "\n";
		}
		System.out.println(ven);
	}
	
	public void printVenuePrice() {
		String ven = "";
		for(int i = 0; i < s.length; i++) {
			for(int o = 0; o < s[i].length; o++) {
				ven += "[" + s[i][o].getprice() + "] ";
			}
			ven += "\n";
		}
		System.out.println(ven);
	}
	
	public double maxPrice(int rowStart, int rowEnd, int colStart, int colEnd) {
		double max = 0;
		
		for(int i = rowStart; i < s.length - (s.length - rowEnd); i++) {
			for(int o = colStart; o < s[i].length - (s[i].length - colEnd); o++) {
				if (s[i][o].getprice() > max) {
					max = s[i][o].getprice();
				}
			}
		}
		
		return max;
	}
	
	public boolean containsGA(int row) {
		boolean gah = false;
		
		for(int i = 0; i < s[row].length; i++) {
				if(s[row][i].getType() == "G") {
					gah = true;
				}
			
		}
		return gah;
	}
	
	public boolean allPremium(int col) {
		boolean gah = true;
		

		for(int i = 0; i < s.length; i++) {
			for(int o = col; o < col+1; o++) {
				if(s[i][o].getType() != "P") {
					gah = false;
				}
			}
		}
		return gah;
	}
}