package ch13

import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yousa on 2017/6/26.
  */
object irisDecisionTree {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("irisDecisionTree")
    val sc = new SparkContext(conf)

    val data = MLUtils.loadLibSVMFile(sc,"E://work//SparkMLlib//data//irisDecisionTree.txt")

    val numClasses = 3
    val categoricalFeaturesInfo = Map[Int,Int]()
    val impurity = "entropy"
    val maxDepth = 5
    val maxBins = 3
    val model = DecisionTree.trainClassifier(data,numClasses,categoricalFeaturesInfo,impurity,maxDepth,maxBins)
    val test = Vectors.dense(Array(7.2,3.6,6.1,2.5))
    println(model.predict(test))
  }
}
