package ch03

import org.apache.spark.{SparkConf, SparkContext}
/**
  * Created by MKD on 2017/4/15.
  */
object wordCount {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordCount")//创建环境变量
    val sc = new SparkContext(conf)
    val data = sc.textFile("d://work//SparkMLlibDemo//data//wc.txt")
    data.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect().foreach(println)

  }
}
