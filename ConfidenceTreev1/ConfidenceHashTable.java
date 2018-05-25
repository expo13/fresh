
public class ConfidenceHashTable{

	private ConfidenceLinkedList[] linkedList;

	public ConfidenceHashTable() {
		linkedList = new ConfidenceLinkedList[10];	
	}

	public String hashValue(String value) { 
		//hashed function
		String hashedValue;
	}

	public boolean isPresent(String value) {
		String hashedValue = hashValue(value);
		int position = getArrayPosition(hashedValue);
		return searchArrayPosition(hashedValue, position);
	}

	private int getArrayPosition(String hashedValue) {
		//return position;
		return 0;
	}

	private boolean searchArrayPosition(String hashedValue, int position) {
		return linkedList[position].searchHashedValue(unhashHashedValue(hashedValue)) != null;
	}

	private String unhashHashedValue(String hashedValue){
		//dehash function
		//return value;
		return null;
	}

}
