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
		CSVUtilities x = new CSVUtilities(data);
		System.out.println(x.CSVData);
		
	}
}
