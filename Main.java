/*

* @author (Dylan I. Pace)

* <p> (Main)

* <p> (Assignment 06)

* <p> (Describe, in general, the code contained.)

*/


//importing things for reading files
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
//importing things for set
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//importing scanner class
import java.util.Scanner;

public class Main
{//method for reading files
	public static String readFile(String path, Charset encoding) throws IOException 
	{
        return Files.readString(Paths.get(path), encoding);
	}
	//method for finding repeated words
	public static int repeatedWords (String[] lyrics)
	{
		Scanner scan = new Scanner (System.in);
		int count = 0;
		//asking user for a word
		System.out.println("What word would you like to count? (Case Sensitive)");
		
		String word = scan.nextLine();
		//going through array to find how many of the requested word exist
		for (int c = 0; c < lyrics.length; c++)
		{//some words have commas or parenthesis tied to them, this is to counter that
			if (lyrics[c].contains(",") || lyrics[c].contains(")") || lyrics[c].contains("("))
			{
				if (lyrics[c].contains(")") && lyrics[c].contains("("))
				{
					if (lyrics[c].contains(word) && lyrics[c].length()-2 == word.length())//to make sure there are no false positives
					{
						count++;
					}
				}
				else
					if (lyrics[c].contains(word) && lyrics[c].length()-1 == word.length())//to make sure there are no false positives
					{
						count++;
					}
			}
			else
				if (lyrics[c].contains(word) && lyrics[c].length() == word.length())//to make sure there are no false positives
				{
					count++;
				}
		}
		return count;
	}
	//main method
	public static void main(String[] args)
	{
		//this path will need to be changed for the file to work on your System
		//I also added spaces between words that were just brought to the next line
		String filePath = "C:\\Users\\Ninfuzz\\Downloads\\happy.txt";
		
		String content = null;
		//to catch any possible errors and for testing
		try {
			content = readFile(filePath, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//the commented code one line below this was for testing purposes
		//System.out.println(content);
		//turning the file into an array, then a list, then a set
		String[] happyArray = content.split(" ");
		List<String> happyList = Arrays.asList(happyArray);
		Set<String> happySet = new HashSet<>(happyList);
		//displays how many unique words are in the song
		System.out.println("There are " + happySet.size() + " unique words in the song Happy.");
		//calls the method to find how many times a word is used
		System.out.println(repeatedWords(happyArray));
		
	}

}
