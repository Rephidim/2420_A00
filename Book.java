package books;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Book 
implements Comparable<Book>{
	
	private String title;
	private String author;
	private int year;
	
	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public int getYear() {
		return this.year;
	}
	
	public static List<Book> getList(String file) {
		List<Book> list = new ArrayList<Book>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = br.readLine()) != null) {
				String[] deets = line.split(",");
				if(deets.length < 3 || deets.length > 3) {
					System.err.println("Problem reading in ' " + line + "'.");
					continue;
				}
				list.add(new Book(deets[0],deets[1],Integer.parseInt(deets[2])));
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String toString() {
		return getTitle() + " by " + getAuthor() + " (" + getYear() + ")";
	}

	@Override
	public int compareTo(Book b) {
		int r = 0;
		if (this.getAuthor().equals(b.getAuthor())) {
			r = 0;
		}
		if (this.getAuthor().compareToIgnoreCase(b.getAuthor()) > 0) {
			r = 1;
		}
		if (this.getAuthor().compareToIgnoreCase(b.getAuthor()) < 0) {
			r = -1;
		}
		return r;
	}
	
	// Tested getList() method
//	public static void main(String[] args) {
//		String file = "D:\\Java Dev\\Workspace\\books.csv";
//		List<Book> books = getList(file);
//		for(Book b : books) {
//			System.out.println(b);
//		}
//	}

}
