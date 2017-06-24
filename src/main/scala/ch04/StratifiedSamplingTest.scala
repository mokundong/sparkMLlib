package ch04

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/6/24.
  */
//object StratifiedSamplingTest {
//  def main(args:Array[String]): Unit = {
//    val conf = new SparkConf()
//      .setMaster("local")
//      .setAppName("StratifiedSamplingTest")
//    val sc = new SparkContext(conf)
//    val data = sc.textFile("d://work//Spark MLlib//data//a425.txt")
//    .map(row => {
//    if (row.length == 3)
//      (row,1)
//    else (row,2)
//    })
//    val fractions = Map[String,Double] = Map("aa" -> 2)//设定抽样格式
//    val approxSample = data.sampleByKey(withReplacement = false,fractions,0)//计算抽样样本
//    approxSample.foreach(println)
//  }
//}
