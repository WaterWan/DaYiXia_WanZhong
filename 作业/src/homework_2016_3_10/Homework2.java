package homework_2016_3_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
/**
 * file io
 * @author 151250137
 */
public class Homework2 {
	public static void main(String[] args) {
		try {
			// read fileA
			File fileA = new File("src/txts/fileA.txt");
			FileReader fileReaderA = new FileReader(fileA);
			BufferedReader bufferedReaderA = new BufferedReader(fileReaderA);
			String contentA = bufferedReaderA.readLine();
			System.out.println(contentA);
			bufferedReaderA.close();
			// read fileB
			File fileB = new File("src/txts/fileB.txt");
			FileReader fileReaderB = new FileReader(fileB);
			BufferedReader bufferedReaderB = new BufferedReader(fileReaderB);
			String contentB = bufferedReaderB.readLine();
			contentB = contentB + contentA;
			// write fileB
			FileWriter fileWriterB = new FileWriter(fileB);
			fileWriterB.write(contentB);
			fileWriterB.close();
			System.out.println(contentB);
			bufferedReaderB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
