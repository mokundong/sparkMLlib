package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/4/15.
  * 数据分区组合
  */
object Repartition {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("Repartition")
    val sc = new SparkContext(conf)
    var arr = sc.parallelize(Array(1, 2, 3, 4, 5, 6))
    arr = arr repartition 3
    println(arr.partitions.length)
  }
}
