package ch03

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 去除数据集中的重复项
  */
object distinct {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("distinct")
    val sc = new SparkContext(conf)
    var arr = sc.parallelize(Array(("cool"),("good"),("bad"),("fine"),("good"),("cool")))
    val result = arr.distinct()
    result.foreach(println)

  }
}
