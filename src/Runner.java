import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.File;

public class Runner
{
	public static void main(String... args)
	{		
		File data = new File("Class_Size_Reduction_Projects.csv");
		File file = new File("a.csv");
		CSVUtilities x = new CSVUtilities(data);
		CSVUtilities writeIn = new CSVUtilities(file);
		int y = x.numColumns;
		int z = x.numRows;
		int a = 0;
		int b = y * z;
		while(a < b)
		{
			for(int i = 0; i < y; i++)
			{	
				System.out.print(x.CSVData.get(a) + "  ");
				a++;
			}
			System.out.println();
			
		}
		
		writeIn.writeCSV(file);
		
		System.out.println();
		
		
		System.out.println(x.getColumnHeaders());
		System.out.println(x.getDataString(1));
		System.out.println(x.getDataInt(5));
		System.out.println(x.getDataDouble(5));
		
		//System.out.println(x.CSVData);
		
	}
}
