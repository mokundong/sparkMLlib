package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/4/15.
  * 笛卡尔操作
  */
object CartesianTest {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("CartesianTest")//创建环境变量
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array(1,2,3,4,5,6))
    val arr2 = sc.parallelize(Array(6,5,4,3,2,1))
    val result = arr.cartesian(arr2)
    result.foreach(print)
  }
}
