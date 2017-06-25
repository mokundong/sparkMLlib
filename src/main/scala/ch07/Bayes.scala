package ch07

import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/6/25.
  */
object Bayes {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("Bayes")
    val sc = new SparkContext(conf)
    val data = MLUtils.loadLabeledPoints(sc,"d://work//Spark MLlib//data//bayes.txt")
    val model = NaiveBayes.train(data,1.0)
    model.labels.foreach(println)
    model.pi.foreach(println)
  }
}
