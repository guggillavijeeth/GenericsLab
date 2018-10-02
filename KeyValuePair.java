package kvpairs;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class KeyValuePair<T, U> {
	
	public static void main(String [] args) {
		
		KeyValuePair<String, Integer> kv1 = new KeyValuePair<String, Integer>("First", 10);
		KeyValuePair<String, Integer> kv2 = new KeyValuePair<String, Integer>("Second", 20);
		KeyValuePair<String, Integer> kv3 = new KeyValuePair<String, Integer>("Third", 30);
		KeyValuePair<String, Integer> kv4 = new KeyValuePair<String, Integer>("Fourth", 40);
		KeyValuePair<String, Integer> kv5 = new KeyValuePair<String, Integer>("Fifth", 50);
		KeyValuePair<String, Integer> duplicatekv5 = new KeyValuePair<String, Integer>("Fifth", 50);

		String str = "First";
		Integer num = 10;
		
		System.out.println(str.hashCode());
		System.out.println(num.hashCode());
		
		//System.out.println(kv5.hashCode());
		
		LinkedList<KeyValuePair<String, Integer>> myList = new LinkedList<KeyValuePair<String, Integer>>();
		
		myList.addFirst(kv5);
		myList.addFirst(kv4);
		myList.addFirst(kv3);
		myList.addFirst(kv2);
		myList.addFirst(kv1);
		
		System.out.println(lookup("First", myList));
		System.out.println(lookup("Fourth", myList));
		System.out.println(lookup("Forth", myList));
		
		System.out.println(isAssoc(myList));
		
		myList.addFirst(kv2);
		
		System.out.println(isAssoc(myList));
	}
	
	public static <T, U> U lookup(T searchKey, LinkedList<KeyValuePair<T, U>> searchList) {
		Iterator <KeyValuePair<T, U>> traverser = searchList.iterator();
		while (traverser.hasNext()) {
			KeyValuePair<T, U> current = traverser.next();
			if (searchKey.equals(current.key)){
				return current.value;
			}
		}
		return null;
	}
	
	public static <T, U> boolean isAssoc (LinkedList<KeyValuePair<T, U>> inputList) {
		Iterator <KeyValuePair<T, U>> traverser = inputList.iterator();
		int index = 0;
		while (traverser.hasNext()) {
			index++;
			KeyValuePair<T, U> current = traverser.next();
			ListIterator <KeyValuePair<T, U>> localTraverser = inputList.listIterator(index);
			while (localTraverser.hasNext()) {
				KeyValuePair<T, U> follower = localTraverser.next();
				if (current.key.equals(follower.key)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private T key;
	private U value;
	
	public KeyValuePair(T keyIn, U valIn) {
		key = keyIn;
		value = valIn;
	}
	
	public T getKey() {
		return key;
	}
	
	public U getValue() {
		return value;
	}
	
	//Why isn't this method working??
	@Override
	public int hashCode() {
		return Integer.valueOf(Integer.toString(key.hashCode()) + Integer.toString(value.hashCode()));
	}
}
//Ending comment added for new commit
