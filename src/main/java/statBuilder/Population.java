package statBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Population extends Stat{
	public Population(String countryName) {
		try {
			Gson gson = new Gson();
			Reader reader = Files.newBufferedReader(Paths.get("\\Workspace\\3311Assignment\\src\\main\\resources\\population.json"));
			JsonObject jObj = gson.fromJson(reader, JsonObject.class);
			this.indicatorName = jObj.getAsJsonObject(countryName).getAsJsonPrimitive("Indicator_Name").toString();
			//this.unit = jObj.getAsJsonObject(countryName).getAsJsonPrimitive("Unit").toString();
			this.stat = jObj.getAsJsonObject(countryName).getAsJsonObject("Year");
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
