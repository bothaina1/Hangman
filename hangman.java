package Hang;

import java.io.*;
import java.util.*;


public class hangman implements IHangman{

	public int count= 10;

	int m;

   public  String word = selectRandomSecretWord();

	

	public void reading (String r[]) {

		try{ BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));

	    String line = br.readLine();

	    int i=0;

		while (line != null && i < count){

			

			r[i]= line;

			line = br.readLine();

			i++;

	    }br.close();

		}

     catch (IOException e) {

    	 e.printStackTrace();

     }

	}

	

	

	public void setDictionary(String[] words) {

		reading(words);



}

	

		

	public String selectRandomSecretWord() {

		 String words[] = new String [count];

		 setDictionary(words);

		 Random random = new Random();

		 return words[random.nextInt(count)]; 

		

	}

	



	public String guess(Character c) throws Exception{

		int i=0;

		int score=0;

	

		int len = word.length();

		char missing [] = new char[len];

		String st =new String();

		for(i=0; i < len ; i++) {

			missing[i]= '-';

		}

		

		int g=m;

		while(g != 0) {

	    c = Character.toLowerCase(c);

	    if ( c!= null) {	

		for(i=0; i < len ; i++) {

			if (word.charAt(i) == c) {

				missing[i] = c;

				score++;

			}	

		}

		if (score==0) {

			g--;

		}	

		score=0;}

       st = new String(missing);

       System.out.println(st);

       if(st.contains("-")) { }

		else

	    { System.out.println("you won");

		 break;}

       if(g==0) {

    	   throw new Exception("you lost");

    	  // System.out.println("you lost"); 

    	   //break;

       }

       System.out.println("enter another letter");

       Scanner input= new Scanner(System.in);

       c = input.next().charAt(0);

		

	  

		}

	    

		String fs = new String(missing);

	return fs;

	}

		



	public void setMaxWrongGuesses(Integer max) {

	     m= max; 

	}
	
	
	public static void main(String[] args)  {

		// TODO Auto-generated method stub

		hangman obj = new hangman();	

	  System.out.println("enter a letter");

	try (Scanner input = new Scanner(System.in)) {
		char m;

		m = input.next().charAt(0);

		obj.setMaxWrongGuesses(8);

		try {

			obj.guess(m);

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	

}

		}
