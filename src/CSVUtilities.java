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
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVUtilities
{
	
	ArrayList<String> CSVData = new ArrayList<String>();
	int numColumns;

	public CSVUtilities(File csv)
	{
			FileReader reader = null;
			BufferedReader filein = null;
			try
			{
				reader = new FileReader(csv);
				filein = new BufferedReader(reader);
				try
				{
					String line = filein.readLine();
						while (line != null)
						{ 
							String[] attributes = line.split(",");
							CSVData.add(attributes[0]);
							line = filein.readLine(); 
						}
				}
				
				catch (IOException ioe)
				{
		            ioe.printStackTrace();
		        }	
			}

		catch (FileNotFoundException fnfe)
		{
			System.out.println("ERROR: File not found!");
		}

	}
	
	public List<String> getColumnHeaders()
	{
		//return this.readLine();
	}
	
	public List<String> getDataString(int column)
	{
		ArrayList<String> x = new ArrayList<String>();
		x.add(this[column]);
		
	}

	public List<Integer> getDataInt(int column)
	{
		
	}
	
	public List<Double> getDataDouble(int column)
	{
		
	}
}