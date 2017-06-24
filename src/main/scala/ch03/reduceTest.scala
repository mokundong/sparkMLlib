package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/4/15.
  */
object reduceTest {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("reduceTest")
    val sc = new SparkContext(conf)
    var arr = sc.parallelize(Array("one","two","three","four","five"))
    val result = arr.reduce(_ + _)
    result.foreach(print)
  }
}
