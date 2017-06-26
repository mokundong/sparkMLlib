package ch13

import org.apache.spark.mllib.tree.RandomForest
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yousa on 2017/6/26.
  */
object irisRFDTree {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("irisRFDTree")
    val sc = new SparkContext(conf)
    val data = MLUtils.loadLibSVMFile(sc,"E://work//SparkMLlib//data//irisRFDTree.txt")

    val numClasses = 3
    val categoricalFeaturesInfo = Map[Int,Int]()
    val numTrees = 3
    val featureSubsetStrategy = "auto"
    val impurity = "entropy"
    val maxDepth = 5
    val maxBins = 3

    val model = RandomForest.trainClassifier(data,numClasses,categoricalFeaturesInfo,numClasses,featureSubsetStrategy,impurity,maxDepth,maxBins)
    model.trees.foreach(println)
  }
}
