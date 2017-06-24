package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/4/15.
  */
object CacheTest2 {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("CacheTest2")//创建环境变量
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array("abc","b","c","d","e","f"))
    arr.foreach(println)
  }
}
