package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 寻找最长字符串
  */
object reduceTest2 {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("reduceTest2")
    val sc = new SparkContext(conf)
    var arr = sc.parallelize(Array("one","two","three","four","five"))
    val result = arr.reduce(maxLong)
    result.foreach(print)
  }
  def maxLong(str1:String,str2:String):String ={
    var str = str1
    if(str2.size >= str.size){
      str = str2
    }
    return str
  }
}
