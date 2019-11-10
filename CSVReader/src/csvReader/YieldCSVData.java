package csvReader;

import java.util.HashMap;
import java.util.Map;

import com.github.mygreen.supercsv.annotation.CsvBean;
import com.github.mygreen.supercsv.annotation.CsvColumn;

@CsvBean(header = true, validateHeader = true)
public class YieldCSVData {

	@CsvColumn
	private String monsoonYear;
	
	@CsvColumn
	private String season;
	
	@CsvColumn
	private String locationName;
	
	@CsvColumn
	private String crop;
	
	@CsvColumn
	private Double yield;
	
	
	public YieldCSVData() {
		super();
	}


	public String getMonsoonYear() {
		return monsoonYear;
	}


	public void setMonsoonYear(String monsoonYear) {
		this.monsoonYear = monsoonYear;
	}


	public String getSeason() {
		return season;
	}


	public void setSeason(String season) {
		this.season = season;
	}


	public String getLocationName() {
		return locationName;
	}


	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}


	public String getCrop() {
		return crop;
	}


	public void setCrop(String crop) {
		this.crop = crop;
	}


	public Double getYield() {
		return yield;
	}


	public void setYield(Double production) {
		this.yield = production;
	}

	public void setYield(String production) {
		try {
			this.yield = Double.valueOf(production);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Map<String, String> getCSVHeaderNameToCSVBeanSetterMethodMapping(String sourceLocationType) {
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("YEAR", "MonsoonYear");
		resultMap.put("SEASON", "Season");
		resultMap.put("CROP", "Crop");
		resultMap.put("Yield (tonne/ha)", "Yield");
		resultMap.put(sourceLocationType, "LocationName");
		
		return resultMap;
	}


	@Override
	public String toString() {
		return "YieldCSVData [monsoonYear=" + monsoonYear + ", season=" + season + ", locationName=" + locationName
				+ ", crop=" + crop + ", yield=" + yield + "]";
	}
}
