package ch08

import org.apache.spark.mllib.tree.RandomForest
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/6/25.
  */
object RFDTree {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("RFDTree")
    val sc = new SparkContext(conf)
    val data = MLUtils.loadLibSVMFile(sc,"d://work//Spark MLlib//data//DTree.txt")
    val numClasses = 2//设定分类数量
    val categoricalFeaturesInfo = Map[Int,Int]()//设置数据输入格式
    val numTrees = 3//设置随机森林中决策树的数目
    val featureSubsetStrategy = "auto"//设置属性在节点计算数
    val impurity = "entropy"//设置信息增益方式
    val maxDepth = 5//设置树的高度
    val maxBins = 3//设定分裂数据集
    val model = RandomForest.trainClassifier(data,numClasses,categoricalFeaturesInfo,numTrees,featureSubsetStrategy,impurity,maxDepth,maxBins)//建立模型
    model.trees.foreach(println)
  }
}
