package task2;
//Import (aka include) some stuff.
import common.*;

/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2017/02/08 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack2
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;
	/**
	 * Task 1
	 * Current times the stack has been accessed.
	 */
	private int stack_access_counter;

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '$', '$'};

	/**
	 * Default constructor
	 */
	public BlockStack2()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack2(final int piSize)
	{


                if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
        stack_access_counter = 0;
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick()
	{
		this.stack_access_counter++;
		return this.acStack[this.iTop];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition)
	{
		this.stack_access_counter++;
		return this.acStack[piPosition];
	}

	/**
	 * Standard push operation
	 * @throws VerifyStackBoundaries 
	 */
	public void push(final char pcBlock) throws VerifyStackBoundaries
	{	
		this.stack_access_counter++;
		this.isFullException();
		if(this.iTop == 0){
			this.acStack[this.iTop] = pcBlock;
			this.acStack[++this.iTop] = 'a';
		}
		
		this.acStack[++this.iTop] = pcBlock;
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 * @throws VerifyStackBoundaries 
	 */
	public char pop() throws VerifyStackBoundaries
	{
		this.stack_access_counter++;
		this.isEmptyException();
		char cBlock = this.acStack[this.iTop];
		this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
		return cBlock;
	}
	/**
	 * Get acces_counter variable (Task 2)
	 * @return the number of times the stack was accessed,int
	 * @author Andres
	 */
	public int getAccessCounter(){
		return this.stack_access_counter;
	}

	/**
	 * Get iTop variable (Task 2)
	 * @return returns the index of the top element
	 */
	public int getITop(){
		return this.iTop;
	}
	
	/**
	 * Get iSize variable (Task 2)
	 * @return returns the size of the stack
	 */
	public int getISize(){
		return this.iSize;
	}
	
	/**
	 * Get iSize variable (Task 2)
	 * @return returns the stack
	 */
	public char[] acStack(){
		return this.acStack;
	}
	
	/**
	 * Checks if the stack is empty
	 */
	public boolean isEmpty(){
		return(this.iTop ==-1);
	}
	
	/**
	 * Method that checks if the stack is empty
	 */
	private void isEmptyException() throws VerifyStackBoundaries{
		if(this.isEmpty())
			throw new VerifyStackBoundaries("The stack is empty. ");
	}
	
	/**
	 * Method that checks if the stack is full
	 */
	private void isFullException() throws VerifyStackBoundaries{
		if(this.iTop==this.iSize)
			throw new VerifyStackBoundaries("The stack is full.");
	}
	
}

// EOF
