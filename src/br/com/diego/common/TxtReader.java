package br.com.diego.common;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class TxtReader {

	
	@SuppressWarnings("resource")
	public static ArrayList<String> readFile(String filePath) {
		ArrayList<String> text = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			while(line != null) {
				text.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("ReadLine fails: "+e.getMessage());
		}
		return text;
	}

}
