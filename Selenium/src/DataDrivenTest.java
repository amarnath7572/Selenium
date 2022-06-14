import java.io.IOException;
import java.util.ArrayList;

public class DataDrivenTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		DataDrivenExcel d = new DataDrivenExcel();
		
		ArrayList<String> data = d.getData("Sheet1","TestCases","Add Profile");
		
		for(String i: data)
		{
			System.out.println(i);
		}
		
	}

}
