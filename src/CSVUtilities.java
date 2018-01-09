import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
	int numColumns = 0;
	int numRows = 0;

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
							numColumns = attributes.length;
							for(int x = 0; x < numColumns; x++ )
							{
								CSVData.add(attributes[x]);
							}
							numRows++;
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
	
	public static void writeCSV(File file)
	{
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(file);
		}
		catch(FileNotFoundException e)
		{
			System.err.println(e);
		}
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name");
        sb.append(',');
        sb.append("High Score");
        sb.append('\n');
        
        
        sb.append("id");
        sb.append(',');
        sb.append("Name");
        sb.append('\n');
        
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
	}
	
	public List<String> getColumnHeaders()
	{
		ArrayList<String> headers = new ArrayList<String>();
		for(int i = 0; i < numColumns; i++)
		{	
			headers.add(CSVData.get(i));
		}
		return headers;
	}
	
	public List<String> getDataString(int column)
	{
		ArrayList<String> x = new ArrayList<String>();
		int i = column+numColumns;
		while(i < numColumns*numRows)
		{	
			String y = CSVData.get(i);
			x.add(y);
			i = i+numColumns;
		}
		return x;
		 
	}

	public List<Integer> getDataInt(int column)
	{
		ArrayList<Integer> x = new ArrayList<Integer>();
		int i = column+numColumns;
		while(i < numColumns*numRows)
		{	
			int y = Integer.parseInt(CSVData.get(i));
			x.add(y);
			i = i+numColumns;
		}
		return x;
	}
	
	public List<Double> getDataDouble(int column)
	{
		ArrayList<Double> x = new ArrayList<Double>();
		int i = column+numColumns;
		while(i < numColumns*numRows)
		{	
			double y = Double.parseDouble(CSVData.get(i));
			x.add(y);
			i = i+numColumns;
		}
		return x;
	}
}