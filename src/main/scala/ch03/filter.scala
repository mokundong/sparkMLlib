package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 筛选
  */
object filter {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("filter")
    val sc = new SparkContext(conf)
    var arr = sc.parallelize(Array(1,2,3,4,5))
    val result = arr.filter(_ >=3)
    result.foreach(println)

  }
}
