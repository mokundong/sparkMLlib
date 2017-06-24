package ch04

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.random.RandomRDDs._
/**
  * Created by MKD on 2017/6/24.
  */
object RandonRDDTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    .setMaster("local")
    .setAppName("RandonRDDTest")
    val sc = new SparkContext(conf)
    val randomNun = normalRDD(sc,100)
    randomNun.foreach(println)
  }
}
