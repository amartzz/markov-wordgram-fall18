/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author YOUR-NAME
 *
 */

public class WordGram {
	
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int j=0; j< size; j++) {
			myWords[j]= source[j + start];
		}
		
		String myToString= null;
		int myHash= 0;
		}
			
		// DONE: initialize myWords, myToString, myHash
	

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * gets order or size of the WordGram
	 * @return
	 */
	public int length(){
		// DONE change this
	
	int theL= myWords.length;
		return theL;
	}


	@Override
	public boolean equals(Object other) {
		if (! (other instanceof WordGram) || other == null){
			return false;
		}
		WordGram wg= (WordGram) other;
		//if (other instanceof WordGram) {
			if (wg.length() != myWords.length) {
			return false;	
			}
		for (int i=0; i< wg.length(); i++) {
			if (!(wg.wordAt(i).equals(myWords[i]))) {
				return false;
			}
		}
		
	    // DONE: complete this method
	
		
		return true;
	}

	@Override
	public int hashCode(){
		// DONE: complete this method
		//String localWords= myWords.toString();
		if (myHash==0) {
		String newString= this.toString();
		myHash= newString.hashCode();
		}
		
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		//WordGram wg = new WordGram(myWords,0,myWords.length);
		// DONE: Complete this method
		
		int k = myWords.length;
		String[] placehold= new String[k];
		for (int i=0; i<k; i++) {
			if(i==k-1) {
				placehold[i]=last;
			}
			else {
				placehold[i]= myWords[i+1];
			}
			
					}
		
		//placehold.replace(k-1, last);
		WordGram wg= new WordGram(placehold, 0, k);
		return wg;
	}

	@Override
	/**
	 * @return myToString
	 */
	
	public String toString(){
		// DONE: Complete this method
		// NEED TO CHANGE THIS TO RECEIVE FULL CREDIT
		if (myToString==null) {
		myToString= String.join(" ", myWords);
		}
		
		return myToString;
	}
}
