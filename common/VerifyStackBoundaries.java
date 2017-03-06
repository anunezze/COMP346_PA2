/*
 * Programming assignment 2, COMP 346
 * Eglen  Cecaj 		ID: 26746047
 * Andres Nunez			ID: 27194331
 */

package common;
public class VerifyStackBoundaries extends Exception {
	
	//Parameterless Constructor
    public VerifyStackBoundaries() {
    }
    
    //Parameterized constructor
	public VerifyStackBoundaries(String msg){
		super(msg);	
	}
	
}
