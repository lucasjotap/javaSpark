import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Extractor {
	public static Dataset<Row> extractData(String csvFilePath) {
		//Set up SparkSession
		SparkSession spark = SparkSession.builder()
			.appName("Data Extractor")
			.master("local[*]")
			.getOrCreate();
		try {
		//Setting up the path for file reading.
		Dataset<Row> dataframe = spark.read()
			.format("csv")
			.option("header", "true")
			.load(csvFilePath);
	    
	    return dataframe;

		} finally {
			spark.close();
	}
  }
}