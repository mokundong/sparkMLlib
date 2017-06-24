package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/4/15.
  * 以value计算的countByValue方法
  */
object countByValue {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("countByValue")
    val sc = new SparkContext(conf)
    var arr = sc.parallelize(Array(1, 2, 3, 4, 5, 6,2,3,4,5,3,2,1,4,6,7))
    val result = arr.countByValue()
    result.foreach(print)
  }
}
