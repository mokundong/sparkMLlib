package ch04

import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/6/24.
  */
object CorrectTest {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("CorrectTest")
    val sc = new SparkContext(conf)
    val rddx = sc.textFile("d://work//Spark MLlib//data//x.txt")
      .flatMap(_.split(' ')
        .map(_.toDouble))
    val rddy = sc.textFile("d://work//Spark MLlib//data//y.txt")
      .flatMap(_.split(' ')
        .map(_.toDouble))
    val correlation: Double = Statistics.corr(rddx, rddy)
    println(correlation)
  }
}
