package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/4/15.
  */
object flatMap {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("flatMap")
    val sc = new SparkContext(conf)
    var arr = sc.parallelize(Array(1,2,3,4,5))
    val result = arr.flatMap(x => List(x + 1)).collect()
    result.foreach(println)

  }
}
