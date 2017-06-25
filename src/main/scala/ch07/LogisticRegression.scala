package ch07

import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/6/25.
  */
object LogisticRegression {
  val conf = new SparkConf().setMaster("local").setAppName("LogisticRegression")
  val sc = new SparkContext(conf)

  def main(args: Array[String]) {
    val data = sc.textFile("d://work//Spark MLlib//data//u.txt")							  	 //获取数据集路径
    val parsedData = data.map { line =>							 //开始对数据集处理
      val parts = line.split('|')									 //根据逗号进行分区
      LabeledPoint(parts(0).toDouble,Vectors.dense(parts(1).toDouble))
    }.cache()
    val model = LogisticRegressionWithSGD.train(parsedData,50)
    val target = Vectors.dense(-1)
    val result = model.predict(target)
    println(result)
  }
}
