package ch07

import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/6/25.多元逻辑回归
  */
object LogisticRegression3 {
  val conf = new SparkConf().setMaster("local").setAppName("LogisticRegression2")
  val sc = new SparkContext(conf)

  def main(args: Array[String]) {
    val data = MLUtils.loadLibSVMFile(sc,"d://work//Spark MLlib//data//sample_libsvm_data.txt")							  	 //获取数据集路径
    val splits = data.randomSplit(Array(0.6,0.4),seed = 11L)
    val parsedData = splits(0)
    val parsedTest = splits(1)
    val model = LogisticRegressionWithSGD.train(parsedData,50)
    println(model.weights)
    val predictionAndLabels = parsedTest.map{
      case LabeledPoint(label,features) =>
        val prediction = model.predict(features)
        (prediction,label)
    }
    val metrics = new MulticlassMetrics(predictionAndLabels)
    val precision = metrics.precision
    println("precision = " + precision)
  }
}
