package org.jackzeng.spark.sql

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

/**
  * @author zengxj
  * @create 2017/12/14
  */
object MockDataFrame {

  def main(args: Array[String]): Unit = {
    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local").setAppName("AfeUtilsTest"))
    val sql = new SQLContext(sc)

    //val taxiDF = sql.read.format("com.databricks.spark.csv").option("header", "true").load("support/src/main/resources/juxinli_reportresponse.csv")

    val juxinliRDD = sc.textFile("support/src/main/resources/juxinli_reportresponse_deser.csv").map(_.split("&"))

    val schema = StructType(
      List(
        StructField("juxinlicellphone", StringType, true),
        StructField("dw_audit_cre_date", StringType, true)
      )
    )

    val rowRDD = juxinliRDD.map(p => Row(p(0), p(1)))
    val juxinliDataFrame = sql.createDataFrame(rowRDD, schema)
    juxinliDataFrame.registerTempTable("juxinli_table")

    val df = sql.sql("select * from juxinli_table")


    df.rdd.foreach(row => {
      val raw = row.getAs[String]("juxinlicellphone")
      val date = row.getAs[String]("dw_audit_cre_date")
      println(raw)
      println(date)

      //deserialize test
//      val res = AfeUtils.deserRawResponse(row, ThirdPartyEnum.JUXINLICELLPHONE)
//      println(res)
//
//      val mapper = JacksonUtil.getObjectMapper
//      println(mapper.writeValueAsString(res))

    })
  }

}
