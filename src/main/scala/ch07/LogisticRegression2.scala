package ch07

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.util.MLUtils

/**
  * Created by MKD on 2017/6/25.多元逻辑回归
  */
object LogisticRegression2 {
  val conf = new SparkConf().setMaster("local").setAppName("LogisticRegression2")
  val sc = new SparkContext(conf)

  def main(args: Array[String]) {
    val data = MLUtils.loadLibSVMFile(sc,"d://work//Spark MLlib//data//sample_libsvm_data.txt")							  	 //获取数据集路径
    val model = LogisticRegressionWithSGD.train(data,50)
    println(model.weights.size)
    println(model.weights)
    println(model.weights.toArray.filter(_ != 0).size)
  }
}
