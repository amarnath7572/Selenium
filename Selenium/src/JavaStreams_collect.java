import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams_collect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// List --> Stream --> manipulations --> New List
		
		List<String> newList = Stream.of("Amar", "Ajith", "hema", "Aron", "Ramana").filter(i->i.endsWith("a")).map(i->i.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(newList.get(0));
		
		//Print all Strings of the new list
		for(String i : newList)
		{
			System.out.println(i);
		}
		
		
		// Print unique numbers from Array of integers
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,3,4,5,1,2,7); // Convert array into List
		numbers.stream().distinct().forEach(i->System.out.println(i)); // convert to stream and apply distinct method
		
		// Sort the distinct numbers and get the 3rd value
		
		// to get the third value we have to convert stream into list and do get(index)
		List<Integer> newNumList = numbers.stream().distinct().sorted().collect(Collectors.toList()); 
		System.out.println(newNumList.get(2));
		
	}

}
