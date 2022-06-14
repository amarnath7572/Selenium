import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreams_map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Print the names with last letter A and convert them to uppercase
		
		Stream.of("Amar", "Ajith", "hema", "Aron", "Ramana").filter(i->i.endsWith("a")).map(i->i.toUpperCase()).forEach(i->System.out.println(i));
		
		//print every string in uppercase letters
		
		Stream.of("Amar", "Ajith", "hema", "Aron", "Ramana").map(i->i.toUpperCase()).forEach(i->System.out.println(i));
		
		//filter is to make a condition true
		// map is to apply a method on all strings of the stream/filtered stream
		// for each also works same as map, works on all elements of the stream
		
		//print names which have first letter as A, convert them to uppercase and sort them
				
		List<String> names= Arrays.asList("Amar", "Ajith", "hema", "Aron", "Ramana");
		names.stream().filter(i->i.startsWith("A")).map(i->i.toUpperCase()).sorted().forEach(i->System.out.println(i));
		
		//Just sort the string
		Stream.of("Amar", "Ajith", "Hema", "Aron", "Ramana").sorted().forEach(i->System.out.println(i));
		
		//merge two Arraylists and print
		List<String> names1 = Arrays.asList("Amar", "Ajith", "Hema", "Aron", "Ramana");
		
		ArrayList<String> names2 = new ArrayList<String>();
		names2.add("Amar");
		names2.add("Ajith");
		names2.add("hema");
		names2.add("Pradeep");
		names2.add("Sindhu");
		names2.add(("Mallik"));
		
		//Convert Arraylists into streams first, use concat method from Stream class and pass it into new stream, print the new stream
		Stream<String> newStream = Stream.concat(names1.stream(),names2.stream());
		newStream.forEach(i->System.out.println(i));
		
		//print true if a name is available in the arraylist
		
		boolean result = newStream.anyMatch(i->i.equalsIgnoreCase("Amar"));
		System.out.println(result);
		
	}

}
