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