package csvReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MainClass {
	
	public static void main(String args[]) throws IOException {
//		
		Map<String, String> csvToSetterMethodMapping = YieldCSVData.getCSVHeaderNameToCSVBeanSetterMethodMapping("LOCATION NAME"); 
		List<YieldCSVData> list = CSVReader.readFromFile("/home/sumit/Downloads/sample1.csv", YieldCSVData.class, csvToSetterMethodMapping);
		
		System.out.println(list);
	}
}
