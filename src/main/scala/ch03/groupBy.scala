package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/4/15.
  */
object groupBy {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("groupBy")
    val sc = new SparkContext(conf)
    var arr = sc.parallelize(Array(1,2,3,4,5))
    arr.groupBy(myFilter(_),1)
    arr.groupBy(myFilter2(_),2)
  }
  def myFilter(num:Int):Unit={
    num >= 3
  }
  def myFilter2(num:Int):Unit={
    num < 3
  }
}
