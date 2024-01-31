import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.functions;

public class Transformer {
	public static Dataset<Row> transformData(Dataset<Row> data) {
		Dataset<Row> transformedData = data.filter(functions.col("age").gt(20));
		//add any other transformation here
		return transformedData; 
	}
}