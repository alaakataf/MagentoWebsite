
package mytestcases;

import java.util.Random;

public class parameter {
	Random rand = new Random ();
	String [] firstNames = { "John", "Emma", "Michael", "Sophia", "William", 
            "Olivia", "James", "Isabella", "Alexander", "Charlotte"};
	String [] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", 
            "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"};
	String commonPassword = "12#asdq$" ;

int randomIndex = rand.nextInt(10);

int randomEmailID = rand. nextInt(999);
String emailID = (firstNames[randomIndex] + lastNames[randomIndex] + randomEmailID + "@"+"gmail.com");

}
