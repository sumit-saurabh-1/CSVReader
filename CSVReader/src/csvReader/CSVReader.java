package csvReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class CSVReader {

	public static <T> List<T> readFromFile(String fileName, Class<T> beanType, Map<String, String> csvToSetterMethodMapping)
			throws IOException {
		return readFromFile(fileName, beanType, csvToSetterMethodMapping, CsvPreference.STANDARD_PREFERENCE);
	}

	public static <T> List<T> readFromFile(String fileName, Class<T> beanType, Map<String, String> csvToSetterMethodMapping,
			CsvPreference csvPreference) throws IOException {

		List<T> resultList = new ArrayList<T>();

		if (csvToSetterMethodMapping == null || csvToSetterMethodMapping.isEmpty()) {
			throw new IOException("CSVReader: Please provide proper mapping from csv headers to setter methods");
		}

		CsvBeanReader fileReader = new CsvBeanReader(new FileReader(fileName), csvPreference);
		String[] header = fileReader.getHeader(true);

		String[] nameMapping = new String[header.length];

		int index = 0;
		for (String entry : header) {
			String setterMethodName = csvToSetterMethodMapping.get(entry);
			nameMapping[index++] = setterMethodName;
		}

		T record;
		while ((record = fileReader.read(beanType, nameMapping)) != null) {
			resultList.add(record);
		}
		fileReader.close();
		return resultList;
	}

}