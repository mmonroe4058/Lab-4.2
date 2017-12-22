import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Graph extends Application
{
	public static void main(String... args)
	{
		/* List<Book> books = readBooksFromCSV("book.csv");
		
		for (Book b : books)
            System.out.println(b);
		*/
		
		/*List<HighScores> scores = readScoresFromCSV("highscores.csv");
		
		for (HighScores s : scores)
            System.out.println(s);
            */
		
		launch(args);
	}
	
	private static List<HighScores> readScoresFromCSV(String file)
	{
		List<HighScores> scores = new ArrayList();
		Path pathToFile = Paths.get(file);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
		{
			String line = br.readLine();
			while (line != null)
			{ 
				String[] attributes = line.split(",");
				HighScores newscore = createScore(attributes);
				scores.add(newscore);
				line = br.readLine(); 
			}
		
		}
			
		catch (IOException ioe)
		{
            ioe.printStackTrace();
        }	
		
		return scores;
		
	}
	
	private static HighScores createScore(String[] scoresArray)
	{
		String name = scoresArray[0];
		int score = Integer.parseInt(scoresArray[1]);
		return new HighScores(name, score);
	}
	
    
    @Override
    public void start(Stage primaryStage)
    {
    	List<HighScores> scores = readScoresFromCSV("highscores.csv");
        primaryStage.setTitle("Get Score");
        Button btn = new Button();
        btn.setText("Get Score");
        btn.setOnAction(new EventHandler<ActionEvent>()
        {
 
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println(scores.get(((int) Math.random() * scores.size())));
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
	
	
	
	
	
	
	
	
	
	
	
	/*
	private static List<Book> readBooksFromCSV(String fileName)
	{
		List<Book> books = new ArrayList<>(); Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
		{
			String line = br.readLine();
			while (line != null)
			{ 
				String[] attributes = line.split(",");
				Book book = createBook(attributes);
				books.add(book);
				line = br.readLine(); 
			}
		
		}
			
		catch (IOException ioe)
		{
            ioe.printStackTrace();
        }	
		
		return books;
	}
	private static Book createBook(String[] metadata)
	{
		String name = metadata[0];
		int price = Integer.parseInt(metadata[1]);
		String author = metadata[2];
		return new Book(name, price, author);
	}
	*/


}