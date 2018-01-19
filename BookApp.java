package books;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookApp {
	private String title;
	private String author;
	private int year;
	private static int count = 0;
	
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
				count++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(list);
		return list;
	}
	
	public static void main(String[] args) {
		String file = "###";
		List<Book> books = getList(file);
		System.out.println("Number of books read in: " + count);
		System.out.println();
		System.out.println("Sorted book list:");
		for(Book b : books) {
			System.out.println(b);
		}
		
	}
	
}
