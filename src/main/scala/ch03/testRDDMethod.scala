package ch03

import org.apache.spark.{SparkConf, SparkContext}
/**
  * Created by MKD on 2017/4/15.
  */
object testRDDMethod {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("testRDDMethod")//创建环境变量
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array(1,2,3,4,5,6))
    val result = arr.aggregate(0)(math.max(_, _), _+_)
    println(result)
  }
}
