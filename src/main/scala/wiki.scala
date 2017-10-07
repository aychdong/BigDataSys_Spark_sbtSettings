import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object wiki{
def main(args: Array[String]): Unit={
val spark_master_url = "spark://c220g1-030818.wisc.cloudlab.us:7077"
val username = "dongchen"

val config = new SparkConf().setAppName("task2").setMaster(spark_master_url)
val sc = new SparkContext(config)
val sqlContext = new SQLContext(sc)
val df = sqlContext.read
	.format("com.databricks.spark.xml")
	.option("rowTag", "page")
	.load("/enwiki-20110115-pages-articles_whole.xml")
df.printSchema()
}
}
