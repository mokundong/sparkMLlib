package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/4/15.
  */
object sortBy {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("sortBy")
    val sc = new SparkContext(conf)
    var arr = sc.parallelize(Array((5,"b"),(6,"a"),(1,"f"),(3,"d"),(4,"c"),(2,"e")))
    arr = arr.sortBy(word => word._1,true)
    val arr2 = arr.sortBy(word => word._2,true)
    arr.foreach(print)

    arr2.foreach(print)
  }
}
