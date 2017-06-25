package ch08

import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/6/25.
  */
object DT {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("DT")
    val sc = new SparkContext(conf)
    val data = MLUtils.loadLibSVMFile(sc,"d://work//Spark MLlib//data//DTree.txt")
    val numClasses = 2//设置分类数量
    val categoricalFeaturesInto = Map[Int,Int]()//设置输入格式
    val impyrity = "entropy"//设定信息增益计算方式
    val maxDepth = 5//设置树的高度
    val maxBins = 3//设置分裂数据集
    val model = DecisionTree.trainClassifier(data,numClasses,categoricalFeaturesInto,impyrity,maxDepth,maxBins)
    println(model.topNode)
  }
}
