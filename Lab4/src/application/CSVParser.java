package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVParser {
	public static String[][] readCSV(String filename) {
		
		try {
			InputStream inputStream = ClassLoader.
			        getSystemResourceAsStream("csv/"+filename);
			InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader in = new BufferedReader(streamReader);

			
			ArrayList<String[]> result = new ArrayList<String[]>();
			
			for (String line; (line = in.readLine()) != null;) {
				String rawdata = line;
				String[] parseddata = rawdata.split(",");
				
				result.add(parseddata);
			}
			String[][] result2 = result.toArray(new String[result.size()][]);
			
			return result2;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}	
}
