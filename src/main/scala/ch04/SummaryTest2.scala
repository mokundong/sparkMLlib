package ch04

import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}
/**
  * Created by MKD on 2017/6/24.
  */
object SummaryTest2 {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("SummaryTest2")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("d://work//Spark MLlib//data//b.txt")
      .map(_.split(' ')
        .map(_.toDouble))
      .map(line => Vectors.dense(line))//转成Vector格式
    val summary = Statistics.colStats(rdd)//获取Statistics
    println(summary.normL1)
    println(summary.normL2)
  }
}
