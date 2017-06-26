package ch13

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yousa on 2017/6/26.
  */
object irisNorm {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("irisNorm")
    val sc = new SparkContext(conf)
    val data = sc.textFile("E://work//SparkMLlib//data//Sepal.Length_setosa.txt")
      .map(_.toDouble)
      .map(line => Vectors.dense(line))
    val summary = Statistics.colStats(data)//计算统计量
    println("setosa中sepal的曼哈顿距离的值为：" + summary.normL1)
    println("setosa中sepal的欧几里德距离的值为：" + summary.normL2)
  }
}
