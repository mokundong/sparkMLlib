package ch03

import org.apache.spark.{SparkConf, SparkContext}
/**
  * Created by MKD on 2017/4/15.
  */
object testRDDMethod3 {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("testRDDMethod3")//创建环境变量
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array("abc","b","c","d","e","f"))
    val result = arr.aggregate("")((value,word) => value + word, _ + _ )
    println(result)
  }
}
