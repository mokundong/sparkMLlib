package ch07

import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/6/25.
  */
/**
object Bayes1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("Bayes1")
    val sc = new SparkContext(conf)
    val data = file.map { line => //处理数据
      val parts = line.split(',') //分割数据
      LabeledPoint(parts(0).toDouble, //标签数据转换
        Vectors.dense(parts(1).split(' ').map(_.toDouble))) //向量数据转换
    }

    val splits = data.randomSplit(Array(0.7, 0.3), seed = 11L) //对数据进行分配
    val trainingData = splits(0) //设置训练数据
    val testData = splits(1) //设置测试数据
    val model = NaiveBayes.train(trainingData, lambda = 1.0) //训练贝叶斯模型
    val predictionAndLabel = testData.map(p => (model.predict(p.features), p.label)) //验证模型
    val accuracy = 1.0 * predictionAndLabel.filter( //计算准确度
      label => label._1 == label._2).count() //比较结果
    println(accuracy) //打印准确度
  }
}
  */