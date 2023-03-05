package testPractice;
import java.io.*;
import java.util.Scanner;

/*
Write a program that parses a sentence and replaces each word with the following: 
1) The first letter of the word
2) The number of distinct characters between first and last character
3) The last letter of the word. 
For example, Smooth would become S3h. 
Words are separated by spaces or non-alphabetic characters and these separators should be maintained in their original form and location in the answer. 
A few of the things we will be looking at is accuracy, efficiency, solution completeness. 
*/

public class maint {
	
	
	
	  public static String wordParser(String input) {
		    // IMPLEMENT YOUR SOLUTION HERE
		    
		  // Given String value    
		  
		//    String value = "new string ojala sirva eso haciendolo doble maldicion oogway salvame-del olvido!";
		    
		  // We call the value into the method  
		    String output = parseValue(input);
		    
		    
		    // Result shown
		    System.out.println("The new word is: "+ output);
		    
		    return null;
		  }
		  
		  /* Here we create the new string using the class String Builder , with append and taking the first, last and middle number */
		  public static String parseValue(String value) {
		    StringBuilder concatString = new StringBuilder();
		    String[] words = value.split("(?<=[^a-zA-Z])|(?=[^a-zA-Z])");
		   for (int i = 0; i < words.length; i++) {
		      String word = words[i];
		        if (word.matches("[a-zA-Z]+")) {
		            concatString.append(word.charAt(0));
		            concatString.append(countDistinctChars(word.substring(1, word.length() - 1)));
		            concatString.append(word.charAt(word.length() - 1));
		        } else {
		            concatString.append(word);
		        }
		    }
		    return concatString.toString();
		}
		  
		  
		  
		  
		//   String str = "Hello, world!";
		// char[] chars = str.toCharArray();
		// for (char c : chars) {
//		     System.out.print(c + " ");
		// }
		  /*Here we count the different Characters of the given string between the first and the last letter of a word*/
		public static String countDistinctChars(String str) {
		    int[] count = new int[128];
		    int distinct = 0;
		    String blank="";
		    for (char c : str.toCharArray()) {
		        if (Character.isLetter(c)) {
		            int index = (int) c;
		            if (count[index] == 0) {
		              
		                distinct++;
		                
		            }
		            
		              count[index]++;
		            
		        }
		    }
		    
		    if(distinct==0){
		      
		      return blank;
		      
		    }else{
		      
		      return Integer.toString(distinct);
		      
		    }
		    
		    
		}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		 wordParser("Creativity is thinking-up new things. Innovation is doing new things!");
		
	    // expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!
	}

}
