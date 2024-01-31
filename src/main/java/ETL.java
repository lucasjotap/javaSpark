//Own imports.
// import com.mycompany.etl.Loader;
// import com.mycompany.etl.TableCreator;
//import com.mycompany.etl.Transformer;
// import com.mycompany.etl.Extractor;

//Spark imports
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class ETL {
	public static void main(String[] args) {
            
            //File to be read.
            try ( //Set up Spark Session
                    SparkSession spark = SparkSession.builder()
                            .appName("ETL Job")
                            .master("local[*]")
                            .getOrCreate()) {
                //File to be read.
                String csvFilePath = "/home/lucas/Downloads/MOCK_DATA.csv";
                //Create table.
                String jdbcUrl = "jdbc:mysql://localhost:3306/etlJava";
                String userName = "localhost";
                String password = "sqlserver";
                TableCreator.createTable(jdbcUrl, userName, password);
                //Data extraction.
                Dataset<Row> extractedData = Extractor.extractData(csvFilePath);
                Dataset<Row> transformedData = Transformer.transformData(extractedData);
                //Load data.
                String tableName = "java_table";
                //Send it to DB.
                Loader.loadToDatabase(transformedData, jdbcUrl, tableName);
                //Close spark after task is fully run.
            }
	}
}