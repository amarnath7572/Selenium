import java.util.ArrayList;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Count the number of names in the arrayList starting with A
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Amar");
		names.add("Ajith");
		names.add("hema");
		names.add("Pradeep");
		names.add("Sindhu");
		names.add(("Allik"));
		int count =0;
		
		for (int i=0;i<names.size();i++)
		{
			String temp = names.get(i);
			if(temp.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println("Count of names starting with A: "+ count);
		
		//Another way to loop
		for(String i : names)
		{
			if(i.startsWith("A"))
			{
				count++;
			}
			
		}
		System.out.println("Count of names starting with A: "+ count);
		
		
		//Using Stream filter
		
		ArrayList<String> names2 = new ArrayList<String>();
		names2.add("Amar");
		names2.add("Ajith");
		names2.add("hema");
		names2.add("Pradeep");
		names2.add("Sindhu");
		names2.add(("Mallik"));
		
		//pass this arraylist into a stream (collection of strings), filter using intermediate and terminal operations
		
		Long c = names2.stream().filter(i->i.startsWith("A")).count();
		//stream does executions in parallel
		
		System.out.println("C Count : "+ c);
		
		//Directly giving a stream instead of collection of strings
		
		Stream.of("Amar", "Ajith", "hema", "Aron").filter(i->i.startsWith("A")).count();
		//There is no life for intermediate operation if there's no terminal operation
		//Terminal operation will execute only if intermediate op returns true
		
		//Another way to write stream
		
		Long d = Stream.of("Amar", "Ajith", "hema").filter(i->
		{
			i.startsWith("A");
			return true;
		}).count();
		
		System.out.println("D Count - "+d);
		
		// print all the names in the list whose length is greater than 4
		//Based on the intermediate operation , new Stream is created and passed onto the terminal operation where it takes each string and just prints it
		Stream.of("Amar", "Ajith", "hema", "Aron","Ramana").filter(i->i.length()>4).forEach(i->System.out.println(i));
		names.stream().filter(i->i.length()>4).forEach(i->System.out.println(i));
		
		//limit to only result
		names.stream().filter(i->i.length()>4).limit(1).forEach(i->System.out.println(i));
		
	}

}
