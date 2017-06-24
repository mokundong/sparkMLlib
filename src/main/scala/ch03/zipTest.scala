package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/4/15.
  */
object zipTest {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("sortBy")
    val sc = new SparkContext(conf)
    val arr1 = Array(1,2,3,4,5,6)
    val arr2 = Array("a","b","c","d","e","f")
    val arr3 = Array("g","h","i","j","k","l")
    val arr4 = arr1.zip(arr2).zip(arr3)
    arr4.foreach(print)
  }
}
