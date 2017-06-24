package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/4/15.
  */
object keyBy {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("keyBy")
    val sc = new SparkContext(conf)
    var arr = sc.parallelize(Array("one","two","three","four","five"))
    val result = arr.keyBy(word => word.size)
    result.foreach(println)
  }
}
