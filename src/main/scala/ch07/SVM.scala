package ch07

import org.apache.spark.mllib.classification.SVMWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.Vectors

/**
  * Created by MKD on 2017/6/25.
  */
object SVM {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("SVM")
    val sc = new SparkContext(conf)
    val data = sc.textFile("d://work//Spark MLlib//data//u.txt")
    val parsedData = data.map{line =>
      val parts = line.split('|')
      LabeledPoint(parts(0).toDouble,Vectors.dense(parts(1).toDouble))
    }.cache()
    val model = SVMWithSGD.train(parsedData,10)
    println(model.weights)
    println(model.intercept)
  }
}
