package ch04

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/6/24.
  */
object SingleCorrectTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("SingleCorrectTest")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("d://work//Spark MLlib//data//x.txt")
      .flatMap(_.split(' ')
        .map(_.toDouble))
      .map(line => Vectors.dense(line))
    println(Statistics.corr(rdd,"spearman"))
  }
}
