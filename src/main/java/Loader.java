import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;

public class Loader{
	public static void loadToDatabase(Dataset<Row> data, String jdbcUrl, String tableName) {
		data.write()
			.mode(SaveMode.Append)
			.format("jdbc")
			.option("url", jdbcUrl)
			.option("dbtable", tableName)
			.save();	
	}
}