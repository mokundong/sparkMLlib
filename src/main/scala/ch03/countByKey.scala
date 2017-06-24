package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/4/15.
  * 以key计算的countByKey方法
  */
object countByKey {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("countByKey")
    val sc = new SparkContext(conf)
    var arr = sc.parallelize(Array((1,"cool"),(2,"good"),(1,"bad"),(1,"fine")))
    val result = arr.countByKey()
    result.foreach(print)
  }
}
