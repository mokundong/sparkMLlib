package ch13

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/6/25.
  */
object irisALL {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("irisALL")
    val sc = new SparkContext(conf)

    val data = sc.textFile("E://work//SparkMLlib//data//Sepal.Length.txt")
    .map(_.toDouble)
    .map(line => Vectors.dense(line))
    val summary = Statistics.colStats(data)//计算统计量
    println("setosa中Sepal.Length的均值为：" + summary.mean)
    println("setosa中Sepal.Length的方差为：" + summary.variance)
  }
}
